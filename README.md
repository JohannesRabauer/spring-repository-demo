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