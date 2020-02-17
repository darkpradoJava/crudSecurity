<%--
  Created by IntelliJ IDEA.
  User: darkprado
  Date: 13.02.2020
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<c:if test="${error}">Введены неверно логин или пароль.</c:if>
<form action="/login" method="POST">
    <label for="login">Login</label>
    <input type="text" name="login" id="login" required><br>
    <label for="password">Password</label>
    <input type="password" name="password" id="password" required><br>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
