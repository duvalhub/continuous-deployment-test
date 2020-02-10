#!/bin/bash
set -e
echo "### Lauching build job. JENKINS_CLI_JAR_PATH: '$JENKINS_CLI_JAR_PATH', JENKINS_URL: '$JENKINS_URL', JENKINS_PARAMS: '$JENKINS_PARAMS', JENKINS_JOB: '$JENKINS_JOB'"
java -jar $JENKINS_CLI_JAR_PATH -s $JENKINS_URL -webSocket -auth "$JENKINS_USER_ID:$JENKINS_API_TOKEN" build -s "$JENKINS_JOB" $( if [ ! -z "$JENKINS_PARAMS" ]; then echo -n "$JENKINS_PARAMS"; fi )