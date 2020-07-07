package utn.frgp.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.nacionalidadService;
import utn.frgp.edu.ar.dao.sexoService;
import utn.frgp.edu.ar.dao.ubicacionService;
import utn.frgp.edu.ar.dao.usuariosService;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



@Controller
public class ClientesController{
	
	
	@RequestMapping(value = "redireccionar_clientes_D", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
	    modelMap.addAttribute("clientes", clientesService.getClientes());
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	    modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    return "/clientes";
	}
	
	
	@RequestMapping(value = "redireccionar_detalleCliente" , method = RequestMethod.GET)
	public String list2(ModelMap modelMap, Integer id) {
	    modelMap.addAttribute("detalleCliente", clientesService.LeerCliente(id));		
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	    modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    return "/detalleCliente";
	}
	
	
	
	
	@RequestMapping(value = "formclientes" , method = RequestMethod.GET)
	public String list3(ModelMap modelMap, Integer id) {
	    modelMap.addAttribute("formclientes", clientesService.LeerCliente(id));		
	    modelMap.addAttribute("listaProvincias", ubicacionService.getProvincias());		
	    modelMap.addAttribute("listaLocalidades", ubicacionService.getLocalidades());		
	    modelMap.addAttribute("listaSexo", sexoService.getSexo());	
	    modelMap.addAttribute("listaNacionalidades", nacionalidadService.getNacionalidad());	
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	    modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    return "/formclientes";
	}
	
	
	//////
	@RequestMapping(value = "altaCliente" , method = RequestMethod.GET)
	public String lista4(ModelMap modelMap) {
	    modelMap.addAttribute("listaProvincias", ubicacionService.getProvincias());
	    modelMap.addAttribute("listaLocalidades", ubicacionService.getLocalidades());		
	    modelMap.addAttribute("listaSexo", sexoService.getSexo());	
	    modelMap.addAttribute("listaNacionalidades", nacionalidadService.getNacionalidad());	
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	    modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    return "/altaCliente";
	}
	
	
	@RequestMapping(value = "altaClientePOST" , method = RequestMethod.POST)
	public String lista4(ModelMap modelMap, HttpServletRequest request) {
	    modelMap.addAttribute("listaProvincias", ubicacionService.getProvincias());	    
	    modelMap.addAttribute("listaLocalidades", ubicacionService.getLocalidades());		
	    modelMap.addAttribute("listaSexo", sexoService.getSexo());	
	    modelMap.addAttribute("listaNacionalidades",nacionalidadService.getNacionalidad());
	    Clientes cli= new Clientes();
	    
	    cli.setNombre(request.getParameter("nombre"));
	    cli.setApellido(request.getParameter("apellido"));
	    cli.setDni(Integer.parseInt(request.getParameter("dni")));
	    
	    cli.setIdSexo(sexoService.getSexoId(Integer.parseInt(request.getParameter("sexo"))));
	    
	    String sDate1=request.getParameter("fnac");  
	    cli.setFecha_alta(Calendar.getInstance().getTime());
	    System.out.println("sDate1--------------------------" + sDate1);
	    SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
	    System.out.println("formato-------------------" + formato);
	    java.util.Date fechaDate = null;
	    System.out.println("null-------------------" );
        try {
        	System.out.println("try-------------------" );
			fechaDate = formato.parse(sDate1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
        cli.setFecha_nacimiento(fechaDate);        
        cli.setFecha_alta(Calendar.getInstance().getTime());
        
	    cli.setIdNacionalidad(nacionalidadService.getNacionalidadId(Integer.parseInt(request.getParameter("nacionalidad"))));
	    cli.setIdLocalidad(ubicacionService.getLocalidadesId(Integer.parseInt(request.getParameter("localidad"))));
	    cli.setIdProvincia(ubicacionService.getProvinciasId(Integer.parseInt(request.getParameter("provincia"))));
	  
	    
	    Usuarios usu = new Usuarios();
	    usu.setContrasenia(request.getParameter("dni"));
	    usu.setNombreUsuario(request.getParameter("nombreUser"));
	    usu.setFecha_alta(Calendar.getInstance().getTime());
	    usu.setFecha_baja(null);
	    cli.setIdUsuario(usu);
	    System.out.println(" NICOSSSSSSSSSSS  aca a a a a a a a a a a" + nombreUsuarioByNombre("nombreUser"));
	
	    if( clientesService.CrearCliente(cli)) {
	    	modelMap.addAttribute("status", "El cliente ha sido creado correctamente.");
	    }else {
	    	modelMap.addAttribute("status", "Ocurrió un error al crear el cliente.");
	    }
	    	  
		List<Clientes> list = new ArrayList();
	    list.add(cli);  
	    
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	    modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    modelMap.addAttribute("altaCliente", list);    
	    
	    return "/altaCliente";
	}
	
	
	    //////////////valido el nombre usuario en la tabla Usuario///////
	    
		@RequestMapping( value= "validarNombreUsuario", method = RequestMethod.POST )
		@ResponseBody
		public String nombreUsuarioByNombre( String nombre){
			System.out.println(nombre);
			List<Usuarios> usuario = clientesService.UsuarioByNombre(nombre);
			System.out.println( usuario );
			if( usuario.size() == 0 ) {
				return "true";			
			}else{
				return "false";
			}
			
		}
		 
		  ///////valido el Dni que no este duplicado//////////
		 
			@RequestMapping( value= "validarNumeroDocumento", method = RequestMethod.POST )
			@ResponseBody
			public String validarDniUsuario( String dni){
				System.out.println("dni es " + dni);
				List<Clientes> clientes = clientesService.ClienteByDni(dni);
				System.out.println("array cli " + clientes );
				if( clientes.size() == 0 ) {
					return "true";			
				}else{
					return "false";
				}				
			}
			
	///nico//////////////////////////////////////////////////
	
	@RequestMapping( value= "eliminarCliente", method = RequestMethod.POST )
	@ResponseBody
	public String eliminarCliente( Integer id ){
		boolean cl = clientesService.EliminarCliente(id);
		if( cl ) {
			return "true";
		}
		return "false";
	}
	
	
	@RequestMapping(value = "formclientesPost" , method = RequestMethod.POST)
	public String list4(ModelMap modelMap, Integer id , HttpServletRequest request) {
	    modelMap.addAttribute("listaProvincias", ubicacionService.getProvincias());	
	    
	    modelMap.addAttribute("listaLocalidades", ubicacionService.getLocalidades());		
	    modelMap.addAttribute("listaSexo", sexoService.getSexo());	
	    modelMap.addAttribute("listaNacionalidades",nacionalidadService.getNacionalidad());
	    Clientes cli= clientesService.getClienteId(Integer.parseInt(request.getParameter("idCliente")));
	    
	    cli.setNombre(request.getParameter("nombre"));
	    cli.setApellido(request.getParameter("apellido"));
	    cli.setDni(Integer.parseInt(request.getParameter("dni")));
	    
	    cli.setIdSexo(sexoService.getSexoId(Integer.parseInt(request.getParameter("sexo"))));
	   
	    String sDate1=request.getParameter("fnac");  
	    cli.setFecha_alta(Calendar.getInstance().getTime());
	    System.out.println("sDate1--------------------------" + sDate1);
	    SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
	    System.out.println("formato-------------------" + formato);
	    java.util.Date fechaDate = null;
	    System.out.println("null-------------------" );
        try {
        	System.out.println("try-------------------" );
			fechaDate = formato.parse(sDate1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
        cli.setFecha_nacimiento(fechaDate);    

	    cli.setIdNacionalidad(nacionalidadService.getNacionalidadId(Integer.parseInt(request.getParameter("nacionalidad"))));
	    cli.setIdLocalidad(ubicacionService.getLocalidadesId(Integer.parseInt(request.getParameter("localidad"))));
	    cli.setIdProvincia(ubicacionService.getProvinciasId(Integer.parseInt(request.getParameter("provincia"))));
	  
	    
	   
	    if( clientesService.ModificarCliente(cli) ) {
	    	modelMap.addAttribute("status", "El cliente ha sido modificado correctamente.");
	    }else {
	    	modelMap.addAttribute("status", "Ocurrió un error al actualizar el cliente.");
	    }
	  
	    List<Clientes> list = new ArrayList();
	    list.add(cli); 
	    
	  
	    
	    modelMap.addAttribute("formclientes", list);
	    
	    
	    
	    return "/formclientes";
	}
	

					
						
	//----------------------------- NOMBRE USUARIO
						
						
						/*@SuppressWarnings("unchecked")
						public static Usuarios getNombreUsuarioId(Integer id) {
					        ConfigHibernet config= new ConfigHibernet();
					    		try {
					    		
					    			 
					    			 Session session = config.abrirConexion();
						    	        Transaction transaction = session.beginTransaction();
						    	        Usuarios usu = (Usuarios) session.byId(Usuarios.class).getReference(id);
						    	        session.close();
					    			 
					    			return usu;
					    		} catch (DataAccessException e) {
					    			return null;
					    		}
					    	
					        
					    }*/
						
					
	
	
}