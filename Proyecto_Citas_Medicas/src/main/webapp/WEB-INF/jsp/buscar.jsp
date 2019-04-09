<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


 <title>CITALIA - Pide tu cita m�dica</title>
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
  <div class="container">
        			<table class="table">
							<thead>
								<tr style="text-align: center">
									<th><strong>ID Cita</strong></th>
									<th><strong>M�dico</strong></th>
									<th><strong>Fecha</strong></th>
									<th><strong>Hora</strong></th>
									
								</tr>
							</thead>
							<c:forEach var="medico" items="${medicoDTO}">
							<tr style="text-align: center">
							<td>${medico.nombre_medico}</td>
							<td>${medico.nick_medico}</td>
							<td>${medico.email_medico}</td>
				
						
							
							</tr>
								</c:forEach>
						</table>
						</div>
  
  <div class="container">
        			<table class="table">
							<thead>
								<tr style="text-align: center">
									<th><strong>ID Cita</strong></th>
									<th><strong>M�dico</strong></th>
									<th><strong>Fecha</strong></th>
									<th><strong>Hora</strong></th>
									
								</tr>
							</thead>
							<c:forEach var="cita" items="${citaMedicosDTO}">
							<tr style="text-align: center">
							<td>${cita.id_cita}</td>
							<td>${cita.nick_medico}</td>
							<td>${cita.fecha_cita}</td>
							<td>${cita.hora_cita}</td>
							<td><a class="nav-link" href="/pideCita?id_cita=${cita.id_cita}" style="color: #8331CC">Pedir cita</a></td>
						
							
							</tr>
								</c:forEach>
						</table>
						</div>
  
  
<ul></ul>
<ul></ul>
<ul></ul>
<ul></ul>
        </nav>
        
        
         <div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Class name</th>
									<th class="cell100 column2">Type</th>
									<th class="cell100 column3">Hours</th>
									<th class="cell100 column4">Trainer</th>
									<th class="cell100 column5">Spots</th>
								</tr>
							</thead>
						</table>
					</div>
					</div>
					</div>
					</div>
					</div>
</body>
</html>