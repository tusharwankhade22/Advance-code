<%@page import="edu.jspiders.springmvc.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<style>
    /* Global Styles */
    body {
        font-family: 'Arial', sans-serif;
        background-color: #eef2f7;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Main Container */
    .main {
        background-color: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    .main h1 {
        font-size: 24px;
        font-weight: bold;
        text-align: center;
        color: #333333;
        margin-bottom: 20px;
    }

    /* Form Styles */
    form {
        display: flex;
        flex-direction: column;
    }

    label {
        margin-bottom: 8px;
        font-weight: bold;
        color: #555555;
    }

    input[type="text"],
    input[type="email"],
    input[type="tel"],
    input[type="password"] {
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #cccccc;
        border-radius: 6px;
        font-size: 14px;
        transition: all 0.3s ease;
    }

    input[type="text"]:focus,
    input[type="email"]:focus,
    input[type="tel"]:focus,
    input[type="password"]:focus {
        border-color: #007bff;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.4);
        outline: none;
    }

    .radio-group {
        margin-bottom: 20px;
    }

    .radio-group label {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
        cursor: pointer;
    }

    .radio-group input[type="radio"] {
        margin-right: 10px;
    }

    /* Submit Button */
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        padding: 12px;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    /* Feedback Message */
    .feedback {
        text-align: center;
        color: green;
        font-weight: bold;
        margin-top: 15px;
    }
</style>
</head>
<body>
    <div class="main">
         <% 
           Student student=(Student)request.getAttribute("student");
         %>
        <h1>Update Student</h1>
        <form action="./upadte-student" method="post">
        
            <label for="id">Id:</label>
            <input type="text" name="id" id="id" placeholder="Enter your full name" value="<%=student.getId()%>" readonly="readonly">
            <!-- Name -->
            <label for="name">Name:</label>
            <input type="text" name="name" id="name" placeholder="Enter your full name" value="<%=student.getName() %>" required>

            <!-- Email -->
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" placeholder="Enter your email" value="<%= student.getEmail()%>" required>

            <!-- Phone Number -->
            <label for="phoneno">Phone No:</label>
            <input type="tel" name="phoneno" id="phoneno" placeholder="Enter your 10-digit phone number" required pattern="[0-9]{10}" value="<%=student.getPhoneno() %>" title="Enter a valid 10-digit phone number">

            <!-- Course -->
            <div class="radio-group">
                <label>Course:</label>
                <label><input type="radio" name="course" value="DEVELOPMENT" required> Development</label>
                <label><input type="radio" name="course" value="TESTING" required> Testing</label>
            </div>

            <!-- Submit Button -->
            <input type="submit" name="submit" value="Update">
        </form>

        <!-- Dynamic Feedback -->
        <% 
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
        <div class="feedback"><%= message %></div>
        <% } %>
    </div>
</body>
</html>
