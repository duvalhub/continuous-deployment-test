
@Library(['test-library@feature/base', 'shared-library@feature/multiple-env']) _

import com.duvalhub.gitclone.GitCloneRequest
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
    sh "ls -l"

    String url = "https://github.com/duvalhub/helloworld-app.git"
    GitCloneRequest gitCloneRequest = new GitCloneRequest(url)
    gitCloneRequest.toCheckout = "develop"
    gitClone(gitCloneRequest)

    dir(gitCloneRequest.directory) {
        editFile()
    }

    checkState()

    String cli_script = ""


}