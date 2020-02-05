#!/bin/bash

echo "### Cli touch"
java -version
ls -l $JENKINS_CLI_JAR_PATH
echo $JENKINS_URL

# java -jar "$JENKINS_CLI_JAR_PATH" -s "$JENKINS_URL" help
java -jar "$JENKINS_CLI_JAR_PATH" help