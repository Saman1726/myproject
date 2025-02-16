# 💰 Expense Tracker API – A Personal Finance Management System

## Concept:
A Spring Boot REST API that allows users to track their income and expenses, categorize transactions, and generate reports.

## Why is this a great project?
- ✅ Demonstrates CRUD operations (Create, Read, Update, Delete transactions).
- ✅ Showcases database relationships (Users → Transactions → Categories).
- ✅ Includes authentication & role-based access control (RBAC) (Admin/User).
- ✅ Real-world use case (People need to manage finances, so it’s relatable).
- ✅ Scalable & cloud-ready (Deploy using AWS, Docker, and CI/CD).

## 🚀 Features

### 1️⃣ User Management
- User Registration/Login (JWT Authentication)
- Roles: Admin vs. Regular User
- Password Reset via Email (AWS SES or SMTP)

### 2️⃣ Transactions
- Users can add, edit, delete, and view transactions.
- Each transaction has:
  - amount (positive = income, negative = expense)
  - category (Food, Rent, Salary, etc.)
  - date (when it happened)
  - description (optional)

### 3️⃣ Categories
- Users can define categories for better organization.
  - Example categories: Food, Rent, Entertainment, Salary.

### 4️⃣ Reports & Analytics
- Monthly expense summary (how much spent in each category).
- Total balance calculation (income – expenses).
- Top spending categories visualization (if frontend is added).
- Export to CSV or PDF.

### 5️⃣ Extra Features (Optional, Advanced)
- Recurring Expenses (e.g., rent auto-added every month).
- Budget Alerts (notify users when they overspend).
- Multi-user household accounts (shared finances).

## 🛠️ Tech Stack

### Backend:
- Spring Boot (Core Framework)
- Spring Security + JWT (User authentication)
- Spring Data JPA (Hibernate) (Database ORM)
- PostgreSQL/MySQL (AWS RDS) (Database)

### Deployment & Cloud:
- AWS RDS → Managed relational database.
- Docker + AWS Fargate → Run containerized app without managing servers.
- GitHub Actions (CI/CD) → Automate build & deployment.
- Swagger (OpenAPI) → API documentation.

### Optional Enhancements:
- AWS S3 → Store receipts if users want to attach bills.
- AWS SES → Send email notifications (e.g., "You spent too much this month!").
- Redis (AWS ElastiCache) → Cache frequent database queries.

## 💾 Database Schema Design

Here’s a simple ERD (Entity Relationship Diagram):

```
User (id, name, email, password, role)
  ├── Transaction (id, user_id, amount, category_id, date, description)
  ├── Category (id, name, user_id)
```

- Users have many transactions.
- Transactions belong to a category (like Food, Salary, etc.).
- Each user has their own categories (personalized finance tracking).

## 📡 API Endpoints

### Authentication (/api/auth/)
- ✅ POST /register → Sign up new users.
- ✅ POST /login → Get JWT token.

### Transactions (/api/transactions/)
- ✅ GET / → List all transactions for the user.
- ✅ POST / → Add a new transaction.
- ✅ PUT /{id} → Edit a transaction.
- ✅ DELETE /{id} → Delete a transaction.

### Categories (/api/categories/)
- ✅ GET / → List user’s categories.
- ✅ POST / → Create a new category.
- ✅ PUT /{id} → Rename a category.
- ✅ DELETE /{id} → Delete a category.

### Reports (/api/reports/)
- ✅ GET /monthly-summary → Get spending summary for the month.
- ✅ GET /top-categories → See where most money is spent.

## 🚀 Deployment Plan

1. Develop the API Locally (Spring Boot + Docker).
2. Set Up AWS RDS (PostgreSQL/MySQL database).
3. Containerize with Docker (Build a Spring Boot image).
4. Deploy on AWS Fargate (Fully managed container service).
5. Automate CI/CD with GitHub Actions (Auto-deploy on code push).
6. Monitor logs & performance using AWS CloudWatch.

## 🎨 Optional Frontend (If Needed)

- React or Vue.js → Simple dashboard to visualize finances.
- Axios (API calls) → Fetch transactions & categories.
- Chart.js or Recharts → Graphs for spending trends.

## 📌 Why This Project is Great for a Portfolio?

- 🎯 Real-world use case (shows practical backend skills).
- 🎯 Demonstrates authentication, data storage, and security.
- 🎯 Cloud-native deployment (shows AWS, CI/CD, Docker skills).
- 🎯 Scalable & extendable (can add more features later).