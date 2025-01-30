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
h4 {
    color: #333;
    font-size: 16px;
    margin-top: 10px;
}

h4 a {
    color: #4CAF50;
    text-decoration: none;
    font-weight: bold;
}

h4 a:hover {
    text-decoration: underline;
}
</style>
</head>
<body> 
    <div class="main">
        <label align="center" style="font-size: 24px; font-weight: bold; display: block; margin-bottom: 15px;">Sign Up Page</label>

       <form action="./add-admin" method="post">
           <label for="email">Email:</label>
           <input type="email" name="email" id="email">
           
           <label for="phoneno">Phone No:</label>
           <input type="tel" name="phoneno" id="phoneno">
           
           <label for="password">Password</label>
           <input type="password" name="password" id="password">
           
           <input type="submit" name="signup">
       </form>
       <% 
        String message=(String)request.getAttribute("message");
        if(message !=null){
       %>
        <h4><%= message %></h4>
       <% } %>
       <h4 align="center">
			Already an user?<a href="login-page">login</a>
	   </h4>
       
    </div>
</body>
</html>