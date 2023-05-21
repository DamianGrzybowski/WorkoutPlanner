<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 21.05.2023
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update exercise</title>
</head>
<body>
<form:form method="post" action="/home/exercise/update" modelAttribute="exerciseToUpdate">
    <form:hidden path="id"/>

    <label for="name">Exercise name</label>
    <form:input path="name" id="name"/>
    <form:errors path="name" cssClass="error"/><br>

    <label for="type">Type</label>
    <form:input path="type" id="type"/>
    <form:errors path="type" cssClass="error"/><br>

    <label for="sets">Sets</label>
    <form:input type="Number" path="sets" id="sets"/>
    <form:errors path="sets" cssClass="error"/><br>

    <label for="reps">reps</label>
    <form:input type="Number" path="reps" id="reps"/>
    <form:errors path="reps" cssClass="error"/><br><br>

    <button class="custom-button" type="submit">Update</button>
</form:form>
<a href="/home/exercises" class="custom-button">Back</a>


</body>
</html>
