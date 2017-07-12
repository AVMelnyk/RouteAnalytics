<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/login.css" />
</head>
<body>
    <div class="error_message">
    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            Your login attempt was not successful due to <br/><br/>
            <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
    </c:if>
    </div>
    <c:url value="/spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text"  name="username" placeholder="Email address" >
        <input type="password"  name="password" placeholder="Password" >
        <button  type="submit">Войти</button>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
</body>
</html>
