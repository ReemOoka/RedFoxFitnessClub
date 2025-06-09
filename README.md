# RedFoxFitnessClub
# 🏋️ Gym Management System

A Java-based desktop application that simulates the internal operations of a fitness center, including member management, staff interactions, scheduling, sales, and reporting.

This project demonstrates solid object-oriented design principles, layered architecture, exception handling, and modular structure using pure Java.

---

## 📌 Key Features

### 👤 Member & Guest Management
- Classes: `Member`, `Guest`, `MembershipPlan`
- Add, update, or remove gym members and assign them to fitness programs

### 🧑‍🏫 Gym Staff & UI Interaction
- Classes: `GymWorkersUI`, `OnlineUsersUI`
- Simulates user interfaces for gym employees and online users (CLI/console-based or GUI-like logic)

### 🏃 Fitness Sessions & Scheduling
- Classes: `GroupFitnessClass`, `PersonalTraining`, `Schedule`, `Session`, `Attendance`
- Organize and track class schedules, personal training appointments, and attendance records

### 📦 Inventory & Product Sales
- Classes: `Inventory`, `Product`, `Sales`, `PointSystem`
- Manage gym product inventory and record sales, implement a points-based rewards system

### 🧾 Reporting & Control
- Classes: `ReportGenerator`, `MembershipController`
- Generate usage and sales reports; control membership logic programmatically

### ⚠️ Exception Handling
- Class: `InvalidAgeException`
- Custom checked exception for validating member age or other constraints

---

## 🚀 Tech Stack

- **Language:** Java 11
- **Architecture:** Object-Oriented Modular Design
- **Testing:** JUnit (see `src/test/java`)
- **Build Tool:** Maven
- **UI Layer:** Simulated via Java classes (CLI logic)
- **IDE Used:** VS Code

---

## 📁 Project Structure

gymanagementsystem/
├── src/
│ ├── main/java/com/rffc/ # All core application classes
│ └── test/java/com/rffs/ # Unit test for system
├── pom.xml # Maven configuration
└── README.md


---

## 🧪 How to Run

> Make sure JDK 11+ and Maven are installed

1. **Clone the repo**
   ```bash
   git clone https://github.com/ReemPatel13/gymanagementsystem.git
   cd gymmanagementsystem


2. **Compile the project**
    ```bash
    mvn clean compile
    
3. **Run the application**
    ```bash
    mvn exec:java -Dexec.mainClass="com.rffc.GymApplication"
    
Or open in an IDE and run GymApplication.java directly

---
## 📊 Example Use Cases
Register members and guests

Schedule classes and track attendance

Assign trainers and manage personal training sessions

Handle inventory and record product sales

Generate reports for gym usage and finances

Use exception handling to catch and manage invalid inputs

---
## 📜 License
This project is licensed under the MIT License. See the LICENSE file for details.

---
## 🙋‍♀️ Author
Reem Ooka

Full Stack Java Developer | AI/ML Researcher


