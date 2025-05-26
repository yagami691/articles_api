
# 📰 Articles & Comments API

A RESTful API built with **Spring Boot** and **PostgreSQL**, allowing you to:

- Manage **articles**
- Add and view **comments** related to an article

---

## 🚀 Getting Started

### 1. ⚙️ Prerequisites

- Java 17+
- Maven
- PostgreSQL
- An API testing tool (Postman, Thunder Client, etc.)

### 2. 📦 Database Configuration

Create a PostgreSQL database named `articles_db` (or any other name), and configure `application.properties` as follows:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/articles_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. ▶️ Running the Application

From your IDE or terminal:

```bash
./mvnw spring-boot:run
```

---

## 🔗 API Endpoints

### 📥 Add an Article

```http
POST /api/articles
Content-Type: application/json
```

#### 🔸 Request Body

```json
{
  "title": "AI in Africa",
  "content": "Will the africans also explore this opportunity?",
  "publicationDate": "2023-05-04"
}
```

---

### 📄 Get All Articles

```http
GET /api/articles/allUsers
```

---

### 🔍 Get Article by ID

```http
GET /api/articles/articlesId?id=4
```

---

### 📝 Update an Article

```http
PUT /api/articles/7
Content-Type: application/json
```

#### 🔸 Request Body

```json
{
  "title": "Introduction to Spring Boot",
  "content": "Spring Boot simplifies the development of Java applications.",
  "publicationDate": "2025-05-26"
}
```

---

### ❌ Delete an Article

```http
DELETE /api/articles/7
```

---

### 💬 Add a Comment to an Article

```http
POST /api/articles/addComment
Content-Type: application/json
```

#### 🔸 Request Body

```json
{
  "comment": "Fascinating topic, but feels like science fiction for regular folks right now.",
  "article": {
    "id": 7
  }
}
```

---

## ✅ Expected Output

Requests will return `Article` and `Comment` objects in JSON format. Errors will return clear messages (404, 400, etc.).

---

## 🛠 Entity Structure Example

- `Articles` (id, title, content, publicationDate, comments)
- `Comments` (id, comment, article)

Relationship:
- One `Article` has many `Comments`
- A `Comment` is linked to one `Article`

---

## 👨‍💻 Author

Developed by: **Nkounga Moïse**
