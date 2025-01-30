<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    text-align: center;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 5px;
    font-weight: bold;
    font-size: 16px;
    color: #333;
}

.radio-group {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 20px;
}

.radio-group label {
    display: flex;
    align-items: center;
    font-size: 16px;
    color: #333;
    margin-bottom: 8px;
    cursor: pointer;
}

.radio-group input[type="radio"] {
    appearance: none;
    width: 18px;
    height: 18px;
    border: 2px solid #007bff;
    border-radius: 50%;
    margin-right: 10px;
    position: relative;
}

.radio-group input[type="radio"]:checked {
    background-color: #007bff;
    border: 5px solid white;
    box-shadow: 0 0 0 2px #007bff;
}



input[type="submit"] {
    width: 100%;
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

@media (max-width: 400px) {
    .main {
        width: 90%;
        padding: 20px;
    }
}


</style>
</head>
<body>

<div class="main">
       <label align="center" style="font-size: 24px; font-weight: bold; display: block; margin-bottom: 15px;">Search by Course</label>

       <form action="./course" method="post">
           <div class="radio-group">
                <label>Course:</label>
                <label><input type="radio" name="course" value="DEVELOPMENT" required> Development</label>
                <label><input type="radio" name="course" value="TESTING" required> Testing</label>
            </div>
           
           <input type="submit" name="Search" value="search">
       </form>
    </div>
</body>
</html>