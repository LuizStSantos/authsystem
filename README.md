# AuthSystem 🚀

AuthSystem is a user authentication system built with Spring Boot. It allows users to register, log in, and view a personalized welcome page. The application uses cookies to manage user sessions and PostgreSQL as the database.

## Features ✨

- ✅ User registration with validation.
- 🔒 User login with authentication.
- 🎉 Personalized welcome page after login.
- 🍪 Cookies for session management.
- 📱 Responsive UI with Bootstrap.

## Project Structure 🗂️

```
authsystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.github.luizstsantos.authsystem/
│   │   │   │   ├── AuthsystemApplication.java       # Main application entry point
│   │   │   │   ├── DataConfiguration.java          # Database configuration
│   │   │   │   ├── controller/
│   │   │   │   │   └── loginController.java        # Handles login, registration, and home routes
│   │   │   │   ├── model/
│   │   │   │   │   └── user.java                   # User entity
│   │   │   │   ├── repository/
│   │   │   │   │   └── UserRepository.java         # Repository for user data
│   │   │   │   ├── service/
│   │   │   │   │   └── CookieService.java          # Utility for managing cookies
│   │   ├── resources/
│   │   │   ├── templates/
│   │   │   │   ├── login.html                      # Login page
│   │   │   │   ├── register.html                   # Registration page
│   │   │   │   └── home.html                       # Welcome page after login
│   │   │   ├── application.properties              # Application configuration
│   │   └── static/                                 # Static assets (if any)
├── pom.xml                                         # Maven configuration
└── README.md                                       # Project documentation
```

## Technologies Used 🛠️

- **Java 17**: Programming language.
- **Spring Boot**: Framework for building the application.
  - Spring MVC: For handling web requests.
  - Spring Data JPA: For database interaction.
- **PostgreSQL**: Relational database for storing user data.
- **Thymeleaf**: Template engine for rendering HTML views.
- **Bootstrap 4**: For responsive and modern UI design.
- **Jakarta Servlet API**: For managing HTTP requests and responses.

## Prerequisites 📋

- ☕ Java 17 or higher
- 🛠️ Maven
- 🐘 PostgreSQL

## Setup Instructions ⚙️

1. **Clone the repository**:
   ```bash
   git clone https://github.com/luizstsantos/authsystem.git
   cd authsystem
   ```

2. **Configure the database**:
   - Create a PostgreSQL database named `users`.
   - Update the `DataConfiguration.java` file with your database credentials:
     ```DataConfiguration
        dataSource.setUrl("jdbc:postgresql://localhost:5432/users?serverTimezone=UTC");
        dataSource.setUsername("your_username");
        dataSource.setPassword("your_password");
     ```

3. **Build and run the application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**:
   - Open your browser and go to `http://localhost:8080/login`.

## Endpoints 🌐

- **GET /login**: Displays the login page.
- **POST /login**: Authenticates the user and redirects to the home page.
- **GET /register**: Displays the registration page.
- **POST /register**: Registers a new user and redirects to the login page.
- **GET /home**: Displays the personalized welcome page.

## Screenshots 📸

### Login Page
![Login Page](https://github.com/user-attachments/assets/501dd8ce-f15b-48c5-832b-38a2bf908b77)

### Registration Page
![Registration Page](https://github.com/user-attachments/assets/80649c9c-eae5-4727-a629-bc77b8329577)

### Sucess Login Page
![Sucess Login Page](https://github.com/user-attachments/assets/c1ed2e40-11e7-4bf1-97c5-09ace2193fe5)

## License 📄

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author 👤

- **Luiz Santos** - [GitHub Profile](https://github.com/luizstsantos)