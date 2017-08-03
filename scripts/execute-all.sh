#!/usr/bin/env bash

nohup java -Dgelf-tcp -Dlog4j.configuration=file:/home/ubuntu/percy/resources/log4j-gelf-tcp.properties -jar /home/ubuntu/percy/logging-app-1.0-SNAPSHOT.jar > /dev/null 2>&1 &

nohup java -Dgelf-udp -Dlog4j.configuration=file:/home/ubuntu/percy/resources/log4j-gelf-udp.properties -jar /home/ubuntu/percy/logging-app-1.0-SNAPSHOT.jar > /dev/null 2>&1 &

nohup java -Draw-text -Dlog4j.configuration=file:/home/ubuntu/percy/resources/log4j-raw.properties-text -jar /home/ubuntu/percy/logging-app-1.0-SNAPSHOT.jar > /dev/null 2>&1 &

nohup java -Draw-json -Dlog4j.configuration=file:/home/ubuntu/percy/resources/log4j-raw-json.properties -jar /home/ubuntu/percy/logging-app-1.0-SNAPSHOT.jar > /dev/null 2>&1 &
