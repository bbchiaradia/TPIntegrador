  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<%@ page import="utn.frgp.edu.ar.*" %>
	<%@ page import="utn.frgp.edu.ar.entidad.*" %>


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.jsp"%>
    <title>TP Banco - Grupo 7</title>
  </head>
  <body style="width: 100vw; height:100vh;" class="flex d-flex justify-content-center align-items-center">
  	<%@ page import="utn.frgp.edu.ar.*" %>
	<%@ page import="utn.frgp.edu.ar.entidad.*" %>
    <container style="width: 100%; height: 70%;">
    <div class="container">
    <div class="row">
    	<div class="col-md-8 offset-md-2">
    	<div class="card mt-4 animate__animated animate__fadeIn">
        	 <div class="card-header">
   				 Login
 			 </div>  
 			 
 			 <div class="card-body">
			 <!-- <form action="redireccionar_Index.html" method="get"> -->  
				
				<div class="row">					
					
	 		
	    				<div class="col-md-12">
	    				<div class="input-group mb-3">
	     			 	<input type="text" onkeyup="validaUser(event);"  class="form-control"  minlength="5" maxlength="20" name="nombreUser" required id="nombreUser" maxlength="70"
	     			 	placeholder=" Ingrese el nombre usuario">
	    				<span id="erruser" style="display: none; color:red;font-size:1rem"></span>
	    				</div>
	    				</div>
                    				
				</div>
				
				
				<div class="row">
				<div class="col-md-12">
				
				

				
				<div class="input-group mb-3">
				    <input type="password" class="form-control"  minlength="5" maxlength="20" name="contrasenia" required id="contrasenia" maxlength="70"
	     			 	placeholder=" Ingrese el nombre usuario">
	    				<span id="errpass" style="display: none; color:red;font-size:1rem"></span>
					</div>
					</div>
				</div>
				 
				 	   <div class="row mt-3 px-4 justify-content-end">	                   
	                   <button class="btn btn-sm btn-primary" onclick="validaPass(event);" >INGRESAR</button> 	                
	                   </div> 
				
					<!--  </form> -->	 
				</div>
 			 </div>    
 			 
 			 
 		        	    <br>
 		        	    
 	  	    
   	 
    
 		 
        </div>
        
        

        
        
    	</div>
    	
    	

    	
    	
    </div>
    </div>
    </container>

<%@ include file="foot.html"%>
<script>

function validaUser(e){
	console.log(e);

		$("#btnSubmit").prop("disabled", false);
		document.getElementById("erruser").innerText = "";
		document.getElementById("erruser").style.display = "none"; 
		let nombreUser = document.getElementById("nombreUser").value;
		$.ajax({
	        url: '${request.getContextPath()}/TP_L5_GRUPO_7_/validarNombreUsuarioAcceso.html',
	        type: 'POST',
	        data: {
	        	nombre: nombreUser,
	        },
	        success: function (data) {
	      	  if( data.indexOf("false") > -1  ){
	      		//$("#btnSubmit").prop("disabled", true);
	      		document.getElementById("erruser").innerText = "el usuario no existe en el sistema";
	    		document.getElementById("erruser").style.display = "block"; 
	      	  }else{
	      		//$("#btnSubmit").prop("disabled", false);
	    		document.getElementById("erruser").innerText = "";
	    		document.getElementById("erruser").style.display = "none"; 
	      	  }
	          return false;
	        }
	      });
	
}

function validaPass(e){
	console.log(e);

		$("#btnSubmit").prop("disabled", false);
		document.getElementById("errpass").innerText = "";
		document.getElementById("errpass").style.display = "none"; 
		let nombreUser = document.getElementById("nombreUser").value;
		let contrasenia = document.getElementById("contrasenia").value;
		$.ajax({
	        url: '${request.getContextPath()}/TP_L5_GRUPO_7_/validarContraseniaAcceso.html',
	        type: 'POST',
	        data: {
	        	nombre: nombreUser,
	        	contrasenia: contrasenia,
	        },
	        success: function (data) {
	      	  if( data.indexOf("false") > -1  ){
	      		//$("#btnSubmit").prop("disabled", true);
	      		document.getElementById("errpass").innerText = "La contraseña no es valida";
	    		document.getElementById("errpass").style.display = "block"; 
	      	  }else{
	      		//$("#btnSubmit").prop("disabled", false);
	    		document.getElementById("errpass").innerText = "";
	    		document.getElementById("errpass").style.display = "none"; 
	      	  }
	          return false;
	        }
	      });
	
}

</script>

  </body>
</html>
