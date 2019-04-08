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
  <ul><button type="submit" class="btn btn-primary">Buscar</button></ul>
    
    </nav>
  </form>
  <nav class="navbar navbar-expand-sm">
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="/loginpaciente" style="color: #8331CC">Citas de Hoy</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/citaproximapac" style="color: #8331CC">Próximas citas</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/citaantiguapac" style="color: #8331CC">Citas antiguas</a>
    </li>
  </ul>
  </nav>
       
        
          <div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Médico</th>
									<th class="cell100 column4">Fecha</th>
									<th class="cell100 column4">Hora</th>
									
								</tr>
							</thead>
							<tr>
							<c:forEach var="cita" items="${cita_paciente}">
							<td>${cita.nick_medico}</td>
							<td>${cita.fecha_cita}</td>
							</c:forEach>
							
							</tr>
						</table>
					</div>
					</div>
					</div>
					</div>
					</div>
 
</body>
</html>