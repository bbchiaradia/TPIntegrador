<<<<<<< HEAD
=======
<html>
<body>
<%@ page import="utn.frgp.edu.ar.*" %>
<%@ page import="utn.frgp.edu.ar.entidad.*" %>
>>>>>>> adefe0792e37d5188b1db2762e8d19099159bff8

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.html"%>
    <title>TP Banco - Grupo 7</title>
  </head>
  <body style="width: 100vw; height:100vh;" class="flex d-flex justify-content-center align-items-center">
  	<%@ page import="utn.frgp.edu.ar.*" %>
	<%@ page import="utn.frgp.edu.ar.entidad.*" %>
    <container style="width: 100%; height: 70%;">
    <div class="container">
    <div class="row">
    	<div class="col-md-8 offset-md-2">
    	<div class="card mt-4 animate__animated animate__fadeIn">
        	 <div class="card-header">
   				 Login
 			 </div>  
 			 <div class="card-body">
				<div class="row">
					<div class="col-md-12">
					<div class="input-group mb-3">
  					<input type="text" class="form-control" placeholder="Usuario" aria-label="Usuario">
					</div>
					</div>
				</div>
				<div class="row">
				<div class="col-md-12">
				<div class="input-group mb-3">
  					<input type="password" class="form-control" placeholder="Contraseña" aria-label="Contraseña">
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