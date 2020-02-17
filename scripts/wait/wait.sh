#!/bin/bash
set -e

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

    echo "Curling '$DEPLOYMENT_URL'. Expecting '$expected'"
    result=$(curl -m 5 -L -s $DEPLOYMENT_URL || true)

    if [ "$result" == "$expected" ]; then
        echo "Result found '$expected'"
        exit 0
    fi

    echo "Tried #$((attempt_counter+1))/$max_attempts . Expected '$expected'. Got '$result'. Sleeping for $sleep_time second."

    attempt_counter=$(($attempt_counter+1))
    sleep $sleep_time
done
