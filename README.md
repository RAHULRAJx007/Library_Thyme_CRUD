# 📚 Library_Thyme_CRUD

A **Spring Boot + Thymeleaf CRUD application** for managing books in a library.
This project is beginner-friendly and demonstrates real-world concepts like form validation, image upload, and database integration.

---

## 🚀 Features

* ➕ Add new books
* ✏️ Update existing book details
* ❌ Delete books
* 📋 View list of all books
* 🖼 Upload book cover image (stored in database)
* ✅ Form validation with user-friendly error messages
* 🎨 Responsive UI using Bootstrap

---

## 🛠️ Technologies Used

* **Java 17+**
* **Spring Boot**
* **Spring MVC**
* **Spring Data JPA (Hibernate)**
* **Thymeleaf**
* **MySQL** (or any relational DB)
* **Bootstrap 5**
* **Maven**

---

## 📂 Project Structure

```
Library_Thyme_CRUD
│
├── src/main/java/com/books
│   ├── controller
│   │   └── BookController.java
│   ├── model
│   │   └── Book.java
│   ├── repository
│   │   └── BookRepository.java
│   ├── service
│   │   └── BookService.java
│   └── LibraryThymeCrudApplication.java
│
├── src/main/resources
│   ├── templates
│   │   ├── book_form.html
│   │   ├── book_list.html
│   │   └── updatebook.html
│   ├── application.properties
│   └── static
│
└── pom.xml
```

---

## 🖼 Image Handling

* Book cover images are uploaded using `MultipartFile`
* Images are stored in the database as `byte[]` using `@Lob`
* Images are rendered in Thymeleaf using Base64 encoding

---

## ✅ Validation

This project uses **Jakarta Bean Validation**:

* `@NotBlank` for text fields
* `@Email` for email validation
* `@Pattern` for phone number validation

Validation errors are displayed **below each input field** in the UI.

---

## ⚙️ Configuration

### Database Configuration (`application.properties`)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

---

## ▶️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/RAHULRAJX007/Library_Thyme_CRUD.git
```

2. Open the project in **Eclipse / IntelliJ**

3. Configure your database in `application.properties`

4. Run the application:

```bash
mvn spring-boot:run
```

5. Open browser:

```
http://localhost:8080/
```

---

## 📌 Future Enhancements

* Pagination & search
* Image preview before upload
* Global exception handling
* User authentication (Spring Security)
* Deployment to cloud (Render / Railway)

---

## 👨‍💻 Author

**Rahul Raj**
GitHub: [RAHULRAJX007](https://github.com/RAHULRAJX007)

---

⭐ If you like this project, don’t forget to star the repository!
