<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Visitor Counter</title>
</head>
<body>
    <h1>Visitor Count: <%= request.getAttribute("visitorCount") %></h1>
</body>
</html>