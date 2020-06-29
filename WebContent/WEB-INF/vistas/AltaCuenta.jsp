<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
    <c:if test="${status != null }">
    <script>
    alert( "${status}" );
    </script>
    </c:if>
    <!-- detalle de cuenta -->
    <container>
    <div class="row animate__animated animate__fadeIn">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 ABM Cuentas
 			 </div>  
 			 <div class="card-body">
				<div class="row">
					<div class="col-md-12">
					
					<ul class="nav nav-tabs" id="myTab" role="tablist">
					  <li class="nav-item">
					    <a class="nav-link active" id="propias-tab" data-toggle="tab" href="#propias" role="tab" aria-controls="propias" aria-selected="true">Alta</a>
					  </li>
					   <li class="nav-item">
					    <a class="nav-link" id="otras-tab" data-toggle="tab" href="#otras"            role="tab" aria-controls="otras" aria-selected="false">Baja</a>
					  </li>
					  	 <li class="nav-item">
					    <a class="nav-link" id="modificacion-tab" data-toggle="tab" href="#modificacion" role="tab"             aria-controls="modificacion" aria-selected="false">Modificacion</a>
					  </li>
					</ul>
					
					<div class="tab-content py-2 mt-2" id="myTabContent">
					  <div class="tab-pane fade show active" id="propias" role="tabpanel" aria-labelledby="propias-tab">
					 	
					 	
					 	<form id="formu" method="POST" action="nuevacuenta.html">
					 	<div class="row">
					 	<!-- <div class="col-md-4">
					 	<div class="form-group">
						    <label for="numeroCuenta">Numero de cuenta:</label>
						      <input type="number" class="form-control" min="1" max="60" id="numeroCuenta" placeholder="se auto-genera">

						    </select>
						  </div>
					 	</div>  -->
	
					 	<div class="col-md-6">
					 	<div class="form-group">
						    <label for="tipoCuenta">Tipo de cuenta:</label>
						    <select class="form-control" name="tipoCuenta" id="tipoCuenta">
						    <c:forEach var="tipocuenta" items="${ tiposcuenta }">
						      <option value="${tipocuenta.getId_TipoCuenta()}">${tipocuenta.getDescripcion()} </option>
						    </c:forEach>
						    </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-6">
					 	<div class="form-group">
						    <label for="clienteCuenta">Cliente:</label>
						   <select class="form-control" name="clientePropietario" id="clientePropietario">
						   <c:forEach var="cliente" items="${ clientes }">
						   	  <option value="${cliente.getIdCliente()}" > ${cliente.getNombre()} ${cliente.getApellido()}  </option>
						      </c:forEach>
						       </select>
						     <!--<input type='button' value='Selected option' id='but_read'>  -->  
						     <!-- <div id="result"></div>  -->
						  </div>
					 	</div>
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="crearCuenta();">Crear Cuenta</button>
					 	</div>
					 	</form>
					 	
					 	<!--<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="confirm( 'Desea crear la cuenta?' );">Crear Cuenta</button>
					 	</div>-->
					  </div>
					  
					  <!-- baja de cuentas -->
					  <div class="tab-pane fade" id="otras" role="tabpanel" aria-labelledby="otras-tab">
					  	<div class="row">
					 	<div class="col-md-9">
					 	<div class="form-group">
						   <select class="form-control clientePropietario" name="clientePropietario" id="clientePropietario">
						   <c:forEach var="cliente" items="${ clientes }">
						   	  <option value="${cliente.getIdCliente()}" > ${cliente.getNombre()} ${cliente.getApellido()}  </option>
						      </c:forEach>
						       </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-8">
					 	<div class="form-group">
						    <label for="titular">Titular:</label>
						    <input type="number" class="form-control" id="titular" placeholder="">
						  </div>
					 	</div>
					 	
					 	<div class="col-md-7">
					 	<div class="form-group">
						    <label for="saldo">Saldo:</label>
						   <input type="number" class="form-control" id="saldo" placeholder="">
						  </div>
					 	</div>
					 	
					 	 	<div class="col-md-6">
					 	<div class="form-group">
						    <label for="tipoCuenta">Tipo Cuenta:</label>
						   <input type="number" class="form-control" id="tipoCuenta" placeholder="">
						  </div>
					 	</div>
					 	
					 	
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="confirm( 'Desea dar de baja la cuenta?' );">Dar de Baja</button>
					 	</div>
					  </div>
					  
					  <!-- modificacion de cuentas -->
					   <div class="tab-pane fade" id="modificacion" role="tabpanel" aria-labelledby="otras-tab">
					  	<div class="row">
					 	<div class="col-md-9">
					 	<div class="form-group">
						    <label for="cuentaBaja">Cuenta a modificar:</label>
						    <select class="form-control" id="cuentaBaja">
						      <option>386-254454-9</option>
						    </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-8">
					 	<div class="form-group">
						    <label for="titular">Titular:</label>
						    <input type="number" class="form-control" id="titular" placeholder="">
						  </div>
					 	</div>
					 	
					 	<div class="col-md-7">
					 	<div class="form-group">
						    <label for="saldo">Saldo:</label>
						   <input type="number" class="form-control" id="saldo" placeholder="">
						  </div>
					 	</div>
					 	
					 	 	<div class="col-md-6">
					 	<div class="form-group">
						    <label for="tipoCuenta">Tipo Cuenta:</label>
						   <input type="number" class="form-control" id="tipoCuenta" placeholder="">
						  </div>
					 	</div>
					 	
					 	
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="confirm( 'Desea modificar la cuenta?' );">Modificar</button>
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
    
    </div>
    </container>

<%@ include file="foot.html"%>
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>
<script languaje="javascript">
$(document).ready(function(){
	// Inicializa select2
	$("#clientePropietario").select2();

	// Read selected option
	$('#but_read').click(function(){
	  var username = $('#clientePropietario option:selected').text();
	  var userid = $('#clientePropietario').val();

	  //$('#result').html("id : " + userid + ", name : " + username);

	});
	
	function crearCuenta(){
		let n = confirm("Proceder a crear la cuenta?");
		if (n){
			document.all.formu.submit();
		}
		return;
	}
	
	function cuentas(){
		let x = document.getElementsByName("clientePropietario").value();
		alert(x);
		return;
	}

	
	$(document).on('change', '.clientePropietario', function(){
		let x = $("[name=clientePropietario]").val()
		$.ajax({
	          url: '${request.getContextPath()}/TP_L5_GRUPO_7_/cuentascliente.html',
	          type: 'POST',
	          data: {
	            id: x
	          },
	          success: function (data) {
	        	  alert(data);
	        	  if( data.indexOf("true") > -1 ){
	        		  $("#cliente_"+id).remove();
	        		  alert("El usuario ha sido eliminado correctamente");
	        	  }else{
	        		  alert("Ocurrió un error al eliminar el usuario");
	        	  }
	            return data && data.status ? handleSuccess(id) : handleError();
	          }
	        });
	});
});


</script>

  </body>
</html>