# 🏦 Next Invest — Full-Stack Investment Platform  
### 💼 Powered by React, Spring Boot & Supabase

A modern, scalable **investment management** platform created as part of the **Flipr Labs Full-Stack Challenge**.  
Users can explore investment opportunities while admins manage offerings and newsletter subscriptions securely.

---

## 🌍 Live Production Deployment

| Layer | URL |
|------|-----|
| 🌐 Frontend | https://investplatform-flipr.onrender.com/ |
| 🔗 Backend API | https://flipr-backend-n9mi.onrender.com |
| 🗄️ Database | Supabase — Managed PostgreSQL Cloud DB |
| ☁️ Hosting | Render Cloud |

---

## ✨ Core Features

### 👥 User Platform
- View curated investment offerings
- Real-time charts (progress & returns analytics)
- Fully responsive (Mobile | Tablet | Desktop)
- Smooth animations + transitions
- Persistent **Dark / Light theme**

### 🛠 Admin Portal
- **Secure Authentication** (JWT + Role Based Access)
- CRUD operations on investment offerings
- Newsletter subscriber management
- Protected routing & session persistence

---

## 🧩 Technology Stack

### Frontend 🖥️

| Tech | Purpose |
|------|---------|
| React + Vite | UI development & optimization |
| Tailwind CSS | Fast + responsive UI styling |
| Framer Motion | Smooth animations for UI/UX |
| Chart.js (react-chartjs-2) | Data visualization |
| Axios | API handling with JWT |
| React Router DOM | Client-side routing |

---

### Backend ⚙️

| Tech | Purpose |
|------|---------|
| Spring Boot 3+ | RESTful API backend |
| Spring Security + JWT | Authentication & Authorization |
| JPA / Hibernate | ORM for DB interaction |
| PostgreSQL (Supabase) | Cloud-hosted scalable DB |
| Render | Deployment & hosting |

---

## 🗄️ Database — Supabase Configuration

```properties
spring.datasource.url=jdbc:postgresql://<SUPABASE_HOST>:5432/postgres
spring.datasource.username=<SUPABASE_USER>
spring.datasource.password=<SUPABASE_PASSWORD>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

jwt.secret=<YOUR_SECRET_KEY>
