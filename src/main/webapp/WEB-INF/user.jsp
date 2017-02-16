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
    <form action="logout" method="get">
        <input type="submit" value="Logout"/>
    </form>
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

                <form action="edit" method="get" >
                    <td>
                        <input type="hidden" name="editAction" value="edit"/>
                        <input type="hidden" name="editUser" value="${user.username}"/>
                        <input type="submit" value="Edit"/>
                    </td>
                </form>
                <form id="deleteForm" action="user" method="post" onsubmit="return confirmDelete()">
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
        <input type="submit" value="add user">
    </form>

    <script>
        var frm = document.getElementById('deleteForm');

        function confirmDelete() {

//            var c = confirm("Click Ok to confirm delete!");
//            if (c == true) {
//                console.log("Ok is pressed");
//                frm.submit();
//            }
            return confirm("Click Ok to confirm delete!");
        }
    </script>
</body>
</html>