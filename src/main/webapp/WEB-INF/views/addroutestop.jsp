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
        <div class="add_stop_form">
            <form:form  action="/addroutestop/${route.id}" modelAttribute="routeStop">
                <form:label path="routeStopName">Stop Name</form:label>
                <form:input path="routeStopName"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" value="add route" class="btn">
            </form:form>
        </div>
    </body>
</html>
