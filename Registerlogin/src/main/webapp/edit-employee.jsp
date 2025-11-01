<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="in.sp.dao.EmployeeDAO" %>
<%@ page import="in.sp.backend.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 40px;
        }
        .container {
            background: white;
            border-radius: 10px;
            padding: 30px;
            max-width: 600px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        form input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn {
            background-color: #007bff;
            color: white;
            padding: 10px 15px;
            margin-top: 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
<%
    String idParam = request.getParameter("id");
    if (idParam != null && !idParam.isEmpty()) {
        try {
            int id = Integer.parseInt(idParam);
            EmployeeDAO dao = new EmployeeDAO();
            Employee emp = dao.getEmployeeById(id);

            if (emp != null) {
%>
    <h2>Edit Employee</h2>
    <form action="updateEmployee" method="post">
        <input type="hidden" name="id" value="<%= emp.getId() %>">

        <label>First Name:</label>
        <input type="text" name="firstName" value="<%= emp.getFirstName() %>" required>

        <label>Last Name:</label>
        <input type="text" name="lastName" value="<%= emp.getLastName() %>" required>

        <label>Email:</label>
        <input type="email" name="email" value="<%= emp.getEmail() %>" required>

        <label>Phone:</label>
        <input type="text" name="phone" value="<%= emp.getPhone() %>" required>

        <label>Department:</label>
        <input type="text" name="department" value="<%= emp.getDepartment() %>" required>

        <label>Position:</label>
        <input type="text" name="position" value="<%= emp.getPosition() %>" required>

        <label>Salary:</label>
        <input type="number" name="salary" value="<%= emp.getSalary() %>" required>

        <button type="submit" class="btn">Update Employee</button>
    </form>
<%
            } else {
%>
    <p class="error">Employee not found with ID: <%= id %></p>
<%
            }
        } catch (NumberFormatException e) {
%>
    <p class="error">Invalid employee ID format.</p>
<%
        }
    } else {
%>
    <p class="error">No employee ID provided in URL.</p>
<%
    }
%>
</div>
</body>
</html>
