<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/addroute.css" />
</head>
<body>
    <form name="addroute" action="/addroute"  method="POST" accept-charset="UTF-8" >
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
    </form>
</body>
</html>
