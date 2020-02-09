def call(Trace trace) {
     withCredentials([
        usernamePassword(
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD',
            credentialsId: 'GITHUB_SERVICE_ACCOUNT_CREDENTIALS'
        )
    ]) {
        GitCloneRequest gitCloneRequest = new GitCloneRequest(trace.getGitUrl())
        gitCloneRequest.toCheckout = "develop"
        gitClone(gitCloneRequest)

        dir(gitCloneRequest.directory) {    
            editFile(trace)
        }
    }
}
