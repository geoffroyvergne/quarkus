# Quarkus kotlin orm

## Bootstrap

```
mvn io.quarkus:quarkus-maven-plugin:0.15.0:create \
    -DprojectGroupId=com.example \
    -DprojectArtifactId=kotlin-orm \
    -DclassName="com.example.orm.PersonResource" \
    -Dpath="/person" \
    -Dextensions="kotlin,quarkus-resteasy-jsonb, quarkus-jdbc-postgresql, quarkus-hibernate-orm-panache"
```    

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

