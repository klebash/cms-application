# CMS Application - REST API

This project is a basic Content Management System (CMS) application built as a REST API. The API allows users to perform CRUD (Create, Read, Update, Delete) operations on articles and manage images associated with those articles.

## Features

- CRUD Operations: Create, read, update, and delete articles.
- Image Management: Upload and associate images with articles.
- RESTful API: The application provides a simple and effective REST API for managing content.

## Prerequisites

Before running the application, ensure you have the following installed:

- Java 8 or higher
- Maven
- MySQL or another compatible relational database
- Git

## Getting Started

Follow the steps below to set up and run the application.

### 1. Clone the Repository

Use the following command to clone the repository to your local machine:

git clone https://github.com/klebash/cms-application.git

### 2. Create the Database

Create a PostgreSQL database with the name `cms_db`. You can run the  SQL query or use your preferred database management tool:


### 3. Update Database Connection Details

Open the `properties.yml` file located in the `src/main/resources` directory and update the database connection details with your own credentials (e.g., username, password, database URL).

Example:

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/cms_db
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update

### 4. Set Up Dependencies

Use Maven to clean and install the necessary dependencies. If you are on Linux, run the following command:

./mvnw clean install

If you are on Windows, run:

mvnw.cmd clean install

### 5. Run the Application

To start the application, you can either:

- Run it using Maven:

  - On Linux:

    ./mvnw spring-boot:run

  - On Windows:

    mvnw.cmd spring-boot:run

- Alternatively, use an IDE like IntelliJ IDEA or Eclipse. Import the project as a Maven project and run the `main` method in the `CmsApplication.java` file.

## API Endpoints

The following are the key endpoints available in the API:

- GET /articles: Retrieve a list of all articles.
- POST /articles: Create a new article.
- GET /articles/{id}: Retrieve a single article by its ID.
- PUT /articles/{id}: Update an existing article.
- DELETE /articles/{id}: Delete an article by its ID.
- POST /api/images: Create a new image.
- GET /api/images/{id}: Retrieve an image by ID.

- User Postman to test it : https://cms-api-challenge.postman.co/workspace/CMS-API-CHALLENGE-Workspace~f8d7c3ee-124f-4d00-a44b-3445f942c35d/collection/38024711-27dedf13-ba73-4d42-a43e-08cc1ee4c2af?action=share&creator=38024711

