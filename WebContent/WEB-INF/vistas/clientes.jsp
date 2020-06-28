<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
   <%@ include file="head.jsp"%>
    <title>TP Banco - Grupo 7</title>
  </head>
  
  
  <body style="width: 100vw; height:100vh;">
  	<%@ page import="utn.frgp.edu.ar.*" %>
		<%@ page import="utn.frgp.edu.ar.entidad.*" %>
		<%@ page import="utn.frgp.edu.ar.dao.*" %>
		<%@ page import="utn.frgp.edu.ar.controller.*" %>
    <container>
    <%@ include file="nav.html"%>
    <div class="container">
    
    <br>
   <div class="row mt-3 px-4 justify-content-end">
   <a href="redireccionar_formclientes.html">
    <button class="btn btn-sm btn-secondary" role="button">Alta clientes</button>
     </a>
    </div>
    
    
    <!-- detalle de cuenta -->
    <container>
    <div class="row animate__animated animate__fadeIn">
    	   <div class="col-md-12">
    	   <div class="card mt-4">
        	 <div class="card-header">
   				 Listado de clientes
 			 </div>  
 			
     	
     		
 			 <div class="card-body">
				<div class="row">
				
					<div class="col-md-12">
					<div class="row header_detalle">
					<div class="col-md-3">Apellido</div>
					<div class="col-md-3">Nombre</div>
					<div class="col-md-3">DNI</div>
					<div class="col-md-3">Operaciones</div>
					</div>
					<hr>
					</div>
					
					<div class="col-md-12 tarjeta">
					 <c:forEach var="cliente" items="${ clientes }">
		           <!--   <td> ${ cliente.toString() }</td> -->
					<div class="row my-1 py-1" id="cliente_${cliente.getIdCliente()}" style="border-bottom: 1px solid lightgrey;">
					<div class="col-md-3">${ cliente.getApellido() }</div>
					<div class="col-md-3">${ cliente.getNombre() }</div>
					<div class="col-md-3">${ cliente.getDni() }</div>
					<div class="col-md-3" style="display:flex;">
					<!--   <a href="clientes/" name="id" value=${cliente.getIdCliente() }">-->
					  
					  <form method="get" class="frmBoton" action="redireccionar_detalleCliente.html">
					  <input type="hidden" name="id" value="${cliente.getIdCliente() }">
						<button class="btn btn-sm btn-primary mr-1"  data-toggle="tooltip" data-placement="top" title="Ver cliente"> 
						<i class="fa fa-eye" aria-hidden="true"></i> 
						</button>	
						</form>
						
						
						 <form method="get" class="frmBoton" action="formclientes.html">
						  <input type="hidden" name="id" value="${cliente.getIdCliente() }">
						<button class="btn btn-sm btn-warning" data-toggle="tooltip" data-placement="top" title="Editar cliente">
						 <i class="fa fa-pencil" aria-hidden="true"></i>
						  </button>
						  </form>
						  
						  <button  class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="Eliminar" 
						  onclick="eliminarUsuario( ${ cliente.getIdCliente() }, '${ cliente.getNombre() }', '${ cliente.getApellido() }' )">
						   <i class="fa fa-trash-o" aria-hidden="true" ></i>
						 </button>
					</div>
					</div>
					</c:forEach>			
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

<script languaje="javascript">
$(function() {
	$('#example2').DataTable({
		'paging' : true,
		'lengthChange' : false,
		'searching' : true,
		'ordering' : true,
		'info' : true,
		'autoWidth' : true
	})
})

function eliminarUsuario( id, nombre, apellido ){
	let confirmacion = confirm("desea eliminar el usuario " + nombre + "  " + apellido + "?");
	if( confirmacion ){
		$.ajax({
	          url: '${request.getContextPath()}/TP_L5_GRUPO_7_/eliminarCliente.html',
	          type: 'POST',
	          data: {
	            id: id
	          },
	          success: function (data) {
	        	  if( data.indexOf("true") > -1 ){
	        		  $("#cliente_"+id).remove();
	        		  alert("El usuario ha sido eliminado correctamente");
	        	  }else{
	        		  alert("Ocurrió un error al eliminar el usuario");
	        	  }
	            return data && data.status ? handleSuccess(id) : handleError();
	          }
	        });
	}
}

</script>

  </body>
</html>