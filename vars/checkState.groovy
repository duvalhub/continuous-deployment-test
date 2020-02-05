def call() {
    String script = "${env.BASE_DIR}/scripts/checkFile/checkFile.sh"
    withEnv(["JENKINS_CLI_JAR_PATH=${env.BASE_DIR}/lib/jenkins-cli.jar"]){
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