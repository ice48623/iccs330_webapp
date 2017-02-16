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
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="css/user.css">
</head>
<body>
    <div class="container">
        <div class="user-header">
            <div class="welcome">
                <h1>Hello ${currentUser}</h1>
            </div>
            <form class="logout" action="logout" method="get">
                <input class="btn btn-warning" type="submit" value="Logout"/>
            </form>
        </div>
        <table class="user-table table table-striped">
            <thead>
                <tr>
                    <td>username</td>
                    <td>First name</td>
                    <td>Last name</td>
                    <td>E-mail</td>
                </tr>
            </thead>
            <c:forEach var="user" items="${allUser}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.email}</td>

                    <form action="edit" method="get" >
                        <td>
                            <input type="hidden" name="editAction" value="edit"/>
                            <input type="hidden" name="editUser" value="${user.username}"/>
                            <input class="btn btn-info" type="submit" value="Edit"/>
                        </td>
                    </form>
                    <c:choose>
                        <c:when test="${currentUser != user.username}">
                            <form id="deleteForm" action="user" method="post" onsubmit="return confirmDelete()">
                                <td>
                                    <input type="hidden" name="deleteAction" value="delete"/>
                                    <input type="hidden" name="deleteUser" value="${user.username}"/>
                                    <input class="btn btn-danger" type="submit" value="Delete"/>
                                </td>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <td></td>
                        </c:otherwise>
                    </c:choose>

                </tr>

            </c:forEach>
        </table>
        <form action="register" method="get">
            <input class="btn btn-primary" type="submit" value="add user">
        </form>
    </div>
    <script>
        function confirmDelete() {
            return confirm("Click Ok to confirm delete!");
        }
    </script>
</body>
</html>
