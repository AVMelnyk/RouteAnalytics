<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/addroutestops.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
    <sec:csrfMetaTags/>
</head>
<body>
<ul>
    <li><a href="/">Route Analytics</a></li>
    <li><a href="/routes">Routes</a></li>
    <li><a href="/register">Register</a></li>
    <li><a href="/contacts">Contacts</a></li>
</ul>
<p class="route_header"  >Номер маршруту: <c:out value = "${route.routeNumber} "/></p>
<p class="route_header">Напрямок слідування: <c:out value = "${route.routeName}"/></p>
<c:set var="balance" value="12" />
<form:form name="/addstops"  action="/addstops"   modelAttribute="route" method="POST" accept-charset="UTF-8" >
    <table class="routestops_table">
        <input type="hidden" name="stoplistsize" value="${stopList.size()}"/>
        <input type="hidden" name="route_id" value="${route.id}"/>
        <th> Stop Number</th>
        <th> Stop Name </th>
        <c:forEach var="routeStop"  items="${stopList}">
        <tr>
            <td><c:out value = "${balance}"/></td>
            <td><input type='text' name='stopname/<c:out value = "${routeStop.routeStopId}"/>' id="'stopname/<c:out value = "${routeStop.routeStopId}"/>" /></td>
        </tr>
            <c:set var="balance" value="${balance+1}" />
    </c:forEach>
    </table>
    <span>
        <input type="submit" value="Save Route" class="btn"></span>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form:form>
</body>
</html>
