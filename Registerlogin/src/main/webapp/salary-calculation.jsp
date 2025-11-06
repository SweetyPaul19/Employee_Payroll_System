<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Salary Calculator | PAY ZEN</title>
  <link rel="icon" href="assets/favicon.ico" type="image/x-icon">
  <style>
    body {
      font-family: 'Poppins', sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f5f6fa;
    }

    header {
      background-color: #2f3640;
      color: #fff;
      padding: 15px 0;
      text-align: center;
    }

    nav a {
      color: white;
      text-decoration: none;
      margin: 0 15px;
      font-weight: bold;
    }

    nav a:hover {
      color: #00a8ff;
    }

    main {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 80vh;
      flex-direction: column;
    }

    .salary-form {
      background: white;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
      width: 400px;
      text-align: center;
    }

    .salary-form h2 {
      margin-bottom: 20px;
      color: #2f3640;
    }

    .salary-form input {
      width: 90%;
      padding: 10px;
      margin: 10px 0;
      border-radius: 8px;
      border: 1px solid #ccc;
      outline: none;
      transition: 0.3s;
    }

    .salary-form input:focus {
      border-color: #00a8ff;
    }

    .salary-form button {
      background-color: #00a8ff;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: 0.3s;
    }

    .salary-form button:hover {
      background-color: #0097e6;
    }

    .result-box {
      background-color: #dff9fb;
      border: 1px solid #00a8ff;
      padding: 15px;
      border-radius: 8px;
      margin-top: 20px;
      color: #2f3640;
      font-weight: bold;
    }
  </style>
</head>
<body>
  <header>
    <h1>Salary Calculator</h1>
    <nav>
      <a href="index1.jsp">Dashboard</a>
      <a href="employee-management.jsp">Employee Management</a>
      <a href="salary-calculation.jsp" class="active">Salary Calculator</a>
      <a href="runPayroll">Run Payroll</a>
      <a href="about.html">About</a>
      <a href="contact.html">Contact Us</a>
    </nav>
  </header>

  <main>
    <section class="salary-form">
      <h2>Calculate Net Pay</h2>
      <form action="calculateSalary" method="post">
        <input type="number" step="0.01" name="basic" placeholder="Basic Salary" required>
        <input type="number" step="0.01" name="hra" placeholder="HRA" required>
        <input type="number" step="0.01" name="da" placeholder="DA" required>
        <input type="number" step="0.01" name="otherAllowance" placeholder="Other Allowances" required>
        <input type="number" step="0.01" name="deductions" placeholder="Deductions" required>
        <input type="number" name="totalDays" placeholder="Total Working Days" required>
        <input type="number" name="workedDays" placeholder="Worked Days" required>
        <button type="submit">Calculate</button>
      </form>

      <% 
        String netPay = (String) request.getAttribute("netPay");
        if (netPay != null) {
      %>
        <div class="result-box">
          Net Salary: ₹ <%= netPay %>
        </div>
      <% } %>
    </section>
  </main>

  <footer>
    <p>© 2025 PAY ZEN | Employee Payroll System</p>
  </footer>
</body>
</html>
