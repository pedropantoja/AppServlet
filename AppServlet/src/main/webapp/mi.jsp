<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>AppServlet</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/add">
    <h1>Insertar Datos a Redis</h1>
    <label>
      <span>Nombre:</span>
      <input id="nombre" type="text" name="nombre" placeholder="Nombre"/>
    </label>
    <label>
        <span>Apellidos:</span>
        <input id="apellido" type="text" name="apellido" placeholder="Apellidos"/>
    </label>
    <label>
      <span>Correo:</span>
      <input id="correo" type="text" name="correo" placeholder="Correo"/>
    </label>
    <label>
        <span>&nbsp;</span>
        <input type="submit"/>
    </label>
    <button type="button" name="datos">Mostrar Datos</button>
    <c:forEach var="h" items="${listpers}" varStatus="loop">
      <p> <i>${loop.index}: </i> <b>${h.nombre}</b>  ... ${h.apellido} ... ${h.email}</p>
    </c:forEach>
</form>
</body>
</html>
