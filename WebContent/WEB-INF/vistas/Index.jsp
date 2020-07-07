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
    
      <script>
   sessionStorage.setItem('rol', '${rol}');
  
   </script>
    <p>
   ${rol}
   </p>
   
   
    <%@ include file="nav.html"%>
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
					<div class="row">
					<div class="col-md-4">Número de cuenta</div>
					<div class="col-md-4">Tipo</div>
					<div class="col-md-4">  
					<a href="redireccionar_detalle_cuenta.html">
					<button class="btn btn-sm btn-primary" role="button">Detalles</button>
					</a>
					</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-4">Número de cuenta</div>
					<div class="col-md-4">Tipo</div>
					<div class="col-md-4">  
					<a href="redireccionar_detalle_cuenta.html">
					<button class="btn btn-sm btn-primary" role="button">Detalles</button>
					</a>
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