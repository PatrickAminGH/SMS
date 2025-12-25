🎓 School Management System (SMS)

A Java-based School Management System developed to manage essential academic and administrative operations efficiently.
The system is built using Object-Oriented Programming (OOP) principles and features a JavaFX graphical user interface for an intuitive user experience.

📌 Project Overview

The School Management System (SMS) is a desktop application designed for educational institutions to organize and manage students, subjects, and administrative processes in a structured and scalable way.

This project was developed as an academic software project, focusing on clean code, proper architecture, and practical implementation of data structures and OOP concepts.

🚀 System Features
👨‍🎓 Student Management

Add new students to the system

Remove students using their unique ID

Search and display student information

Maintain student records efficiently

📚 Subject Management

Add subjects with defined credit hours

Remove existing subjects

Associate subjects with students

👨‍💼 Admin Panel

Centralized admin menu

Action-based navigation using JavaFX scenes

Structured UI for management tasks

🖥️ Graphical User Interface

Built using JavaFX

Multi-scene (scene-based) navigation

Form-based input with validation

Clean layout using JavaFX containers

🛠️ Technologies Used
Technology	Purpose
Java	Core application logic
JavaFX	Graphical User Interface
OOP Principles	Encapsulation, Inheritance, Polymorphism
Scene-Based UI	Multi-window navigation
🧮 Data Structures Used

The system uses the following data structures to efficiently manage data:

🔹 LinkedList

Used to store and manage collections of:

Students

Subjects

Allows dynamic insertion and deletion without fixed size limitations

Ideal for frequently updated records

🔹 Queue (QueueLinkedList)

Implemented using a linked list

Used to manage ordered processing such as:

Student registration queues

Admin task sequencing

Follows FIFO (First In, First Out) principle

These data structures improve performance, organization, and real-world simulation of school workflows.

🧱 System Architecture

The project follows a modular, object-oriented architecture:

Model Layer

Student

Subject

Admin

UI Layer (JavaFX)

Add Student

Remove Student

Add Subject

Admin Menu

Control Logic

Event handling

Scene switching

Input validation

This separation ensures maintainability, scalability, and clarity.

📂 Project Structure
School-Management-System/
│
├── src/
│   ├── sms/
│   │   ├── Main.java
│   │   ├── Admin.java
│   │   ├── AddStudent.java
│   │   ├── RemoveStudent.java
│   │   ├── AddSubject.java
│   │   └── ...
│
├── resources/
│   └── styles / assets (if applicable)
│
├── README.md
└── .gitignore

▶️ How to Run the Project
Prerequisites

Java JDK 8 or higher

JavaFX properly configured

IDE such as IntelliJ IDEA, Eclipse, or NetBeans

Steps

Clone the repository:

git clone https://github.com/your-username/school-management-system.git


Open the project in your IDE

Configure JavaFX libraries if required

Run Main.java

📖 Learning Outcomes

This project demonstrates:

Real-world application of LinkedList and Queue data structures

Implementation of OOP concepts in Java

Building JavaFX multi-scene applications

Event-driven programming and UI management

Clean and modular project design

🔮 Future Enhancements

Database integration (SQLite / MySQL)

Login and role-based authentication

Attendance management

Grade calculation and reports

Export data to PDF or Excel

👤 Author

Youssef Ahmed
Faculty of Computers
Software & Multimedia Student

📜 License

This project is developed for educational purposes.
Free to use, modify, and extend for learning and academic projects.
