<%--
  Created by IntelliJ IDEA.
  User: darkprado
  Date: 04.02.2020
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1 align="center">Users list:</h1>
<table border="1" cellspacing="0" align="center">
    <tr align="center">
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>Name</th>
        <th>Role</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr align="center">
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>
                <c:forEach items="${user.roles}" var="role">${role.role}</c:forEach>
            </td>
            <td width="40"><a href="/admin/edit/${user.id}">edit</a></td>
            <td width="40"><a href="/admin/delete/${user.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<p align="center"><a href="/admin/add">Add user</a></p>
</body>
</html>
