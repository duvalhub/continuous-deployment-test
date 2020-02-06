#!/bin/bash
set -e
echo "### Cli touch"
java -jar $JENKINS_CLI_JAR_PATH -s $JENKINS_URL -webSocket -auth "$JENKINS_USER_ID:$JENKINS_API_TOKEN" build -s "continuous-deployment-tests/continuous-deployment-test-app/$APP_BRANCH"
