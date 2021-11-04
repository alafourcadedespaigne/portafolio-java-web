# Spring Boot MySQL Zemoga Homework

This application was developed to demonstrate Spring Boot integration with Twitter for the Zemoga company

Technologies Used

- Java 11
- Spring Boot 2.4.13-SNAPSHOT
- Spring Data JPA
- thymeleaf
- Spring Social Twitter
- Lombok
- MySQL

### IMPORTANT
To successfully complete the task, the Zemoga team provided the necessary credentials to access both the Twitter developer account and the Amazon cloud database. For confidentiality reasons, these credentials will not be exposed. Before running the application it is necessary to configure the following values.

For integration with the Twitter API, the variables to change in the application.propertie file are the following

```shell
spring.social.twitter.appId={API_KEY}
spring.social.twitter.appSecret={API_SECRET_KEY}
twitter.access.token={ACCESS_TOKEN}
twitter.access.token.secret={ACCESS_TOKEN_SECRET}
```

For the connection to the MYSQL Database hosted in the Amazon cloud, the credentials are the following
```shell
spring.datasource.url=jdbc:mysql://{SERVER}:{PORT}/{DATABASE}?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username={USER}
spring.datasource.password={PASSWORD}
```
<br />
Once we have configured all the previously requested credentials, we proceed to run the application


##How to Run this application

First dowNload or clone this project from [GitHub](https://github.com/alafourcadedespaigne/springboot-mongo-homework).

```shell
$ git clone https://github.com/alafourcadedespaigne/springboot-mongo-homework.git
```

Then, navigate to application root folder and execute,

```shell
$ ./mvnw clean install
```

There should now be a newly created jar file with all the files needed to run this application in the target folder.

Then you can run the application by executing the following command  using the built-in jar file.
```shell
$ ./mvnw spring-boot:run
```

### To see the application in the browser go to the url

[http://localhost:8080/](http://localhost:8080/)



