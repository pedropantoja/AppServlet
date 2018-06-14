<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>AppServlet</title>
</head>
<body>
 <h2>Apellidos:</h2>
 <c:forEach var="h" items="${listpers}" varStatus="loop">
         <p> <i>${loop.index}: </i> <b>${h.apellido}</b></p>
 </c:forEach>
</body>
</html>
