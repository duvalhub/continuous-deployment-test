import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.jenkins.JenkinsBuild

def call(JenkinsBuild jenkinsBuild) {
    echo "### Running JenkinsBuild.groovy with JenkinsBuild: '${jenkinsBuild.toString()}"
    String script = "${env.WORKSPACE}/scripts/launchJenkins/launchJenkins.sh"
    withJenkins() {
        String[] params = jenkinsBuild.params
        String params_string = ""
        for( String param: params ) {
            params_string += String.format("-p %s ", param)
        }
        env.JENKINS_JOB = jenkinsBuild.getBuild()
        env.JENKINS_PARAMS = params_string
        echo executeScript(script)
    }
}
