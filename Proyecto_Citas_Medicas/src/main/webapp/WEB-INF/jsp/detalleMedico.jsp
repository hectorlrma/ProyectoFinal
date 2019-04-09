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
<style type='text/css'>
 
tr:nth-child(odd) {
    background-color:#B99EF3;
}
tr:nth-child(even) {
    background-color:#9778DC;
}
 
</style>	
</head>
<body>
<nav class="navbar navbar-expand-sm" style="background-color: #2BD1E8 ">
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="/index" style="color: #8331CC; font-size: 25px;"><strong>CITALIA</strong></a>
    </li>
    
  </ul>
  <a class="nav-link" href="/volverBuscar" style="color: #8331CC; font-size: 25px;"><strong>VOLVER A BUSCAR</strong></a>
  <ul></ul><ul></ul><ul></ul>
  
  </nav>
 <div class="container">
        			<table id="tablePreview" class="table table-striped table-hover table-bordered">
							<thead>
								<tr style="text-align: center">
									<th scope="row"><strong>Nombre</strong></th>
									<th scope="row"><strong>Email</strong></th>
									<th scope="row"><strong>Especialidad</strong></th>
									<th scope="row"><strong>Localidad</strong></th>
									
								</tr>
							</thead>
							<tr style="text-align: center">
							<td>${medicoDTO.nombre_medico}</td>
							<td>${medicoDTO.email_medico}</td>
							<td>${localidadDTO.nombre_localidad}</td>
							<td>${especialidadDTO.nombre_especialidad}</td>
						
							
							</tr>
						</table>
						</div>
</body>
</html>