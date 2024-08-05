# Store
Retail Store Billing System
This project implements a RESTful API for handling billing operations in a retail store. It calculates the net payable amount based on user type, items purchased, and applicable discounts.

Prerequisites
Before running the application, ensure you have the following installed:

Java JDK 21 or higher
Gradle build tool (version specified in build.gradle)
Getting Started
Follow these instructions to get the project up and running on your local machine.

Clone the Repository
bash
Copy code
git clone https://github.com/geethakrishna544/Retail-Store
cd Retail-Store
Build the Project
To build the project, run the following Gradle command:
gradle build
This command compiles the source code, executes tests, and packages the application into a JAR file located in build/libs/.

Run the Application
You can run the application using the following Gradle command:
gradle bootRun
The application will start, and you can access the endpoints at http://localhost:8080.

API Documentation (Swagger)
The API documentation is generated using Swagger. Once the application is running, you can access the Swagger UI at:
http://localhost:8080/swagger-ui.html
