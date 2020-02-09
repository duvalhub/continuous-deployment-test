import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(Trace trace) {
    String script = "${env.WORKSPACE}/scripts/launchJenkins/launchJenkins.sh"
    withJenkins() {
        withEnv([
            "APP_BRANCH=develop",
            "STRING_TO_SEARCH=${trace.getStringToSearch()}"
        ]){
            executeScript(script)
        }
    }
}
