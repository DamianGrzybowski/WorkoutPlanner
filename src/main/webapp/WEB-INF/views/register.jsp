
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register</title>
    <link href="/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<form:form method="post" action="/register" modelAttribute="user">

    <label for="firstName">First name</label>
    <form:input path="firstName" id="firstName"/><br>
    <form:errors path="firstName" cssClass="error"/><br>

    <label for="lastName">Last name</label>
    <form:input path="lastName" id="lastName"/><br>
    <form:errors path="lastName" cssClass="error"/><br>

    <label for="email">Email</label>
    <form:input path="email" id="email" type="Email"/><br>
    <form:errors path="email" cssClass="error"/><br>

    <label for="password">Password</label>
    <form:input path="password" id="password" type="Password"/><br>
    <form:errors path="password" cssClass="error"/><br>

    <label for="confirmPassword">Confirm Password</label>
    <form:input path="confirmPassword" id="confirmPassword" type="Password"/><br>
    <form:errors path="confirmPassword" cssClass="error"/><br>

    <button type="submit">Register</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


    <div>
        <a href="/login">Already have an account? Sign in</a>
    </div>



</form:form>

</body>
</html>
