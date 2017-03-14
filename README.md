# PullRequest App

Pullrequest-app is an example project that uses:

  - Spring-boot
  - Eureka
  - Cassandra
  - Gradle
  - Docker

### Running

To run the api project:

```sh
$ cd pullrequest-api
$ gradle bootRun
```

To run the eureka service discovery project:
```sh
$ cd pullrequest-eureka
$ gradle bootRun
```
### Start Cassandra Server

To start the cassadra server:
```sh
$ docker run --name ca -p 127.0.0.1:9042:9042 -p 127.0.0.1:9160:9160 -d cassandra
```
To create the table, execute the load.cql inside `pullrequest-data-repository\cassandra\cql`
