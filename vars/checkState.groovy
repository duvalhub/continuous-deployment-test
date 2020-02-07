import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(Trace trace) {
    String script = "${env.BASE_DIR}/scripts/wait/wait.sh"
    withEnv([
        "EXPECTED=${trace.getStringToSearch()}",
        "DEPLOYMENT_URL=${trace.url}"
    ]){
        executeScript(script)
    }
}