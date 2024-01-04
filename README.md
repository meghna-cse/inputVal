
# inputVal - ReST API for Input Validation

## About inputVal
inputVal is a ReST API developed for the CSE 5382 Secure Programming course at UTA. This project focuses on validating input using regular expressions, ensuring secure and efficient data handling in web applications.

## Project Overview

### Features

-   **Input Validation**: Utilizes regular expressions for robust input validation.
-   **Phone Book Application**: Demonstrates practical application with a phone book management system.
-   **Audit Logs**: Records operations with details like IP address, username, action, and timestamp.

### Design of the regular expression
For more details on the regular expression design, visit the [wiki](https://github.com/meghna-cse/inputVal/wiki/Regular-Expression#design-of-the-regular-expression)

## Getting Started

Follow these steps to get a local copy up and running:

### Prerequisites
-   Maven (for resolving dependencies)
-   Docker (for building and running the application)

### Installation and Setup
  
- Clone the repo:
	```sh
	git clone https://github.com/meghna-cse/inputVal.git` 
	```
-   Navigate to the project directory and follow these commands:
    -   Resolve Maven dependencies: `mvn clean install`
    -   Build Docker image: `docker build -t [image_name] .`
    -   Create Docker network: `docker network create [network_name]`
    -   Run Docker container: `docker run -d -p 8080:8080 --network [network_name]`
-   Access the application at [http://localhost:8080](http://localhost:8080/).

## Usage

The API provides endpoints for managing a phone book:

-   **List Contacts**: `GET /PhoneBook/list`
-   **Add Contact**: `POST /PhoneBook/add` (Parameters: name, phoneNumber)
-   **Delete by Phone Number**: `PUT /PhoneBook/deleteByPhoneNumber` (Parameter: phoneNumber)
-   **Delete by Name**: `PUT /PhoneBook/deleteByName` (Parameter: name)

## Dependencies
-   Snake Yaml, Xerial JDBC, Hibernate ORM, Spring Boot (Starter test, data JPA, web)
