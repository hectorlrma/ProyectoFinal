<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Exo 2' rel='stylesheet'>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

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
<body background="imagenes/fondo-medico.jpg" >
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
  <ul class="navbar-nav">
   <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" style="color: #8331CC" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          ¿Quieres crear una cita?
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <label class="dropdown-item" data-toggle="modal" data-target="#altaCita">Alta Cita</label>
         </div>
      </li>
  </ul>
  


<!-- Modal Registro-->
<div class="modal fade" id="altaCita" tabindex="-1" role="dialog" aria-labelledby="altaCitaModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="altaCita">Alta cita</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="/altacita">
      <div class="modal-body">
        <div class="form-group">
    <label for="fecha_cita">Date(yyyy-mm-dd)</label>
    <input type="text" class="form-control"  value="${citaDTO.fecha_cita}" id="fecha_cita" name="fecha_cita" placeholder="Introduce la fecha">
  </div>   
   <div class="form-group">
    <label for="hora_cita">Hora(hh:mm)</label>
    <input type="text" class="form-control"  value="${citaDTO.hora_cita}" id="hora_cita" name="hora_cita" placeholder="Introduce la hora">
  </div> 
   <div class="form-group">
     <button type="submit" class="btn btn-primary">Dar de alta</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
     </div>
  </div>
  
  </form>
  </div>
  </div>
  </div>
    
        </nav>

  <nav class="navbar navbar-expand-sm">
  <ul>¡BIENVENIDO DOCTOR/A ${nick_medico}!</ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="btn btn-info" href="/citaHoyMed"><strong>Citas de Hoy</strong></a>
    </li> &nbsp; &nbsp;
      <li class="nav-item">
      <a class="btn btn-info" href="/citaproximamed"><strong>Próximas citas</strong></a>
    </li> &nbsp; &nbsp;
    <li></li>
     <li class="nav-item">
      <a class="btn btn-info" href="/citaantiguamed"><strong>Citas antiguas</strong></a>
    </li> &nbsp; &nbsp;
    <li></li>
     <li class="nav-item">
      <a class="btn btn-info" href="/citaconfirmada"><strong>Citas confirmadas</strong></a>
    </li>
  </ul>
  
  </nav>
       <div class="container">
        			<table id="tablePreview" class="table table-hover table-bordered">
							<thead>
								<tr style="text-align: center; background-color:#B99EF3">
									<th scope="row"><strong>NÚMERO CITA</strong></th>
									<th scope="row"><strong>PACIENTE</strong></th>
									<th scope="row"><strong>FECHA</strong></th>
									<th scope="row"><strong>HORA</strong></th>
									
								</tr>
							</thead>
							<c:forEach var="cita" items="${cita_medico}">
							<tr style="text-align: center; background-color:#B6B2BF">
							<td>${cita.id_cita}</td>
							<td>${cita.nick_paciente}</td>
							<td>${cita.fecha_cita}</td>
							<td>${cita.hora_cita}</td>
							<td><a href="/borrarcita?id_cita=${cita.id_cita}" type="button" class="btn btn-danger">Borrar</a></td>
						
							
							</tr>
								</c:forEach>
						</table>
					
 </div>
</body>
</html>