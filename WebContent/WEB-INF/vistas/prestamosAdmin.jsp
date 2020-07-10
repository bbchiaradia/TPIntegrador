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
   
    <c:if test="${ msj  } ">
    <p> ${msj} </p> 
    </c:if>
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
							    <th scope="col">Cliente</th>
							      <th scope="col">Solicitado</th>
							      <th scope="col">Monto</th>
							      <th scope="col">Cuotas</th>
							     <th scope="col">Cuenta destino</th>
							      <th scope="col">Estado</th>
							       <th scope="col" class="text-center">Accion</th>
							     
							    </tr>
							  </thead>
							  
							  
							  
							  <tbody>
							  
							    <c:forEach var="prestamos_cliente" items="${ prestamos_cliente }">
							    <form method="post" class="frmBoton" action="aprobarPrestamo.html">
							    <tr>
							      
							       <c:forEach var="cliente" items="${ cliente }">
								     <c:if test="${prestamos_cliente.getIdCliente().getIdCliente() == cliente.idCliente }">
								     <td>${cliente.nombre}  ${cliente.apellido}</td>
								     </c:if>
								     </c:forEach>

							      <td>${prestamos_cliente.fecha}</td>
							      <td>$ ${prestamos_cliente.importe}</td>
 								  <td> ${prestamos_cliente.cuotas}</td>
 									
 									
 									
 									 <c:forEach var="cliente" items="${ cliente }">
								     <c:if test="${prestamos_cliente.getIdCliente().getIdCliente() == cliente.idCliente }">
								     <td>
								     <select class="form-control" id="cuentaDestino" required name="cuentaDestino">
								     <c:forEach var="cuentas" items="${ cuentas }">
								     
								       <c:if test="${cuentas.getIdCliente().getIdCliente() == cliente.idCliente }">
				  					 <option value="${cuentas.idCuenta}">  ${cuentas.nroCta} - Saldo: $ ${cuentas.saldo} </option> 
				  					 </c:if>
				  					 
		
									 </c:forEach> 
								    </select>
								    </td>
								     </c:if>
								     </c:forEach>
 									
 									
 							
						    
						    
		
								 <c:forEach var="estado_prestamo" items="${ estado_prestamo }">
							     <c:if test="${prestamos_cliente.getIdEstado().getIdEstado() == estado_prestamo.idEstado }">
							      <td>${estado_prestamo.getDescripcion()}</td>
							     </c:if>
							     </c:forEach>
							     

							      <td>
							     
						 			 <input type="hidden" name="idPrestamo" value="${prestamos_cliente.idPrestamo}">
										<button class="btn btn-sm btn-success"  data-toggle="tooltip" data-placement="top" title="Aprobar">
										<i class="fas fa-thumbs-up" aria-hidden="true"> </i> Aprobar
										</button>
								</form>
							      </td>
							      
							        <td>
							     <form method="post" class="frmBoton" action="rechazarPrestamo.html">
						 			 <input type="hidden" name="idPrestamo" value="${prestamos_cliente.idPrestamo}">
										<button class="btn btn-sm btn-danger mr-1"  data-toggle="tooltip" data-placement="top" title="Rechazar">
										<i class="fas fa-thumbs-down" aria-hidden="true"> </i> Rechazar
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