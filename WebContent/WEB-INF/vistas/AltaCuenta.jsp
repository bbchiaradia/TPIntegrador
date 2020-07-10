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
						    <option readonly value="-1" >[seleccione tipo de cuenta]</option>
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
						   <option readonly value="-1" >[seleccione cliente asociado]</option>
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
					 	onclick="crearCuenta( event);">Crear Cuenta</button>
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
						   <select class="form-control clientePropietario" name="clientePropietario" id="cliente_Propietario" >
						   <option readonly value="-1" >[seleccione cliente]</option>
						   <c:forEach var="cliente" items="${ clientes }">
						   	  <option value="${cliente.getIdCliente()}" > ${cliente.getNombre()} ${cliente.getApellido()}  </option>
						      </c:forEach>
						       </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-8">
					 	<div class="form-group">
						    <label for="titular">Cuenta:</label>
						    <select class="form-control cuentaUsuario" name="cuentaUsuario" id="cuenta_Usuario">
						       </select>
						  </div>
					 	</div>
					 	
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button"  id="btn_baja"
					 	onclick="bajarCuenta();">Dar de Baja</button>
					 	</div>
					  </div>
					  
					  <!-- modificacion de cuentas -->
					   <div class="tab-pane fade" id="modificacion" role="tabpanel" aria-labelledby="otras-tab">
					  	<div class="row">
					 	<div class="col-md-9">
					 	<div class="form-group">
						    <label for="cuentaBaja">Cliente de la cuenta a modificar:</label>
						    <select class="form-control cliente_Propietario_M" name="cliente_Propietario_M" id="cliente_Propietario_M">
						    <option readonly value="-1" >[seleccione cliente]</option>
						   <c:forEach var="cliente" items="${ clientes }">
						   	  <option value="${cliente.getIdCliente()}" > ${cliente.getNombre()} ${cliente.getApellido()}  </option>
						      </c:forEach>
						       </select>
						  </div>
					 	</div>
					 	
					 	<div class="col-md-8">
					 	<div class="form-group">
						    <label for="titular">Cuenta a modificar:</label>
						     <select class="form-control cuenta_Usuario_M" name="cuenta_Usuario_M" id="cuenta_Usuario_M">
						       </select>
						  </div>
					 	</div>
					 	
					 	 	<div class="col-md-6">
					 	<div class="form-group">
						    <label for="tipoCuenta">Tipo Cuenta:</label>
						   <select class="form-control tipoCuenta_M" name="tipoCuenta_M" id="tipoCuenta_M">
						    <c:forEach var="tipocuenta" items="${ tiposcuenta }">
						      <option id="tipoc_${tipocuenta.getId_TipoCuenta()}" value="${tipocuenta.getId_TipoCuenta()}">${tipocuenta.getDescripcion()} </option>
						    </c:forEach>
						    </select>
						  </div>
					 	</div>
					 	
					 	
					 	</div>
					 	<div class="row justify-content-end px-4">
					 	<button class="btn btn-sm btn-primary" role="button" 
					 	onclick="modificarCuenta();">Modificar</button>
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
	$("#cliente_Propietario").select2();
	$("#cliente_Propietario_M").select2();
	
	// Read selected option
	$('#but_read').click(function(){
	  var username = $('#clientePropietario option:selected').text();
	  var userid = $('#clientePropietario').val();
	});
	
	/*
	function cuentas(){
		let x = document.getElementsByName("clientePropietario").value();
		alert(x);
		return;
	}*/

	//Obtiene las cuentas del usuario seleccionado
	$(document).on('change', '.clientePropietario', function(){
		document.getElementById("cuenta_Usuario").innerHTML = "";
		let x = $("#cliente_Propietario option:selected").val()
		$.ajax({
	          url: '${request.getContextPath()}/TP_L5_GRUPO_7_/cuentascliente.html',
	          type: 'POST',
	          data: {
	            id: x
	          },
	          success: function (data) {
	        	  if( data != false ){
	        		  data = JSON.parse(data);
	        		  data.forEach( item => {
	        			  $("#cuenta_Usuario").append( 
	        					  "<option value= " + item.idCuenta  + "> " + item.id_TipoCuenta.descripcion + " - Num: " + item.nroCta +"</option>");
	        		  } );
	        	  }else{
	        		  alert("Ocurrió un error al obtener las cuentas del usuario");
	        	  }
	            return false;
	          }
	        });
	});
	
	
	//Obtiene las cuentas del usuario seleccionado para modificacion de cuentas
	$(document).on('change', '.cliente_Propietario_M', function(){
		document.getElementById("cuenta_Usuario_M").innerHTML = "";
		let x = $("#cliente_Propietario_M option:selected").val()
		$.ajax({
	          url: '${request.getContextPath()}/TP_L5_GRUPO_7_/cuentascliente.html',
	          type: 'POST',
	          data: {
	            id: x
	          },
	          success: function (data) {
	        	  if( data != false ){
	        		  data = JSON.parse(data);
	        		  data.forEach( item => {
	        			  $("#cuenta_Usuario_M").append( 
	        					  "<option  id=cid_"+item.idCuenta+" attr-tid='"+item.id_TipoCuenta.id_TipoCuenta+"' value= " + item.idCuenta  + "> " + item.id_TipoCuenta.descripcion + " - Num: " + item.nroCta + " - Saldo: $" + item.saldo +  "</option>");
	        		  } );
	        	  }else{
	        		  alert("Ocurrió un error al obtener las cuentas del usuario");
	        	  }
	            return false;
	          }
	        });
	});
	
	$(document).on('change', '#cuenta_Usuario_M', function(){
		let x = $("#cuenta_Usuario_M option:selected").val()
		let tid = document.getElementById("cid_"+x).getAttribute("attr-tid");
		$("#tipoCuenta_M").val(tid);
	});
	
	
});

