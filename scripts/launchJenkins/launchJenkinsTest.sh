#!/bin/bash
set -e
export JENKINS_CLI_JAR_PATH=/Users/huguesmcd/lib/jenkins-cli/jenkins-cli.jar
export JENKINS_URL="https://jenkins.philippeduval.ca"
export JENKINS_JOB="continuous-deployment-pipelines/continuous-deployment-release/feature%2Ffirst-draft"
export JENKINS_USER_ID=$(cat /Users/huguesmcd/.jenkins-auth.cfg | cut -d':' -f1)
export JENKINS_API_TOKEN=$(cat /Users/huguesmcd/.jenkins-auth.cfg | cut -d':' -f2)
export JENKINS_PARAMS="-p GIT_REPOSITORY=ewf"
./launchJenkins.sh

