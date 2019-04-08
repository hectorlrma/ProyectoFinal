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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
      <a class="nav-link" href="loginmedico" style="color: #8331CC">Citas de Hoy</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="citaproximamed" style="color: #8331CC">Próximas citas</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="citaantiguamed" style="color: #8331CC">Citas antiguas</a>
    </li>
  </ul>
  </nav>
       
        			<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Médico</th>
									<th class="cell100 column4">Fecha</th>
									<th class="cell100 column4">Hora</th>
									
								</tr>
							</thead>
							<tr>
							<c:forEach var="cita" items="${cita_medico}">
							<td>${cita.nick_medico}</td>
							<td>${cita.fecha_cita}</td>
							</c:forEach>
							
							</tr>
						</table>
					
 
</body>
</html>