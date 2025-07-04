# spring-repository-demo

This repository displays very basic implementations of various use cases with default-spring features.
You can use this as a template or as a collection of useful basic implementations to pick from.

# Steps to creating this project

By following these following steps, you can recreate this repository yourself. 
For each step there is a separate branch which is linked in the bullet point.

1. Spring Base Project from [spring initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.5.0&packaging=jar&jvmVersion=21&groupId=software.xdev&artifactId=spring_repository_demo&name=spring_repository_demo&description=Demo%20project%20for%20Spring%20Boot&packageName=software.xdev.spring_repository_demo&dependencies=web,data-jpa). ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-1-Spring-Base-Project))
2. [docker-compose](./docker/docker-compose.yml) (start with `docker compose up` in ./docker) ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-2-Add-Docker) / [Changes](https://github.com/JohannesRabauer/spring-repository-demo/compare/Step-1-Spring-Base-Project...Step-2-Add-Docker))
3. Add postgresql dependency to [pom.xml](./pom.xml) ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-3-Add-PostgreSQL-Dependency) / [Changes](https://github.com/JohannesRabauer/spring-repository-demo/compare/Step-2-Add-Docker...Step-3-Add-PostgreSQL-Dependency))
```xml
<dependency>
     <groupId>org.postgresql</groupId>
     <artifactId>postgresql</artifactId>
</dependency>
```
4. Configure access in [application.properties](./src/main/resources/application.properties) ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-4-Configure-PostgreSQL-Access) / [Changes](https://github.com/JohannesRabauer/spring-repository-demo/compare/Step-3-Add-PostgreSQL-Dependency...Step-4-Configure-PostgreSQL-Access)):
```properties
spring.datasource.url: jdbc:postgresql://localhost:15432/rabauer-db
spring.datasource.username: dev
spring.datasource.password: not-secure
spring.datasource.driver-class-name: org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```
5. Add business logic ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-5-And-Step-6-Add-Business-Logic-And-Repositories) / [Changes](https://github.com/JohannesRabauer/spring-repository-demo/compare/Step-4-Configure-PostgreSQL-Access...Step-5-And-Step-6-Add-Business-Logic-And-Repositories))
6. Add repositories (DB-Logic) ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-5-And-Step-6-Add-Business-Logic-And-Repositories) / [Changes](https://github.com/JohannesRabauer/spring-repository-demo/compare/Step-4-Configure-PostgreSQL-Access...Step-5-And-Step-6-Add-Business-Logic-And-Repositories))
7. Add controller (Rest-Endpoints) ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-7-Add-Rest-Controller) / [Changes](https://github.com/JohannesRabauer/spring-repository-demo/compare/Step-5-And-Step-6-Add-Business-Logic-And-Repositories...Step-7-Add-Rest-Controller)). Tests:
   1. `curl -X POST localhost:8080/cars/new -H "Content-type:application/json" -d "{\"brand\":\"Audi\",\"model\":\"A3\",\"year\":2025}"`
   2. `curl localhost:8080/cars/all`
8. Add springdoc-openapi dependency to [pom.xml](./pom.xml). Then swagger UI is accessible through http://localhost:8080/swagger-ui/index.html ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-8-Add-OpenAPI-Swagger) / [Changes](https://github.com/JohannesRabauer/spring-repository-demo/compare/Step-7-Add-Rest-Controller...Step-8-Add-OpenAPI-Swagger))
```xml
<dependency>
     <groupId>org.springdoc</groupId>
     <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
     <version>2.8.9</version>
</dependency>
```
9. Add Token Authentification with `spring-boot-starter-security`. API is still testable on http://localhost:8080/swagger-ui/index.html by clicking "Authorize" (with value `supersecrettoken123`) first. ([Branch](https://github.com/JohannesRabauer/spring-repository-demo/tree/Step-9-Add-Authentification) / [Changes](https://github.com/JohannesRabauer/spring-repository-demo/compare/Step-8-Add-OpenAPI-Swagger...Step-9-Add-Authentification))