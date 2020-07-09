<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
    <!-- listado de cuentas -->
    <div class="row animate__animated animate__fadeIn">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	
        	        	 <div class="card-header">
   				 Detalle de Cuotas <b>  </b>
 			 </div>  
 			 

 			<div class="card-body">
			    	<div class="row">
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-4">Estado </div>
					<div class="col-md-4">Monto</div>
					<div class="col-md-4">Accion</div>
					
					 </div>
					 <hr>
				
					<div class="row">
				
				     <div class="col-md-4">PAGADO</div>
                     <div class="col-md-4">1000</div>
                    <button class="btn btn-sm btn-danger mr-1"  data-toggle="tooltip" data-placement="top" title="Pagar Cuota">
					<i class="fa fa-money" aria-hidden="true"> </i> Pagar Cuota
					</button>
     
				     </div>
				      <hr>
				     <div class="row">
				     <div class="col-md-4">DEBE</div>
                     <div class="col-md-4">1000</div>
                     <button class="btn btn-sm btn-danger mr-1"  data-toggle="tooltip" data-placement="top" title="Pagar Cuota">
					<i class="fa fa-money" aria-hidden="true"> </i> Pagar Cuota
					</button>
					</div>
					<hr>
				
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