<%@ page session="true" %>
<%
    // Check if admin is logged in
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Employee Payroll System</title>
  <link rel="stylesheet" href="style.css">
  <link rel="icon" href="favicon.ico" type="image/x-icon">
  <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
  <script src="js/main.js"></script>
  <script src="js/employee.js"></script>
</head>
<body>
  <div class="container">
  <!--Sidebar-->
    <aside class="sidebar">
      <h2>EMPLOYEE<br>PAYROLL SYSTEM</h2>
      <ul class="sidebar-menu">
  <li onclick="location.href='index1.jsp'"><i class="fas fa-home"></i> Dashboard</li>
  <li onclick="location.href='employee-management.jsp'"><i class="fas fa-users"></i> Employee Management</li>
  <li onclick="location.href='salary-calculation.jsp'"><i class="fas fa-calculator"></i> Salary Calculation</li>
  <li onclick="location.href='runPayroll'"><i class="fas fa-play-circle"></i> Run Payroll</li>
  <li onclick="location.href='about.html'"><i class="fas fa-info-circle"></i> About</li>
  <li onclick="location.href='contact.html'"><i class="fas fa-envelope"></i> Contact Us</li>
</ul>
    </aside>
    <!-- Main Section -->
    <main class="main-content">
      <!-- Top Navigation -->
  <nav class="navbar">
  <ul>
    <li onclick="window.location.href='index1.jsp'">Dashboard</li>
    <li onclick="window.location.href='employee-management.jsp'">Employee Management</li>
    <li onclick="window.location.href='salary-calculation.jsp'">Salary Calculation</li>
    <li onclick="window.location.href='runPayroll'">Run Payroll</li>
    <li onclick="window.location.href='about.html'">About</li>
    <li onclick="window.location.href='contact.html'">Contact Us</li>
  </ul>
</nav>
      <!-- Hero Section -->
      <section class="hero">
        <div class="hero-text">
          <h1>PAY ZEN</h1>
          <p>Manage employee salaries and payroll efficiently.</p>
          <button class="btn">Get Started</button>
        </div>
        <div class="hero-image">
          <img src="images/employee.png" alt="Employee image" width="700" height="600">
        </div>
      </section>
    </main>
  </div>
  <style>
    /* Optional small style enhancement for Admin Login button */
    .admin-login-btn {
      background-color: #004aad;
      color: white;
      padding: 6px 12px;
      border-radius: 5px;
      cursor: pointer;
      transition: 0.3s;
    }
    .admin-login-btn:hover {
      background-color: #00367d;
    }
    .sidebar-menu li {
      cursor: pointer;
      transition: background-color 0.3s;
    }
    .sidebar-menu li:hover {
      background-color: #f0f0f0;
    }
  </style>
</body>
</html>
