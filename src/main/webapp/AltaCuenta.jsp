<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.html"%>
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
   				 ABM Cuentas
 			 </div>  
 			 <div class="card-body">
				<div class="row">
					<div class="col-md-12">
					
					<ul class="nav nav-tabs" id="myTab" role="tablist">
					  <li class="nav-item">
					    <a class="nav-link active" id="propias-tab" data-toggle="tab" href="#propias" role="tab" aria-controls="propias" aria-selected="true">Alta</a>
					  </li>
					   <li class="nav-item">
					    <a class="nav-link" id="otras-tab" data-toggle="tab" href="#otras"            role="tab" aria-controls="otras" aria-selected="false">Baja</a>
					  </li>
					  	 <li class="nav-item">
					    <a class="nav-link" id="modificacion-tab" data-toggle="tab" href="#modificacion" role="tab"             aria-controls="modificacion" aria-selected="false">Modificacion</a>
					  </li>
					</ul>
					
					<div class="tab-content py-2 mt-2" id="myTabContent">
					  <div class="tab-pane fade show active" id="propias" role="tabpanel" aria-labelledby="propias-tab">
					 	
					 	<div class="row">
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="numeroCuenta">Numero de cuenta:</label>
						      <input type="number" class="form-control" min="1" max="60" id="numeroCuenta" placeholder="se auto-genera">

						    </select>
						  </div>
					 	</div>
	
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="tipoCuenta">Tipo de cuenta:</label>
						    <select class="form-control" id="tipoCuenta">
						      <option>Caja de ahorro</option>
						      <option>Cuenta corriente</option>
						    </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-4">
					 	<div class="form-group">
						    <label for="clienteCuenta">Cliente:</label>
						   <select class="form-control" id="tipoCuenta">
						   	  <option>Nicolas Flores</option>
						      <option>Belen Chiaradia</option>
						       </select>
						  </div>
					 	</div>
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="confirm( 'Desea crear la cuenta?' );">Crear Cuenta</button>
					 	</div>
					  </div>
					  
					  <div class="tab-pane fade" id="otras" role="tabpanel" aria-labelledby="otras-tab">
					  	<div class="row">
					 	<div class="col-md-9">
					 	<div class="form-group">
						    <label for=""cuentaBaja"">Cuenta a dar de baja:</label>
						    <select class="form-control" id="cuentaBaja">
						      <option>386-254454-9</option>
						    </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-8">
					 	<div class="form-group">
						    <label for="titular">Titular:</label>
						    <input type="number" class="form-control" id="titular" placeholder="">
						  </div>
					 	</div>
					 	
					 	<div class="col-md-7">
					 	<div class="form-group">
						    <label for="saldo">Saldo:</label>
						   <input type="number" class="form-control" id="saldo" placeholder="">
						  </div>
					 	</div>
					 	
					 	 	<div class="col-md-6">
					 	<div class="form-group">
						    <label for="tipoCuenta">Tipo Cuenta:</label>
						   <input type="number" class="form-control" id="tipoCuenta" placeholder="">
						  </div>
					 	</div>
					 	
					 	
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="confirm( 'Desea realizar la transferencia por $129?' );">Dar de Baja</button>
					 	</div>
					  </div>
					  
					   <div class="tab-pane fade" id="modificacion" role="tabpanel" aria-labelledby="otras-tab">
					  	<div class="row">
					 	<div class="col-md-9">
					 	<div class="form-group">
						    <label for=""cuentaBaja"">Cuenta a modificar:</label>
						    <select class="form-control" id="cuentaBaja">
						      <option>386-254454-9</option>
						    </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-8">
					 	<div class="form-group">
						    <label for="titular">Titular:</label>
						    <input type="number" class="form-control" id="titular" placeholder="">
						  </div>
					 	</div>
					 	
					 	<div class="col-md-7">
					 	<div class="form-group">
						    <label for="saldo">Saldo:</label>
						   <input type="number" class="form-control" id="saldo" placeholder="">
						  </div>
					 	</div>
					 	
					 	 	<div class="col-md-6">
					 	<div class="form-group">
						    <label for="tipoCuenta">Tipo Cuenta:</label>
						   <input type="number" class="form-control" id="tipoCuenta" placeholder="">
						  </div>
					 	</div>
					 	
					 	
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="confirm( 'Desea realizar la transferencia por $129?' );">Modificar</button>
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