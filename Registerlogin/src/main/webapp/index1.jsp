<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="in.sp.backend.Employee" %>
<%
    List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Employee Management | PAY ZEN</title>
  <link rel="icon" href="assets/favicon.ico" type="image/x-icon">
  <style>
    /* ====== GLOBAL STYLES ====== */
    body {
      font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f8fafc;
      margin: 0;
      padding: 0;
      color: #222;
    }

    header {
      background: #003366;
      color: #fff;
      text-align: center;
      padding: 1rem 0;
    }

    header h1 {
      margin: 0;
      font-size: 2rem;
      letter-spacing: 1px;
    }

    nav {
      background-color: #004c99;
      text-align: center;
      padding: 0.6rem 0;
    }

    nav a {
      color: white;
      text-decoration: none;
      margin: 0 1.2rem;
      font-weight: 500;
      transition: color 0.3s;
    }

    nav a:hover {
      color: #ffd700;
    }

    main {
      max-width: 1100px;
      margin: 2rem auto;
      background: #fff;
      padding: 2rem;
      border-radius: 12px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      color: #003366;
      border-left: 4px solid #004c99;
      padding-left: 10px;
      margin-bottom: 1.5rem;
    }

    /* ====== FORM STYLES ====== */
    form {
      display: flex;
      flex-wrap: wrap;
      gap: 1rem;
      margin-bottom: 2rem;
    }

    form input {
      flex: 1 1 180px;
      padding: 0.6rem;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 0.95rem;
      transition: border 0.3s;
    }

    form input:focus {
      border-color: #004c99;
      outline: none;
    }

    form button {
      background-color: #004c99;
      color: white;
      border: none;
      padding: 0.7rem 1.5rem;
      border-radius: 6px;
      cursor: pointer;
      font-weight: 600;
      transition: background 0.3s;
    }

    form button:hover {
      background-color: #003366;
    }

    /* ====== TABLE STYLES ====== */
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 1rem;
    }

    th, td {
      padding: 0.9rem;
      border: 1px solid #ddd;
      text-align: center;
    }

    th {
      background-color: #004c99;
      color: white;
      font-weight: 600;
    }

    tr:nth-child(even) {
      background-color: #f4f6f8;
    }

    tr:hover {
      background-color: #e8f0fe;
    }

    td {
      font-size: 0.95rem;
    }

    /* ====== FOOTER ====== */
    footer {
      text-align: center;
      padding: 1rem;
      background-color: #003366;
      color: white;
      margin-top: 3rem;
      font-size: 0.9rem;
      letter-spacing: 0.5px;
    }

    /* ====== RESPONSIVE ====== */
    @media (max-width: 768px) {
      form {
        flex-direction: column;
      }

      nav a {
        display: inline-block;
        margin: 0.5rem;
      }

      th, td {
        font-size: 0.85rem;
      }
    }
  </style>
</head>
<body>

  <header>
    <h1>Employee Management</h1>
  </header>

  <nav>
    <a href="index1.jsp">Dashboard</a>
    <a href="employee-management.jsp">Employee Management</a>
    <a href="salary-calculation.jsp">Salary Calculator</a>
    <a href="runPayroll">Run Payroll</a>
  </nav>

  <main>
    <section class="add-employee">
      <h2>Register New Employee</h2>
      <form action="registerEmployee" method="post">
        <input type="text" name="firstName" placeholder="First Name" required>
        <input type="text" name="lastName" placeholder="Last Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="text" name="phone" placeholder="Phone" required>
        <input type="text" name="department" placeholder="Department" required>
        <input type="text" name="position" placeholder="Position" required>
        <input type="number" name="salary" placeholder="Basic Salary" required>
        <input type="date" name="hireDate" required>
        <button type="submit">Register</button>
      </form>
    </section>

    <%@ page import="java.sql.*" %>

<%
    // Database Connection
    String url = "jdbc:mysql://localhost:3306/employees";
    String user = "root";
    String pass = "20052005";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pass);
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM employees");  // change table name if needed
%>

<table>
  <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Phone</th>
      <th>Department</th>
      <th>Position</th>
      <th>Salary</th>
      <th>Actions</th> <!-- NEW COLUMN -->
    </tr>
  </thead>
  <tbody>
    <%
      boolean hasData = false;
      while (rs.next()) {
        hasData = true;
    %>
    <tr>
      <td><%= rs.getInt("id") %></td>
      <td><%= rs.getString("first_Name") + " " + rs.getString("last_Name") %></td>
      <td><%= rs.getString("email") %></td>
      <td><%= rs.getString("phone") %></td>
      <td><%= rs.getString("department") %></td>
      <td><%= rs.getString("position") %></td>
      <td>₹<%= rs.getDouble("salary") %></td>
      <td>
        <!-- EDIT & DELETE BUTTONS -->
        <a href="edit-employee.jsp?id=<%= rs.getInt("id") %>" style="color:green;">Edit</a> |
        <a href="deleteEmployee?id=<%= rs.getInt("id") %>" style="color:red;"
           onclick="return confirm('Are you sure you want to delete this employee?');">
           Delete
        </a>
      </td>
    </tr>
    <%
      }
      if (!hasData) {
    %>
    <tr><td colspan="7">No employees found.</td></tr>
    <%
      }
    %>
  </tbody>
</table>

<%
    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>
  </main>

  <footer>
    © 2025 PAY ZEN | All Rights Reserved
  </footer>
</body>
</html>
