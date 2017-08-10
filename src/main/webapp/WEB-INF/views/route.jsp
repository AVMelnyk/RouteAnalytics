<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/editroute_style.css" />
    <link rel="stylesheet" href="../../css/routepage_style.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
</head>
<body>
<ul>
    <li><a href="/">Route Analytics</a></li>
    <li><a href="/routes">Routes</a></li>
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
    <div class="route_info">
        <c:set var="seq_id" value="1" />
        <div class="route_info"><span>Route Number: <c:out value = "${route.routeNumber}"/></span></div>
        <div class="route_info"><span>Route Name:  <c:out value = "${route.routeName}"/></span></div>
        <a href="/addroutestop/${route.id}" class="button">add new Stop</a>
        <c:if test="${route.routeStops.size()>0}">
        <table>
            <th>Stop Number </th>
            <th>Stop Name</th>
            <th>Edit</th>
            <th>Delete</th>
            <c:forEach var="routeStop"  items="${route.routeStops}">
                <div class="routestop_info">
                    <tr>
                        <td><c:out value = "${seq_id}"/></td>
                        <td><c:out value="${routeStop.routeStopName}"/></td>
                        <td><a href="<c:url value='/editroutestop/${routeStop.routeStopId}'/>">Edit</a></td>
                        <td><a href="<c:url value='/remove/route/${route.id}/route_stop/${routeStop.routeStopId}'/>">Delete</a></td>
                    </tr>
                </div>
                <c:set var="seq_id" value="${seq_id+1}" />
            </c:forEach>
        </table>
        </c:if>
    </div>
</body>
</html>
