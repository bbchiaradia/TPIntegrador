<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.jsp"%>
    <title>Hello, world!</title>
  </head>
  <body style="width: 100vw; height:100vh;">
  	<%@ page import="utn.frgp.edu.ar.*" %>
	<%@ page import="utn.frgp.edu.ar.entidad.*" %>
    <container>

    <%@ include file="nav.html"%>
    
    
      <c:if test="${rol == 'CLIENTE' }"> 
   
   <c:if test="${NOCUENTAS == null }"> 
    <div class="container">
    <div class="row">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Cuentas
 			 </div>  
 			 <div class="card-body">
				<div class="row">
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-4">Número de cuenta</div>
					<div class="col-md-4">Tipo</div>
					</div>
					<hr>
					
					 <c:forEach var="cuentas_cliente" items="${ cuentas_cliente }">
					<div class="row">
					<div class="col-md-4">${cuentas_cliente.nroCta}</div>
					
					
					 <c:forEach var="tipocuenta" items="${ tiposcuenta }">
				     <c:if test="${cuentas_cliente.getTipocuenta().getId_TipoCuenta() == tipocuenta.id_TipoCuenta }">
				     <div class="col-md-4">${tipocuenta.descripcion}</div>
				     </c:if>
				     </c:forEach>
					
				
				
					
					<form method="get" class="frmBoton" action="redireccionar_detalle_cuenta.html">
						  <input type="hidden" name="id" value="${cuentas_cliente.idCuenta}">
						<button class="btn btn-sm btn-primary" role="button">Detalles</button>
					</form>
					
					
					
					
					
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
  </c:if>  
   <c:if test="${NOCUENTAS != null }"> 
      <div class="col-md-4">${NOCUENTAS}</div>
  </c:if> 
   </c:if>  
     </container>
     
     
    <c:if test="${rol == 'ADMIN' }"> 
   <div class="container">
       <div class="row">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Bienvenido <b> ${nombreLogin} </b>
 			 </div>  

 			 </div> 
    	   </div>
    </div>
    </div>
      
      
      
       </container>
   </c:if>  

<%@ include file="foot.html"%>
  </body>
</html>