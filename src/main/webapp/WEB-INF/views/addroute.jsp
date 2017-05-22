<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>Route Analytics</title>
</head>
<body>
    <form name="addroute" action="/addroute"  method="POST" accept-charset="UTF-8" >
        <ul>
            <li><label>Route Number:</label> <input type='text' name='routenumber' /></li>
            <li><label>Route Name: </label> <input type="text" name="routename"></li>
            <li><input type="submit" value="OK" class="btn"></li>
        </ul>
    </form>
</body>
</html>
