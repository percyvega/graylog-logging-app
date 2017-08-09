#!/usr/bin/env bash

nohup java -Dgelf-udp -Dlogback.configurationFile=logback-gelf-udp.xml -jar /home/ubuntu/percy/graylog-logback-app-1.0-SNAPSHOT.jar > /dev/null 2>&1 &
