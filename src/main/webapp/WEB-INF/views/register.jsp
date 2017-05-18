<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/register.css" />
</head>
<body>
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
    <input type="submit" value="Register" />

</form>
</body>
</html>
