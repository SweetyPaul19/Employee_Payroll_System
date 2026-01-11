**Employee Payroll Management System**
**📌 Project Description**

  The Employee Payroll Management System is a Java-based web application that manages employee details, attendance, salary calculation, and payslip generation. The system uses MySQL as the database and provides a   simple, user-friendly interface for payroll processing.

**✨ Features**

Employee registration and login
Admin login and dashboard
Employee detail management
Attendance-based salary calculation
Allowances and deduction handling
Payroll processing
Payslip generation
Secure data storage using MySQL

**🛠️ Technologies Used**

Frontend: HTML, CSS, JavaScript, JSP
Backend: Java (Servlets)
Database: MySQL
Server: Apache Tomcat
IDE: Eclipse
Database Connectivity: JDBC

**🧮 Salary Calculation Logic**

Gross Salary = Basic Salary + Allowances
Deductions = Leave / Other deductions
Net Salary = Gross Salary − Deductions

**📂 Project Structure**
Registerlogin/
│
├── src/
│   └── main/
│       └── webapp/
│           ├── images/
│           │   ├── employee.png
│           │   ├── logo.png
│           │   └── payroll-illustration.png
│           │
│           ├── admin-login.jsp
│           ├── dashboard.jsp
│           ├── employee-management.jsp
│           ├── payslip.jsp
│           ├── register.jsp
│           ├── runpayroll.jsp
│           ├── salary-calculation.jsp
│           ├── index1.jsp
│           ├── contact.html
│           ├── style.css
│           ├── employee.js
│           └── main.js
│
├── build/
│   └── classes/
│       └── in/sp/backend/
│           ├── Admin.class
│           ├── Employee.class
│           ├── Payroll.class
│           ├── Payslip.class
│           └── Register.class
│
├── .classpath
├── .project
├── .settings/
└── README.md

**🚀 How to Run the Project**

Import the project into Eclipse
Configure MySQL database and update credentials in Java files
Add MySQL JDBC Connector to the project
Deploy the project on Apache Tomcat Server
Open browser and run the application

**🎯 Objective**

The main objective of this project is to automate payroll processing, reduce manual errors, and efficiently manage employee salary records using a database-driven system.

**Made with ❤️ by Sweety**
