<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/addroutestops.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
</head>
<body>
<ul>
    <li><a href="/">Route Analytics</a></li>
    <li><a href="/routes">Routes</a></li>
    <li><a href="/register">Register</a></li>
    <li><a href="/contacts">Contacts</a></li>
</ul>
<form name="editroute"   method="POST" accept-charset="UTF-8" >
    <p class="route_header">Номер маршруту: <c:out value = "${route.routeNumber} "/></p>
    <p class="route_header">Напрямок слідування: <c:out value = "${route.routeName}"/></p>
    <table class="routestops_table">
        <th> Stop Number</th>
        <th> Stop Name </th>
        <c:forEach var="routeStop"  items="${stopList}">
        <tr>
            <td><c:out value = "${routeStop.routeStopId}"/></td>
            <td><input type='text' name='stopname'/></td>
        </tr>
    </c:forEach>
    </table>
    <span ><input type="submit" value="Save Route" class="btn"></span>
</form>
</body>
</html>
