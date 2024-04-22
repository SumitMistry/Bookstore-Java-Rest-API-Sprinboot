## BOOKSTORE


#### PROJECT:
>Scenario: You are working on a RESTful API for a bookstore using Java with Spring Boot. The bookstore has books, authors, and categories. You need to implement an endpoint that allows users to search for books by title, author, or category.
Task: Write a controller method that handles a GET request to search for books. The method should accept query parameters for title, author, and category, and return a list of books that match the search criteria.

Requirements (Reference: **Clare, Colin**)
````
•	Use Spring Boot for the REST API implementation.
•	Use Gradle as the build tool.
•	Use an in-memory database (e.g., H2) for simplicity.
•	Implement error handling to return appropriate error responses if no books are found or the request is invalid.
````
Here's a basic outline of how you could implement this:
````
1.	Define Book, Author, and Category entities with appropriate relationships.
2.	Create repositories for each entity.
3.	Implement a service class with a method to search for books.
4.	Create a controller class with a method to handle the search request.

````

#### SOLUTION:

#### Models:
1. Books
2. Authors
3. Categories

#### Required:
1. Java 21
2. Maven
3. MySQL
4. PostMan

#### Run using commands:
1. ` mvn clean install `
2. ` mvn spring-boot:run ` 

#### Endpoint:
1. http://localhost:8080/api/bookstore/book
2. http://localhost:8080/api/bookstore/author
3. http://localhost:8080/api/bookstore/category

#### Endpoint call methods:
- Reference: Postman:
  * ![BookStore.postman_collection.json](https://github.com/SumitMistry/Bookstore-Java-Rest-API-Sprinboot/blob/main/src/main/java/Springboot/PostManCalls/BookStore.postman_collection.json)

![Api_calls_samples](https://github.com/SumitMistry/Bookstore-Java-Rest-API-Sprinboot/blob/main/sample_api_call1.png "Api_calls_samples")

#### Future Improvements:
1. Logger slf4j integration
2. Hibernate integration from current JDBC connection
3. Dokerizing the app
4. Deploy over the AWS or cloud from localhost
5. Adding the test cases using Junit
6. Developing frontend
7. Developing Swagger for END point use instruction



