<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new plan</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <form:form method="post" action="/home/plan" modelAttribute="plan">

        <label for="name">Plan name:</label>
        <form:input path="name" id="name"/><br>
        <form:errors path="name" cssClass="error"/><br>

        <button type="submit" class="custom-button">Create</button>
    </form:form>
    <a href="/home" class="custom-button">Back</a>

</main>

</body>
</html>
