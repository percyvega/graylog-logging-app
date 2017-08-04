#!/usr/bin/env bash

scp -i    /Users/oeuser/graylog2-dev.pem /Users/oeuser/Documents/Workspaces/graylog-logging-app/target/graylog-logging-app-1.0-SNAPSHOT.jar ubuntu@10.0.112.37:/home/ubuntu/percy/
scp -r -i /Users/oeuser/graylog2-dev.pem /Users/oeuser/Documents/Workspaces/graylog-logging-app/src/main/resources/                         ubuntu@10.0.112.37:/home/ubuntu/percy/
scp -r -i /Users/oeuser/graylog2-dev.pem /Users/oeuser/Documents/Workspaces/graylog-logging-app/scripts/                                    ubuntu@10.0.112.37:/home/ubuntu/percy/
