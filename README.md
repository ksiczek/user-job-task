# Introduction
The project is an implementation of User & JobOffer programming task. During implementation I made some assumptions:
- General
    - I decided to use relational DB instead of NoSQL just because I am more familiar with it. However, I could see no reason not to use NoSQL from the design point of view.
    - I did not like ActiveRecord pattern and I used respositories
    - Tests are black-box like and are more integration ones than units
    - I used Lombok at few places
- User
    - login must be unique
    - id and creation date are filled automatically during creation of a user
    - generated number is better than login as an ID as we can make login private and hide it in responses
- Job offer
    - I decided to put id instead of user name on the offer entity. It can be replaced on the endpoint to fit the requirements
    - companies might share the same name
    - offer is not strictly bound to the user, I mean there is no FK but just identifier

## TODOs
- implement second endpoint with job offers
- implement user update
- conside using test containers
    - or find a better way to reset H2 database
- consider switching to a real DB instead of H2
- catch up with JUnits to test intestines

# User manual
After launching the application go to http://localhost:8080/q/swagger-ui/ to see available options. Mind that user do not allow modifications and job offers were not implemented at all. 

# user-job-task Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/user-job-task-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related Guides

- YAML Configuration ([guide](https://quarkus.io/guides/config#yaml)): Use YAML to configure your Quarkus application
