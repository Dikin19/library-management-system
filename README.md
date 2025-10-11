# 📚 Library Management System

> Sistem manajemen perpustakaan modern yang dibangun dengan Spring Boot 3, dilengkapi dengan JWT Authentication, role-based authorization, dan RESTful API yang lengkap.

## 🎯 **Deskripsi Aplikasi**

Library Management System adalah aplikasi web untuk mengelola perpustakaan digital yang memungkinkan administrator dan anggota untuk mengelola buku, peminjaman, dan profil pengguna dengan sistem keamanan yang baik. Aplikasi ini dirancang dengan arsitektur yang scalable dan menggunakan teknologi terkini.

### ✨ **Fitur Utama**

🔐 **Authentication & Authorization**

- Login/Register dengan JWT Token
- Role-based access control (Admin & Member)
- Session management yang aman

👤 **User Management**

- Manajemen profil pengguna
- Sistem role dan permission
- Data validation yang ketat

📖 **Book Management**

- CRUD operations untuk buku
- Kategori dan pencarian buku
- Inventory management

📋 **Loan Management**

- Sistem peminjaman buku
- Tracking status peminjaman
- History peminjaman pengguna

🛡️ **Security Features**

- JWT-based authentication
- Password encryption dengan BCrypt
- CORS configuration untuk deployment
- Input validation dan sanitization

## 🚀 **Demo & Screenshots**

### 📊 **Sistem Architecture**

![Library Management System Architecture](./LibraryManagementSystem.png)

### 🗄️ **Database Schema**

![Database ERD](./LibraryManagementSystem-EDR.png)

## 🛠️ **Tech Stack**

### **Backend**

- **Java 21** - Programming language
- **Spring Boot 3.5.5** - Application framework
- **Spring Security** - Security framework
- **Spring Data JPA** - Data persistence
- **PostgreSQL** - Primary database
- **Maven** - Dependency management

### **Authentication & Authorization**

- **JWT (jjwt)** - Token-based authentication
- **BCrypt** - Password hashing

### **Documentation & Testing**

- **SpringDoc OpenAPI** - API documentation (Swagger)
- **JUnit 5** - Unit testing
- **Mockito** - Mocking framework

### **Utilities**

- **Lombok** - Reduce boilerplate code
- **Commons Lang3** - Utility functions
- **Logback** - Logging framework

## 📋 **Prerequisites**

Pastikan Anda memiliki tools berikut terinstall:

- ☕ **Java 21** atau lebih baru
- 🔧 **Maven 3.6+**
- 🐘 **PostgreSQL 15+**
- 🎯 **Git** (untuk clone repository)

## ⚡ **Quick Start**

### 1️⃣ **Clone Repository**

```bash
git clone https://github.com/Dikin19/library-management-system.git
cd library-management-system
```

### 2️⃣ **Setup Database**

```sql
-- Buat database baru
CREATE DATABASE LibraryManagementSystem;

-- Buat user (optional)
CREATE USER library_user WITH PASSWORD 'library_password';
GRANT ALL PRIVILEGES ON DATABASE LibraryManagementSystem TO library_user;
```

### 3️⃣ **Konfigurasi Database**

Edit file `src/main/resources/profile/development/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/LibraryManagementSystem
    username: postgres # sesuaikan dengan username Anda
    password: postgres # sesuaikan dengan password Anda
```

### 4️⃣ **Install Dependencies & Run**

```bash
# Install dependencies
mvn clean install

# Jalankan aplikasi
mvn spring-boot:run
```

### 5️⃣ **Akses Aplikasi**

