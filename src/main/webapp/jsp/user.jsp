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
    <title>user</title>
</head>
<body>
    <h1>user.jsp</h1>
    <input type="submit" value="Logout"/>
    <table class="table">
        <thead>
            <tr>
                <td>username</td>
                <td>First name</td>
                <td>Last name</td>
                <td>E-mail</td>
                <td></td>
            </tr>
        </thead>
        <c:forEach var="user" items="${allUser}">
            <tr>
                <td>${user.username}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.email}</td>
                <%--<td><a href="#" id="remove"--%>
                       <%--onclick="document.getElementById('action').value = 'remove';document.getElementById('idEmployee').value = '${employee.id}';--%>

                               <%--document.getElementById('employeeForm').submit();">--%>
                    <%--<span class="glyphicon glyphicon-trash"/>--%>
                <%--</a>--%>
                <form action="edit" method="get" >
                    <td>
                        <input type="hidden" name="editAction" value="edit"/>
                        <input type="hidden" name="editUser" value="${user.username}"/>
                        <input type="submit" value="Edit"/>
                    </td>
                </form>
                <form action="user" method="post" >
                    <td>
                        <input type="hidden" name="deleteAction" value="delete"/>
                        <input type="hidden" name="deleteUser" value="${user.username}"/>
                        <input type="submit" value="Delete"/>
                    </td>
                </form>
            </tr>

        </c:forEach>
    </table>
    <form action="register" method="get">
        <input type="submit">
    </form>
</body>
</html>
