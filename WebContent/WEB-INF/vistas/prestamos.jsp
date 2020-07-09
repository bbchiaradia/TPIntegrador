<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <p>${cuentas}</p>
    
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
						   <input hidden name="idCliente" id="idCliente" value="${idlogin}"  >
						  </div>
					 	</div>

					<div class="col-md-4">
					 	<div class="form-group">
						    <label for="cuentaOrigen">Plazo:</label>
						   <select class="form-control" id="plazoPrestamo">
						      <option value="3" selected>3 meses</option>
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
						      <option value='-1'>[ Seleccione una cuenta de destino ]</option>
						     <c:forEach var="cuenta" items="${ cuentas }">
						      <option value="${cuenta.idCuenta}">  ${cuenta.nroCta} - Saldo: $ ${cuenta.saldo} </option>
						    </c:forEach>
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
    <button id="btnSubmit" class="btn btn-sm btn-primary" onclick="pedirPrestamo();" disabled role="button">Solicitar préstamo</button>
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
							     
							    </tr>
							  </thead>
							  
							  
							  
							  <tbody>
							    <c:forEach var="prestamos_cliente" items="${ prestamos_cliente }">
							    <tr>
							      <td>${prestamos_cliente.fecha}</td>
							      <td>$ ${prestamos_cliente.importe}</td>

									 <c:forEach var="movimientos_prestamos_cliente" items="${ movimientos_prestamos_cliente }">
								     <c:if test="${prestamos_cliente.getIdMovimiento().getIdMovimiento() == movimientos_prestamos_cliente.idMovimiento }">
								    		<c:forEach var="cuenta_movimientos_prestamos_cliente" items="${ cuenta_movimientos_prestamos_cliente }">
								            <c:if test="${movimientos_prestamos_cliente.getIdCuenta().getIdCuenta() == cuenta_movimientos_prestamos_cliente.idCuenta }">
								    		   <td>${cuenta_movimientos_prestamos_cliente.nroCta}</td>
										    </c:if>
										    </c:forEach>
								     </c:if>
								     </c:forEach>
		
		
								 <c:forEach var="estado_prestamo" items="${ estado_prestamo }">
							     <c:if test="${prestamos_cliente.getIdEstado().getIdEstado() == estado_prestamo.idEstado }">
							      <td>${estado_prestamo.getDescripcion()}</td>
							     </c:if>
							     </c:forEach>
							     

							      <td>
							     <form method="get" class="frmBoton" action="redireccionar_cuotas_detalle.html">
						 			 <input type="hidden" name="idPrestamo" value="${prestamos_cliente.idPrestamo}">
										<button class="btn btn-sm btn-primary mr-1"  data-toggle="tooltip" data-placement="top" title="Revisar Cuotas">
										<i class="fa fa-eye" aria-hidden="true"> </i> Cuotas
										</button>
								</form>
							      </td>
							    </tr>
							    
							      </c:forEach>
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
	<script>
	$(document).ready(function(){
		$(document).on('change', '#cuentaDestino', function(e){
			console.log(e);
			if(e.target.value < 0 ){
				$("#btnSubmit").prop('disabled', true);
			}else{
				$("#btnSubmit").prop('disabled', false);
			}
			
		});
	});
	
	function pedirPrestamo(){
		let monto = document.getElementById("montoTransfer").value;
		let idCliente = document.getElementById("idCliente").value;
		let plazo = document.getElementById("plazoPrestamo").value;
		let cuentaDestino = document.getElementById("cuentaDestino").value;
		console.log(monto);
		console.log(idCliente);
		if( monto > 0 ){ 
			$.ajax({
		          url: '${request.getContextPath()}/TP_L5_GRUPO_7_/pedirprestamo.html',
		          type: 'POST',
		          data: {
		            id: idCliente,
		            monto: monto,
		            plazo:plazo,
		            cuentadestino :cuentaDestino
		          },
		          success: function (data) {
		        	  console.log(data);
		        	  
		            return false;
		          }
		        });
		}else{
			alert('El préstamo no puede ser de monto negativo')
			return;
		}
	}
	</script>
  </body>
</html>