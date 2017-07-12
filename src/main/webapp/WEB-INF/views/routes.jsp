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
    <li><a href="/contacts">Contacts</a></li>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.authenticated}">
            <li>
                <form action="/logout" id="logout" method="post">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                    <button type="submit" name=submit" value="logout" class="btn-link">Log out</button>
                </form>
            </li>
        </c:when>
        <c:otherwise>
            <li><a href="/login">Log in</a></li>
        </c:otherwise>
    </c:choose>
</ul>
<h2 class="header">Routes list</h2>

        <a href="/addroute" class="button">add new route</a>

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
