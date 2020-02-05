def call() {
    String script = "${env.BASE_DIR}/scripts/checkFile/checkFile.sh"
    withEnv(["JENKINS_CLI_JAR_PATH=${env.BASE_DIR}/lib/jenkins-cli.jar"]){
        withCredentials([
            usernamePassword(
                usernameVariable: 'USERNAME',
                passwordVariable: 'PASSWORD',
                credentialsId: 'continuous-deployment-test-token'
            )
        ]) {
            
            executeScript(script)
        }

    }

}