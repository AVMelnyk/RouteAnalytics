<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/routepage_style.css" />
    <link rel="stylesheet" href="../../css/editroute_style.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
</head>
<body>
    <ul>
        <li><a href="/">Route Analytics</a></li>
        <li><a href="/routes">Routes</a></li>
        <li><a href="/register">Register</a></li>
        <li><a href="/contacts">Contacts</a></li>
    </ul>

    <div class="route_info">
        <p>Route Number: <c:out value = "${route.routeNumber}"/></p>
        <p>Route Name:  <c:out value = "${route.routeName}"/></p>
        <a href="/addstop" class="button">add new Stop</a>
        <c:forEach var="routeStop"  items="${routeStopList}">
            <p>Stop Name: <c:out value="${routeStop.routeStopName}"/></p>
        </c:forEach>
    </div>
</body>
</html>
