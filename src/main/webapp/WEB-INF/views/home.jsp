<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
        <sec:csrfMetaTags/>
        <title>Route Analytics</title>
        <link rel="stylesheet" href="../../css/homepage_style.css" />
        <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
    </head>
    <body>
    <ul>
        <li><a href="/">Route Analytics</a></li>
        <li><a href="/routes">Routes</a></li>
        <li><a href="/register">Register</a></li>
        <li><a href="/contacts">Contacts</a></li>
    </ul>
        <h2>Hello World!</h2>
        <h1>It`s Route Analytics home page!</h1>
        <h2><a href="/routes">Routes</a>|<a href="/register">Register</a></h2>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
            <%--@elvariable id="_csrf" type="org.springframework.web.bind.MissingServletRequestParameterException"--%>
            <c:url var="logoutUrl" value="/logout" />
            <form action="${logoutUrl}" id="logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
                <input type="submit" name="submit" value="Log Out">
            </form>
        </c:if>
    </body>
</html>
