# Database Schema

## Table: students

| Column          | Data Type     | Constraints                  |
|-----------------|---------------|------------------------------|
| id              | BIGINT        | Primary Key, Auto-Increment  |
| full_name       | VARCHAR(255)  | Not Null                     |
| roll_number     | VARCHAR(100)  | Not Null, Unique             |
| college_name    | VARCHAR(255)  | Not Null                     |
| course_enrolled | VARCHAR(255)  | Not Null                     |

### SQL DDL Statement


CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    roll_number VARCHAR(100) NOT NULL UNIQUE,
    college_name VARCHAR(255) NOT NULL,
    course_enrolled VARCHAR(255) NOT NULL
);
