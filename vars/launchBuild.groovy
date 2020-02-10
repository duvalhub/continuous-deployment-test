import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(String jenkins_job = "continuous-deployment-pipelines/continuous-deployment-test-app/develop") {
    String script = "${env.WORKSPACE}/scripts/launchJenkins/launchJenkins.sh"
    withJenkins() {
        withEnv([
            "JENKINS_JOB=$jenkins_job"
        ]){
            executeScript(script)
        }
    }
}
