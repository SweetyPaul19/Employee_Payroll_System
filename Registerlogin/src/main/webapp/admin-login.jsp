<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page | PAY ZEN</title>
    <link rel="icon" href="assets/favicon.ico" type="image/x-icon">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #2a5298, #1e3c72);
            height: 100vh; 
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            text-align: center;
        }

        .welcome-heading {
            color: #fff;
            font-size: 38px;
            margin-bottom: 20px;
            letter-spacing: 2px;
            font-weight: 600;
        }

        .login-section {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .admin-img {
            width: 120px;
            height: 120px;
            border-radius: 50%;
            margin-bottom: 20px;
            border: 3px solid #fff;
            background: #fff;
            padding: 10px;
        }

        .login-card {
            width: 350px;
            background: #fff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.2);
            text-align: center;
        }

        .login-card h2 {
            color: #1e3c72;
            margin-bottom: 20px;
        }

        input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 8px;
            border: 1px solid #ccc;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #1e3c72;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background-color: #2a5298;
            transform: translateY(-2px);
        }

        .msg {
            color: red;
            font-size: 14px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="welcome-heading">Welcome to PAY ZEN</h1>
        <div class="login-section">
            <img src="images/employee.png" alt="Admin" class="admin-img">

            <div class="login-card">
                <h2>Login Page</h2>

                <% String errorMsg = request.getParameter("error"); %>
                <% if (errorMsg != null) { %>
                    <p class="msg"><%= errorMsg %></p>
                <% } %>

                <form action="login" method="post">
                    <input type="text" name="username" placeholder="Enter Username" required>
                    <input type="password" name="password" placeholder="Enter Password" required>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
