
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.html"%>
    <title>Hello, world!</title>
  </head>
  <body style="width: 100vw; height:100vh;">
  <%@ page import="utn.frgp.edu.ar.*" %>
<%@ page import="utn.frgp.edu.ar.entidad.*" %>
    <container>
    <%@ include file="nav.html"%>
    <div class="container">
    <div class="row">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Informes : Movimientos
 			 </div>  
 			 <!-- Si quiere ver el cliente, se  pondrían los campos como solo lectura -->
 			 <div class="card-body">
				<div class="row">
				<div class="col-md-12">
				<form method="POST" action="formclientes.jsp" >
				<div class="row">
					<div class="col-md-12">
					<div class="row" >
						<div class="col-md-6">
							<div class="form-group row  w-85">
    				<label for="concepto" class="pr-2">Concepto: </label>

     			 	<select class="form-control" id="concepto" required style="width:90%;" name="concepto">
  					<option value="1" default>Alta cuentas</option>
  					<option value="2">Préstamos</option>
  					<option value="3">Transferencias</option>
					</select>

 				 </div>
						</div>
						
						<div class="col-md-6">
							 <div class="form-group row  w-85" >
		    				<label for="txtbusqueda" class="pr-2">Búsqueda: </label>

		     			 	<input type="text" class="form-control" id="txtbusqueda" required name="txtbusqueda" maxlength="50"
		     			 	style="width:90%;"
		     			 	placeholder="Nombre - dni del cliente">

		 				 </div>
						</div>
					</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12">
					<div class="row" >
						<div class="col-md-6">
							<div class="form-group row  w-85">
    				<label for="concepto" class="pr-2">Tipo cuenta: </label>

     			 	<select class="form-control" id="tcuenta" required style="width:90%;" name="tcuenta">
  					<option value="1" default>Tipo 1</option>
  					<option value="2">Tipo 2</option>
  					<option value="3">Tipo 3</option>
					</select>

 				 </div>
						</div>
						
						<div class="col-md-6">
							 <div class="form-group row  w-85" >
		    				<label for="fdesde" class="pr-2">Fecha inicio: </label>

		     			 	<input class="form-control" type="date" value="" style="width:90%;" id="fdesde">

		 				 </div>
						</div>
					</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12">
					<div class="row" >
						<div class="col-md-6">
							<div class="form-group row  w-85">
    				<label for="fhasta" class="pr-2">Fecha fin: </label>

     			 	<input class="form-control" type="date" value="" style="width:90%;" id="fhasta">

 				 </div>
						</div>
						
						<div class="col-md-6 align-items-center flex d-flex" style="display:flex !important;	">
						<button class="btn btn-sm btn-primary">Buscar</button>
						</div>
						
					</div>
					</div>
				</div>
				 
 				 
				</form>						
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