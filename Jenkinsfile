
@Library(['test-library@feature/base', 'shared-library@feature/multiple-env']) _

import com.duvalhub.gitclone.GitCloneRequest
import com.duvalhub.continuousdeploymenttest.trace.Trace

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


    initializeWorkdir(new InitializeWorkdirIn(trace.getGitUrl()))
    
    AppConfig appConfig = readConfig()
    

    validateEnvironment(trace)

    Release release = new Release()
    launchRelease(release)


}