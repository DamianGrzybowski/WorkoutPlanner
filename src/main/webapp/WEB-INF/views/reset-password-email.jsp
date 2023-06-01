<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Password reset</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <style>
        body {
            text-align: center;
        }
    </style>
</head>
<body>

<h4>Enter your user account's verified email address, and we will send you a password reset link.</h4>
<form:form method="post" action="/password_reset">

    <label for="email">Email:</label>
    <input type="text" name="userEmail" id="email"><br>

    <p>
        <button type="submit" class="custom-button">Reset Your password</button>
    </p>
</form:form>


</body>
</html>
