# AI Smart Inventory Management System

An intelligent inventory management application built using **Java Spring Boot, React.js, and MySQL**. It helps businesses manage products, suppliers, stock transactions, and purchase orders while providing inventory insights and AI-powered assistance.

## 🚀 Features

### 1. User Authentication
- User registration and login.
- Password encryption using BCrypt.
- Role-based user information.
- Account activation status.

### 2. Product Management
- Add new products.
- Update product details.
- Delete products.
- View all products.
- Track product quantities and minimum stock levels.

### 3. Supplier Management
- Add and manage suppliers.
- Store supplier contact information.
- View supplier details.

### 4. Stock Management
- Track stock transactions.
- Monitor stock availability.
- Identify low-stock products.

### 5. Purchase Order Management
- Create purchase orders.
- Manage order information.
- Track purchase order status.

### 6. Dashboard
- Display inventory statistics.
- View product and supplier information.
- Monitor stock levels.

### 7. AI Inventory Assistant
- Rule-based low-stock detection.
- Suggested reorder quantities.
- Basic inventory question answering.
- Planned Google Gemini AI integration for natural-language inventory assistance.

## 🛠️ Technologies Used

| Category | Technologies |
|---|---|
| Backend | Java 25, Spring Boot 3.3.5 |
| Frontend | React.js, Vite, JavaScript |
| Database | MySQL |
| ORM | Spring Data JPA, Hibernate |
| Security | Spring Security, BCrypt |
| API | REST APIs |
| Build Tool | Maven |
| Icons | Lucide React |
| IDE | Eclipse, Visual Studio Code |
| API Testing | Postman |
| Version Control | Git and GitHub |

## 🏗️ Project Architecture

The project follows a layered architecture.

```text
AI-Smart-Inventory-Management/
│
├── backend/
│   └── src/main/java/com/inventory/smartinventory/
│       ├── config/
│       ├── controller/
│       ├── dto/
│       ├── entity/
│       ├── repository/
│       ├── service/
│       └── serviceimpl/
│
├── frontend/
│   └── src/
│       ├── components/
│       ├── pages/
│       ├── services/
│       ├── App.jsx
│       └── main.jsx
│
└── README.md
```

## ⚙️ Installation and Setup

### Prerequisites

Install the following software:

- JDK 25
- Node.js and npm
- MySQL Server
- Eclipse IDE or IntelliJ IDEA
- Visual Studio Code
- Git

### 1. Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

```bash
cd AI-Smart-Inventory-Management
```

### 2. Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE smart_inventory;
```

Configure `application.properties` in your backend:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smart_inventory
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

Replace the database username and password with your own credentials.

### 3. Run Backend

1. Open the backend project in Eclipse or IntelliJ IDEA.
2. Configure the MySQL database connection.
3. Run `SmartInventoryApplication.java`.

Backend URL:

```text
http://localhost:8080
```

### 4. Run Frontend

Open the frontend folder in Visual Studio Code.

Install dependencies:

```bash
npm install
```

Start the React application:

```bash
npm run dev
```

Frontend URL:

```text
http://localhost:5173
```

Use the Vite URL displayed in your terminal if it selects a different port.

## 🔗 REST API Endpoints

| Module | Method | Endpoint |
|---|---|---|
| Register | POST | `/api/auth/register` |
| Login | POST | `/api/auth/login` |
| Products | GET | `/api/products` |
| Suppliers | GET | `/api/suppliers` |
| Stock Transactions | GET | `/api/stock/transactions` |
| Purchase Orders | GET | `/api/purchase-orders` |
| Dashboard | GET | `/api/dashboard` |
| AI Recommendations | GET | `/api/ai/recommendations` |

Additional endpoints may be available for creating, updating, and deleting records.

## 🤖 AI Recommendation Logic

The current inventory recommendation service identifies products whose quantity is at or below the configured minimum stock level.

**Low-stock detection:**

```java
p.getQuantity() <= p.getMinStock()
```

**Suggested reorder quantity:**

```java
Math.max(p.getMinStock() * 2 - p.getQuantity(), 1)
```

The current recommendations use rule-based logic, not a trained machine learning model.

Google Gemini AI integration is planned to support natural-language inventory questions and contextual insights.

## 🔒 Security

- Passwords are encrypted using BCrypt.
- Passwords are excluded from JSON responses.
- Database credentials should be kept outside source code.
- Production deployment requires proper authentication and authorization.

## 🔮 Future Enhancements

- Complete Gemini AI chatbot integration.
- AI-based demand forecasting.
- Automated reorder suggestions.
- Supplier comparison and recommendations.
- Inventory trend analysis.
- Email alerts for low stock.
- JWT-based authentication and authorization.
- Cloud deployment.

## 👨‍💻 Developer

**Prashanth Potta**

B.Tech Computer Science and Engineering

**Technologies:** Java, Spring Boot, React.js, MySQL, REST APIs.

## 📄 License

This project is developed for educational and portfolio purposes.
