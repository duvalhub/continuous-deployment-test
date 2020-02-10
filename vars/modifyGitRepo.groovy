import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(Trace trace) {
     withCredentials([
        usernamePassword(
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD',
            credentialsId: 'GITHUB_SERVICE_ACCOUNT_CREDENTIALS'
        )
    ]) {
        dir(trace.app_workdir) {    
            withSshKey() {
                editFile(trace)
            }
        }
    }
}
