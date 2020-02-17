import com.duvalhub.git.GitCloneRequest
import com.duvalhub.appconfig.AppConfig
import com.duvalhub.appconfig.Platforms

import com.duvalhub.initializeworkdir.InitializeWorkdirIn

import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.continuousdeploymenttest.release.Release
import com.duvalhub.jenkins.JenkinsBuild

def call() {

    String uuid = sh(
        script: 'uuidgen',
        returnStdout: true
    ).trim()
    echo "### Running pipeline test with UUID: '$uuid'"
    Trace trace = new Trace(uuid)

    initializeWorkdir(new InitializeWorkdirIn(trace.getGitRepo()))
    trace.app_workdir = env.APP_WORKDIR

    modifyGitRepo(trace)
    
    AppConfig appConfig = readConfiguration()
    Platforms platforms = appConfig.deploy.platforms
    
    echo "Validating DEV environment..."
    trace.platform = platforms.dev
    validateEnvironment(trace)

    echo "Launching Release Pipeline"
    launchRelease(trace)

    String release_branch = determineReleaseBranch(trace)
    echo "Release branch found: '$release_branch'"

    echo "Validating STAGE environment..."
    JenkinsBuild jenkinsBuild = trace.jenkinsBuild
    jenkinsBuild.version = release_branch
    trace.platform = platforms.stage
    validateEnvironment(trace)

    echo "Launching Production Pipeline"
    launchProduction(trace)

    echo "Validating PROD environment..."
    jenkinsBuild.version = "master"
    trace.platform = platforms.prod
    validateEnvironment(trace)
}