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
  <ul class="navbar-nav">
   <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#"  style="color: #8331CC" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          ¿Eres Paciente?
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <label class="dropdown-item" data-toggle="modal" data-target="#logInModal">Inicia Sesión</label>
          <label class="dropdown-item" data-toggle="modal" data-target="#registroPacienteModal">Regístrate</label>
          
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">¿Olvidó su contraseña?</a>
        </div>
      </li>
  </ul>
  <ul class="navbar-nav">
   <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" style="color: #8331CC" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          ¿Eres Médico?
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <label class="dropdown-item" data-toggle="modal" data-target="#logInModal">Inicia Sesión</label>
          <label class="dropdown-item" data-toggle="modal" data-target="#registroMedicoModal">Regístrate</label>
          
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">¿Olvidó su contraseña?</a>
        </div>
      </li>
  </ul>

<!-- Modal Inicio Sesion -->
<div class="modal fade" id="logInModal" tabindex="-1" role="dialog" aria-labelledby="logInModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logInModalLabel">Log In</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="registrarse">
      <div class="modal-body">
   <div class="form-group">
    <label for="exampleInputPassword">Nick</label>
    <input type="text" class="form-control" id="exampleInputPassword" placeholder="Introduce tu nick">
  </div>      
   <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Introduce tu password">
  </div>
    <div class="form-group">
     <button type="submit" class="btn btn-primary">Log in</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
     </div>
  </div>
  <!--<div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>-->


     <!--  </div>
      <div class="modal-footer">
      <button type="submit" class="btn btn-primary">Submit</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
         
      </div> -->
      </form>
    </div>
  </div>
</div>
<ul></ul>



<!-- Modal Registro-->
<div class="modal fade" id="registroPacienteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Registro Paciente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form>
      <div class="modal-body">
        <div class="form-group">
    <label for="exampleInputPassword">Nick</label>
    <input type="text" class="form-control" id="exampleInputPassword" placeholder="Introduce tu nick">
  </div>      
   <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Introduce tu password">
  </div>
 <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Introduce tu email">
   <!--  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
  </div>
      <div class="form-group">
     <button type="submit" class="btn btn-primary">Log in</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
     </div>
       </div>
      </form>
    </div>
  </div>
</div>
<div class="modal fade" id="registroMedicoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Registro Médico</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form>
      <div class="modal-body">
        <div class="form-group">
    <label for="exampleInputPassword">Nick</label>
    <input type="text" class="form-control" id="exampleInputPassword" placeholder="Introduce tu nick">
  </div>      
   <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Introduce tu password">
  </div>
 <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Introduce tu email">
   <!--  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Especialidad</label>
    <select>
    <c:forEach var="especialidad" items="${especialidades}">
    <option value="${especialidad.id_especialidad}">${especialidad.nombre_especialidad}</option>
    </c:forEach>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Localidad</label>
    <select>
    <c:forEach var="localidad" items="${localidades}">
    <option value="${localidad.id_localidad}">${localidad.nombre_localidad}</option>
    </c:forEach>
    </select>
  </div>
      
      <div class="form-group">
     <button type="submit" class="btn btn-primary">Registro</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
     </div>
     </div>
      </form>
    </div>
  </div>
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