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
 			 
 			  <c:forEach var="detalleCliente" items="${ detalleCliente }">

 			 <div class="card-body">
				<div class="row">
				
					<div class="col-md-12">
					<div class="row">
					<div class="col-md-6"><strong>Apellido : </strong>${ detalleCliente.getApellido() }</div>
					<div class="col-md-6"><strong>Nombre: </strong>${ detalleCliente.getNombre() }</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Dni : </strong>${ detalleCliente.getDni() }</div>
					<div class="col-md-6"><strong>Cuit: </strong>20334455668</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Sexo : </strong>${ detalleCliente.getIdSexo().getDescripcion() }</div>
					<div class="col-md-6"><strong>Nacionalidad: </strong>${ detalleCliente.getIdNacionalidad().getDescripcion() }</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Fecha de nacimiento: </strong> ${ detalleCliente.getFecha_nacimiento() }</div>
					<div class="col-md-6"><strong>Provincia: </strong>${ detalleCliente.getIdProvincia().getDescripcion() }</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Localidad: </strong>${ detalleCliente.getIdLocalidad().getDescripcion() }</div>
					</div>
					
					<div class="row">
					<div class="col-md-6"><strong>Nombre de usuario: </strong> AquilesVaesa</div>
					<div class="col-md-6"><strong>Fecha de alta: </strong> ${ detalleCliente.getFecha_alta() }</div>
					</div>
					<hr>
					</div>					
				</div>
				</div>
				 </c:forEach>	
				
 			 </div> 
    	   </div>
    </div>
    </container>
  
    
    </div>
    </container>

<%@ include file="foot.html"%>
  </body>
</html>