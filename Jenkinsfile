@Library('test-library@feature/base') _


dockerSlave() {
    checkout scm
    env.BASE_DIR = pwd()

    echo "BASE DIR: '${env.BASE_DIR}'"
    // GitClone hello-world
    String url = "https://github.com/duvalhub/helloworld-app.git"
    GitCloneRequest gitCloneRequest = new GitCloneRequest(url)
    gitClone(gitCloneRequest)

    dir(gitCloneRequest.directory) {
        editFile()
    }

}