#!/usr/bin/env bash

cd ..

mvn clean install

scp    -i /Users/oeuser/graylog2-dev.pem /Users/oeuser/Documents/Workspaces/graylog-logging-app/target/graylog-*.jar ubuntu@10.0.112.37:/home/ubuntu/percy/
scp -r -i /Users/oeuser/graylog2-dev.pem /Users/oeuser/Documents/Workspaces/graylog-logging-app/scripts/             ubuntu@10.0.112.37:/home/ubuntu/percy/
