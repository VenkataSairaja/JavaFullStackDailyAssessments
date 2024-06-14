<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Current Date and Time</title>
</head>
<body>
    <h1>Current Date and Time:</h1>
    <%
        java.util.Date currentDate = new java.util.Date();
        out.println(currentDate);
    %>
    <br>
    <%
        java.time.LocalDateTime currentDateTime = java.time.LocalDateTime.now();
        out.println(currentDateTime);
    %>
</body>
</html>