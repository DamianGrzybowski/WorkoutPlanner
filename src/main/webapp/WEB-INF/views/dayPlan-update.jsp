<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Day plan update</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
</head>
<body>
<form:form method="post" action="/home/dayplan/update" modelAttribute="dayPlanToUpdate">
    <form:hidden path="id"/>
    <div class="select-container">
        <label for="day">Day:</label>
        <form:select path="day" id="day">
            <form:options items="${days}"/>
        </form:select><br>
        <form:errors path="day" cssClass="error"/>
    </div>

    <div class="select-container select-container">
        <label for="exercises">Exercises:</label>
        <form:select path="exercises" id="exercises" multiple="true">
            <c:forEach items="${exercises}" var="exercise">
                <form:option value="${exercise.id}" label="${exercise.name}"/>
            </c:forEach>
        </form:select>
    </div>
    <br>
    <form:errors path="exercises" cssClass="error"/><br>

    <div class="select-container">
        <label for="trainingPlan">Training Plan</label>
        <form:select path="trainingPlan" id="trainingPlan">
            <c:forEach items="${plans}" var="plan">
                <form:option value="${plan.id}" label="${plan.name}"/>
            </c:forEach>
        </form:select>
    </div>
    <br>
    <form:errors path="trainingPlan" cssClass="error"/>


    <button type="submit" class="custom-button">Update</button>
</form:form>
<br><br>
<a href="/home/dayplans" class="custom-button">Back</a>


</body>
</html>
