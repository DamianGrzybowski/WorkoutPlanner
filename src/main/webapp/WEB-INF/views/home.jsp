<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <title>Home</title>
    <link href="/css/home.css" rel="stylesheet" type="text/css">
    <link href="/css/table1.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <div>
        Hello ${user.username}! Plan Your workout routine with WorkoutPlanner.
    </div>
</header>
<%@include file="nav.jsp" %>

<main>
    <c:if   test="${fn:isNotNull(planDetails)}"></c:if>
    <h1>Latest plan : ${planDetails.name}</h1>
    <c:forEach items="${dayPlans}" var="day">
        <table>
            <thead>
            <tr>
                <th>${day.day}</th>
                <th>Exercise</th>
                <th>Type</th>
                <th>Sets</th>
                <th>Reps</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${day.exercises}" var="exercise" varStatus="status">
                <tr>
                    <td>${status.index + 1}.</td>
                    <td>${exercise.name}</td>
                    <td>${exercise.type}</td>
                    <td>${exercise.sets}</td>
                    <td>${exercise.reps}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </c:forEach>
</main>


</body>
</html>
