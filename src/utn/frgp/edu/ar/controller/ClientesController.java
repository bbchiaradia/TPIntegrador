package utn.frgp.edu.ar.controller;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.ConfigHibernet;
import utn.frgp.edu.ar.dao.daoBanco;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Localidades;
import utn.frgp.edu.ar.entidad.Nacionalidad;
import utn.frgp.edu.ar.entidad.Provincias;
import utn.frgp.edu.ar.entidad.Sexo;
import utn.frgp.edu.ar.entidad.Usuarios;

import java.sql.Date;
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
	    modelMap.addAttribute("clientes", getClientes());

	    return "/clientes";
	}
	
	
	@RequestMapping(value = "redireccionar_detalleCliente" , method = RequestMethod.GET)
	public String list2(ModelMap modelMap, Integer id) {
	    modelMap.addAttribute("detalleCliente", LeerCliente(id));		
	    
	    return "/detalleCliente";
	}
	
	
	
	
	@RequestMapping(value = "formclientes" , method = RequestMethod.GET)
	public String list3(ModelMap modelMap, Integer id) {
	    modelMap.addAttribute("formclientes", LeerCliente(id));		
	    modelMap.addAttribute("listaProvincias", getProvincias());		
	    modelMap.addAttribute("listaLocalidades", getLocalidades());		
	    modelMap.addAttribute("listaSexo", getSexo());	
	    modelMap.addAttribute("listaNacionalidades", getNacionalidad());	
	    return "/formclientes";
	}
	
	
	//////
	@RequestMapping(value = "altaCliente" , method = RequestMethod.GET)
	public String lista4(ModelMap modelMap) {
	    modelMap.addAttribute("listaProvincias", getProvincias());
	    modelMap.addAttribute("listaLocalidades", getLocalidades());		
	    modelMap.addAttribute("listaSexo", getSexo());	
	    modelMap.addAttribute("listaNacionalidades", getNacionalidad());	
	    return "/altaCliente";
	}
	
	
	@RequestMapping(value = "altaClientePOST" , method = RequestMethod.POST)
	public String lista4(ModelMap modelMap, HttpServletRequest request) {
	    modelMap.addAttribute("listaProvincias", getProvincias());	    
	    modelMap.addAttribute("listaLocalidades", getLocalidades());		
	    modelMap.addAttribute("listaSexo", getSexo());	
	    modelMap.addAttribute("listaNacionalidades",getNacionalidad());
	    Clientes cli= new Clientes();
	    
	    cli.setNombre(request.getParameter("nombre"));
	    cli.setApellido(request.getParameter("apellido"));
	    cli.setDni(Integer.parseInt(request.getParameter("dni")));
	    
	    cli.setIdSexo(getSexoId(Integer.parseInt(request.getParameter("sexo"))));
	   
	   /* String sDate1=request.getParameter("fnac");  
	    SimpleDateFormat date1=new SimpleDateFormat("dd/MM/yyyy");
	    Date date;
		try {
			cli.setFecha_nacimiento(Calendar.getInstance().getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	    
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
        
	    cli.setIdNacionalidad(getNacionalidadId(Integer.parseInt(request.getParameter("nacionalidad"))));
	    cli.setIdLocalidad(getLocalidadesId(Integer.parseInt(request.getParameter("localidad"))));
	    cli.setIdProvincia(getProvinciasId(Integer.parseInt(request.getParameter("provincia"))));
	  
	    
	    Usuarios usu = new Usuarios();
	    usu.setContrasenia(request.getParameter("dni"));
	    usu.setNombreUsuario(request.getParameter("nombreUser"));
	    usu.setFecha_alta(Calendar.getInstance().getTime());
	    usu.setFecha_baja(null);
	    cli.setIdUsuario(usu);
	    System.out.println(" NICOSSSSSSSSSSS  aca a a a a a a a a a a" + nombreUsuarioByNombre("nombreUser"));
	
	    if( CrearCliente(cli)) {
	    	modelMap.addAttribute("status", "El cliente ha sido creado correctamente.");
	    }else {
	    	modelMap.addAttribute("status", "Ocurrió un error al crear el cliente.");
	    }
	    
	  
	    List<Clientes> list = new ArrayList();
	    list.add(cli);  
	    
	    
	    
	    
	    modelMap.addAttribute("altaCliente", list);    
	    
	    return "/altaCliente";
	}
	
	
	 public boolean CrearCliente (Clientes cliente) 
	    {
		 
		
		  System.out.println( "ACA CREAR 128");
		  
		  ConfigHibernet config= new ConfigHibernet();   
		  
		  try {
		    Session session = config.abrirConexion();
	        Transaction transaction = session.beginTransaction();
	        session.save(cliente);
	        System.out.println( "ACA CREAR 136" );
	        transaction.commit();
	        System.out.println( "ACA CREAR 138");
	        config.cerrarSession(); 
	        System.out.println( "ACA CREAR 1401" );
	        return true;
		   }catch(Exception e) {
			   System.out.println( "ACA CREAR 142" );
			   System.out.println( e.getMessage() );	
			   return false;
	       	}

	    }
	    //////////////valido el nombre usuario en la tabla Usuario///////
	    
		@RequestMapping( value= "validarNombreUsuario", method = RequestMethod.POST )
		@ResponseBody
		public String nombreUsuarioByNombre( String nombre){
			System.out.println(nombre);
			List<Usuarios> usuario = UsuarioByNombre(nombre);
			System.out.println( usuario );
			if( usuario.size() == 0 ) {
				return "true";			
			}else{
				return "false";
			}
			
		}
		
		 @SuppressWarnings("unchecked")
			public static List<Usuarios> UsuarioByNombre(String nombre){
				ConfigHibernet config= new ConfigHibernet();
				 Session session = config.abrirConexion();
				//List<Cuentas> cuentas = session.createCriteria(Cuentas.class).add(Restrictions.eq("idCliente", id)).list();
				 Query q = session.createQuery("from Usuarios where nombreUsuario = '" + nombre +"'" );
				 List<Usuarios> usuario = q.list();
				 System.out.println(q);
				 return usuario;
		}
		 
		  ///////valido el Dni que no este duplicado//////////
		 
			@RequestMapping( value= "validarNumeroDocumento", method = RequestMethod.POST )
			@ResponseBody
			public String validarDniUsuario( String dni){
				System.out.println("dni es " + dni);
				List<Clientes> clientes = ClienteByDni(dni);
				System.out.println("array cli " + clientes );
				if( clientes.size() == 0 ) {
					return "true";			
				}else{
					return "false";
				}				
			}
			
			 @SuppressWarnings("unchecked")
				public static List<Clientes> ClienteByDni(String dni){
					ConfigHibernet config= new ConfigHibernet();
					 Session session = config.abrirConexion();
					 Query q = session.createQuery("from Clientes where dni = " + Integer.parseInt(dni));
					 List<Clientes> clientes = q.list();
					 return clientes;
			}
	 
	
	
	
	///nico//////////////////////////////////////////////////
	
	@RequestMapping( value= "eliminarCliente", method = RequestMethod.POST )
	@ResponseBody
	public String eliminarCliente( Integer id, daoBanco dao ){
		System.out.println(id);
		boolean cl = dao.EliminarCliente(id);
		if( cl ) {
			return "true";
		}
		return "false";
	}
	
	
	@RequestMapping(value = "formclientesPost" , method = RequestMethod.POST)
	public String list4(ModelMap modelMap, Integer id , HttpServletRequest request) {
	    modelMap.addAttribute("listaProvincias", getProvincias());	
	    
	    modelMap.addAttribute("listaLocalidades", getLocalidades());		
	    modelMap.addAttribute("listaSexo", getSexo());	
	    modelMap.addAttribute("listaNacionalidades",getNacionalidad());
	    Clientes cli= getClienteId(Integer.parseInt(request.getParameter("idCliente")));
	    
	    cli.setNombre(request.getParameter("nombre"));
	    cli.setApellido(request.getParameter("apellido"));
	    cli.setDni(Integer.parseInt(request.getParameter("dni")));
	    
	    cli.setIdSexo(getSexoId(Integer.parseInt(request.getParameter("sexo"))));
	   
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

	    cli.setIdNacionalidad(getNacionalidadId(Integer.parseInt(request.getParameter("nacionalidad"))));
	    cli.setIdLocalidad(getLocalidadesId(Integer.parseInt(request.getParameter("localidad"))));
	    cli.setIdProvincia(getProvinciasId(Integer.parseInt(request.getParameter("provincia"))));
	  
	    
	   
	    if( ModificarCliente(cli) ) {
	    	modelMap.addAttribute("status", "El cliente ha sido modificado correctamente.");
	    }else {
	    	modelMap.addAttribute("status", "Ocurrió un error al actualizar el cliente.");
	    }
	  
	    List<Clientes> list = new ArrayList();
	    list.add(cli); 
	    
	  
	    
	    modelMap.addAttribute("formclientes", list);
	    
	    
	    
	    return "/formclientes";
	}
	
	private static List<Clientes> clientes;
	
	
	@SuppressWarnings("unchecked")
	public static List<Clientes> getClientes() {
        	ConfigHibernet config= new ConfigHibernet();
    		try {
    			 
    			 Session session = config.abrirConexion();
 		        Transaction transaction = session.beginTransaction();
 		       clientes = session.createCriteria(Clientes.class)
  					 .add(Restrictions.isNull("fecha_baja"))
  					 .list();
 				 
 		        config.cerrarSession(); 
    			 
    			 
    			 
    			
    			return clientes;
    		} catch (DataAccessException e) {
    			return null;
    		}
    	
        
    }
	
	@SuppressWarnings("unchecked")
	public static List<Clientes> LeerCliente(Integer id) {
		ConfigHibernet config= new ConfigHibernet();
		try {
			
			
			 
			 Session session = config.abrirConexion();
		        Transaction transaction = session.beginTransaction();
		        clientes = session.createCriteria(Clientes.class)
						 .add(Restrictions.eq("idCliente", id))
						 .list();
				 System.out.println( "Acaaaaaaaaa 71"+ id);
				 
		        config.cerrarSession(); 

			return  clientes;
			
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static Clientes getClienteId(Integer id) {
        ConfigHibernet config= new ConfigHibernet();
    		try {
    			
    			  Session session = config.abrirConexion();
    		        Transaction transaction = session.beginTransaction();
    		        Clientes cli = (Clientes) session.byId(Clientes.class).getReference(id);
    		        System.out.println( "ACA UPDATEEEEEEE 91"+cli.toString() );
    		        config.cerrarSession(); 
    			 
    			return cli;
    		} catch (DataAccessException e) {
    			return null;
    		}    
    }
	
	
	
	 public boolean ModificarCliente (Clientes cliente) 
	    {
		 
		
		  System.out.println( "ACA UPDATEEEEEEE 108");
		  
		  ConfigHibernet config= new ConfigHibernet();   
		  
		  try {
		    Session session = config.abrirConexion();
	        Transaction transaction = session.beginTransaction();
	        session.update(cliente);
	        System.out.println( "ACA UPDATEEEEEEE 127" );
	        transaction.commit();
	        System.out.println( "ACA UPDATEEEEEEE 129");
	        //config.cerrarSession(); 
	        System.out.println( "ACA UPDATEEEEEEE 131" );
	        return true;
		   }catch(Exception e) {
			   System.out.println( "ACA UPDATEEEEEEE 133" );
			   System.out.println( e.getMessage() );	
			   return false;
	       	}
	
	    }
	 

	//--------------------- Provincias
			 
			 private static List<Provincias> prov;
				
				@SuppressWarnings("unchecked")
				public static List<Provincias> getProvincias() {
			        ConfigHibernet config= new ConfigHibernet();
			    		try {
			    			
			    		 	Session session = config.abrirConexion();
			    	        Transaction transaction = session.beginTransaction();
			    	        prov = session.createCriteria(Provincias.class) .list();
			    	        session.close();
			    		     
			    			return prov;
			    		} catch (DataAccessException e) {
			    			return null;
			    		}
			    	
			        
			    }
				
				
				
				
				@SuppressWarnings("unchecked")
				public static Provincias getProvinciasId(Integer id) {
			        ConfigHibernet config= new ConfigHibernet();
			    		try {
			    			

			    			 	Session session = config.abrirConexion();
				    	        Transaction transaction = session.beginTransaction();
				    	        Provincias prov = (Provincias) session.byId(Provincias.class).getReference(id);
				    	        session.close();
			    			 
			    			 
			    			return prov;
			    		} catch (DataAccessException e) {
			    			return null;
			    		}
			    	
			        
			    }
				
			
				
	//--------------------- Localidades
				 
				 private static List<Localidades> loc;
					
					@SuppressWarnings("unchecked")
					public static List<Localidades> getLocalidades() {
				        ConfigHibernet config= new ConfigHibernet();
				    		try {
				    			    
				    			 	Session session = config.abrirConexion();
					    	        Transaction transaction = session.beginTransaction();
					    	        loc = session.createCriteria(Localidades.class) .list();
					    	        session.close();
				    			    
				    			    
				    			return loc;
				    		} catch (DataAccessException e) {
				    			return null;
				    		}
				    	
				        
				    }
					
					
					@SuppressWarnings("unchecked")
					public static Localidades getLocalidadesId(Integer id) {
				        ConfigHibernet config= new ConfigHibernet();
				    		try {
				    			
				    			 	Session session = config.abrirConexion();
					    	        Transaction transaction = session.beginTransaction();
					    	        Localidades loc = (Localidades) session.byId(Localidades.class).getReference(id);
					    	        session.close();
				    			
				    			return loc;
				    		} catch (DataAccessException e) {
				    			return null;
				    		}
				    	
				        
				    }
					
							
	//-------------------- Sexo
				
				 private static List<Sexo> sexo;
					
					@SuppressWarnings("unchecked")
					public static List<Sexo> getSexo() {
				       ConfigHibernet config= new ConfigHibernet();
				    		try {
				    		
				   		        
							 	Session session = config.abrirConexion();
				    	        Transaction transaction = session.beginTransaction();
				    	        sexo = session.createCriteria(Sexo.class) .list();
				    	        session.close();
				   		        
				    			 
				    			return sexo;
				    		} catch (DataAccessException e) {
				    			return null;
				    		}
				    	
				        
				    }
				
					
				
						
						@SuppressWarnings("unchecked")
						public static Sexo getSexoId(Integer id) {
								 ConfigHibernet config= new ConfigHibernet();
					    		try {

						   		     Session session = config.abrirConexion();
						    	        Transaction transaction = session.beginTransaction();
						    	        Sexo sexo = (Sexo) session.byId(Sexo.class).getReference(id);
						    	        session.close();
					    			 
					    			return sexo;
					    		} catch (DataAccessException e) {
					    			return null;
					    		}
					    	
					        
					    }
					
					
				
	//-------------------- Nacionalidad 
					
					
					 private static List<Nacionalidad> nac;
						
						@SuppressWarnings("unchecked")
						public static List<Nacionalidad> getNacionalidad() {
					        ConfigHibernet config= new ConfigHibernet();
					    		try {
					    			
					    		
					    			    Session session = config.abrirConexion();
						    	        Transaction transaction = session.beginTransaction();
						    	        nac = session.createCriteria(Nacionalidad.class) .list();
						    	        session.close();
					    			    
					    			    
					    			return nac;
					    		} catch (DataAccessException e) {
					    			return null;
					    		}
					    	
					        
					    }
						
						@SuppressWarnings("unchecked")
						public static Nacionalidad getNacionalidadId(Integer id) {
					        ConfigHibernet config= new ConfigHibernet();
					    		try {
					    		
				    			    Session session = config.abrirConexion();
					    	        Transaction transaction = session.beginTransaction();
					    	        Nacionalidad nac = (Nacionalidad) session.byId(Nacionalidad.class).getReference(id);
					    	        session.close();

					    			return nac;
					    		} catch (DataAccessException e) {
					    			return null;
					    		}
					    	
					        
					    }
						
						
	//----------------------------- NOMBRE USUARIO
						
						
						@SuppressWarnings("unchecked")
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
					    	
					        
					    }
						
					
	
						

	
}