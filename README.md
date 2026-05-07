# Homework 2 - Student & Teacher Management

## Overview
Spring Boot-based RESTful API designed to manage Students, Teachers, and their Many-to-Many relationships

## Tech Stack
- **Language:** Java 21
- **Framework:** Spring Boot 3.x
- **ORM:** Spring Data JPA
- **Database:** H2 In-memory Database
- **API Testing:** Postman

## API Documentation

### 1. Student Management
- `POST /api/v1/students/save`: Register a new student
- `GET /api/v1/students/getAllStudents`: Retrieve all students
- `GET /api/v1/students/details/{id}`: Get student info with their assigned teachers

### 2. Teacher Management
- `POST /api/v1/teachers/save`: Register a new teacher
- `GET /api/v1/teachers/getAllTeachers`: Retrieve all teachers

### 3. Relationship Management
- `POST /api/v1/assign/student-to-teacher?student_id={id}&teacher_id={id}`: Assign a teacher to a student

## Setup
1. Clone the repo
2. Build using Maven: `./mvnw clean install`
3. Run: `./mvnw spring-boot:run`
4. H2 Console: `http://localhost:8080/h2-console` 
   - **JDBC URL:** `jdbc:h2:mem:testdb`
   - **User:** `sa` | **Password:** (blank)
