<%--
  Created by IntelliJ IDEA.
  User: ice
  Date: 2/13/17
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <form action="register" method="post">
        <h1>Register</h1>
        <p>username: </p><input type="text" name="username">
        <p>password: </p><input type="password" name="password">
        <p>First name: </p><input type="text" name="firstname">
        <p>Last name: </p><input type="text" name="lastname">
        <p>Email: </p><input type="email" name="email">

        <input type="submit" name="save" value="save">
    </form>

    <form action="user" method="get">
        <input type="submit" name="back" value="back">
    </form>
</body>
</html>
