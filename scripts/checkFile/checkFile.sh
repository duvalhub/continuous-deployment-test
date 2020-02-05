#!/bin/bash


java -jar "$JENKINS_CLI_JAR_PATH" -s "$JENKINS_URL" -auth "$USERNAME:$PASSWORD" help