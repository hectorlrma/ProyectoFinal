<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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