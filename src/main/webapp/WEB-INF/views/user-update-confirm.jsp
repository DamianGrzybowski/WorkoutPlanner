<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confirm</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <h3>Please confirm your password before proceeding</h3>
    <form:form method="post" action="/home/user/confirm_u" modelAttribute="user">
        <label for="password">Password</label>
        <form:password path="password" id="password"/>

        <p>
            <button type="submit" class="custom-button">Submit</button>
        </p>
    </form:form>
    <a href="/home/user" class="custom-button">Back</a>
</main>
</body>
</html>
