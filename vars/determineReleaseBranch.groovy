import com.duvalhub.continuousdeploymenttest.trace.Trace
def call(Trace trace) {
    withSshKey() {
        dir( trace.app_workdir ) {
            String script = "${env.PIPELINE_WORKDIR}/scripts/bash/getReleaseBranch/getReleaseBranch.sh"
            return executeScript(script, true)
        }
    }
}