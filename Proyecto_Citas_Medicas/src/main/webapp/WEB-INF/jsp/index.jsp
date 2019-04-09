<!DOCTYPE html>
<html lang="en">
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
          <label class="dropdown-item" data-toggle="modal" data-target="#logInPacienteModal">Inicia Sesión</label>
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
          <label class="dropdown-item" data-toggle="modal" data-target="#logInMedicoModal">Inicia Sesión</label>
          <label class="dropdown-item" data-toggle="modal" data-target="#registroMedicoModal">Regístrate</label>
          
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">¿Olvidó su contraseña?</a>
        </div>
      </li>
  </ul>

<!-- Modal Inicio Sesion -->
<div class="modal fade" id="logInMedicoModal" tabindex="-1" role="dialog" aria-labelledby="logInModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logInModalLabel">Log In</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="loginmedico">
      <div class="modal-body">
   <div class="form-group">
    <label for="nick_medico">Nick</label>
    <input type="text" class="form-control" id="nick_medico" name="nick_medico" placeholder="Introduce tu nick">
  </div>      
   <div class="form-group">
    <label for="password_medico">Password</label>
    <input type="password" class="form-control" id="password_medico" name="password_medico" placeholder="Introduce tu password">
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

<div class="modal fade" id="logInPacienteModal" tabindex="-1" role="dialog" aria-labelledby="logInModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logInModalLabel">Log In</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="loginpaciente">
      <div class="modal-body">
   <div class="form-group">
    <label for="nick_paciente">Nick</label>
    <input type="text" class="form-control" id="nick_paciente" name="nick_paciente" placeholder="Introduce tu nick">
  </div>      
   <div class="form-group">
    <label for="password_paciente">Password</label>
    <input type="password" class="form-control" id="password_paciente" name="password_paciente" placeholder="Introduce tu password">
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
      <form action="registroPaciente">
      <div class="modal-body">
        <div class="form-group">
    <label for="nick_paciente">Nick</label>
    <input type="text" class="form-control"  value="${pacienteDTO.nick_paciente}" id="nick_paciente" name="nick_paciente" placeholder="Introduce tu nick">
  </div>   
   <div class="form-group">
    <label for="nombre_paciente">Nombre</label>
    <input type="text" class="form-control"  value="${pacienteDTO.nombre_paciente}" id="nombre_paciente" name="nombre_paciente" placeholder="Introduce tu password">
  </div>   
   <div class="form-group">
    <label for="password_paciente">Password</label>
    <input type="password" class="form-control"  value="${pacienteDTO.password_paciente}" id="password_paciente" name="password_paciente" placeholder="Introduce tu password">
  </div>
 <div class="form-group">
    <label for="email_paciente">Email</label>
    <input type="email" class="form-control" value="${pacienteDTO.email_paciente}" id="email_paciente" name="email_paciente" aria-describedby="emailHelp" placeholder="Introduce tu email">
   <!--  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
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
<div class="modal fade" id="registroMedicoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Registro Médico</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="registroMedico">
      <div class="modal-body">
        <div class="form-group">
    <label for="nick_medico">Nick</label>
    <input type="text" class="form-control"  value="${medicoDTO.nick_medico}" id="nick_medico" name="nick_medico" placeholder="Introduce tu nick">
  </div>      
   <div class="form-group">
    <label for="nombre_medico">Nombre</label>
    <input type="text" class="form-control" value="${medicoDTO.nombre_medico}" id="nombre_medico" name="nombre_medico" placeholder="Introduce tu password">
  </div>
   <div class="form-group">
    <label for="password_medico">Password</label>
    <input type="password" class="form-control" value="${medicoDTO.password_medico}" id="password_medico" name="password_medico" placeholder="Introduce tu password">
  </div>
 <div class="form-group">
    <label for="email_medico">Email</label>
    <input type="email" class="form-control" value="${medicoDTO.email_medico}" id="email_medico" name="email_medico" aria-describedby="emailHelp" placeholder="Introduce tu email">
   <!--  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Especialidad</label>
    <select name="id_especialidad">
    <c:forEach var="especialidad" items="${especialidades}">
    <option value="${especialidad.id_especialidad}">${especialidad.nombre_especialidad}</option>
    </c:forEach>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Localidad</label>
    <select name="id_localidad">
    <c:forEach var="localidad" items="${localidades}">
    <option  value="${localidad.id_localidad}">${localidad.nombre_localidad}</option>
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
<div class="d-flex justify-content-sm-center" style="background-color: #2BD1E8">
<p style="font-family: 'Exo 2';font-size: 200px; color: #8331CC">CITALIA</p>
</div>
<div class="d-flex justify-content-sm-center" style="background-color: #2BD1E8">
<p style="font-family: 'Exo 2';font-size: 30px; color: #8331CC">[Tus citas médicas en un click]</p>

</div>

<br>
<br>
<div class="d-flex justify-content-md-around"><div class="p-2"> <img alt="" src="https://images.vexels.com/media/users/3/146911/isolated/preview/50a6d66d1628e97f630846f158e5b7eb-s--mbolo-de-la-lupa-by-vexels.png" width="25" height="25"> <p style="font-size: 18px"> <strong>Encuentra tu médico preferido</strong></p><p class="text-muted">Elige entre los mejores especialistas</p><p class="text-muted">del país y recibe el mejor diagnóstico.</p></div>
  <div class="p-2"> <img alt="" src="https://t4.ftcdn.net/jpg/00/66/79/81/160_F_66798148_QWEQO5TMR6JJMcPKXXqyPVGj1slsqND6.jpg" width="20" height="20"><p style="font-size: 18px"> <strong>Busca por localidad</strong></p><p class="text-muted">Elige tu zona y evita</p><p class="text-muted">tener que transportarte lejos.</p></div>
  <div class="p-2"> <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Check_mark.svg/1200px-Check_mark.svg.png" width="20" height="20"><p style="font-size: 18px"> <strong>Pide tu cita online sin esperas ni colas</strong></p><p class="text-muted">En un click tendrás tu cita registrada</p></div>
</div>
 <form action="/action_page.php">
 <nav class="navbar navbar-expand-sm" style="background-color: #2BD1E8 ">
  <ul></ul>
  <ul></ul>
  <ul></ul>
  <ul></ul>
       
    </nav>
    
  </form>
 

</body>
</html>
