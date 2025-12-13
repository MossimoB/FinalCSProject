# FinalCSProject

## School System

### Author: Mossimo Bianco 2585451

This project is a Java-based student academic record management system.
It allows the creation and management of student files, including personal information, academic departments, enrolled courses, assignments, and grades.

The system supports:

* Registering and dropping students from courses
* Creating courses under specific departments
* Adding assignments with weights to courses
* Recording and calculating student scores
* Displaying academic records such as assignment averages and final grades

The goal of this project is to model a realistic academic environment while applying object-oriented programming principles such as encapsulation, association, and data validation.

---

## **Classes and Responsibilities**

### **Department**

Represents an academic department (e.g., Computer Science, Mathematics).

**Responsibilities:**

* Stores the department name and department ID
* Validates department names
* Associates courses and students with a department

---

### **Student**

Represents a student enrolled in the institution.

**Responsibilities:**

* Stores student name, student ID, gender, address, and department
* Registers for and drops courses
* Displays academic records for enrolled courses

---

### **Course**

Represents a course offered by a department.

**Responsibilities:**

* Stores course name, credit value, and department
* Manages registered students
* Stores assignments and their weights
* Validates total assignment weights
* Calculates student performance in the course
* Displays academic records for all registered students

---

### **Assignment**

Represents an assignment within a course.

**Responsibilities:**

* Stores assignment name, weight, and maximum score
* Stores individual student scores
* Calculates assignment averages

---

### **Address**

Represents a student’s address.

**Responsibilities:**

* Stores street number, street name, city, province, and postal code
* Validates Canadian postal codes

---

### **Util**

A utility class used for string formatting.

**Responsibilities:**

* Converts strings to title case
* Ensures consistent formatting of student names, course names, and department names

---

## **Enumerations**

### **Gender**

Restricts gender values to predefined options:

* MALE
* FEMALE

---

### **Province**

Restricts province values to valid Canadian provinces.

---

## **Key Features**

* Object-oriented design with clear class responsibilities
* Data validation to ensure correctness
* Academic record calculation and display
* Clean separation of concerns between classes
* Utility support for consistent data formatting

---

## **Conclusion**

This project demonstrates the practical application of object-oriented programming concepts in Java by modeling a real-world academic management system.
It emphasizes clean design, modularity, and data integrity while providing meaningful functionality for managing students and their academic records.

---
