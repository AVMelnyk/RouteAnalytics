<%@ page isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Route Analytics</title>
    <sec:csrfMetaTags/>
    <link rel="stylesheet" href="../../css/register_style.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
</head>
<ul>
    <li><a href="/">Route Analytics</a></li>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.authenticated}">
            <li><a href="/routes">Routes</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/register">Register</a></li>
        </c:otherwise>
    </c:choose>
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
<div class="error_message">
    <p><c:out value="${errorMsg}"/></p>
</div>
<div class="registr_greetings">
    <h1>Registration form</h1>
</div>
<div class="registration_form">
    <form:form  name="registration" action="/user/registration"  modelAttribute="userDto" acceptCharset="UTF-8" method="POST">
        <form:label path="userName">username</form:label>
        <form:errors path="userName" />
        <form:input path="userName" />
        <form:label path="firstName">FirstName</form:label>
        <form:errors path="firstName" />
        <form:input path="firstName" />
        <form:label path="lastName">LastName</form:label>
        <form:errors path="lastName" />
        <form:input path="lastName" />
        <form:label path="email">Email</form:label>
        <form:errors path="email" />
        <form:input path="email"/>
        <form:label path="password">Password</form:label>
        <form:errors path="password" />
        <form:password path="password"/>
        <form:label path="matchingPassword">Confirm Password</form:label>
        <form:errors path="matchingPassword" />
        <form:password  path="matchingPassword"/>
        <input class="input submit" type="submit" value="Register" />
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form:form>
</div>
</body>
</html>
