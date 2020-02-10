#!/bin/bash
set -e
echo "### Lauching build job"
java -jar $JENKINS_CLI_JAR_PATH -s $JENKINS_URL -webSocket -auth "$JENKINS_USER_ID:$JENKINS_API_TOKEN" build -s "continuous-deployment-pipelines/continuous-deployment-test-app/$APP_BRANCH"

echo "### Looking for '$STRING_TO_SEARCH' at '$DEPLOYMENT_URL'"

