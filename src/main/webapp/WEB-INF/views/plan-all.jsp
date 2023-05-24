<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All plans</title>
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
            <th>Plan name</th>
            <th>Action</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${plans}" var="plan">
            <tr>
                <td>${plan.name}</td>
                <td><a href="/home/plan/details?id=${plan.id}" class="custom-button">Details</a></td>
                <td><a href="/home/plan/update?id=${plan.id}" class="custom-button1">Update</a></td>
                <td><a href="/home/plan/delete/confirm?id=${plan.id}" class="custom-button2">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/home" class="custom-button">Back</a>
    <a href="/home/plan" class="custom-button">Create new plan</a>
</main>
</body>
</html>
