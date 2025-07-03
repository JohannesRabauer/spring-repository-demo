# spring-repository-demo

1. Spring Base Project from [spring initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.5.0&packaging=jar&jvmVersion=21&groupId=software.xdev&artifactId=spring_repository_demo&name=spring_repository_demo&description=Demo%20project%20for%20Spring%20Boot&packageName=software.xdev.spring_repository_demo&dependencies=web,data-jpa)
2. [docker-compose](./docker/docker-compose.yml) (start with `docker compose up` in ./docker)
3. Add postgresql dependency to [pom.xml](./pom.xml)
```xml
<dependency>
     <groupId>org.postgresql</groupId>
     <artifactId>postgresql</artifactId>
</dependency>
```
4. Configure access in [application.properties](./src/main/resources/application.properties):
```properties
spring.datasource.url: jdbc:postgresql://localhost:15432/rabauer-db
spring.datasource.username: dev
spring.datasource.password: not-secure
spring.datasource.driver-class-name: org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```
5. Add business logic
6. Add repositories (DB-Logic)
7. Add controller (Rest-Endpoints). Tests:
   1. `curl -X POST localhost:8080/cars/new -H "Content-type:application/json" -d "{\"brand\":\"Audi\",\"model\":\"A3\",\"year\":2025}"`
   2. `curl localhost:8080/cars/all`
8. Add springdoc-openapi dependency to [pom.xml](./pom.xml). Then swagger UI is accessible through http://localhost:8080/swagger-ui/index.html
```xml
<dependency>
     <groupId>org.springdoc</groupId>
     <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
     <version>2.8.9</version>
</dependency>
```
9. Add Token Authentification with `spring-boot-starter-security`. API is still testable on http://localhost:8080/swagger-ui/index.html by clicking "Authorize" (with value `supersecrettoken123`) first.