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
 
</style>	
<title>Citas Paciente</title>
</head>
<body background="imagenes/fondo-paciente.png" >
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
  <a class="nav-link" href="/citaHoyPac" style="color: #8331CC; font-size: 25px;"><strong>MIS CITAS</strong></a>
  <ul></ul><ul></ul><ul></ul>
  
  </nav>
<form action="/buscar">
 <nav class="navbar navbar-expand-sm" style="background-color: #2BD1E8 ">
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
  
     <select name="especialidad" class="custom-select mb-3">
      <option selected>Elige Especialidad</option>
      <c:forEach var="especialidad" items="${especialidades}">
       <option value="${especialidad.id_especialidad}">${especialidad.nombre_especialidad}</option>
       </c:forEach>
    </select>
 
 
     <select name="localidad" class="custom-select mb-3">
    <option selected>Elige Localidad</option>
      <c:forEach var="localidad" items="${localidades}">
       <option value="${localidad.id_localidad}">${localidad.nombre_localidad}</option>
       </c:forEach>
     </select>
     
  <ul><button type="submit" class="btn btn-primary"><strong>BUSCAR</strong></button></ul>
    </nav>
  </form>
  <nav class="navbar navbar-expand-sm">
  <ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul>
  
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="btn btn-info" href="/citaHoyPac" ><strong>Citas de Hoy</strong></a>
    </li>&nbsp; &nbsp;
     <li class="nav-item">
      <a class="btn btn-info" href="/citaproximapac"><strong>Próximas citas</strong></a>
    </li>&nbsp; &nbsp;
     <li class="nav-item">
      <a class="btn btn-info" href="/citaantiguapac"><strong>Citas antiguas</strong></a>
    </li>
  </ul>
  </nav>
       
        
          <div class="container">
        			<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr style="text-align: center; background-color:#B99EF3;">
									<th scope="row"><strong>NÚMERO CITA</strong></th>
									<th scope="row"><strong>MÉDICO</strong></th>
									<th scope="row"><strong>FECHA</strong></th>
									<th scope="row"><strong>HORA</strong></th>
									
								</tr>
							</thead>
							<c:forEach var="cita" items="${cita_paciente}">
							<tr style="text-align: center; background-color:#B6B2BF"  >
							<td><strong>${cita.id_cita}</strong></td>
							<td><strong>${cita.nick_medico}</strong></td>
							<td><strong>${cita.fecha_cita}</strong></td>
							<td><strong>${cita.hora_cita}</strong></td>
							<td><a href="cancelarCita?id_cita=${cita.id_cita}" type="button" class="btn btn-danger">Cancelar</a></td>
						
							
							</tr>
								</c:forEach>
						</table>
						</div>
 
</body>
</html>