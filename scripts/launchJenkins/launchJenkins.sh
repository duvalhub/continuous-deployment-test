#!/bin/bash
echo "### Lauching build job. JENKINS_CLI_JAR_PATH: '$JENKINS_CLI_JAR_PATH', JENKINS_URL: '$JENKINS_URL', JENKINS_PARAMS: '$JENKINS_PARAMS', JENKINS_JOB: '$JENKINS_JOB'"

attempt_counter=0
max_attempts=5
sleep_time=2
expected="$EXPECTED"

while true; do
  if [ ${attempt_counter} -eq ${max_attempts} ];then
    echo "Max attempts reached. Failing"
    exit 1
  fi

  set +e
  curl "$JENKINS_JOB_HTTP/api/json"
  build_error_code=$(echo $?)
  set -e
  if (( $build_error_code == 0)); then
    echo "Launching job '$JENKINS_JOB'"
    java -jar $JENKINS_CLI_JAR_PATH -s $JENKINS_URL -webSocket -auth "$JENKINS_USER_ID:$JENKINS_API_TOKEN" build -s "$JENKINS_JOB" $( if [ ! -z "$JENKINS_PARAMS" ]; then echo -n "$JENKINS_PARAMS"; fi ) 
  else 
    echo "Job not found. Tried #$((attempt_counter+1))/$max_attempts . Sleeping for $sleep_time second."
    attempt_counter=$(($attempt_counter+1))
    sleep $sleep_time
  fi
done
