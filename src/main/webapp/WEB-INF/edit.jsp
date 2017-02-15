<%--
  Created by IntelliJ IDEA.
  User: ice
  Date: 2/14/17
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <form action="edit" method="post">
        <h1>Edit</h1>
        <p>username: </p><input type="text" name="username" value="${username}" readonly>
        <%--<p>password: </p><input type="password" name="password">--%>
        <p>First name: </p><input type="text" name="firstname" value="${firstname}">
        <p>Last name: </p><input type="text" name="lastname" value="${lastname}">
        <p>Email: </p><input type="email" name="email" value="${email}">

        <input type="submit" name="save" value="save">
    </form>

    <%--<form action="user" method="get">--%>
        <%--<input type="submit" name="back" value="back">--%>
    <%--</form>--%>
</body>
</html>
