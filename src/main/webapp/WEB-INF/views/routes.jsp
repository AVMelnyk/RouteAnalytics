<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RouteAnalytics</title>
    <link rel="stylesheet" href="../../css/main.css" />
</head>
<body>
<h2 class="header">Routes list</h2>
<a href="/">Home</a>

    <table>
        <th>Номер Маршруту:</th>
        <th>Напрямок:</th>
        <c:forEach var="route"  items="${routeList}">
            <tr>
                <td><c:out value = "${route.routeNumber}"/></td>
                <td><c:out value = "${route.routeName}"/></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
