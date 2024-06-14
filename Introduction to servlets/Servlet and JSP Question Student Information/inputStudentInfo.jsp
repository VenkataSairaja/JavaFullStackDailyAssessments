<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Input Student Information</title>
</head>
<body>
    <h1>Input Student Information</h1>
    <form action="StudentServlet" method="post">
        Name: <input type="text" name="name"><br><br>
        Age: <input type="number" name="age"><br><br>
        Grade: <input type="text" name="grade"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>