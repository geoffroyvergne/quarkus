# rest kotlin

## Bootstrap

mvn io.quarkus:quarkus-maven-plugin:0.16.0:create \
    -DprojectGroupId=com.example \
    -DprojectArtifactId=rest-kotlin \
    -DclassName="com.example.rest.GreetingResource" \
    -Dpath="/greeting" \
    -Dextensions="kotlin,resteasy-jsonb"

## Run

```export JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home```

```mvn compile quarkus:dev```

```curl http://localhost:8080/greeting```