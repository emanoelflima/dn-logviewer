# dn-logviewer
Log report generator for DN application test

## About the application

LogViewer it's a report processor from log text files divided in angular and spring boot applications and was developed using TDD concepts.

## Installation

Use the npm package manager to install the angular application.

```bash
npm install
```

Use maven to install the spring boot application.

```bash
mvn clean install
```

## Running tests

To run front-end tests, execute the following command:

```bash
ng test
```

The front-end tests were made from the default angular generated tests, that checks some elements of the page.

To test the back-end application, run the following:

```bash
mvn test
```

The following tests are available for the spring boot application:

* Report generation from a file
* Matching of a start rendering entry
* Matching of a finish rendering entry
* Matching of a get rendering entry

## Running the application

To run the angular application:

```bash
npm start
```

To run the spring boot application:

```bash
mvn spring-boot:run
```

## Using the application

After start the applications, access the following address:

```bash
localhost:4200
```

The main page shows an area where you can drag a log file and generate the report data. After submitting the file, the system will show a screen with a table containing the processed data.

The system only accepts .log and .txt files.

You can also download the original xml received from the server to your disk.

## Checking the api via swagger

Swagger was also configured for an api navigation. You can access the interface from the following address:

```bash
http://localhost:8080/swagger-ui/
```
