package utn.frgp.edu.ar.controller;


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
	    SimpleDateFormat date1=new SimpleDateFormat("dd/MM/yyyy");
	    Date date;
		try {
			//date = (Date) date1.parse(sDate1);
			cli.setFecha_nacimiento(Calendar.getInstance().getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

	    cli.setIdNacionalidad(getNacionalidadId(Integer.parseInt(request.getParameter("nacionalidad"))));
	    cli.setIdLocalidad(getLocalidadesId(Integer.parseInt(request.getParameter("localidad"))));
	    cli.setIdProvincia(getProvinciasId(Integer.parseInt(request.getParameter("provincia"))));
	  
	    
	   
	    ModificarCliente(cli);		
	  
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
	
	
	
	 public void ModificarCliente (Clientes cliente) 
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
	        config.cerrarSession(); 
	        System.out.println( "ACA UPDATEEEEEEE 131" );
		   }catch(Exception e) {
			   System.out.println( "ACA UPDATEEEEEEE 133" );
			   System.out.println( e.getMessage() );	
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