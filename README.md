# 💼 Employee Payroll Management System

## 📌 Project Overview
The **Employee Payroll Management System** is a Java-based web application designed to efficiently manage employee records, attendance, salary processing, and payslip generation. It provides a simple, secure, and user-friendly interface for handling payroll operations within an organization.

---

## ✨ Features
- 🔐 **User Authentication**
  - Employee Registration & Login  
  - Admin Login & Dashboard  

- 👨‍💼 **Employee Management**
  - Add, update, and manage employee details  

- 📊 **Attendance & Payroll**
  - Attendance-based salary calculation  
  - Allowance and deduction handling  

- 💰 **Salary Processing**
  - Automated payroll generation  
  - Payslip creation and display  

- 🛡️ **Data Security**
  - Secure data storage using MySQL  

---

## 🛠️ Tech Stack

| Layer        | Technology                    |
|-------------|------------------------------|
| Frontend    | HTML, CSS, JavaScript, JSP   |
| Backend     | Java (Servlets)              |
| Database    | MySQL                        |
| Server      | Apache Tomcat                |
| IDE         | Eclipse                      |
| Connectivity| JDBC                         |

---

## 🧮 Salary Calculation Logic

- **Gross Salary** = Basic Salary + Allowances  
- **Deductions** = Leaves / Other Deductions  
- **Net Salary** = Gross Salary − Deductions  

---

## 📁 Project Structure

```
Registerlogin/
├── src/
│ └── main/
│ └── webapp/
│ ├── images/
│ │ ├── employee.png
│ │ ├── logo.png
│ │ └── payroll-illustration.png
│ ├── admin-login.jsp
│ ├── dashboard.jsp
│ ├── employee-management.jsp
│ ├── payslip.jsp
│ ├── register.jsp
│ ├── runpayroll.jsp
│ ├── salary-calculation.jsp
│ ├── index1.jsp
│ ├── contact.html
│ ├── style.css
│ ├── employee.js
│ └── main.js
│
├── build/
│ └── classes/
│ └── in/sp/backend/
│ ├── Admin.class
│ ├── Employee.class
│ ├── Payroll.class
│ ├── Payslip.class
│ └── Register.class
│
├── .classpath
├── .project
├── .settings/
└── README.md
```


---

## 🚀 How to Run the Project

1. 📥 Import the project into **Eclipse**
2. ⚙️ Configure the **MySQL database** and update credentials
3. 🔌 Add the **MySQL JDBC Connector (JAR)**
4. 🌐 Deploy the project on **Apache Tomcat Server**
5. ▶️ Run the application in your web browser

---

## 📸 Screenshots
> Add screenshots here (Dashboard, Payslip, Login Page, etc.)

---

## 📈 Future Enhancements
- Role-based access control  
- Email payslip functionality  
- PDF download for payslips  
- REST API integration  
- Improved UI with modern frameworks  

---

## 🤝 Contribution
Contributions are welcome! Feel free to fork this repository and submit pull requests.

---

## 📄 License
This project is open-source and available under the **MIT License**.

---

## 👨‍💻 Author
Made with ❤️ by **Sweety**
