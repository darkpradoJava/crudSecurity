<%--
  Created by IntelliJ IDEA.
  User: darkprado
  Date: 18.02.2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<h1>User page</h1>
Hello ${user}!
<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>
</body>
</html>
