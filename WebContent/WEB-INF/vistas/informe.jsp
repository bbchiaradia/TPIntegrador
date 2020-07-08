
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
					 <c:forEach var="conceptos" items="${ listaconcepto }">
					<div class="row">
					<div class="col-md-4">${conceptos.descripcion}</div>					
					
				
					<div class="col-md-4">  
					<a href="redireccionar_detalle_cuenta.html">
					<button class="btn btn-sm btn-primary" role="button">Detalles</button>
					</a>
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