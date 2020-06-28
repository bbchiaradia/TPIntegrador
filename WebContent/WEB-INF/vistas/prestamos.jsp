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
    
    <!-- solicitud de prestamos -->
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
						   <select class="form-control" id="plazoPrestamo">
						      <option value="3">3 meses</option>
						      <option value="6">6 meses</option>
						      <option value="9">9 meses</option>
						      <option value="12">12 meses</option>
						      <option value="18">18 meses</option>
						      <option value="24">24 meses</option>
						    </select>
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
    <div class="row mt-3 px-4 justify-content-end">
    <button class="btn btn-sm btn-primary" role="button" onclick="alert('mensaje de alerta')">Solicitar préstamo</button>
    </div>
    </container>
    
	    <!-- historial de prestamos -->
	    <container>
	    <div class="row animate__animated animate__fadeIn">
	    	   <div class="col-md-12">
	    	   <div class="card mt-4">
	        	 <div class="card-header">
	   				 Estado de préstamos
	 			 </div>  
	 			 <div class="card-body">
					<div class="row">
						<div class="col-md-12">
						<div class="row">
	
							<table class="table">
							  <thead>
							    <tr>
							      <th scope="col">Solicitado</th>
							      <th scope="col">Monto</th>
							      <th scope="col">Cuenta destino</th>
							      <th scope="col">Estado</th>
							      <th scope="col">Detalle</th>
							    </tr>
							  </thead>
							  <tbody>
							    <tr>
							      <td>27/06/2020</td>
							      <td>$15</td>
							      <td>$CA-123456789</td>
							      <td>Aprobado</td>
							      <td>
							      <button class="btn btn-sm btn-primary mr-1"  data-toggle="tooltip" data-placement="top" title="Ver préstamo"> 
									<i class="fa fa-eye" aria-hidden="true"></i> 
									</button>	
							      </td>
							    </tr>
							  </tbody>
							</table>
	
						</div>			
						
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