# Quarkus

## Bootstrap

mvn io.quarkus:quarkus-maven-plugin:0.15.0:create \
    -DprojectGroupId=com.example \
    -DprojectArtifactId=base \
    -DclassName="com.example.base.GreetingResource" \
    -Dpath="/hello"


## Run

export JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home

mvn compile quarkus:dev

curl http://localhost:8080/hello

curl http://localhost:8080/hello/greeting/quarkus

## Build

mvn package

## Test

mvn test

## Run

./target/base-1.0-SNAPSHOT-runner

## Native image

mvn package -Pnative

## Native test

mvn verify -Pnative

## Docker package

mvn package -Pnative -Dnative-image.docker-build=true

docker build -f src/main/docker/Dockerfile.native -t quarkus-base .

docker run -i --rm -p 8080:8080 quarkus-base

