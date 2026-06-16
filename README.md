# 🎓 Student Admission System

A web-based Student Admission Management System built using Spring Boot, Spring Security, Thymeleaf, JPA, and MySQL. The application allows administrators to securely manage student records through an intuitive user interface.

## Features

* Secure Admin Login
* Add New Students
* Update Existing Student Records
* Delete Students
* Search Students
* View Student Directory
* Spring Security Authentication
* Responsive User Interface

## Technologies Used

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Thymeleaf
* MySQL
* Maven
* HTML5
* CSS3

## Project Structure

```text
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── entity
│   │   ├── repository
│   │   └── config
│   └── resources
│       ├── templates
│       └── application.properties
└── test
```

## Screenshots

### Admin Login

<img width="1163" height="1132" alt="Screenshot 2026-06-16 220404" src="https://github.com/user-attachments/assets/003a72d2-ead8-4182-8b72-efe118197994" />


### Student Dashboard

<img width="1163" height="1132" alt="Screenshot 2026-06-16 220425" src="https://github.com/user-attachments/assets/a06a72d2-443d-4c83-9357-3473a8ce35d4" />


## Database Configuration

Update the database configuration in:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/StudentAdmissionDB
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

## Running the Application

Clone the repository:

```bash
git clone https://github.com/rohanandelkar/student-admission-system.git
```

Navigate to the project folder:

```bash
cd student-admission-system
```

Run the application:

```bash
mvn spring-boot:run
```

Open in browser:

```text
http://localhost:9090/login
```

## Future Enhancements

* Pagination
* Role-Based Access Control
* Student Photo Upload
* Export Data to Excel/PDF
* REST API Integration

## Author

Rohan Andelkar
