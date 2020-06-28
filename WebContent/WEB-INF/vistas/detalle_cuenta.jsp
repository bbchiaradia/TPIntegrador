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
   				 Detalle de la cuenta $123XYZ
 			 </div>  
 			 <div class="card-body">
				<div class="row text-center">
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-3">Número de cuenta</div>
					<div class="col-md-3">Tipo</div>
					<div class="col-md-3">ALIAS</div>
					<div class="col-md-3">Saldo</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-3">$123XYZ</div>
					<div class="col-md-3">Caja de ahorro $</div>
					<div class="col-md-3">CEBADA.MALTA.LUPULO</div>
					<div class="col-md-3">-$35748</div>
					</div>
					</div>
				</div>
				</div>
 			 </div> 
    	   </div>
    </div>
    </container>
    
    
    <div class="row mt-3 px-4 justify-content-end">
    <button class="btn btn-sm btn-primary" role="button" onclick="verMovimientos()">Ver movimientos</button>
    </div>
    
    
     <!-- movimientos de cuenta -->
    <div class="row" id="movimientos">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Movimientos de la cuenta $123XYZ
 			 </div>  
 			 <div class="card-body">
				<div class="row text-center">
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-3">Fecha</div>
					<div class="col-md-3">Descripción</div>
					<div class="col-md-3">Importe</div>
					<div class="col-md-3">Saldo</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-3">27/06/2020</div>
					<div class="col-md-3">Ferretería La Bisabra</div>
					<div class="col-md-3">$-456</div>
					<div class="col-md-3">-$35748</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-3">27/06/2020</div>
					<div class="col-md-3">Ferretería La Bisabra</div>
					<div class="col-md-3">$-456</div>
					<div class="col-md-3">-$35748</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-3">27/06/2020</div>
					<div class="col-md-3">Ferretería La Bisabra</div>
					<div class="col-md-3">$-456</div>
					<div class="col-md-3">-$35748</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-3">27/06/2020</div>
					<div class="col-md-3">Ferretería La Bisabra</div>
					<div class="col-md-3">$-456</div>
					<div class="col-md-3">-$35748</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-3">27/06/2020</div>
					<div class="col-md-3">Ferretería La Bisabra</div>
					<div class="col-md-3">$-456</div>
					<div class="col-md-3">-$35748</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-3">27/06/2020</div>
					<div class="col-md-3">Ferretería La Bisabra</div>
					<div class="col-md-3">$-456</div>
					<div class="col-md-3">-$35748</div>
					</div>
					
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