<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="in.sp.backend.Admin" %>
<%
    Admin admin = (Admin) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dashboard | PAY ZEN</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="icon" href="assets/favicon.ico" type="image/x-icon">
</head>
<body>
  <header>
    <h1>Welcome, <%= admin.getUsername() %> 👋</h1>
    <nav>
      <a href="index1.jsp">Dashboard</a>
      <a href="employee-management.jsp">Employee Management</a>
      <a href="salary-calculation.jsp">Salary Calculator</a>
      <a href="payroll-run.jsp">Run Payroll</a>
      <a href="logout">Logout</a>
    </nav>
  </header>

  <main>
    <section class="dashboard">
      <h2>Payroll Overview</h2>
      <p>Manage employees, calculate salaries, and generate payslips with ease.</p>
      <div class="cards">
        <div class="card"><h3>👩‍💼 Employees</h3><p>Manage all employee details</p></div>
        <div class="card"><h3>💰 Salary</h3><p>Calculate and view net pay</p></div>
        <div class="card"><h3>🧾 Payroll</h3><p>Generate and store payslips</p></div>
      </div>
    </section>
  </main>

  <footer>
    <p>© 2025 PAY ZEN | Employee Payroll System</p>
  </footer>
</body>
</html>
