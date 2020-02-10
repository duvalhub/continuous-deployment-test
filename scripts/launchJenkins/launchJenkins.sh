#!/bin/bash
set -e
echo "### Lauching build job"
java -jar $JENKINS_CLI_JAR_PATH -s $JENKINS_URL -webSocket -auth "$JENKINS_USER_ID:$JENKINS_API_TOKEN" build -s
$JENKINS_PARAMS "$JENKINS_JOB"
