# Hibernate UI Application

This project is an **advanced version** of a previous **console-based application**, now enhanced with a graphical **User Interface (UI)**. Built using **Hibernate**, this application retains the original core logic while offering a more intuitive and interactive user experience.

---

## 🖼️ UI Preview

Here’s a quick look at the graphical interface:

![UI Screenshot](https://github.com/AryanMevada/JAVA-Fullstack-Project3_Hibernate/blob/main/Screenshot%202025-04-22%20110034.png)

---

## 🚀 Features

- ✅ Full integration with **Hibernate ORM** for efficient database operations.
- 🎨 A clean and functional **UI** layer added on top of the console version.
- ⚡ Improved user experience and streamlined workflows.
- 🧱 Follows proper **MVC architecture** for maintainability and scalability.

  
## 📁 Project Structure

Hibernate-UI-Project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── dao/             # Data access objects (Hibernate logic)
│   │   │           ├── model/           # Entity classes
│   │   │           ├── service/         # Business logic
│   │   │           └── ui/              # UI components (Swing/JavaFX)
│   │   └── resources/
│   │       └── hibernate.cfg.xml       # Hibernate configuration
│
├── lib/                                 # External libraries (e.g., PostgreSQL driver)
│
├── images/                              # Screenshots for README
│   └── ui-screenshot.png
│
├── README.md                            # Project documentation
├── .gitignore
└── pom.xml or build.gradle              # Dependency management (if using Maven or Gradle)

## 📋 Prerequisites

Before running the project, make sure the following requirements are met:

- **Java JDK** (version 8 or later)
- **PostgreSQL** installed and running
- **PostgreSQL Database Configuration**:
  - Database Name: `studentdb`
  - Username: `postgres`
  - Password: `1234`

### 🔌 Hibernate Configuration (from `hibernate.cfg.xml`)

```xml
<!-- Database connection -->
<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/studentdb</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">1234</property>
```
## 🧰 Technologies Used

- **Java**
- **Hibernate**
- **[Your UI Framework, e.g., Swing / JavaFX]**
- **Maven** or **Gradle** (if applicable)

---

## ▶️ How to Run

1. Clone the repository and open the project in your preferred IDE (IntelliJ, Eclipse, etc.).
2. Set up your database and configure `hibernate.cfg.xml` accordingly.
3. Build and run the project. The UI should launch automatically.

---

## 🕹️ Previous Version

This version builds upon a simpler, **console-based** application. All existing backend logic remains intact, while a UI has been layered on top for enhanced usability.

---

## 📌 Notes

- Make sure all required dependencies are included in the `lib/` folder or managed via Maven/Gradle.
- This project is ideal for learning and demonstrating **Hibernate with UI integration**.

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).

...
