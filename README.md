# 🚗 Automobile Store Management System

A full-stack web application built using **Spring Boot** to manage automobile store operations including customer records, inventory management, billing, and service tracking. Designed for retail-level management with clean UI and MySQL-backed data persistence.

---

## ✨ Features

- 🧾 Add, update, and delete customer records
- 🚙 Manage vehicle inventory and stock levels
- 💳 Generate and store billing information
- 📊 Dashboard view for store analytics

---

## 🛠 Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **Build Tool**: Maven
- **Deployment**: Heroku (via `Procfile` and `system.properties`)
- **Tools**: JPA

---

## 📦 Setup Instructions

### Prerequisites
- Java 11+
- Maven
- MySQL

### Steps

```bash
# Clone the repository
git clone https://github.com/saikirananumalla/store-management-system.git
cd store-management-system

# Set up MySQL
# Import db.sql into your local MySQL instance

# Build the app
./mvnw clean package

# Run the app
java -jar target/DBMS-0.0.1-SNAPSHOT.jar
