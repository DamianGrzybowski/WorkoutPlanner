<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 21.05.2023
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All training days</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Day</th>
        <th>Action</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${plans}" var="plan">
        <tr>
            <td>${plan.day}</td>
            <td><a href="/home/dayplans/details" class="custom-button">Details</a> </td>
            <td><a href="/home/dayplans/update?id=${plan.id}" class="custom-button1">Update</a> </td>
            <td><a href="/home/dayplans/delete?id=${plan.id}" class="custom-button2">Delete</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/home" class="custom-button">Back</a>
<a href="/home/dayplan" class="custom-button">Create new day plan</a>
</body>
</html>