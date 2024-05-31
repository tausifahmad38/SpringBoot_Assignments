# SpringBoot_Assignments
Environment Setup Details
Required Software
Ensure the following software is installed and available on your local PC/Laptop. You can request these software in TARMAC.

OpenJDK 17 or above
STS IDE (Latest version 4)
Any database (MySQL/Oracle) OR any in-memory database (H2/HSQL)
General Instructions
Use H2 in-memory database for the assignments wherever applicable.
Use Maven build tool/Maven build based applications.
Create a separate project for each assignment. You can use Spring Initializr to create projects.
Capture screenshots of the output of the program wherever applicable and submit them along with the solutions.
Submit the src and pom.xml for each project.
Assignments
Assignment 1: Basic Spring Boot Application
Create a Spring Boot Application with the following requirements:

RESTful URLs:
URL 1: Displays the bank name as a string.
URL 2: Displays the bank address as a string.
Bean List:
Display the list of all default beans created by Spring Boot automatically in the console.
Testing:
Test the application by executing and viewing the console to see the list of beans.
Test both URLs to verify they return and display data as expected.
Assignment 2: Spring Boot Application with Thymeleaf
Create a Spring Boot Application with the following requirements:

RESTful URLs:
URL 1: Displays an HTML page with the bank name as the heading and a table with around 10 branches of the bank in Bangalore.
URL 2: Displays an HTML page with the bank name as the heading and a table with all services provided by the bank.
Health Check:
A /health path parameter should show the application's health status as UP/DOWN.
Thymeleaf Views:
Use Thymeleaf for the HTML views.
Testing:
Test both URLs to verify they return and display data as expected.
Assignment 3: Employee Management Application
Create a Spring Boot Application with the following requirements:

Employee Details:
Allow users to enter employee details: Employee ID, Employee Name, Employee Email, and Location.
Save the submitted data to a database table.
Display Employees:
URL 1: /displayAll - Show the list of all registered employees.
URL 2: /employee/{id} - Show details of the employee with the given Employee ID.
RESTful URLs:
Implement all functionalities as RESTful URLs.
Assignment 4: Employee Management with Map Storage
Create a Spring Boot Application with the following requirements:

Store Employee Details:
Store employee details in a Map with Employee ID as the key and the employee object as the value.
REST Operations:
GET: Retrieve details of all registered employees or details of an employee by Employee ID (Path Parameter).
POST: Save employee details into the Map.
PUT: Update/modify employee details except for Employee ID.
DELETE: Delete an unwanted employee record.
Testing:
Test all functionalities using any REST Client like Advanced REST Client (ARC) or Postman.
Example Configuration for Remote Access to H2
To enable remote access to the H2 database console, follow these steps:

Update application.properties or application.yml:

properties
Copy code
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:tcp://localhost/~/test
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
yaml
Copy code
spring:
  h2:
    console:
      enabled: true
      path: /h2-console
  datasource:
    url: jdbc:h2:tcp://localhost/~/test
    driverClassName: org.h2.Driver
    username: sa
    password: password
Enable H2 TCP Server Mode:

Add the following bean definition in your Spring Boot application's main class or a configuration class:

java
Copy code
package com.example;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootAssignment3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAssignment3Application.class, args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
Open Firewall Port:

Ensure that port 9092 is open in your firewall to allow remote connections.

Access H2 Console Remotely:

Navigate to http://<your-server-ip>:8081/h2-console in your web browser.

