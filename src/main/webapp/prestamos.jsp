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
   				 Solicitudes de préstamos
 			 </div>  
 			 <div class="card-body">
				<div class="row">
					<div class="col-md-12">
					<div class="row">

						<div class="col-md-4 offset-md-2">
					 	<div class="form-group">
						    <label for="montoPrestamo">Monto:</label>
						   <input type="number" min="5000" max="1000000" class="form-control" id="montoTransfer" placeholder="Monto a solicitar">
						  </div>
					 	</div>

					<div class="col-md-4">
					 	<div class="form-group">
						    <label for="cuentaOrigen">Plazo:</label>
						   <input type="number" min="1" max="60" class="form-control" id="montoTransfer" placeholder="En meses...">
						  </div>
					 	</div>

					</div>
					
					<div class="row">
					<div class="col-md-8 offset-md-2">
					<div class="form-group">
						    <label for="cuentaDestino">Cuenta de destino:</label>
						    <select class="form-control" id="cuentaDestino">
						      <option>1</option>
						      <option>2</option>
						    </select>
						  </div>
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
    <button class="btn btn-sm btn-primary" role="button" onclick="alert('mensaje de alerta')">Ver movimientos</button>
    </div>
    
    </div>
    </container>

<%@ include file="foot.html"%>
  </body>
</html>