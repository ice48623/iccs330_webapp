<%--
  Created by IntelliJ IDEA.
  User: ice
  Date: 2/13/17
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form action="register.jsp" method="post">

        <h1>Login.jsp</h1>
        <table class="table">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>username</td>
                    <td>First name</td>
                    <td>Last name</td>
                    <td>E-mail</td>
                    <td></td>
                </tr>
            </thead>
            <c:forEach var="user" items="${allUser}">
                <tr>

                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.email}</td>
                    <%--<td><a href="#" id="remove"--%>
                           <%--onclick="document.getElementById('action').value = 'remove';document.getElementById('idEmployee').value = '${employee.id}';--%>

                                   <%--document.getElementById('employeeForm').submit();">--%>
                        <%--<span class="glyphicon glyphicon-trash"/>--%>
                    <%--</a>--%>

                    </td>
                </tr>
            </c:forEach>
        </table>

        <input type="submit">
    </form>
</body>
</html>
