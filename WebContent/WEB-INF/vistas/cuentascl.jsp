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
   				 Detalle de la cuenta <b> ${ detalleCuenta2.nroCta } </b>
 			 </div>  
 			 

 			<div class="card-body">
			    	<div class="row">
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-5">Número de cuenta</div>
					<div class="col-md-5">Tipo</div>
					<div class="col-md-5">CBU</div>
					<div class="col-md-5">Saldo</div>
					<div class="col-md-5"></div>
					</div>
					<hr>
					
					 <c:forEach var="cuentas_cliente" items="${ cuentas_clientecl }">
					<div class="row">
					<div class="col-md-5">${cuentas_cliente.nroCta}</div>
					
					
					 <c:forEach var="tipocuenta" items="${ tiposcuentacl }">
				     <c:if test="${cuentas_cliente.getTipocuenta().getId_TipoCuenta() == tipocuenta.id_TipoCuenta }">
				     <div class="col-md-5">${tipocuenta.descripcion}</div>
				     </c:if>
				     </c:forEach>
					
				     <div class="col-md-5">${cuentas_cliente.cbu}</div>
					 <div class="col-md-5">${cuentas_cliente.saldo}</div>
					
					<div class="col-md-5">
					<form method="get" class="frmBoton" action="redireccionar_detalle_cuenta.html">
						  <input type="hidden" name="id" value="${cuentas_cliente.idCuenta}">
						<button class="btn btn-sm btn-primary" role="button">Detalles</button>
					</form>
					</div>
					
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