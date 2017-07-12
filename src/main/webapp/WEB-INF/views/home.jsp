<%@ page isELIgnored="false" %>
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
            <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
        <html>
        <head>
            <link rel="stylesheet" href="../../css/homepage_style.css" />
            <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
            <sec:csrfMetaTags/>
            <title>Route Analytics</title>
            <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
        </head>
        <body>
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
        <div class="greeting">
            <h2>Hello World!</h2>
            <h1>It`s Route Analytics home page!</h1>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="greeting"><h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
            </div>
        </c:if>
    </body>
</html>
