<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <table>
        <thead>
        <tr>
            <th>User Name</th>
            <th>Email</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><a href="/home/user/confirm_u" class="custom-button1">Update</a></td>
            <td><a href="/home/user/accept_d" class="custom-button2">Delete</a></td>
        </tr>
        </tbody>
    </table>

    <a href="/home" class="custom-button">Back</a>


</main>
</body>
</html>
