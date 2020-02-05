#!/bin/bash

echo "### Cli touch"
java -version
java -jar "$JENKINS_CLI_JAR_PATH" -s "$JENKINS_URL" help