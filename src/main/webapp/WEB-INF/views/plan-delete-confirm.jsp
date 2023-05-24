<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm delete</title>
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <p>
        <a href="/home/plan/delete?id=${planToDelete.id}" class="custom-button1">Plan ONLY delete</a>
    </p>
    <p>
        <a href="/home/plan/deleteAll?id=${planToDelete.id}" class="custom-button2">Delete all</a>
    </p>

    <a href="/home/plans" class="custom-button">Back</a>
</main>

</body>
</html>
