
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.html"%>
    <title>Hello, world!</title>
  </head>
  <body style="width: 100vw; height:100vh;">
  	<%@ page import="app.*" %>
	<%@ page import="tpbanco.*" %>
    <container>
    <%@ include file="nav.html"%>
    <div class="container">
    <div class="row">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Clientes <span> Este span se muestra si es edición </span>
 			 </div>  
 			 <!-- Si quiere ver el cliente, se  pondrían los campos como solo lectura -->
 			 <div class="card-body">
				<div class="row">
				<div class="col-md-12">
				<form method="POST" action="formclientes.jsp">
				 <div class="form-group row">
    				<label for=""nombre"" class="col-sm-2 col-form-label">Nombre:</label>
    				<div class="col-sm-10">
     			 	<input type="text" class="form-control" id="nombre" required name="nombre" maxlength="50"
     			 	placeholder=" Ingrese el/los nombre/s del cliente">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="apellido" class="col-sm-2 col-form-label">Apellido:</label>
    				<div class="col-sm-10">
     			 	<input type="text" class="form-control" id="apellido" required name="apellido" maxlength="50"
     			 	placeholder=" Ingrese el/los apellido/s del cliente">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="dni" class="col-sm-2 col-form-label">DNI:</label>
    				<div class="col-sm-10">
     			 	<input type="text" class="form-control" id="dni" name="dni" required maxlength="8" pattern="\d*"
     			 	placeholder=" Documento del cliente, solo números">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="sexo" class="col-sm-2 col-form-label">Sexo:</label>
    				<div class="col-sm-10">
     			 	<select class="form-control" id="sexo" required name="sexo">
  					<option>Masculino</option>
  					<option>Femenino</option>>
					</select>
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="datepicker" class="col-sm-2 col-form-label">Fecha de nacimiento:</label>
    				<div class="col-sm-10">
     			 	<input type="text" id="datepicker" required name="fnac">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="nacionalidad" class="col-sm-2 col-form-label">Nacionalidad:</label>
    				<div class="col-sm-10">
     			 	<input type="text" class="form-control" required id="nacionalidad" name="nacionalidad" maxlength="50"
     			 	placeholder="Nacionalidad del cliente">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="provincia" class="col-sm-2 col-form-label">Provincia:</label>
    				<div class="col-sm-10">
     			 	<select class="form-control" id="provincia" required name="provincia">
  					<option>Provincia 1</option>
  					<option>Provincia 2</option>
  					<option>Provincia 3</option>
					</select>
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for=""nombre"" class="col-sm-2 col-form-label">Dirección:</label>
    				<div class="col-sm-10">
     			 	<input type="text" class="form-control" required id="nombre" maxlength="70"
     			 	placeholder=" Calle y número">
    				</div>
 				 </div>
 				 
 				  <div class="form-group row">
    				<label for="username" class="col-sm-2 col-form-label">Nombre de usuario:</label>
    				<div class="col-sm-10">
     			 	<input type="text" class="form-control" required id="username" name="username" maxlength="70"
     			 	placeholder="Usuario con el que hará login">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row text-right justify-content-end px-4">
    				<button class="btn btn-primary" value="Enviar" >Enviar</button>
 				 </div>
 				 
 				 
				</form>						
				</div>
				</div>
				</div>
 			 </div> 
    	   </div>
    </div>
    </div>
    </container>

<%@ include file="foot.html"%>
    <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
  </body>
</html>