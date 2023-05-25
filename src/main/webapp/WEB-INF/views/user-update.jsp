<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User update</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <form:form method="post" action="/home/user/update" modelAttribute="user">
        <form:hidden path="id"/>

        <label for="userName">User name</label>
        <form:input path="username" id="userName"/><br>
        <form:errors path="username" cssClass="error"/><br>

        <label for="email">Email</label>
        <form:input path="email" id="email" type="Email"/><br>
        <form:errors path="email" cssClass="error"/><br>

        <label for="password">Password</label>
        <form:password path="password" id="password" value=""/><br>
        <form:errors path="password" cssClass="error"/><br>

        <label for="confirmPassword">Confirm Password</label>
        <form:password path="confirmPassword" id="confirmPassword" value=""/><br>
        <form:errors path="confirmPassword" cssClass="error"/><br>

        <button class="custom-button" type="submit">Update</button>

    </form:form>
    <p>
        <a href="/home/user" class="custom-button">Back</a>
    </p>

</main>

</body>
</html>
