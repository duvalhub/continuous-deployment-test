import com.duvalhub.continuousdeploymenttest.trace.Trace
def call(Trace trace) {
    dir( trace.app_workdir ) {
        String script = "${env.WORKSPACE}/scripts/getReleaseBranch/getReleaseBranch.sh"
        return executeScript(script)
    }
 
}