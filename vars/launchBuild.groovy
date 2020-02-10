import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.jenkins.LaunchBuild

def call(LaunchBuild launchBuild) {
    echo "### Running launchBuild.groovy with LaunchBuild: '${launchBuild.toString()}"
    String script = "${env.WORKSPACE}/scripts/launchJenkins/launchJenkins.sh"
    withJenkins() {
        String[] params = launchBuild.params
        String params_string = ""
        for( String param: params ) {
            params_string += String.format("-p %s ", param)
        }
        env.JENKINS_JOB = launchBuild.getBuild()
        env.JENKINS_PARAMS = params_string
        executeScript(script)
    }
}
