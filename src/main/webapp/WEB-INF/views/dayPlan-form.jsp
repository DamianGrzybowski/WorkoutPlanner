<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Your day plan</title>
    <link href="/css/form.css" rel="stylesheet" type="text/css">
    <link href="/css/button.css" rel="stylesheet" type="text/css">
</head>
<body>
<form:form method="post" action="/home/dayplan" modelAttribute="dayPlan">

    <label for="day">Day:</label>
    <form:select path="day" id="day">
        <form:option value="-" label="--Please Select--"/>
        <form:options items="${days}"/>
    </form:select><br>
    <form:errors path="day" cssClass="error"/><br>

    <label for="exercises">Exercises:</label>
    <form:checkboxes path="exercises" items="${exercises}" itemLabel="name" itemValue="id" id="exercises"/><br>
    <form:errors path="exercises" cssClass="error"/><br>

    <label for="trainingPlan">Training Plan</label>
    <form:select path="trainingPlan" id="trainingPlan">
        <form:option value="-" label="--Please Select--"/>
        <c:forEach items="${plans}" var="plan">
            <form:option value="${plan.id}" label="${plan.name}"/>
        </c:forEach>
    </form:select><br>
    <form:errors path="trainingPlan" cssClass="error"/>
    <br>
    <br>

    <button type="submit" class="custom-button">Create</button>
    <br><br>
    <a href="/home/dayplans" class="custom-button">Back</a>


</form:form>

</body>
</html>
