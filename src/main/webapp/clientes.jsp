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
					<div class="row header_detalle">
					<div class="col-md-3">Apellido</div>
					<div class="col-md-3">Nombre</div>
					<div class="col-md-3">DNI</div>
					<div class="col-md-3">Operaciones</div>
					</div>
					<hr>
					</div>
					
					<div class="col-md-12">
					<div class="row">
					<div class="col-md-3">Wolfcastle</div>
					<div class="col-md-3">Rainier</div>
					<div class="col-md-3">66666666</div>
					<div class="col-md-3">
						<button class="btn btn-sm btn-primary mr-1" data-toggle="tooltip" data-placement="top" title="Ver cliente"> 
						<i class="fa fa-eye" aria-hidden="true"></i> 
						</button>
						<button class="btn btn-sm btn-warning" data-toggle="tooltip" data-placement="top" title="Editar cliente">
						 <i class="fa fa-pencil" aria-hidden="true"></i>
						  </button>
						  <button class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="Eliminar">
						   <i class="fa fa-trash-o" aria-hidden="true" ></i>
						 </button>
					</div>
					</div>
					<hr>				
					</div>
					
				</div>
				</div>
 			 </div> 
    	   </div>
    </div>
    </container>
    
    
    <div class="row mt-3 px-4 justify-content-end">
    <button class="btn btn-sm btn-primary" role="button" onclick="alert('mensaje de alerta')">Alta clientes</button>
    </div>
    
    </div>
    </container>

<%@ include file="foot.html"%>
  </body>
</html>