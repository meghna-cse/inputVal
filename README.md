Course: CSE 5382 Secure Programming
*This project was created as part of my Graduate coursework.
  ## Problem Statement
  To produce a ReST API that validates its input using regular expressions.
  
  ## BUILDING AND RUNNING THE APPLICATION
  To build and run the below commands, the current working directory should be the home directory of the project. 
  1. Before the docker image can be created, we need to resolve the maven dependencies. For this maven should be installed on the machine.
  2. Build the application using the following command: `mvn clean install`.
  3. Build docker image using the following command: `docker build -t` .
  4. Create docker network using the following command: `docker network create`.
  5. Run the docker container using the following command: `docker run -d -p 8080:8080 --network`
  6. The application is now up and running on port 8080. To access the application use the following URL: http://localhost:8080 or http://127.0.0.1:8080 

Now, we can access the various ReST endpoints using the following URLs: 
1. http://localhost:8080/PhoneBook/list 
		- Method: GET
		- Parameters: None
		- Response: List of all the contacts in the phone book. 
2.  http://localhost:8080/PhoneBook/add
		- Method: POST
		- Parameters: name, phoneNumber
		- Response: the contact added to the phone book or an error message. 
3.  http://localhost:8080/PhoneBook/deleteByPhoneNumber 
		- Method: PUT
		- Parameters: phoneNumber
		- Response: success message.
4.  http://localhost:8080/PhoneBook/deleteByName
		- Method: PUT 
		- Parameters: name 
		- Response: success message.

## Dependencies used in the application

1. Snake Yaml : required by Xerial JDBC dependency
2. Xerial (SQLITE) JDBC
3. Hibernate ORM : A relational mapper for mapping declared Java objects into their table equivalents in the given dialect.
4. Spring Boot Starter test : necessary for carrying out the tests on the phone book application.
Comprises of mockito and JUnit which are necessary for successful testing of the application.
5. Spring Boot starter data JPA : provides a simplified way to access the SQLite relational database.
6. Spring Boot starter web : necessary for setting up the ReST endpoints within the application.

The application persists data in the SQLite database which is created by hibernate and stored within the application class files.

Using the REST endpoints, which can be accessed on Postman using the provided URL, data can be stored, retrieved, or manipulated accordingly.

## Audit Logs:
• The audit logs creates a record of the various operations that are carried out on the application including details such as the initiating IP address, the username, the processed data, the action being carried out, and the timestamp of the action.
• This data is stored in the SQLite database in the AuditLog table. The auditable processes include:
1. Listing phonebooks
2. Adding a phonebook
3. Deleting a phonebook by name
4. Deleting a phonebook by phone number

## Design of the regular expression

[Wiki Link](https://github.com/meghna-cse/inputVal/wiki/Regular-Expression#design-of-the-regular-expression)