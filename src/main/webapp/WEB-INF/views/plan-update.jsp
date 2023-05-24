<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Plan update</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <p>
        <a href="/home/plan/name?id=${trainingPlan.id}" class="custom-button1">Change plan name</a>
    </p>
    <p>
        <a href="/home/plan/dayplans?id=${trainingPlan.id}" class="custom-button1">Change your day plans</a>
    </p>
    <br>
    <a href="/home/plans" class="custom-button">Back</a>

</main>

</body>
</html>
