### Api REST Assured Integration Tests

Exemplo de testes de integração usando [REST Assured](http://rest-assured.io/) em um projeto [Spring Boot](http://spring.io/projects/spring-boot).

### Testes de Integração

#### Executando os testes:

#### Maven

Todos os testes
```sh
$ mvn clean verify
```

Para gerar relatório do Allure
```sh
$ mvn allure:report
```

#### Gradle

Todos os testes
```sh
$ gradlew integrationTest
```

Para gerar relatório do Allure
```sh
$ gradlew allureReport
```
