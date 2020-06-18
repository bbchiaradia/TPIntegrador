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
  	<%@ page import="utn.frgp.edu.ar.*" %>
	<%@ page import="utn.frgp.edu.ar.entidad.*" %>
    <container>
    <%@ include file="nav.html"%>
    <div class="container">
    
    <!-- listado de cuentas -->
    <div class="row animate__animated animate__fadeIn">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Cuentas
 			 </div>  
 			 <div class="card-body">
				<div class="row">
					<div class="col-md-12">
					<div class="row">
					<div class="col-md-4">Número de cuenta</div>
					<div class="col-md-4">Tipo</div>
					<div class="col-md-4">  
					<a href="detalle_cuenta.jsp">
					<button class="btn btn-sm btn-primary" role="button">Detalles</button>
					</a>
					</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-4">Número de cuenta</div>
					<div class="col-md-4">Tipo</div>
					<div class="col-md-4">  
					<a href="detalle_cuenta.jsp">
					<button  class="btn btn-sm btn-primary" role="button">Detalles</button>
					</a>
					</div>
					</div>
					</div>
				</div>
				</div>
 			 </div> 
    	   </div>
    </div>
    </div>
    </container>

<%@ include file="foot.html"%>
  </body>
</html>