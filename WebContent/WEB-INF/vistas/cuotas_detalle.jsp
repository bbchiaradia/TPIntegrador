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
 			 
 			  <form method="POST" action="redireccionar_pagoCuota.html">
					<div class="row">
					<div class="col-md-8 offset-md-2">
					<div class="form-group">
						    <label for="cuentaDestino"></label>
						    <select class="form-control" id="PagarDesde" name="PagarDesde">
						      <option value='-1'>[ Seleccione desde donde pagar:  ]</option>
						     <c:forEach var="cuenta" items="${ cuentas }">
						      <option value="${cuenta.idCuenta}">  ${cuenta.nroCta} - Saldo: $ ${cuenta.saldo} </option>
						    </c:forEach>
						    </select>
						  </div>
					</div>
					</div>
					<hr>


 			<div class="card-body">
			    	<div class="row">
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-4">Estado </div>
					<div class="col-md-4">Monto</div>
					<div class="col-md-4">Accion</div>
					
					 </div>
					 <hr>
				
				   
				  
				    <c:forEach var="cuotas" items="${ cuotas }">
					<div class="row">
				     
				     
				     <c:if test="${cuotas.fecha_pago == null }">
				     <div class="col-md-4 " style="background: rgb(239, 196, 200);">PENDIENTE</div>
                     </c:if>
                      <c:if test="${cuotas.fecha_pago != null}">
				     <div class="col-md-4" style="background: rgba( 24,124,78,0.20);">PAGÓ</div>
                     </c:if>
                     
                     
                      <c:if test="${cuotas.fecha_pago == null }">
				     <div class="col-md-4 " style="background: rgb(239, 196, 200);">$ ${monto_cuota}</div>
                     </c:if>
                      <c:if test="${cuotas.fecha_pago != null}">
				     <div class="col-md-4" style="background: rgba( 24,124,78,0.20);">$ ${monto_cuota}</div>
                     </c:if>
                     
            
                     <c:if test="${cuotas.fecha_pago == null }">				  
				      <input type="hidden" name="idCuota" value="${cuotas.idCuota}">
				       <input type="hidden" name="idPrestamo" value="${idPrestamo}">
				         <input type="hidden" name="montoCuota" value="${monto_cuota}">
					     <button class="btn btn-sm btn-danger mr-1 ml-3"  data-toggle="tooltip" data-placement="top" title="Pagar Cuota">
						 <i class="fa fa-money" aria-hidden="true"> </i> Pagar Cuota
						 </button>
                  
                   
                    
                    </c:if>
				     </div>
				      <hr>
				
				     </c:forEach>
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