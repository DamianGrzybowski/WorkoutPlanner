<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 20.05.2023
  Time: 00:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Home</title>
</head>
<body>
<header>
    <div>
        Hello ${user.username}. Plan Your workout routine with WorkoutPlanner!
    </div>
</header>
<nav>
    <div>
        <a href="/home/plan">Add new plan</a>
    </div>
    <div>
        <a href="/home/dayplan">Add new day plan</a>
    </div>
    <div>
        <a href="/home/exercise">Add new exercise</a>
    </div>
    <div>
        <a href="/home/plans">All plans</a>
    </div>
    <div>
        <a href="/home/dayplans">All day plans</a>
    </div>
    <div>
        <a href="/home/exercises">All exercises</a>
    </div>
    <div>
        <a href="/logout">Logout</a>
    </div>
</nav>
<main>



</main>


</body>
</html>
