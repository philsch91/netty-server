# Netty Server

## Build and Run 

1. `mvn clean compile assembly:single`
2. `docker build -t se/netty-server .`
3. `docker tag se/netty-server rabbitcarrental.azurecr.io/se/netty-server:latest`
4. `docker login rabbitcarrental.azurecr.io`
5. `docker push rabbitcarrental.azurecr.io/se/netty-server:latest`
6. `docker logout rabbitcarrental.azurecr.io`
7. `docker run -p 9999:9999 se/netty-server`

## Test
date; for((i = 0; i <= 10000; i++)); do echo "Hello from Philipp ${i}" | nc localhost 9999; done; date
