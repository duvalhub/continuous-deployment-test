import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(Trace trace) {
    String script = "${env.BASE_DIR}/scripts/wait/wait.sh"
    withEnv([
        "EXPECTED=${trace.getStringToSearch()}",
        "URL=http://hello-world.cicd-test.dev.philippeduval.ca"
    ]){
        executeScript(script)
    }
}