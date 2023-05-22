<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 21.05.2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Day plan details</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <h1>${dayPlanDetails.day}</h1>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Reps</th>
            <th>Sets</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${exercises}" var="exercise">
            <tr>
                <td>${exercise.name}</td>
                <td>${exercise.type}</td>
                <td>${exercise.reps}</td>
                <td>${exercise.sets}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/home/dayplans" class="custom-button">Back</a>

</main>
</body>
</html>
