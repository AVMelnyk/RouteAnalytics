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
    <form:form name="addroute" action="/addroute"  method="POST" acceptCharset="UTF-8">
        <table>
            <tr>
                <td>Route Number:</td>
                <td><input type='text' name='routenumber'/></td>
            </tr>
            <tr>
                <td>Route Name: </td>
                <td><input type="text" name="routename"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="add route" class="btn"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
