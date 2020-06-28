<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.jsp"%>
    <title>TP Banco - Grupo 7</title>
  </head>
  
  
  <body style="width: 100vw; height:100vh;">
  	<%@ page import="utn.frgp.edu.ar.*" %>
		<%@ page import="utn.frgp.edu.ar.entidad.*" %>
		<%@ page import="utn.frgp.edu.ar.dao.*" %>
		<%@ page import="utn.frgp.edu.ar.controller.*" %>
    <container>
    <%@ include file="nav.html"%>
    <div class="container">
    
    <br>
   <div class="row mt-3 px-4 justify-content-end">
   <a href="redireccionar_formclientes.html">
    <button class="btn btn-sm btn-secondary" role="button">Alta clientes</button>
     </a>
    </div>
    
    
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
					
					<div class="col-md-12 tarjeta">
					 <c:forEach var="cliente" items="${ clientes }">
		           <!--   <td> ${ cliente.toString() }</td> -->
					<div class="row">
					<div class="col-md-3">${ cliente.getApellido() }</div>
					<div class="col-md-3">${ cliente.getNombre() }</div>
					<div class="col-md-3">${ cliente.getDni() }</div>
					<div class="col-md-3">
					<!--   <a href="clientes/" name="id" value=${cliente.getIdCliente() }">-->
					  
					  <form method="get" action="redireccionar_detalleCliente.html">
					  <input type="hidden" name="id" value="${cliente.getIdCliente() }">
						<button class="btn btn-sm btn-primary mr-1"  data-toggle="tooltip" data-placement="top" title="Ver cliente"> 
						<i class="fa fa-eye" aria-hidden="true"></i> 
						</button>	
						</form>
						
						
						 <form method="get"  action="formclientes.html">
						  <input type="hidden" name="id" value="${cliente.getIdCliente() }">
						<button class="btn btn-sm btn-warning" data-toggle="tooltip" data-placement="top" title="Editar cliente">
						 <i class="fa fa-pencil" aria-hidden="true"></i>
						  </button>
						  </form>
						  
						  <button  class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="Eliminar" 
						  onclick="confirm( 'Desea eliminar el cliente ${ cliente.getNombre() }  ${ cliente.getApellido() }?' )">
						   <i class="fa fa-trash-o" aria-hidden="true" ></i>
						 </button>
					</div>
					</div>
					<hr>	
					</c:forEach>			
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