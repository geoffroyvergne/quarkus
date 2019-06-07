# Quarkus

## Bootstrap

```
mvn io.quarkus:quarkus-maven-plugin:0.15.0:create \
    -DprojectGroupId=com.example \
    -DprojectArtifactId=orm \
    -DclassName="com.example.orm.PersonResource" \
    -Dpath="/person"
```
 
```mvn quarkus:add-extension -Dextensions="quarkus-resteasy-jsonb, quarkus-jdbc-postgresql, quarkus-hibernate-orm-panache"```
    
### Run Postgres first

```
docker run \
    --rm \
    --name postgres \
    -e POSTGRES_USER=person \
    -e POSTGRES_PASSWORD=person \
    -e POSTGRES_DB=person \
    -p 5432:5432 \
    -d \
    postgres
```
    
## Run

```export JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home```

```mvn compile quarkus:dev```

## Build

```mvn package```

## Test

```mvn test```

## Native image

```mvn package -Pnative```

## Native test

```mvn verify -Pnative```

## Docker package

```mvn package -Pnative -Dnative-image.docker-build=true```

```docker build -f src/main/docker/Dockerfile.native -t quarkus-orm .```

## Docker run

```
docker run -i --rm \
    --name quarkus-orm \
    --link postgres \
    -p 8080:8080 \
    -e DATABASE_HOST=postgres \
    quarkus-orm
```

## Queries

```curl http://localhost:8080/person```
```curl http://localhost:8080/person/9```

```
curl -X PUT \
    -H 'Content-Type: application/json' \
    -d '{"birth":"2019-06-07","name":"Test","status":"Alive"}' \
    localhost:8080/person
```

```
curl -X DELETE \
    -H 'Content-Type: application/json' \
    -d '{"birth":"2019-06-07","id":9,"name":"Test","status":"Alive"}' \
    localhost:8080/person
```