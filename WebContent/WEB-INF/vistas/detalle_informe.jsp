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
  
  <script>
  	function verMovimientos(){
  		if ($('#movimientos').css('opacity') == 0) $('#movimientos').css('opacity', 1);
  	    else $('#movimientos').css('opacity', 0);
  		
  	}
  </script>
  
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
   				 Detalle concepto de movimiento <b> ${ detalleConcepto.descripcion } </b>
 			 </div>  
 			 

 			   
 			 <div class="card-body">
				<div class="row text-center">
				
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-3">Concepto de movimiento</div>
					<div class="col-md-3">Fecha desde</div>
					<div class="col-md-3">Fecha hasta</div>
					<div class="col-md-3">Total</div>
					
					</div>
					
					<div class="row">
					<div class="col-md-3">${ detalleConcepto.descripcion }</div>
					
					
				
				    <div class="col-md-3">${fechaDesde}</div>				
					<div class="col-md-3">${ fechaHasta }</div>
					<div class="col-md-3">${ saldo }</div>
					</div>
					</div>
				</div>
				</div>
					
				
 			 </div> 
 			 
 			 
 			 
    	   </div>
    </div>
    </container>
    
    
    <div class="row mt-3 px-4 justify-content-end">
    <button class="btn btn-sm btn-primary" role="button" onclick="verMovimientos()">Ver movimientos</button>
    </div>
    
    
     <!-- movimientos de cuenta -->
    <div class="row" id="movimientos">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Movimientos de la cuenta
 			 </div>  
 			 
 			
 			
 			 
 			 <div class="card-body">
				<div class="row text-center">
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-3">Fecha</div>
					<div class="col-md-3">Nro Cuenta</div>
					<div class="col-md-3">Importe</div>
					</div>
					<hr>
					
					 <c:forEach var="movimientos" items="${ movimientos }"> 
					<div class="row">
					<div class="col-md-3">${ movimientos.fecha }</div>
					
					
					

				     <div class="col-md-4">${movimientos.idCuenta.nroCta}</div>

					
					
					
					
					<div class="col-md-3">${ movimientos.importe }</div>
					</div>
					<hr>
					</c:forEach>
					
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