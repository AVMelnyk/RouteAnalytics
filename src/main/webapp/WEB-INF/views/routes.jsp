<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/routes_style.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
</head>
<body>
<ul>
    <li><a href="/">Route Analytics</a></li>
    <li><a href="/routes">Routes</a></li>
    <li><a href="/register">Register</a></li>
    <li><a href="/contacts">Contacts</a></li>
</ul>
<h2 class="header">Routes list</h2>
<a class="addroutelink" href="/addroute">add new route</a>
    <table>
        <th>Номер Маршруту:</th>
        <th>Напрямок:</th>
        <th>Змінити</th>
        <th>Видалити</th>
        <c:forEach var="route"  items="${routeList}">
            <tr>
                <td><c:out value = "${route.routeNumber}"/></td>
                <td><c:out value = "${route.routeName}"/></td>
                <td><a href="<c:url value='/editroute/${route.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${route.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
