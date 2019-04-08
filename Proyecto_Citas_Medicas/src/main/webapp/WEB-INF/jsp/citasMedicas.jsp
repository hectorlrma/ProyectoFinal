<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Exo 2' rel='stylesheet'>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

  <title>CITALIA - Pide tu cita m�dica</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-sm" style="background-color: #2BD1E8 ">
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="/index" style="color: #8331CC">CITALIA</a>
    </li>
  </ul>
  </nav>

  <nav class="navbar navbar-expand-sm">
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="/citaHoyMed" style="color: #8331CC">Citas de Hoy</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/citaproximamed" style="color: #8331CC">Pr�ximas citas</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/citaantiguamed" style="color: #8331CC">Citas antiguas</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/citaconfirmada" style="color: #8331CC">Citas confirmadas</a>
    </li>
  </ul>
  </nav>
       
        			<table>
							<thead>
								<tr>
									<th>M�dico</th>
									<th>Fecha</th>
									<th>Hora</th>
									
								</tr>
							</thead>
							<tr>
							<c:forEach var="cita" items="${cita_medico}">
							<td>${cita.nick_medico}</td>
							<td>${cita.fecha_cita}</td>
							<td>${cita.hora_cita}
							</c:forEach>
							
							</tr>
						</table>
					
 
</body>
</html>