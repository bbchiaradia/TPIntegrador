<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.html"%>
    <title>TP Banco - Grupo 7</title>
  </head>
  
  
  <body style="width: 100vw; height:100vh;">
  	<%@ page import="app.*" %>
	<%@ page import="tpbanco.*" %>
    <container>
    <%@ include file="nav.html"%>
    <div class="container">
    
    <!-- detalle de cuenta -->
    <container>
    <div class="row animate__animated animate__fadeIn">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Listado de clientes
 			 </div>  
 			 <div class="card-body">
				<div class="row">
				
					<div class="col-md-12">
					<div class="row">
					<div class="col-md-6"><strong>Apellido : </strong>Vaesa</div>
					<div class="col-md-6"><strong>Nombre: </strong>Aquiles</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Dni : </strong>33445566</div>
					<div class="col-md-6"><strong>Cuit: </strong>20334455668</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Sexo : </strong>Masculino</div>
					<div class="col-md-6"><strong>Nacionalidad: </strong>Antiguano</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Fecha de nacimiento: </strong> 29/02/2020</div>
					<div class="col-md-6"><strong>Provincia: </strong>Río Negro</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Localidad: </strong> Caleta Olivia</div>
					<div class="col-md-6"><strong>Dirección: </strong> Calle falsa 123</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Nombre de usuario: </strong> AquilesVaesa</div>
					<div class="col-md-6"><strong>Fecha de alta: </strong> 29/02/2020</div>
					</div>
					<hr>
					</div>					
				</div>
				</div>
 			 </div> 
    	   </div>
    </div>
    </container>
  
    
    </div>
    </container>

<%@ include file="foot.html"%>
  </body>
</html>