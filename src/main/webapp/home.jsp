
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.html"%>
    <title>Hello, world!</title>
  </head>
  <body style="width: 100vw; height:100vh;">
  	<%@ page import="app.*" %>
	<%@ page import="tpbanco.*" %>
    <container>
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
					<button class="btn btn-sm btn-primary" role="button">Detalles</button>
					</div>
					</div>
					<hr>
					<div class="row">
					<div class="col-md-4">Número de cuenta</div>
					<div class="col-md-4">Tipo</div>
					<div class="col-md-4">  
					<button class="btn btn-sm btn-primary" role="button">Detalles</button>
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