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

**Login Page**
> <img width="1280" height="617" alt="image" src="https://github.com/user-attachments/assets/bb234110-8370-423d-a1f0-bf76c4b6f53c" />
**Dashboard**
> <img width="1280" height="622" alt="image" src="https://github.com/user-attachments/assets/1309587b-863b-4d44-a9f1-217f07c6c990" />
**Registration Form**
> <img width="1280" height="616" alt="image" src="https://github.com/user-attachments/assets/e55cb801-15b4-44c8-880f-811899e34ae9" />
**Payroll**
> <img width="1280" height="616" alt="image" src="https://github.com/user-attachments/assets/fda56d51-6a5e-4b28-b991-4157edd499cf" />
**Salary Calculator**
> <img width="1280" height="618" alt="image" src="https://github.com/user-attachments/assets/3ac1a310-71fb-4e78-9d20-07a801462d20" />
**Employee Payslip**
> <img width="1280" height="616" alt="image" src="https://github.com/user-attachments/assets/c971b33e-0006-482f-83d0-2c551986f0d7" />

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

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!

---

## 👨‍💻 Author
Made with love❤️ by **Sweety**
