<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Plan details</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="nav.jsp" %>
<main>
    <h1>${planDetails.name}</h1>
    <table>
        <thead>
        <tr>
            <c:forEach items="${dayPlans}" var="day">
                <th>${day.day}</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach items="${dayPlans}" var="plan">
                <td>
                    <ol>
                        <c:forEach items="${plan.exercises}" var="exercise">
                            <li> ${exercise.name}</li>
                        </c:forEach>
                    </ol>
                </td>
            </c:forEach>
        </tr>
        </tbody>
    </table>

</main>
<a href="/home/plans" class="custom-button">Back</a>

</body>
</html>
