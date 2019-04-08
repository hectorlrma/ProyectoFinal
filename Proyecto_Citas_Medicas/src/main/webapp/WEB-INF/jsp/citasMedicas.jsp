<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Exo 2' rel='stylesheet'>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

  <title>CITALIA - Pide tu cita médica</title>
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
      <a class="nav-link" type="button"  href="/citaHoyMed" style="color: #8331CC">Citas de Hoy</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" type="button"  href="/citaproximamed" style="color: #8331CC">Próximas citas</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" type="button"  href="/citaantiguamed" style="color: #8331CC">Citas antiguas</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" type="button" href="/citaconfirmada" style="color: #8331CC">Citas confirmadas</a>
    </li>
  </ul>
  </nav>
       <div class="container">
        			<table class="table">
							<thead>
								<tr style="text-align: center">
									<th><strong>ID Cita</strong></th>
									<th><strong>Médico</strong></th>
									<th><strong>Fecha</strong></th>
									<th><strong>Hora</strong></th>
									
								</tr>
							</thead>
							<c:forEach var="cita" items="${cita_medico}">
							<tr style="text-align: center">
							<td>${cita.id_cita}</td>
							<td>${cita.nick_medico}</td>
							<td>${cita.fecha_cita}</td>
							<td>${cita.hora_cita}</td>
						
							
							</tr>
								</c:forEach>
						</table>
					
 </div>
</body>
</html>