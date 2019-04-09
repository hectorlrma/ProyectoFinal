<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import='com.example.demo.dto.MedicoDTO' %>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


 <title>CITALIA - Pide tu cita médica</title>
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
  <ul><button type="submit" class="btn btn-primary"><strong>Buscar</strong></button></ul>
    
    </nav>
  </form>
  <nav class="navbar navbar-expand-sm">
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="/citaHoyPac" style="color: #8331CC">Citas de Hoy</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/citaproximapac" style="color: #8331CC">Próximas citas</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/citaantiguapac" style="color: #8331CC">Citas antiguas</a>
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
							<c:forEach var="cita" items="${citaMedicosDTO}">
							<tr style="text-align: center">
							<td>${cita.id_cita}</td>
							<td><a class="nav-link" href="/detalleMedico?nick_medico=${cita.nick_medico}" style="color: #8331CC">${cita.nick_medico}</a></td>
							<td>${cita.fecha_cita}</td>
							<td>${cita.hora_cita}</td>
							<td><a class="nav-link" href="/pideCita?id_cita=${cita.id_cita}" style="color: #8331CC">Pedir cita</a></td>
						
							
							</tr>
								</c:forEach>
						</table>
						</div>

        
</body>
</html>