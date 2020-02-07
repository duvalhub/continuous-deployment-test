
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
    env.BASE_DIR = pwd()
    echo "BASE DIR: '${env.BASE_DIR}'"
    String uuid = sh(
        script: 'uuidgen',
        returnStdout: true
    )

    Trace trace = new Trace(uuid)

    withCredentials([
        usernamePassword(
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD',
            credentialsId: 'GITHUB_SERVICE_ACCOUNT_CREDENTIALS'
        )
    ]) {
        String url = "https://$USERNAME:$PASSWORD@github.com/duvalhub/continuous-deployment-test-app.git"
        GitCloneRequest gitCloneRequest = new GitCloneRequest(url)
        gitCloneRequest.toCheckout = "develop"
        gitClone(gitCloneRequest)

        dir(gitCloneRequest.directory) {
            editFile(trace)
        }
    }

    checkState(trace)

    String cli_script = ""


}