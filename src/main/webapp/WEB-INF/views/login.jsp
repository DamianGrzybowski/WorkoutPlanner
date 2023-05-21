
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Login</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">

</head>
<body>
<form:form method="post" action="/login" modelAttribute="user">

    <label for="userName">User Name</label>
    <form:input path="username" id="userName"/><br>
    <form:errors path="username" cssClass="error"/><br>

    <label for="password">Password</label>
    <form:input path="password" id="password" type="Password"/><br>
    <form:errors path="password" cssClass="error"/><br>

    <button class="custom-button" type="submit">Sign in</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <br>

    <div>
        <a href="/register">Don't have an account? Sign up</a>
    </div>


</form:form>

</body>
</html>
