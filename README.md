<div align="center">
  
  ![Logo](src/main/resources/assets/image/logo.png)
  
</div>

---

<h4 align="center">Rest api to save and analyze my Dota 2 games</h4>


<p align="center">
    <a href="https://www.java.com/es/"><img src="https://img.shields.io/badge/java-17.0-c55e00" alt="Java version"></a>
    <a href="https://spring.io/projects/spring-boot"><img src="https://img.shields.io/badge/spring-3.1.0-brightgreen" alt="Spring version"></a>
    <a href="https://spring.io/projects/spring-security"><img src="https://img.shields.io/badge/spring_security-6.1.0-brightgreen" alt="Spring Security version"></a>
    <a href="https://dotnet.testcontainers.org/"><img src="https://img.shields.io/badge/testcontainers-1.18.0-0c94aa" alt="Testcontainers version"></a>
    <a href="https://www.docker.com/"><img src="https://img.shields.io/badge/docker-20.10.22-086dd7" alt="Docker version"></a>
    <a href="https://hub.docker.com/_/mongo"><img src="https://img.shields.io/badge/mongo-6.0.6-00ed64" alt="MongoDB version"></a>
</p>



---
## Description
This API manages information about Dota 2 game matches, including match details and hero data. The API offers CRUD operations for two main entities: Hero and Match.
## Installation
To set up the project locally using Docker and Docker Compose, follow these steps:

1. Clone the repository to your local machine.
2. Ensure Docker and Docker Compose are installed and running.
3. Navigate to the project directory in your terminal.
4. Run the following command to start the application and the required services defined in the docker-compose.yml file:
```bash
docker-compose up -d
```
5. Wait for the containers to be built and started. The application and the associated MongoDB and Mongo Express services should now be running.
6. Configure the database connection in the application properties file to connect to the MongoDB container.
7. Build the project using Maven or Gradle.
8. Run the application using the appropriate command.
## Usage
The API offers various endpoints to interact with hero and match data. To access 
the endpoints, you need to authenticate by providing a email and password to obtain a JWT
token from the next endpoint: `/dota2matches/api/v1/auth/register`.
The information is obtained directly from the game. At the end of a match, fields appear to save the data into the database.
![Match Entity](src/main/resources/assets/image/match%20api.PNG)
The hero information is extracted from the in-game heroes section. The hero's win rate is updated based on the information from the stored matches.
![Match Entity](src/main/resources/assets/image/hero%20api.PNG)
## Authentication and Authorization
The API is secured with authentication and authorization using Spring Security and JWT (JSON Web Tokens). This ensures that only authenticated users with the proper access rights can interact with the endpoints.

To access the API endpoints, follow these steps:

1. Register as a user by providing an email address and password.
2. Send a POST request to the `/dota2matches/api/v1/auth/register` endpoint with the registration details.
3. Upon successful registration, a JWT token will be returned in the response.
4. Include the JWT token in the Authorization header of subsequent requests to the protected endpoints.
5. Set the header key as Authorization and the value as Bearer {your_token}.
6. The API will validate the token and grant access to the requested resources based on the user's roles and permissions.
7. Unauthorized users or those without the necessary permissions will receive a 403 Forbidden status code.

Please note that the API does not provide user management functionalities beyond registration.
## Documentation
The API documentation is available using OpenAPI and Swagger. It provides detailed information about each endpoint and their respective request and response structures. To access the API documentation, follow these steps:

1. Ensure that the application is running locally or on a server.
2. Open a web browser and navigate to the following URL: `http://localhost:8080/dota2matches/api/v1/swagger-ui/index.html`
3. The Swagger UI will be displayed, showcasing a list of all available endpoints and their descriptions.
4. Explore the endpoints, their parameters, and example requests and responses.
5. Use the documentation to understand the API's functionality and how to interact with it.

The API documentation serves as a valuable resource for developers to understand the available endpoints and their usage. It provides a convenient way to test the API directly from the browser and facilitates the integration of the API into other applications.

