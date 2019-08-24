docker run -d --rm -p 8080:8080 --name smallest-http-server busybox sh -c "while true; do { echo -e 'HTTP/1.1 200 OK\r\n'; echo 'hello world'; } | nc -l -p  8080; done"
