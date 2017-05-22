<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/main.css" />
</head>
<body>
<h2 class="header">Routes list</h2>
<h2><a href="/">Home</a></h2>
<h2><a href="/addroute">Add Route</a></h2>
    <table>
        <th>Номер Маршруту:</th>
        <th>Напрямок:</th>
        <th>Змінити</th>
        <th>Видалити</th>
        <c:forEach var="route"  items="${routeList}">
            <tr>
                <td><c:out value = "${route.routeNumber}"/></td>
                <td><c:out value = "${route.routeName}"/></td>
                <td><a href="<c:url value='/edit/${route.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${route.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
