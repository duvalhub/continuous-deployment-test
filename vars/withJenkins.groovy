def call (Closure body) {
    withEnv([
        "JENKINS_CLI_JAR_PATH=${env.WORKSPACE}/lib/jenkins-cli.jar",
    ]){
         withCredentials([
            usernamePassword(
                usernameVariable: 'JENKINS_USER_ID',
                passwordVariable: 'JENKINS_API_TOKEN',
                credentialsId: 'continuous-deployment-test-token'
            )
        ]) {
            body()
        }
    }
}
