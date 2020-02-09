#!/bin/bash
set -e

attempt_counter=0
max_attempts=60
sleep_time=1
expected="e0f30s663-1fb5-40a6-b432-871876520dad"

while true;
do
    if [ ${attempt_counter} -eq ${max_attempts} ];then
      echo "Max attempts reached. Failing"
      exit 1
    fi

    result=$(curl -s https://hello-world.cicd-test.dev.philippeduval.ca)

    if [ "$result" == "$expected" ]; then
        echo "Result found '$expected'"
        exit 0
    fi

    echo "Tried #$((attempt_counter+1))/$max_attempts . Expected '$expected'. Got '$result'. Sleeping for $sleep_time second."

    attempt_counter=$(($attempt_counter+1))
    sleep $sleep_time
done
