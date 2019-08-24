#!/bin/bash
nohup bash -c  "while true; do { echo -e 'HTTP/1.1 200 OK\\r\\n'; echo 'hello world'; } | nc -l -p  8080; done" > /tmp/simplehttpserver.log 2>&1 &
