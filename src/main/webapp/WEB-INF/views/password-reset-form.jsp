<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset password</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <style>
        body {
            text-align: center;
        }
    </style>
</head>
<body>
<h3>Reset your password</h3>
<form:form method="post" action="/reset" modelAttribute="user">
    <form:hidden path="id"/>
    <form:hidden path="username"/>
    <form:hidden path="email"/>

    <label for="password">New password:</label>
    <form:password path="password" id="password" value=""/>
    <form:errors path="password" cssClass="error"/><br>

    <label for="confirmPassword">Confirm new password</label>
    <form:password path="confirmPassword" id="confirmPassword" value=""/>
    <form:errors path="confirmPassword" cssClass="error"/><br>

    <p>
        <button type="submit" class="custom-button">Create new password</button>
    </p>

</form:form>

</body>
</html>
