# Employee Payroll System (PAY ZEN)

## Project Overview
PAY ZEN is a web-based Employee Payroll System built using **Java Servlets, JSP, MySQL, HTML, CSS, and JavaScript**.  
It allows administrators to manage employees, calculate salaries, run payrolls, and view payslips efficiently.

---

## Features
- Admin login and management
- Add, edit, and delete employees
- Calculate salary and run payroll
- Generate payslips
- Dashboard showing total employees, payrolls, and salary processed
- Responsive frontend with HTML, CSS, and JS

---

## Folder Structure
EmployeePayrollSystem/
├── src/ # Java code (config, DAO, backend, servlets)
├── WebContent/ # Frontend files (JSP, HTML, CSS, JS, assets)
├── database/ # SQL schema and sample data
├── README.md # Project documentation
├── .classpath
└── .project

---

## Technologies Used
- **Backend:** Java Servlets, JSP  
- **Frontend:** HTML5, CSS3, JavaScript  
- **Database:** MySQL  
- **Server:** Apache Tomcat  
- **IDE:** Eclipse

---

## Setup Instructions

1. **Import Project into Eclipse**  
   - File → Import → Existing Projects into Workspace → Select `EmployeePayrollSystem`

2. **Database Setup**  
   - Create a database in MySQL: `employee_payroll`  
   - Run `employee_payroll.sql` to create tables  
   - Run `sample_data.sql` to insert sample records

3. **Configure DB Connection**  
   - Edit `DBConnect.java` if necessary (MySQL username/password)

4. **Run Project**  
   - Right-click project → Run As → Run on Server (Tomcat)  
   - Open in browser: `http://localhost:8080/EmployeePayrollSystem/`

---

## Author
**Your Name**  
Email: your.email@example.com

---

## License
This project is for educational purposes.
