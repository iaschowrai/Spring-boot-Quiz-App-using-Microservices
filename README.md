#Quiz App - Spring Boot Microservices
Welcome to the Quiz App, a microservices-based application built with Spring Boot. This application allows users to create quizzes, manage questions, and participate in quizzes. The microservices architecture enhances scalability and maintainability, and services include quiz-service, question-service, and service-registry (Eureka Server).

Technologies Used
Spring Boot: A powerful and convention-over-configuration framework for building Java-based microservices.

Spring Web: Provides HTTP request handling capabilities.

Spring Data JPA: Simplifies the data access layer, making it easy to interact with a relational database.

MySQL: A relational database used to store quiz and question data.

Lombok: A library to reduce boilerplate code in Java.

Eureka Server: A service registry for microservices, enabling service discovery.

OpenFeign: A declarative web service client that simplifies calling RESTful services.

Project Structure
The project is divided into three services:

quiz-service:

Creates quizzes, manages questions, and calculates scores.
Communicates with question-service to retrieve and store questions.
Stores data in the quizappdb database.
question-service:

Manages questions, including creation, retrieval by ID or category.
Acts as the data source for quiz-service.
Stores data in its own database.
service-registry (Eureka Server):

Enables service discovery and monitors the running instances of microservices.
Provides information on instances, such as port numbers.
