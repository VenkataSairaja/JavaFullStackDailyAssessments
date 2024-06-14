<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h1>Student Details</h1>
    <%
        Student student = (Student) request.getAttribute("student");
    %>
    Name: <%= student.getName() %><br>
    Age: <%= student.getAge() %><br>
    Grade: <%= student.getGrade() %><br>
</body>
</html>