<%@ page isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form method="POST">
        <div class="registration_form label">
            <label for="firstname">First Name</label>
        </div>
        <div class="registration_form input">
            <input type="text" id="firstname" autofocus>
        </div>
        <div class="registration_form label">
            <label for="lastname">Last Name</label>
        </div>
        <div class="registration_form input">
            <input type="text" id="lastname" >
        </div>
        <div class="registration_form label">
            <label for="username">Username</label>
        </div>
        <div class="registration_form input">
            <input type="text" id="username" >
        </div>
        <div class="registration_form label">
            <label for="password">Password</label>
        </div>
        <div class="registration_form input">
            <input type="password" id="password">
        </div>
        <input  class="input submit" type="submit" value="Register" />
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
</div>
</body>
</html>
