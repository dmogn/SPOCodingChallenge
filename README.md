**Language:** Java

**System Requirements:** JDK 8+, Maven

**Dependencies:** Spring Boot, Lombok, JUnit 5

**Endpoint URL:** http://localhost:8080/api/v1/calculateStaffRequirements

**Swagger documentation:** http://localhost:8080/swagger-ui.html - UI
http://localhost:8080/v2/api-docs - JSON

**Build & run production app:**

```
$ mvn clean package
$ java -jar target/SPOCodingChallenge-1.0.jar
```

**Endpoint call example:**

```
$ curl \
    --header "Content-type: application/json" \
    --request POST \
    --compressed \
    --data '{ "rooms": [35, 21, 17, 28], "senior": 10, "junior": 6 }' \
http://localhost:8080/api/v1/calculateStaffRequirements
```

Best regards,

Dmitry Ognyannikov
