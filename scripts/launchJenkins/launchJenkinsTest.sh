#!/bin/bash
set -e
export JENKINS_JOB="continuous-deployment-pipelines/continuous-deployment-release/feature%2Ffirst-draft"
export JENKINS_PARAMS="-p GIT_REPOSITORY=ewf"
./launchJenkins.sh