function bajarCuenta(){
	let ctrlABajar = $("#cuenta_Usuario option:selected").val();
	if(ctrlABajar < 1 || ctrlABajar == undefined){
		alert("Debe seleccionar una cuenta");return;
	}
	let c = confirm("Realmente desea dar de baja la cuenta seleccionada?");
	if(c){
		let ctaABajar = $("#cuenta_Usuario option:selected").val();
		$.ajax({
	        url: '${request.getContextPath()}/TP_L5_GRUPO_7_/darDeBajaCuenta.html',
	        type: 'POST',
	        data: {
	          id: ctaABajar
	        },
	        success: function (data) {
	      	  if( data.indexOf("true") > -1  ){
	      		alert("La cuenta ha sido dada de baja correctamente");
	      		$("#cuenta_Usuario option:selected").remove();
	      	  }else{
	      		  alert("Ocurrió un error al eliminar la cuenta");
	      	  }
	          return false;
	        }
	      });
	}
	return;
}

//Submitea el formulario
function crearCuenta(e){
	e.stopPropagation();
	e.preventDefault();
	let n = confirm("Proceder a crear la cuenta?");
	if (n){
		document.all.formu.submit();
		document.all.formu.reset();
	}
	document.all.formu.reset();
	return;
}

function modificarCuenta(){
	let ctrlABajar = $("#cuenta_Usuario_M option:selected").val();
	if(ctrlABajar < 1 || ctrlABajar == undefined){
		alert("Debe seleccionar una cuenta");return;
	}
	let x = confirm( "Confirma la modificación del tipo de cuenta?" );
	if(x){
		let cuentaAModificar = $("#cuenta_Usuario_M option:selected").val()
		let tipoQueTieneQueSer = $("#tipoCuenta_M option:selected").val()
		if( cuentaAModificar && tipoQueTieneQueSer){
			$.ajax({
		        url: '${request.getContextPath()}/TP_L5_GRUPO_7_/modificarCuenta.html',
		        type: 'POST',
		        data: {
		        	id: cuentaAModificar,
		        	tipo: tipoQueTieneQueSer
		        },
		        success: function (data) {
		      	  if( data.indexOf("true") > -1  ){
		      		alert("La cuenta ha sido modificada correctamente");
		      		window.location.reload();
		      	  }else{
		      		  alert("Ocurrió un error al eliminar la cuenta");
		      	  }
		          return false;
		        }
		      });
		}
		return false;
	}
	return false;
	
}

</script>

  </body>
</html>