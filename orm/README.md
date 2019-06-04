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

```curl http://localhost:8080/person```