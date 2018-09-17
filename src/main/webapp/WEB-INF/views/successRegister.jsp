<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Route Analytics</title>
        <link rel="stylesheet" href="../../css/homepage_style.css" />
    </head>
    <body>
        <ul>
            <li><a href="/">Route Analytics</a></li>
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.authenticated}">
                    <li><a href="/routes">Routes</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/user/registration">Register</a></li>
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
        <p>You successfully registered  <c:out value = "${user.userName} "/></p>
    </body>
</html>
