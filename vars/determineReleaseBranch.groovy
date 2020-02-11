import com.duvalhub.continuousdeploymenttest.trace.Trace
def call(Trace trace) {
    withSshKey() {
        dir( trace.app_workdir ) {
            String script = "${env.WORKSPACE}/scripts/getReleaseBranch/getReleaseBranch.sh"
            return executeScript(script, true)
        }
    }
}