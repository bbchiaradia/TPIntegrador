<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   				 Menú de transferencias
 			 </div>  
 			 <div class="card-body">
				<div class="row">
					<div class="col-md-12">
					
					<ul class="nav nav-tabs" id="myTab" role="tablist">
					  <li class="nav-item">
					    <a class="nav-link active" id="propias-tab" data-toggle="tab" href="#propias" role="tab" aria-controls="propias" aria-selected="true">Cuentas propias</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" id="otras-tab" data-toggle="tab" href="#otras" role="tab" aria-controls="otras" aria-selected="false">Otras cuentas</a>
					  </li>
					</ul>
					
					<div class="tab-content py-2 mt-2" id="myTabContent">
					  <div class="tab-pane fade show active" id="propias" role="tabpanel" aria-labelledby="propias-tab">
					 	<div class="row">
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="cuentaOrigen">Cuenta de origen:</label>
						    <select class="form-control" id="cuentaOrigen">
						      <option>1</option>
						      <option>2</option>
						    </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="cuentaDestino">Cuenta de destino:</label>
						    <select class="form-control" id="cuentaDestino">
						      <option>1</option>
						      <option>2</option>
						    </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="montoTransfer">Monto:</label>
						   <input type="number" class="form-control" id="montoTransfer" placeholder="Monto a transferir">
						  </div>
					 	</div>
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="confirm( 'Desea realizar la transferencia por $129?' );">Transferir</button>
					 	</div>
					  </div>
					  
					  <div class="tab-pane fade" id="otras" role="tabpanel" aria-labelledby="otras-tab">
					  	<div class="row">
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="cuentaOrigen">Cuenta de origen:</label>
						    <select class="form-control" id="cuentaOrigen">
						      <option>1</option>
						      <option>2</option>
						    </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="cuentaDestino">Cuenta de destino:</label>
						    <input type="text" class="form-control" id="montoTransfer" placeholder="Ingrese el CBU o Alias">
						  </div>
						  <div id="detCtaDestino" style="">
						  <p>Titular: Bojack Horseman</p>
						  <p>CUIT: 20223344558</p>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="montoTransfer">Monto:</label>
						   <input type="number" class="form-control" id="montoTransfer" placeholder="Monto a transferir">
						  </div>
					 	</div>
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="confirm( 'Desea realizar la transferencia por $129?' );">Transferir</button>
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
    
    </div>
    </container>

<%@ include file="foot.html"%>
  </body>
</html>