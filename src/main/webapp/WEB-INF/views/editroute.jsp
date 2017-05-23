<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/main.css" />
</head>
<body>
<h2><a href="/">Home</a></h2>
<h2><a href="/routes">Routes</a></h2>
<form name="editroute" action="/editroutepost"  method="POST" accept-charset="UTF-8" >
    <table>
        <tr>
            <td>Route ID</td>
            <td><input type='text' name='routeID' value="<c:out value = "${route.id}"/>"/></td>
        </tr>
        <tr>
            <td>Route Number:</td>
            <td><input type='text' name='routenumber' value="<c:out value = "${route.routeNumber}"/>"/></td>
        </tr>
        <tr>
            <td>Route Name: </td>
            <td><input type="text" name="routename" value="<c:out value = "${route.routeName}"/>"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="edit route" class="btn"></td>
        </tr>
    </table>
</form>
</body>
</html>

