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
<body background="imagenes/fondo-buscar.jpg" >
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
  <ul><button type="submit" class="btn btn-primary"><strong>Buscar</strong></button></ul>
    
    </nav>
  </form>
 <!--   <nav class="navbar navbar-expand-sm">
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
-->

  <div class="container">
<p> 
  CITAS DISPONIBLES PARA<strong> ${especialidadDTO.nombre_especialidad}</strong>EN
  <strong> ${localidadDTO.nombre_localidad}</strong>
   <p>
        			<table class="table" style="border-radius: 10px;">
							<thead>
								<tr style="text-align: center; background-color:#B99EF3;">
									<th><strong>Médico</strong></th>
									<th><strong>Fecha</strong></th>
									<th><strong>Hora</strong></th>
									
								</tr>
							</thead>
							<c:forEach var="medico" items="${medicoDTO}">
							<tr style="text-align: center; background-color:#B6B2BF">
							<td>${medico.nick_medico}</td>
							<c:set var="contador" value="${0}" />
							<c:forEach var="cita" items="${citaMedicosDTO}">
							<c:if test="${cita.nick_medico==medico.nick_medico}">
							
							<c:set var="suma" value="${1}" />

							<c:if test="${contador == 0}">						
							<td>${cita.fecha_cita}</td>
							<td><a class="nav-link" href="/pideCita?id_cita=${cita.id_cita}" style="color: #8331CC">${cita.hora_cita}</a></td>
							
							

							</c:if>
							<c:if test="${contador > 0}">
							<tr style="text-align: center; background-color:#B6B2BF">
							<td></td>
							<td>${cita.fecha_cita}</td>
							<td>${cita.hora_cita}</td>
							<td><a class="nav-link" href="/pideCita?id_cita=${cita.id_cita}" style="color: #8331CC">Pedir cita</a></td>
							</tr>
							</c:if>
							 <c:set var="contador" value="${contador + suma}" />
							</c:if>
							</c:forEach>
							</tr>
								</c:forEach>
						</table>
						</div>

        
</body>
</html>