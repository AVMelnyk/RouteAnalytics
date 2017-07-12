<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/register_style.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
</head>
<body>
<ul>
    <li><a href="/">Route Analytics</a></li>
    <li><a href="/contacts">Contacts</a></li>
</ul>
<h1>Register</h1>
<h2><a href="/">Home</a></h2>
<form method="POST">
    <table>
        <tr>
            <td> First Name: </td>
            <td><input type="text" name="firstName" /></td>
        </tr>
        <tr>
            <td> Last Name: </td>
            <td><input type="text" name="lastName" /></td>
        </tr>
        <tr>
            <td> Username: </td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td> Password: </td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table>
    <input  class="submit" type="submit" value="Register" />
</form>
</body>
</html>
