# usable-gtd
Web based Todo application

### Description
Technology used for implementation:
* Backend: Java EE 7 ( Jax-Rs, JPA/Hibrnate, CDI ) using wildfly-swarm
* Frontend: angular 4 framework, bootstrap 4

### Build process requirements:
* java sdk 8 or above
* maven 3
* npm 4.5 or above
* node v7.7 or above
* angular-cli 1.0 or above

### Execution requirements:
* java jre 8 or above

## HowTo run application

#### Download and execute
```shell
$ wget https://github.com/aleksandar78/usable-gtd/releases/download/v0.1/usablegtd-swarm.jar

$ java -jar usablegtd-swarm.jar
```

#### Or build and execute

```shell
$ mvn clean package

$ java -jar target/usablegtd-swarm.jar
```

#### Access url:
[Web app - http://localhost:8080] (http://localhost:8080)

[Rest endpoint - http://localhost:8080/rest] (http://localhost:8080/rest)