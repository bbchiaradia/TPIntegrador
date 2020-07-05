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
import utn.frgp.edu.ar.entidad.Cuentas;
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
public class UsuariosController {
	
	
	@RequestMapping(value = "redireccionar_Index.html" , method = RequestMethod.POST)
	public String lista1(ModelMap modelMap, HttpServletRequest request) {
    Usuarios usu= new Usuarios();
	    
	    usu.setNombreUsuario(request.getParameter("nombreUser"));
	    usu.setContrasenia(request.getParameter("contrasenia"));
		 
	    
  
	    if( esAdminBanco(usu.getNombreUsuario())) {
	    	modelMap.addAttribute("rol", "ADMIN");
	    	 System.out.println( "Acaaaaaaaaa 48"+ "ADMIN");
	    }else {
	    	modelMap.addAttribute("rol", "CLIENTE");
	    	 System.out.println( "Acaaaaaaaaa 51"+ "CLIENTE");
	    }
	

	    
	    return "/Index";
		
		
	}
	
	

	@RequestMapping( value= "validarNombreUsuarioAcceso", method = RequestMethod.POST )
	@ResponseBody
	public String nombreUsuarioByNombrePass( String nombre){
		System.out.println(nombre);
		List<Usuarios> usuario = UsuarioByNombrePass(nombre);
		System.out.println( usuario );
		if( usuario.size() == 0 ) {
			return "false";			
		}else{
			return "true";
		}
		
	}
	
	
	 @SuppressWarnings("unchecked")
		public static List<Usuarios> UsuarioByNombrePass(String nombre){
			ConfigHibernet config= new ConfigHibernet();

			 try {
		    		
			Session session = config.abrirConexion();
			Query q = session.createQuery("from Usuarios where nombreUsuario = '" + nombre +"'" );
				 List<Usuarios> usuario = q.list();
				 System.out.println(q);
				 return usuario;

	    		} catch (DataAccessException e) {
	    			return null;
	    		}
			 
	}
	 
		@RequestMapping( value= "validarContraseniaAcceso", method = RequestMethod.POST )
		@ResponseBody 
		public String contraseniaUsuarioByPass(String nombre, String contrasenia){
			System.out.println(nombre);
			System.out.println(contrasenia);
			List<Usuarios> usuario = UsuarioByPass(nombre, contrasenia);
			System.out.println( usuario );
			if( usuario.size() == 0 ) {
				return "false";			
			}else{
				return "true";
			}
			
		}
	 
	 

	
	
		 @SuppressWarnings("unchecked")
			public static List<Usuarios> UsuarioByPass(String nombre ,String contrasenia){
				ConfigHibernet config= new ConfigHibernet();

				 try {
			    		
				Session session = config.abrirConexion();
				Query q = session.createQuery("from Usuarios where nombreUsuario = '" + nombre +"' and contrasenia= '" +contrasenia+"'" );
					 List<Usuarios> usuario = q.list();
					 System.out.println(q);
					 return usuario;

		    		} catch (DataAccessException e) {
		    			return null;
		    		}
				 
		}
	
		 
			private static List<Usuarios> usuarios; 
			@SuppressWarnings("unchecked")
			public boolean esAdminBanco(String nombreUsuario) {
		        ConfigHibernet config= new ConfigHibernet();
		    			 	Session session = config.abrirConexion();
			    	        Transaction transaction = session.beginTransaction();
			    	        System.out.println( "Acaaaaaaaaa 145"+ nombreUsuario);
			    			 Query q = session.createQuery("FROM Usuarios WHERE nombreUsuario='"+ nombreUsuario +"' and idUsuario IN (SELECT idUsuario FROM AdministradorBanco ) ");
			    		   
			    		//	 Usuarios usuarios = (Usuarios) q.uniqueResult();		    	        
						
			    			if (q.uniqueResult()==null) {
			    				 session.close(); 
			    				 System.out.println( "Acaaaaaaaaa 153 CLIENTE"+ nombreUsuario);
				    				return false;
			    				
			    			}else {
			    				 session.close();
			    				 
			    				 System.out.println( "Acaaaaaaaaa 148 ADMIN"+ nombreUsuario);
				    				return true;
			    				
			    			}
                     
			    	        
					 
				 
		    }
			
	
	
	
	
	}