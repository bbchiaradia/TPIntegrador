  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html5>
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
   				 Alta de Cliente
 			 </div>  
 			  		
 		
 			 
 			 <div class="card-body">
				<div class="row">
				<div class="col-md-12">
				<form method="POST" action="altaClientePOST.html">
			
				 <div class="form-group row">
    				<label for="nombre" class="col-sm-2 col-form-label">Nombre:</label>
    				<div class="col-sm-10">
     			 	<input type="text" class="form-control" id="nombre"  name="nombre" maxlength="50"
     			 	placeholder=" Ingrese el/los nombre/s del cliente"> 
    				</div>
 				 </div>
 		 				 <div class="form-group row">
	    				<label for="apellido" class="col-sm-2 col-form-label">Apellido:</label>
	    				<div class="col-sm-10">
	     			 	<input type="text" required  class="form-control" id="apellido"  name="apellido" maxlength="50"
	     			 	placeholder=" Ingrese el/los apellido/s del cliente">
	    				</div>
	 				 </div>
	 				 
	 				 <div class="form-group row">
	    				<label for="dni" class="col-sm-2 col-form-label">DNI:</label>
	    				<div class="col-sm-10">
	     			 	<input type="text" required onkeyup="validaDNI(event);"  class="form-control" id="dni" name="dni" required maxlength="8"
	     			 	placeholder=" Documento del cliente, solo números">
	     			 	<span id="errdni" style="display: none; color:red;font-size:1rem"></span>
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
	     			 	<input type="text" required  id="datepicker" required name="fnac">
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
	     			 	<input type="text" onkeyup="validaUser(event);"  class="form-control"  minlength="5" maxlength="20" name="nombreUser" required id="nombreUser" maxlength="70"
	     			 	placeholder=" Ingrese el nombre usuario">
	    				<span id="erruser" style="display: none; color:red;font-size:1rem"></span>
	    				</div>
                    </div>
 	
 				 
 				

			     <div class="form-group row text-right justify-content-end px-4">
    				<button class="btn btn-primary" id="btnSubmit" value="Enviar" >Guardar</button>
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
    $(document).ready(function() {

        $('#datepicker').datepicker({
            dateFormat: 'dd/mm/yy'
        });
        
        
    });
    
    function validaDNI(e){
    	console.log(e);
    	if( e.target.value.length < 7 ){
    		$("#btnSubmit").prop("disabled", true);
    		document.getElementById("errdni").innerText = "el número de dni debe tener al menos 7 caracteres";
    		document.getElementById("errdni").style.display = "block"; 
    	}else{
    		$("#btnSubmit").prop("disabled", false);
    		document.getElementById("errdni").innerText = "";
    		document.getElementById("errdni").style.display = "none"; 
    		let dni = document.getElementById("dni").value;
    		$.ajax({
		        url: '${request.getContextPath()}/TP_L5_GRUPO_7_/validarNumeroDocumento.html',
		        type: 'POST',
		        data: {
		        	dni: dni,
		        },
		        success: function (data) {
		      	  if( data.indexOf("false") > -1  ){
		      		$("#btnSubmit").prop("disabled", true);
		      		document.getElementById("errdni").innerText = "el dni ya se encuentra registrado en el sistema";
		    		document.getElementById("errdni").style.display = "block"; 
		      	  }else{
		      		$("#btnSubmit").prop("disabled", false);
		    		document.getElementById("errdni").innerText = "";
		    		document.getElementById("errdni").style.display = "none"; 
		      	  }
		          return false;
		        }
		      });
    	}
    }
    
    function validaUser(e){
    	console.log(e);
    	if( e.target.value.length < 5 ){
    		$("#btnSubmit").prop("disabled", true);
    		document.getElementById("erruser").innerText = "el nombre de usuario debe tener al menos 5 caracteres";
    		document.getElementById("erruser").style.display = "block"; 
    	}else{
    		$("#btnSubmit").prop("disabled", false);
    		document.getElementById("erruser").innerText = "";
    		document.getElementById("erruser").style.display = "none"; 
    		let nombreUser = document.getElementById("nombreUser").value;
    		$.ajax({
		        url: '${request.getContextPath()}/TP_L5_GRUPO_7_/validarNombreUsuario.html',
		        type: 'POST',
		        data: {
		        	nombre: nombreUser,
		        },
		        success: function (data) {
		      	  if( data.indexOf("false") > -1  ){
		      		$("#btnSubmit").prop("disabled", true);
		      		document.getElementById("erruser").innerText = "el nombre de usuario ya se encuentra registrado en el sistema";
		    		document.getElementById("erruser").style.display = "block"; 
		      	  }else{
		      		$("#btnSubmit").prop("disabled", false);
		    		document.getElementById("erruser").innerText = "";
		    		document.getElementById("erruser").style.display = "none"; 
		      	  }
		          return false;
		        }
		      });
    	}
    }
  </script>
  </body>
</html>