- 📖 **Swagger UI**: [https://library.msodikin.web.id/swagger-ui/index.html#](https://library.msodikin.web.id/swagger-ui/index.html#)
- 📊 **API Docs**: [https://library.msodikin.web.id/api-docs](https://library.msodikin.web.id/api-docs)

## 👥 **Default Users untuk Testing**

Aplikasi sudah menyediakan akun default untuk testing:

### 🔑 **Admin Account**

```json
{
  "username": "admin1",
  "password": "admin123"
}
```

### 👤 **Member Account**

```json
{
  "username": "member1",
  "password": "member123"
}
```

## 🎭 **User Roles & Permissions**

### 👑 **Admin Role**

Memiliki akses penuh ke sistem dengan kemampuan:

- 🏢 **User Management**

  - ✅ Mengelola semua user member (Create, Read, Update, Delete)
  - ✅ Melihat daftar semua pengguna
  - ✅ Mengubah status dan role pengguna

- 📚 **Book Management**

  - ✅ Menambahkan buku baru ke perpustakaan
  - ✅ Mengupdate informasi buku
  - ✅ Menghapus buku dari sistem
  - ✅ Melihat seluruh koleksi buku

- 📋 **Loan Management**

  - ✅ Melihat semua transaksi peminjaman
  - ✅ Approve/reject peminjaman
  - ✅ Mengelola pengembalian buku
  - ✅ Generate laporan peminjaman

- 👤 **Profile Management**
  - ✅ Mengelola profile semua user
  - ✅ Update informasi user lain

### 🎓 **Member Role**

Akses terbatas untuk pengguna umum dengan kemampuan:

- 📖 **Book Access**

  - ✅ Melihat daftar buku tersedia
  - ✅ Mencari buku berdasarkan kriteria
  - ✅ Melihat detail informasi buku

- 📋 **Personal Loan Management**

  - ✅ Meminjam buku yang tersedia
  - ✅ Melihat riwayat peminjaman pribadi
  - ✅ Check status peminjaman aktif

- 👤 **Personal Profile**
  - ✅ Mengelola profile pribadi
  - ✅ Update informasi personal

## 🛣️ **API Endpoints**

### 🔐 **Authentication Endpoints**

```http
POST   /auth/register          # Register pengguna baru
POST   /auth/login             # Login dan dapatkan JWT token
GET    /auth/logout            # Logout dan invalidate token
```

### 👥 **Admin Management (Admin Only)**

```http
POST   /admin/update           # Update data user
GET    /admin/find-all         # Dapatkan semua user
GET    /admin/find-by-id/{id}  # Dapatkan user berdasarkan ID
DELETE /admin/delete/{id}      # Hapus user
```

### 📚 **Book Management**

```http
POST   /book/create            # Tambah buku baru (Admin only)
PUT    /book/update            # Update buku (Admin only)
GET    /book/find-all          # Dapatkan semua buku (Public)
GET    /book/find-by-id/{id}   # Dapatkan buku berdasarkan ID (Public)
DELETE /book/delete/{id}       # Hapus buku (Admin only)
```

### 📋 **Loan Management**

```http
POST   /loan/pinjam-buku              # Pinjam buku (Member)
POST   /loan/kembalikan-buku/{loanId} # Kembalikan buku (Admin)
GET    /loan/find-all                 # Dapatkan semua peminjaman (Admin)
```

### 👤 **Profile Management**

```http
POST   /profile/create         # Buat profile baru
POST   /profile/update         # Update profile
GET    /profile/find-all       # Dapatkan semua profile
GET    /profile/find-by-id/{id} # Dapatkan profile berdasarkan ID
DELETE /profile/delete/{id}    # Hapus profile
```

### 🎯 **Menjalankan dengan Profile Tertentu**

```bash
# Development
mvn spring-boot:run

# Staging
mvn spring-boot:run -Dspring-boot.run.profiles=staging

# Production
mvn spring-boot:run -Dspring-boot.run.profiles=production
```

## 🔒 **Security Implementation**

### 🛡️ **JWT Authentication**

- **Token Duration**: 1 jam
- **Algorithm**: HS256
- **Header Format**: `Authorization: Bearer <token>`

### 🔐 **Password Security**

- **Hashing**: BCrypt dengan salt rounds
- **Validation**: Minimum requirements enforced

### 🌐 **CORS Configuration**

```java
// Mendukung cross-origin requests untuk deployment
@CrossOrigin(origins = "*")
// Atau konfigurasi global di CorsConfig.java
```

## 🚀 **Deployment Guide**

### 🐳 **Docker Deployment**

```dockerfile
# Dockerfile tersedia untuk containerization
FROM openjdk:21-jdk-slim
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

```bash
# Build dan run dengan Docker
docker build -t library-management-system .
docker run -p 8080:8080 library-management-system
```

### ☁️ **Cloud Deployment**

Aplikasi sudah dikonfigurasi untuk deployment di:

- **Render**

Custome domain :

- **Cloudflare**

## 🔧 **Troubleshooting**

### ❌ **Common Issues & Solutions**

#### 🗄️ **Database Connection Error**

```
Error: Could not connect to PostgreSQL
```

**Solution:**

1. Pastikan PostgreSQL service running
2. Check database credentials di `application.yml`
3. Pastikan database `LibraryManagementSystem` sudah dibuat
4. Test koneksi dengan: `psql -h localhost -U postgres -d LibraryManagementSystem`

#### 🔑 **JWT Token Error**

```
Error: JWT token expired or invalid
```

**Solution:**

1. Login ulang untuk mendapatkan token baru
2. Pastikan format header: `Authorization: Bearer <token>`
3. Check token expiration (1 jam default)

#### 🚫 **Permission Denied**

```
Error: Access Denied
```

**Solution:**

1. Pastikan user login dengan role yang sesuai
2. Check endpoint requirements (Admin/Member only)
3. Verify JWT token masih valid

#### 🌐 **CORS Error**

```
Error: CORS policy blocked
```

**Solution:**

1. Aplikasi sudah dikonfigurasi CORS untuk semua origin
2. Pastikan menggunakan HTTP/HTTPS schema
3. Check browser developer tools untuk detail error

#### 📖 **API Testing**

1. **Swagger UI**: Paling mudah untuk testing interaktif

## 🤝 **Contributing**

### 📋 **Development Workflow**

1. Fork repository
2. Create feature branch: `git checkout -b feature/amazing-feature`
3. Commit changes: `git commit -m 'Add amazing feature'`
4. Push to branch: `git push origin feature/amazing-feature`
5. Open Pull Request

## 👨‍💻 **Authors & Contributors**

- **Dikin19** - _Initial work_ - [GitHub Profile](https://github.com/Dikin19)

## 🙏 **Acknowledgments**

- Spring Boot team untuk framework yang excellent
- PostgreSQL community untuk database yang robust
- JWT.io untuk authentication standards
- OpenAPI untuk API documentation standards

---

<div align="center">

**📚 Made with ❤️ for Library Management**

[![GitHub stars](https://img.shields.io/github/stars/Dikin19/library-management-system.svg?style=social&label=Star)](https://github.com/Dikin19/library-management-system)
[![GitHub forks](https://img.shields.io/github/forks/Dikin19/library-management-system.svg?style=social&label=Fork)](https://github.com/Dikin19/library-management-system/fork)

</div>
