<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/addroute.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <sec:csrfMetaTags/>
</head>
<body>
    <div class="routeform">
    <form:form name="addroute" action="/addroute"  method="POST"  modelAttribute="route" acceptCharset="UTF-8">
            <p>
                <form:label path="routeNumber">Route Number</form:label>
                <form:input path="routeNumber"/>
            </p>
            <p>
                <form:label path="routeName">Route Name</form:label>
                <form:input path="routeName"/>
            </p>
            <p>
                <label for="numberofstops">Number of stops</label>
                <input type="text" name="numberofstops" id="numberofstops">
            </p>
        <td colspan="2"><input type="submit" value="add route" class="btn"></td>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </div>
</form:form>
</body>
</html>
