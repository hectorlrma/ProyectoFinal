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
  <style type='text/css'>
 
tr:nth-child(odd) {
    background-color:#B99EF3;
}
tr:nth-child(even) {
    background-color:#9778DC;
}
 
</style>
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
  <ul>BIENVENIDO DOCTOR ${nick_medico}</ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" type="button"  href="/citaHoyMed" style="color: #8331CC">Citas de Hoy</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" type="button"  href="/citaproximamed" style="color: #8331CC">Pr�ximas citas</a>
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
        			<table id="tablePreview" class="table table-striped table-hover table-bordered">
							<thead>
								<tr style="text-align: center">
									<th scope="row"><strong>ID Cita</strong></th>
									<th scope="row"><strong>M�dico</strong></th>
									<th scope="row"><strong>Fecha</strong></th>
									<th scope="row"><strong>Hora</strong></th>
									
								</tr>
							</thead>
							<c:forEach var="cita" items="${cita_medico}">
							<tr style="text-align: center">
							<td>${cita.id_cita}</td>
							<td>${cita.nick_medico}</td>
							<td>${cita.fecha_cita}</td>
							<td>${cita.hora_cita}</td>
							<td><a href="/borrarcita?id_cita=${cita.id_cita}" type="button" class="btn btn-danger">Borrar</a></td>
						
							
							</tr>
								</c:forEach>
						</table>
					
 </div>
</body>
</html>