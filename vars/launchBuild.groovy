import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.jenkins.LaunchBuild

def call(LaunchBuild launchBuild) {
    String script = "${env.WORKSPACE}/scripts/launchJenkins/launchJenkins.sh"
    withJenkins() {
        withEnv([
            "JENKINS_JOB=${launchBuild.getBuild}"
        ]){
            executeScript(script)
        }
    }
}
