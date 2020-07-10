
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
    <div class="container">
    <div class="row">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Informes : Movimientos
 			 </div>  
 			 <!-- Si quiere ver el cliente, se  pondrían los campos como solo lectura -->
 			 <div class="card-body">
	           <div class="card-body">
				<div class="row">
					<div class="col-md-12">	
				
				
				<div  class="row">
				<div class="col-md-12">	
				<form method="get" class="frmBoton" action="redireccionar_detalle_informe.html">
				  
				  <div class="col-md-6">				
				      <div class="form-group row">
	    				<label for="datepicker" class="col-md-4 col-form-label">Fecha desde:</label>
	    				<div class="col-md-8">
	     			 	<input type="text" required  id="datepicker" required name="fdesde">
	    				</div> 				 
	 				 </div>
				</div>
				 <hr>
				 <div class="col-md-6">
				      <div class="form-group row">
	    				<label for="datepicker2" class="col-md-4 col-form-label">Fecha hasta:</label>
	    				<div class="col-md-8">
	     			 	<input type="text" required  id="datepicker2" required name="fhasta"  >
	    				</div>
	 				  </div>	
	 				</div>				
						 
	 				 
	 			 <hr>		

	                        
	                 <div class="form-group row">
	    				<label for="sexo" class="col-sm-2 col-form-label">Conceptos:</label>
	    				<div class="col-sm-10">
	     			 	<select required class="form-control"  id="id" required name="id">
	
	  					 <c:forEach  var="conceptos" items="${ listaconcepto }">
	  					<option value= "${ conceptos.idConcepto }">${ conceptos.descripcion }</option>
						 </c:forEach>	
						</select>
	    				</div>
	 				 </div> 
	                         <hr>
	                         
	                         <button class="btn btn-sm btn-primary" role="button">Detalles</button>
	
						</form>
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
<script>
    $(document).ready(function() {

        $('#datepicker').datepicker({
            dateFormat: 'dd/mm/yy'
        });
        
        $('#datepicker2').datepicker({
            dateFormat: 'dd/mm/yy'
        });
        
        
    });

    
    </script>
  </body>
</html>