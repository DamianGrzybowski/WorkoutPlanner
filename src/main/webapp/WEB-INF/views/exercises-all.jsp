<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All exercises</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Sets</th>
            <th>Reps</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${exercises}" var="exercise">
            <tr>
                <td>${exercise.name}</td>
                <td>${exercise.type}</td>
                <td>${exercise.sets}</td>
                <td>${exercise.reps}</td>
                <td><a href="/home/exercise/update?id=${exercise.id}" class="custom-button1">Update</a></td>
                <td><a href="/home/exercise/delete?id=${exercise.id}" class="custom-button2">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/home" class="custom-button">Back</a>
    <a href="/home/exercise" class="custom-button">Create new exercise</a>
</main>
</body>
</html>
