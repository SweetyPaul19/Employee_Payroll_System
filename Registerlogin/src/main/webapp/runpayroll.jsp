<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="in.sp.backend.Employee" %>
<%@ page import="in.sp.backend.Payroll" %>

<%
    List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
    List<Payroll> payrollList = (List<Payroll>) request.getAttribute("payrollList");
    String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Run Payroll | PAY ZEN</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background-color: #f9fafc;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            margin: 40px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            padding: 20px 40px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            margin-bottom: 30px;
        }
        label {
            display: block;
            margin-top: 12px;
            font-weight: 600;
        }
        select, input {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
            margin-top: 5px;
        }
        button {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .message {
            text-align: center;
            margin: 10px 0;
            font-weight: 600;
        }
        .success { color: green; }
        .error { color: red; }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        th, td {
            text-align: center;
            padding: 10px;
        }
        tr:nth-child(even) {
            background-color: #f2f6fc;
        }
    </style>
</head>

<body>
<div class="container">
    <h2>💼 Run Payroll</h2>

    <% if (message != null) { %>
        <div class="message <%= message.contains("✅") ? "success" : "error" %>">
            <%= message %>
        </div>
    <% } %>

    <!-- ==================== PAYROLL FORM ==================== -->
    <form action="runPayroll" method="post">
        <label for="employeeId">Select Employee:</label>
        <select name="employeeId" required>
            <option value="">-- Choose Employee --</option>
            <%
                if (employeeList != null && !employeeList.isEmpty()) {
                    for (Employee emp : employeeList) {
            %>
                        <option value="<%= emp.getId() %>">
                            <%= emp.getFirstName() + " " + emp.getLastName() %> (Dept: <%= emp.getDepartment() %>)
                        </option>
            <%
                    }
                } else {
            %>
                <option disabled>No employees found</option>
            <%
                }
            %>
        </select>

        <label for="allowances">Allowances:</label>
        <input type="number" name="allowances" step="0.01" placeholder="Enter Allowances">

        <label for="deductions">Deductions:</label>
        <input type="number" name="deductions" step="0.01" placeholder="Enter Deductions">

        <label for="leavesTaken">Leaves Taken:</label>
        <input type="number" name="leavesTaken" min="0" max="30" placeholder="Enter Leaves Taken">

        <label for="paymentDate">Payment Date:</label>
        <input type="date" name="paymentDate" required>

        <button type="submit">Process Payroll</button>
    </form>

    <!-- ==================== PAYROLL TABLE ==================== -->
    <h3>🧾 Processed Payroll Records</h3>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Employee</th>
                <th>Department</th>
                <th>Basic Salary</th>
                <th>HRA</th>
                <th>DA</th>
                <th>Allowances</th>
                <th>Deductions</th>
                <th>Leaves</th>
                <th>Net Salary</th>
                <th>Payment Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <%
            if (payrollList != null && !payrollList.isEmpty()) {
                for (Payroll p : payrollList) {
        %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getEmployeeName() %></td>
                <td><%= p.getDepartment() %></td>
                <td>₹<%= String.format("%.2f", p.getBasicSalary()) %></td>
                <td>₹<%= String.format("%.2f", p.getHra()) %></td>
                <td>₹<%= String.format("%.2f", p.getDa()) %></td>
                <td>₹<%= String.format("%.2f", p.getAllowances()) %></td>
                <td>₹<%= String.format("%.2f", p.getDeductions()) %></td>
                <td><%= p.getLeavesTaken() %></td>
                <td><b>₹<%= String.format("%.2f", p.getNetSalary()) %></b></td>
                <td><%= p.getPaymentDate() %></td>
                <td>
                    <a href="generatePayslip?employeeId=<%= p.getEmployeeId() %>"
                       style="color: blue; text-decoration: underline;">View Payslip</a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr><td colspan="12">No Payroll Records Found</td></tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
