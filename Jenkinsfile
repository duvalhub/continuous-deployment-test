
@Library(['test-library@feature/base', 'shared-library@feature/multiple-env']) _
env.PIPELINE_BRANCH = "feature/multiple-env"
import com.duvalhub.git.GitCloneRequest
import com.duvalhub.appconfig.AppConfig
import com.duvalhub.initializeworkdir.InitializeWorkdirIn

import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.continuousdeploymenttest.release.Release

/* 
) Clone hello-app on branch develop
) Edit file and commit
) Wait for build to finish ?
) Validate that artifact exists on repo
 */

// dockerSlave() {
node() {
    checkout scm
    
    String uuid = sh(
        script: 'uuidgen',
        returnStdout: true
    ).trim()
    Trace trace = new Trace(uuid)
    trace.url = "https://hello-world.cicd-test.dev.philippeduval.ca"


    initializeWorkdir(new InitializeWorkdirIn(trace.getGitRepo()))
    trace.app_workdir = env.APP_WORKDIR

/*
    modifyGitRepo(trace)
    
    AppConfig appConfig = readConfiguration()
    
    echo "Validating DEV environment"
    validateEnvironment(trace)

    Release release = new Release()
    launchRelease(trace)
*/
    String release_branch = determineReleaseBranch(trace)
    echo "Relase branch found: '$release_branch'"
/*
    echo "Validating STAGE environment"
    JenkinsBuild jenkinsBuild = trace.jenkinsBuild
    jenkinsBuild.branch = release_branch
    validateEnvironment(trace)
*/


}