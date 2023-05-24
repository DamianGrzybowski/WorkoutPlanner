<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Day plans</title>
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
            <th>Day</th>
            <th>Action</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dayPlansByPlan}" var="plan">
            <tr>
                <td>${plan.day}</td>
                <td><a href="/home/dayplan/details?id=${plan.id}" class="custom-button">Details</a></td>
                <td><a href="/home/dayplan/update?id=${plan.id}" class="custom-button1">Update</a></td>
                <td><a href="/home/dayplan/delete?id=${plan.id}" class="custom-button2">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/home/plans" class="custom-button">Back</a>
    <a href="/home/dayplan" class="custom-button">Create new day plan</a>
</main>

</body>
</html>
