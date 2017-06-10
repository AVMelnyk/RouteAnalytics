<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>Route Analytics</title>
    <link rel="stylesheet" href="../../css/addroute.css" />
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
</head>
<body>
<form name="editroute"   method="POST" accept-charset="UTF-8" >
    <p><c:out value = "${route.routeNumber}"/><c:out value = "${route.routeName}"/></p>
    <table>
        <th> Stop Number</th>
        <th> Stop Name </th>
        <c:forEach var="routeStop"  items="${stopList}">
        <tr>
            <td><c:out value = "${routeStop.routeStopId}"/></td>
            <td><input type='text' name='stopname'/></td>
        </tr>
    </c:forEach>
    </table>
    <span><input type="submit" value="edit route" class="btn"></span>
</form>
</body>
</html>
