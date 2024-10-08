# Training Center Registry - Spring Boot Application

This is a Spring Boot application that implements a registry for government-funded training centers. The project includes features to add, view, and validate training center data, along with database integration using MySQL.

## Repository

The source code for this project can be found at the following GitHub link:  
[https://github.com/sayak918/Traini8.git](https://github.com/sayak918/Traini8.git)

## Requirements

- Java 17 (or higher)
- Maven 3.6.0 (or higher)
- MySQL 8.0 (or higher)
- IDE ( IntelliJ IDEA, or any other IDE)

## Project Structure

The project has the following key components:
- `TrainingCenter` Entity: Represents the training center with fields like center name, center code, address, and courses offered.
- REST APIs:
  - **POST /api/training-centers**: Creates a new training center with proper validation.
  - **GET /api/training-centers**: Retrieves the list of all training centers (returns an empty list if none exist).

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/sayak918/Traini8.git
cd Traini8
2. MySQL Setup
You need to have MySQL installed and running on your local machine.

Install MySQL:

Download MySQL and install it on your machine.
Create a Database: Once MySQL is installed and running, log in to MySQL and create a database:   mysql -u root -p

Then run the following SQL command to create a new database:  CREATE DATABASE traini8;

# 3 Update application.properties: In the src/main/resources/application.properties file, update the MySQL configuration with your username and password:
applications.properties

spring.datasource.url=jdbc:mysql://localhost:3306/traini8
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Build and Run the Application
Once MySQL is up and running, follow these steps to build and run the Spring Boot application:

Clean and build the project:

Run the application:
The application will start on http://localhost:8080.

4
 API Endpoints
The following API endpoints are available:

First API
● Create a POST api to create and save a new training center with the following
fields.
○ CenterName (text)* (less than 40 characters)
○ CenterCode (text)* (exactly 12 character alphanumeric)
○ Address (object)*
■ Detailed Address
■ City
■ State
■ Pincode
○ Student Capacity (number)
○ Courses Offered (List<text>)
○ CreatedOn (Epoch time generated by System, not by user)
○ ContactEmail (text) (If present, email should be validated)
○ ContactPhone (text)* (Phone number validation )


POST /api/save
This API allows you to create a new training center.

Request:

Method: POST

URL: http://localhost:8080/api/save

Headers: Content-Type: application/json

Body:
{
  "centerName": "Tech Training Center",
  "centerCode": "ABC123456789",
  "address": {
    "detailedAddress": "123 Main St",
    "city": "Bangalore",
    "state": "Karnataka",
    "pincode": "560001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "contactEmail": "techcenter@example.com",
  "contactPhone": "9876543210"
}

Response:

Status Code: 201 Created

Body:

json
Copy code
{
  "id": 1,
  "centerName": "Tech Training Center",
  "centerCode": "ABC123456789",
  "address": {
    "detailedAddress": "123 Main St",
    "city": "Bangalore",
    "state": "Karnataka",
    "pincode": "560001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "createdOn": 1696789012,
  "contactEmail": "techcenter@example.com",
  "contactPhone": "9876543210"
}

Second API
● Create a GET api to get list of all stored training centers information.
● Api should return the result in json format.
● In the absence of any training centers, we need to return an empty list in response.

GET /api/all
This API retrieves the list of all training centers. If no training centers exist, it returns an empty list.

Request:

Method: GET
URL: http://localhost:8080/api/all
Response:

Status Code: 200 OK

Body (if no centers exist):

json
Copy code
[]
Body (if centers exist):

json
Copy code
[
  {
    "id": 1,
    "centerName": "Tech Training Center",
    "centerCode": "ABC123456789",
    "address": {
      "detailedAddress": "123 Main St",
      "city": "Bangalore",
      "state": "Karnataka",
      "pincode": "560001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Spring Boot", "Docker"],
    "createdOn": 1696789012,
    "contactEmail": "techcenter@example.com",
    "contactPhone": "9876543210"
  }
]
