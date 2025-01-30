<%@page import="edu.jspiders.springmvc.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }
    body {
        background-color: #f4f4f4;
    }
    nav {
        background-color: #4CAF50; /* Green background */
        display: flex;
        justify-content: space-around;
        padding: 1rem;
        box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    }
    nav a {
        color: white;
        text-decoration: none;
        font-size: 1.4rem;
        padding: 0.75rem 1.5rem;
        margin: 0 10px;
        border-radius: 5px;
        transition: background 0.3s, transform 0.2s;
    }
    nav a:hover {
        background-color: #45a049;
        transform: scale(1.05);
    }
    .main {
             
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            color: white;
            padding: 20px;
        }

        .content {
            background: rgba(255, 255, 255, 0.9); /* White background with slight transparency */
            padding: 40px;
            border-radius: 15px;
            max-width: 850px;
            width: 100%;
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2);
        }

        h1 {
            font-size: 3rem;
            font-weight: 700;
            color: #004e92; /* Deep blue color for title */
            margin-bottom: 20px;
        }

        p {
            font-size: 1.2rem;
            line-height: 1.8;
            color: #333;
            margin-bottom: 30px;
        }

        ul {
            list-style-type: none; /* Removed default list style */
            text-align: left;
            padding-left: 0;
            margin-bottom: 30px; /* Added space between list and line */
            font-size: 1.1rem;
            color: #333;
        }

        ul li {
            margin-bottom: 10px; /* Added spacing between list items */
            position: relative; /* Positioned pseudo-element */
            padding-left: 25px; /* Space for bullet icon */
        }

        ul li::before {
            content: "•"; /* Custom bullet symbol */
            color: #ff6347; /* Tomato color for bullets */
            font-size: 1.5rem; /* Larger bullet */
            position: absolute;
            left: 0;
            top: 0;
        }

        .divider {
            width: 100%;
            height: 2px;
            background-color: #ff6347; /* Tomato color line */
            margin-bottom: 30px;
        }

        .button {
            padding: 12px 30px;
            font-size: 1.1rem;
            background-color: #ff6347; /* Tomato color for button */
            color: white;
            border: none;
            border-radius: 30px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .button:hover {
            background-color: #e5533d; /* Slightly darker tomato color on hover */
            transform: scale(1.05); /* Slight scale effect */
        }

        /* Media Queries for responsiveness */
        @media (max-width: 768px) {
            h1 {
                font-size: 2.5rem;
            }

            p {
                font-size: 1rem;
            }

            .content {
                padding: 30px;
            }
        }

        @media (max-width: 480px) {
            h1 {
                font-size: 1.8rem;
            }

            p {
                font-size: 0.9rem;
            }

            .content {
                padding: 20px;
            }
        }
    </style>
</style>

</head>
<body>
      <%
          Admin admin=(Admin)session.getAttribute("auth_admin");
          int id=admin.getId();
      %>
   <nav>
      <a href="add-student-page">Add Student</a>
      <a href="students">All Student</a>
      <a href="edit-admin?id=<%=id%>">Edit Account</a>
      <a href="delete-admin?id=<%=id%>">Delete Account</a>
      <a href="logout">Logout</a>
   </nav>
   <div class="main">
        <div class="content">
            <h1>Student Management System</h1>
            <p>
                The Student Management System allows seamless management of student data. 
                Key features include:
            </p>
            <ul>
                <li>Add New Students</li>
                <li>Update Student Records</li>
                <li>Delete Student Records</li>
                <li>Admin Authentication for Secure Access</li>
                <li>Delete User Accounts</li>
                <li>Update User Account Details</li>
                <li>View All Students</li>
                <li>Search Students by Name, Email, or Course</li>
            </ul>
            <div class="divider"></div>
        </div>
    </div>
   
       <% 
        String message=(String)request.getAttribute("message");
        if(message !=null){
       %>
        <h4><%= message %></h4>
       <% } %>
</body>
</html>