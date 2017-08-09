<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Route Analytics</title>
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
<form:form name="editroute" modelAttribute="route"  method="POST" accept-charset="UTF-8" >
    <form:label path="routeNumber">Route Number</form:label>
    <form:input path="routeNumber" value="${route.routeNumber}" ></form:input>
    <form:label path="routeName">Route Name</form:label>
    <form:input path="routeName" value="${route.routeName}"></form:input>
    <tr>
        <td colspan="2"><input type="submit" value="edit route" class="btn"></td>
    </tr>
</form:form>
</body>
</html>

