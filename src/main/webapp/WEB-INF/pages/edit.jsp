<%--
  Created by IntelliJ IDEA.
  User: darkprado
  Date: 05.02.2020
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty id}">
        <title>Add user</title>
    </c:if>
    <c:if test="${!empty id}">
        <title>Edit user</title>
    </c:if>
</head>
<body>
<c:if test="${empty id}">
    <c:url value="/add" var="action"/>
    <h1>Add user:</h1>
</c:if>
<c:if test="${!empty id}">
    <c:url value="/edit" var="action"/>
    <h1>Edit user:</h1>
    User select: login "<c:out value="${user.login}"/>", password "
    <c:out value="${user.password}"/>", name "<c:out value="${user.name}"/>"</p>
</c:if>
<form action="${action}" method="POST">
    <c:if test="${!empty id}">
        <input type="hidden" name="id" value="${id}">
    </c:if>
    <label for="login">login</label>
    <input type="text" name="login" id="login">
    <label for="password">password</label>
    <input type="text" name="password" id="password">
    <label for="name">name</label>
    <input type="text" name="name" id="name">
    <label for="role">role</label>
    <input type="text" name="role" id="role">
    <c:if test="${empty id}">
        <input type="submit" value="add">
    </c:if>
    <c:if test="${!empty id}">
        <input type="submit" value="edit">
    </c:if>
</form>
</body>
</html>