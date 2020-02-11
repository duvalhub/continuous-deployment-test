#!/bin/bash
set -e
echo "### Lauching build job. JENKINS_CLI_JAR_PATH: '$JENKINS_CLI_JAR_PATH', JENKINS_URL: '$JENKINS_URL', JENKINS_PARAMS: '$JENKINS_PARAMS', JENKINS_JOB: '$JENKINS_JOB'"

attempt_counter=0
max_attempts=60
sleep_time=1
expected="$EXPECTED"

while true;
do
    if [ ${attempt_counter} -eq ${max_attempts} ];then
      echo "Max attempts reached. Failing"
      exit 1
    fi

    echo "Launching job '$JENKINS_JOB'"
    job_success=false
    java -jar $JENKINS_CLI_JAR_PATH -s $JENKINS_URL -webSocket -auth "$JENKINS_USER_ID:$JENKINS_API_TOKEN" build -s "$JENKINS_JOB" $( if [ ! -z "$JENKINS_PARAMS" ]; then echo -n "$JENKINS_PARAMS"; fi ) && job_success=true || job_success=false

    if [ "$job_success" = true ]; then
        echo "Job success."
        exit 0
    fi

    echo "Job failed. Tried #$((attempt_counter+1))/$max_attempts . Sleeping for $sleep_time second."

    attempt_counter=$(($attempt_counter+1))
    sleep $sleep_time
done

