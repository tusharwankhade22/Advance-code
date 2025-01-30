<%@page import="edu.jspiders.springmvc.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>  
<meta charset="UTF-8">
<title>Student List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: 50px auto;
        background: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        text-align: center;
        padding: 12px;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    .feedback {
        text-align: center;
        color: red;
        font-size: 16px;
        margin-top: 20px;
    }
    .no-data {
        text-align: center;
        font-size: 18px;
        color: #555;
        margin-top: 20px;
    }
     .navbar {
      display: flex;
      justify-content: space-around; /* Align items evenly */
      background-color: #4CAF50; /* Green background */
      padding: 1rem;
    }
    .navbar a {
      color: white; /* White text */
      text-decoration: none;
      font-size: 1.4rem;
      padding: 0.5rem 1rem;
      border-radius: 5px;
      transition: background 0.3s, transform 0.2s;
    }
    .navbar a:hover {
      background-color: #45a049; /* Slightly darker green */
      transform: scale(1.05); /* Add a slight zoom effect */
    }
</style>
</head>
<body>
<div class="navbar">
    <a href="home">Home</a>
    <a href="find-student-phoneno">Find by Mobile</a>
    <a href="find-student-email">Find by Email</a>
    <a href="find-student-name">Find by Name</a>
    <a href="find-student-course">Find by Course</a>
  </div>
<div class="container">
    <h1>Student List</h1>

    <%
       @SuppressWarnings("unchecked")
       List<Student> students = (List<Student>) request.getAttribute("students");
       if (students != null && !students.isEmpty()) {
    %>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Course</th>
            <th colspan="2">Action</th>
        </tr>
        <% for (Student student : students) { %>
        <tr>
            <td><%= student.getName() %></td>
            <td><%= student.getEmail() %></td>
            <td><%= student.getPhoneno() %></td>
            <td><%= student.getCourse() %></td>
            <td><a href="edit-student?id=<%=student.getId()%>">Edit</a></td>
            <td><a href="delete-student?id=<%=student.getId()%>">Delete</a></td>
        </tr>
        <% } %>
    </table>
    <% } %>

    <% 
       String message = (String) request.getAttribute("message");
       if (message != null) {
    %>
    <div class="feedback"><%= message %></div>
    <% } %>
</div>
</body>
</html>
