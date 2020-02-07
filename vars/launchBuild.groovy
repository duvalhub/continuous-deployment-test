import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(Trace trace) {
    String script = "${env.BASE_DIR}/scripts/checkFile/checkFile.sh"
    withEnv([
        "JENKINS_CLI_JAR_PATH=${env.BASE_DIR}/lib/jenkins-cli.jar",
        "APP_BRANCH=develop",
        "STRING_TO_SEARCH=${trace.getStringToSearch()}"
    ]){
        // executeScript(script)

         withCredentials([
            usernamePassword(
                usernameVariable: 'JENKINS_USER_ID',
                passwordVariable: 'JENKINS_API_TOKEN',
                credentialsId: 'continuous-deployment-test-token'
            )
        ]) {
            executeScript(script)
        }

    }

}