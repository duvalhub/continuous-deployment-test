#!/bin/bash

echo "### Cli touch"
java -version
ls -l $JENKINS_CLI_JAR_PATH
echo $JENKINS_URL

java -jar $JENKINS_CLI_JAR_PATH -s $JENKINS_URL -webSocket -auth "$JENKINS_USER_ID:$JENKINS_API_TOKEN" build -s 'continuous-deployment/helloworld-app/test%2Fpipeline-development'
