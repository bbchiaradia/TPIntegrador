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
    <div class="row animate__animated animate__fadeIn">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Menu de Préstamos
 			 </div>  
 			 <div class="card-body">
				<div class="row">
					<div class="col-md-12">
					
					<ul class="nav nav-tabs" id="myTab" role="tablist">
					  <li class="nav-item">
					    <a class="nav-link active" id="pendientes-tab" data-toggle="tab" href="#pendientes" role="tab" aria-controls="pendientes" aria-selected="true">Pendientes</a>
					  </li>
					   <li class="nav-item">
					    <a class="nav-link" id="aprobados-tab" data-toggle="tab" href="#aprobados" role="tab" aria-controls="aprobados" aria-selected="true">Aprobados</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" id="rechazados-tab" data-toggle="tab" href="#rechazados" role="tab" aria-controls="rechazados" aria-selected="true">Rechazados</a>
					  </li>
					</ul>
					
					
					
				
					<div class="tab-content py-2 mt-2" id="myTabContent">
					 
					  <div class="tab-pane fade show active" id="pendientes" role="tabpanel" aria-labelledby="pendientes-tab">
											    
					    <!-- detalle de prestamo pendiente-->
					    <container>
					    <div class="row animate__animated animate__fadeIn">
					    	   <div class="col-md-12">
					    	   <div class="card mt-4">
					        	 <div class="card-header">
					   				 Solicitudes pendientes
					 			 </div>  
					 			 <div class="card-body">
									<div class="row">
									
										<div class="col-md-12">
										<div class="row header_detalle">
										<div class="col-md-3">Cliente</div>
										<div class="col-md-3">Monto</div>
										<div class="col-md-3">Plazo</div>
										<div class="col-md-3">Operaciones</div>
										</div>
										<hr>
										</div>
										
										<div class="col-md-12">
										<div class="row">
										<div class="col-md-3">Marcelo Rivero</div>
										<div class="col-md-3">20.000</div>
										<div class="col-md-3">24</div>
										<div class="col-md-3">
											<button class="btn btn-sm btn-success mr-1" data-toggle="tooltip" data-placement="top" title="APROBAR"> 
											<i class="fa fa-check" aria-hidden="true"></i> 
											</button>
											<button class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="RECHAZAR">
											 <i class="fa fa-remove" aria-hidden="true" ></i>
											  </button>
										</div>
										</div>
										<hr>				
										</div>
										
									</div>
									</div>
					 			 </div> 
					    	   </div>
					    </div>
					    </container>
								
					  </div>
					  
					  
					  
					  <div class="tab-pane fade" id="aprobados" role="tabpanel" aria-labelledby="aprobados-tab">
					  
					    <!-- detalle de prestamo aprobados-->
					    <container>
					    <div class="row animate__animated animate__fadeIn">
					    	   <div class="col-md-12">
					    	   <div class="card mt-4">
					        	 <div class="card-header">
					   				 Préstamos aprobados
					 			 </div>  
					 			 <div class="card-body">
									<div class="row">
									
										<div class="col-md-12">
										<div class="row header_detalle">
										<div class="col-md-3">Cliente</div>
										<div class="col-md-3">Monto</div>
										<div class="col-md-3">Plazo</div>
										<div class="col-md-3">Fecha Aprobación</div>
										</div>
										<hr>
										</div>
										
										<div class="col-md-12">
										<div class="row">
										<div class="col-md-3">Marcelo Rivero</div>
										<div class="col-md-3">20.000</div>
										<div class="col-md-3">24</div>
										<div class="col-md-3">12/12/2020</div>
										</div>
										<hr>				
										</div>
										
									</div>
									</div>
					 			 </div> 
					    	   </div>
					    </div>
					    </container>

					  
					</div>
					
			     <div class="tab-pane fade" id="rechazados" role="tabpanel" aria-labelledby="rechazados-tab">
					    
					    <!-- detalle de prestamo rechazados-->
					    <container>
					    <div class="row animate__animated animate__fadeIn">
					    	   <div class="col-md-12">
					    	   <div class="card mt-4">
					        	 <div class="card-header">
					   				 Préstamos rechazados
					 			 </div>  
					 			 <div class="card-body">
									<div class="row">
									
										<div class="col-md-12">
										<div class="row header_detalle">
										<div class="col-md-3">Cliente</div>
										<div class="col-md-3">Monto</div>
										<div class="col-md-3">Plazo</div>
										<div class="col-md-3">Fecha Rechazo</div>
										</div>
										<hr>
										</div>
										
										<div class="col-md-12">
										<div class="row">
										<div class="col-md-3">Marcelo Rivero</div>
										<div class="col-md-3">20.000</div>
										<div class="col-md-3">24</div>
										<div class="col-md-3">12/12/2020</div>
										</div>
										<hr>				
										</div>
										
									</div>
									</div>
					 			 </div> 
					    	   </div>
					    </div>
					    </container>

					  
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
	
<%@ include file="foot.html"%>
  </body>
</html>