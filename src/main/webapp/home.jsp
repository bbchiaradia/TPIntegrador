
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
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="home.jsp">TP Banco</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" (click)="toggleCollapsed()" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class=" header navbar-collapse justify-content-end" id="navbarNav">
      
      <ul class="navbar-nav">
      <li class="nav-item justify-content-between" style="padding: 3px; color:#fff;cursor:pointer">
                    <a class="nav-link">
                      <span>Clientes</span>
                    </a> 
             </li>
             <li class="nav-item justify-content-between" style="padding: 3px; color:#fff;cursor:pointer">
                    <a class="nav-link">
                      <span>Cuentas</span>
                    </a> 
             </li>
           <li class="nav-item justify-content-between" style="padding: 3px; color:#fff;cursor:pointer">
                    <a class="nav-link">
                      <span>Préstamos</span>
                    </a> 
             </li>
            <li class="nav-item justify-content-between" style="padding: 3px; color:#fff;cursor:pointer">
                    <a class="nav-link">
                      <span>Informes</span>
                    </a> 
             </li>
            <li class="nav-item justify-content-between" style="padding: 3px; color:#fff;cursor:pointer">
                    <a class="nav-link">
                      <span>Mis cuentas</span>
                    </a> 
             </li>
            <li class="nav-item justify-content-between" style="padding: 3px; color:#fff;cursor:pointer">
                    <a class="nav-link">
                      <span>Transferencias</span>
                    </a> 
             </li>

          <li class="nav-item dropdown" style="padding: 3px;cursor:pointer"
          id="userDropDown"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <a class="nav-link">Nombre de usuario</a>
              <div class="dropdown-menu" aria-labelledby="userDropDown">
                <a class="dropdown-item" href="#">Configuración</a>
              </div>
             </li>

             <li class="nav-item justify-content-between" style="padding: 3px; color:#fff;cursor:pointer">
                    <a class="nav-link">
                      <span>Salir <em class="fas fa-sign-out-alt"></em></span>
                    </a> 
             </li>
      </ul>

    </div>
  </nav>
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