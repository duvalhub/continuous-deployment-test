import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(String jenkins_job) {
    String script = "${env.WORKSPACE}/scripts/launchJenkins/launchJenkins.sh"
    withJenkins() {
        withEnv([
            "JENKINS_JOB=$jenkins_job"
        ]){
            executeScript(script)
        }
    }
}
