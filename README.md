# Evatro Assignment
![JAVA](https://img.shields.io/badge/Java-17-blue)

## Introduction
This project represent a web service that returns the current temperature of a given city name.

When initializing this project, it takes the values from a JSON file and writes these values to the database. If the requested value is available, the response value is returned; if the data is not available, null is returned.
JSON file content is as follows.
```json
[{"Name":"Istanbul","Temperature":"8","Unit":8},{"Name":"Prag","Temperature":"10","Unit":8},{"Name":"Los Angeles","Temperature":"9","Unit":8},{"Name":"Kiev","Temperature":"-5","Unit":8}]
```

## Test For Production

- This project was deployed to the production environment with Heroku. You can test the project in a live environment.

### Heroku URL : https://evatro-assignment-188fa7ca9c61.herokuapp.com/temperature

- You can send a request to the live environment and receive a response by running the following curl requests in the browser.

```curl
curl --location 'https://evatro-assignment-188fa7ca9c61.herokuapp.com/temperature?q=Istanbul'
```

```curl
curl --location 'https://evatro-assignment-188fa7ca9c61.herokuapp.com/temperature' \
--header 'Content-Type: application/json' \
--data '{
    "query": "Istanbul"
}'
```

## Test For Local

- Clone or download the repository to your computer. You can clone the repositories following command.
```sh
git clone https://github.com/kubilayciftci/evatro-assignment.git
```

- Go to the folder where the application is located via terminal.

- Before the running, please make sure Java 17 and `mvn` installed on your local computer. You can start the application locally on your computer as following command.

```sh
mvn clean install && java -jar target/evatro-assignment-0.0.1-SNAPSHOT.jar
```

- After installing and running the application locally, you can make requests using the following curl requests on your own computer.

```curl
curl --location 'localhost:8080/temperature?q=Istanbul'
```

```curl
curl --location 'localhost:8080' \
--header 'Content-Type: application/json' \
--data '{
    "query": "Istanbul"
}'
```

- Added a postman collection for your HTTP request in the project root folder. If you want you can test with Postman.