<%--
  Created by IntelliJ IDEA.
  User: ice
  Date: 2/13/17
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="css/form.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            /*background-color: #eee;*/
        }

        .form-signin {
            max-width: 330px;
            /*padding: 15px;*/
            margin: 0 auto;
        }
        .form-signin .form-signin-heading,
        .form-signin{
            margin-bottom: 10px;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .input {
            margin-bottom: 10px;
        }

        .login-field {
            margin: 10px 0;
        }

        .regis-btn {
            float: left;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <form class="form-signin" action="register" method="post">
            <h1 class="form-signin-heading">Register</h1>
            <div class="input">
                <p>username: </p><input class="login-field form-control" type="text" name="username" required="required" pattern="[A-Za-z0-9]{1,20}">
                <p>password: </p><input class="login-field form-control" type="password" name="password" required="required"">
                <p>First name: </p><input class="login-field form-control" type="text" name="firstname">
                <p>Last name: </p><input class="login-field form-control" type="text" name="lastname">
                <p>Email: </p><input class="login-field form-control" type="email" name="email">
            </div>
            <input class="regis-btn btn btn-primary" type="submit" name="save" value="save">
        </form>

        <form action="user" method="get">
            <input class="regis-btn btn btn-warning" type="submit" name="back" value="back">
        </form>
        <h2><small>${duplicate}</small></h2>
    </div>
</body>
</html>
