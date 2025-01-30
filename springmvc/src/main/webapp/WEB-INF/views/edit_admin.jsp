<%@page import="edu.jspiders.springmvc.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
.main {
    background-color: #ffffff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 300px;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 5px;
    font-weight: bold;
}

input[type="email"],
input[type="text"],
input[type="tel"],
input[type="password"] {
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
}

input[type="submit"] {
    background-color: #007bff;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}

input:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}
.backtohome a{
  color:#4CAF50;
}
</style>
</head>
<body> 
    <%
          Admin admin=(Admin)request.getAttribute("admin");
          int id=admin.getId();
          String email=admin.getEmail();
          String password=admin.getPassword();
          long phone=admin.getMob();
      %>
   
    <div class="main">
        <label align="center" style="font-size: 24px; font-weight: bold; display: block; margin-bottom: 15px;">Edit Admin Page</label>

       <form action="update_admin" method="post">
           <label for="id">Id:</label>
           <input type="text" name="id" id="id" value="<%=id%>" readonly="readonly">
           
           <label for="email">Email:</label>
           <input type="email" name="email" id="email" value="<%=email%>">
           
           <label for="phoneno">Phone No:</label>
           <input type="tel" name="phoneno" id="phoneno" value="<%=phone%>">
           
           <label for="password">Password</label>
           <input type="password" name="password" id="password" value="<%=password%>">
           
           <input type="submit" name="update" vlaue="update">
       </form>
       <br><br>
       <div align="center" class="backtohome"><a href="home">Back to home</a></div>
       
    </div>
</body>
</html>