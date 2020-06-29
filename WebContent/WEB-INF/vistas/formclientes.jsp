  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.jsp"%>
    <title>Hello, world!</title>
  </head>
  <body style="width: 100vw; height:100vh;">
  <%@ page import="utn.frgp.edu.ar.*" %>
	<%@ page import="utn.frgp.edu.ar.entidad.*" %>
    <container>
    <%@ include file="nav.html"%>
    <div class="container">
    <div class="row">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Detalle de Cliente
 			 </div>  
 			 
 			 
 			 
 			 
 			
 			  <c:forEach var="formclientes" items="${ formclientes }">
 		
 			 
 			 <!-- Si quiere ver el cliente, se  pondrían los campos como solo lectura -->
 			 <div class="card-body">
				<div class="row">
				<div class="col-md-12">
				<form method="POST" action="formclientesPost.html">
				<input hidden name="idCliente" value="${ formclientes.getIdCliente() }">
				
				
				
				 <div class="form-group row">
    				<label for="nombre" class="col-sm-2 col-form-label">Nombre:</label>
    				<div class="col-sm-10">
     			 	<input type="text" required value= "${ formclientes.getNombre() }" class="form-control" id="nombre"  name="nombre" maxlength="50"
     			 	placeholder=" Ingrese el/los nombre/s del cliente"> 
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="apellido" class="col-sm-2 col-form-label">Apellido:</label>
    				<div class="col-sm-10">
     			 	<input type="text" required value= "${ formclientes.getApellido() }" class="form-control" id="apellido"  name="apellido" maxlength="50"
     			 	placeholder=" Ingrese el/los apellido/s del cliente">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="dni" class="col-sm-2 col-form-label">DNI:</label>
    				<div class="col-sm-10">
     			 	<input type="text" required readonly value= "${ formclientes.getDni() }" class="form-control" id="dni" name="dni" required maxlength="8" pattern="\d*"
     			 	placeholder=" Documento del cliente, solo números">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="sexo" class="col-sm-2 col-form-label">Sexo:</label>
    				<div class="col-sm-10">
     			 	<select required class="form-control"  id="sexo" required name="sexo">

  					 <c:forEach var="sexo" items="${ listaSexo }">
  					<option value= "${ sexo.getIdSexo() }">${ sexo.getDescripcion() }</option>
					 </c:forEach>	
					</select>
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="datepicker" class="col-sm-2 col-form-label">Fecha de nacimiento:</label>
    				<div class="col-sm-10">
     			 	<input type="text" required value= " ${ formclientes.getFecha_nacimiento() }" id="datepicker" required name="fnac">
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="nacionalidad" class="col-sm-2 col-form-label">Nacionalidad:</label>
    				<div class="col-sm-10">
     			 	<select class="form-control"   id="nacionalidad" required name="nacionalidad">
  					
  					 <c:forEach var="nacionalidad" items="${ listaNacionalidades }">
  					<option value="${ nacionalidad.getIdNacionalidad()}">${ nacionalidad.getDescripcion() }</option>
					 </c:forEach> 
					</select>
    				</div>
 				 </div>
 				 
 				 <div class="form-group row">
    				<label for="provincia" class="col-sm-2 col-form-label">Provincia:</label>
    				<div class="col-sm-10">
     			 	<select class="form-control" required  id="provincia" required name="provincia">
  					
  					 <c:forEach var="provincias" items="${ listaProvincias }">
  					<option value="${ provincias.getIdProvincia() }">${ provincias.getDescripcion() }</option>
					 </c:forEach>
					</select>
    				</div>
 				 </div>
 				 
 				  <div class="form-group row">
    				<label for="localidad" class="col-sm-2 col-form-label">Localidad:</label>
    				<div class="col-sm-10">
     			 	<select class="form-control" required   id="localidad" required name="localidad">
  					
  					 <c:forEach var="localidades" items="${ listaLocalidades }">
  					<option value="${ localidades.getIdLocalidad() }">${ localidades.getDescripcion() }</option>
					 </c:forEach>
					</select>
    				</div>
 				 </div>
 				 
 				 
 				 <div class="form-group row">
    				<label for="" class="col-sm-2 col-form-label">Usuario:</label>
    				<div class="col-sm-10">
     			 	<input type="text" readonly value="${ formclientes.getIdUsuario().getNombreUsuario() }"  class="form-control" name="nombreUser" required id="nombreUser" maxlength="70"
     			 	placeholder=" Calle y número">
    				<input hidden name="idUsuario" value="${ formclientes.getIdUsuario().getIdUsuario() }">
    				</div>
 				 </div>
 				 
 				

			     <div class="form-group row text-right justify-content-end px-4">
    				<button class="btn btn-primary" value="Enviar" >Guardar</button>
 				 </div>					 
	
 				 
 				 
				</form>						
				</div>
				</div>
				</div>
				
				 </c:forEach>	
				
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