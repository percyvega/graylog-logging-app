#!/usr/bin/env bash

nohup java -Dgelf-udp -Dlog4j.configuration=log4j-gelf-udp.properties -jar /home/ubuntu/percy/graylog-log4j-app-1.0-SNAPSHOT.jar > /dev/null 2>&1 &
