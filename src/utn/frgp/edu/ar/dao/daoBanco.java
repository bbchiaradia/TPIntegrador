package utn.frgp.edu.ar.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.Localidades;
import utn.frgp.edu.ar.entidad.Nacionalidad;
import utn.frgp.edu.ar.entidad.Provincias;
import utn.frgp.edu.ar.entidad.Sexo;
import utn.frgp.edu.ar.entidad.Usuarios;



public class daoBanco implements Idao {
	
	
private static List<Clientes> clientes;
	
	@SuppressWarnings("unchecked")
	public static List<Clientes> getClientes() {
        
    		try {
    			ConfigHibernet config= new ConfigHibernet();
    			 Session session = config.abrirConexion();
    			 session.beginTransaction();
    			 clientes = session.createCriteria(Clientes.class)
    					 .add(Restrictions.isNull("fecha_baja"))
    					 .list();
    			 
    			
    			return clientes;
    		} catch (DataAccessException e) {
    			return null;
    		}
    	
        
    }
	
	@SuppressWarnings("unchecked")
	public static List<Clientes> LeerCliente(Integer id) {
		try {
			
			ConfigHibernet config= new ConfigHibernet();
			 Session session = config.abrirConexion();
			 session.beginTransaction();
			 clientes = session.createCriteria(Clientes.class)
					 .add(Restrictions.eq("idCliente", id))
					 .list();
			 System.out.println( "Acaaaaaaaaa"+ id);
			
			return  clientes;
			
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static Clientes getClienteId(Integer id) {
        
    		try {
    			ConfigHibernet config= new ConfigHibernet();
    			 Session session = config.abrirConexion();
    			  Transaction transaction = session.beginTransaction();
    			 Clientes cli = (Clientes) session.byId(Clientes.class).getReference(id);
    			 transaction.commit();
    			
    			return cli;
    		} catch (DataAccessException e) {
    			return null;
    		}    
    }
	
	
	
	
	 public Clientes AgregarCliente (Clientes cliente) 
	    {
	        ConfigHibernet config= new ConfigHibernet();
	        Session session = config.abrirConexion();
	        session.beginTransaction().commit();
	        session.beginTransaction();
	        session.save(cliente);
	        session.beginTransaction().commit();
	        config.cerrarSession(); 
	        return cliente;
	    }
	 
	 public void ModificarCliente (Clientes cliente) 
	    {
		 
		
		  System.out.println( "ACA UPDATEEEEEEE 108"+cliente.toString() );
		  ConfigHibernet config= new ConfigHibernet();   
		  try {
		    Session session = config.abrirConexion();
	        Transaction transaction = session.beginTransaction();
	        session.save(cliente);
	        System.out.println( "ACA UPDATEEEEEEE 114"+cliente.toString() );
	        transaction.commit();
	        config.cerrarSession(); 
		   }catch(Exception e) {
			   System.out.println( "ACA UPDATEEEEEEE 119" );
			   System.out.println( e.getMessage() );
	       		
	       	}finally{
	       		config.cerrarSession();
	       	}

	    }
	 
	
	 
	 public boolean EliminarCliente (Integer idcliente) 
	    {
		 ConfigHibernet config= new ConfigHibernet();
	      
	        	try {
	        Session session = config.abrirConexion();
	        Transaction transaction = session.beginTransaction();
	        session.beginTransaction();
	        Clientes cli = (Clientes) session.byId(Clientes.class).getReference(idcliente);
	        System.out.println( cli.toString() );
	        cli.setFecha_baja( Calendar.getInstance().getTime() );
	        session.update(cli);
	        transaction.commit();
	        config.cerrarSession(); 
	       	return true;
	       	}catch(Exception e) {
	       		System.out.println( e.getMessage() );
	       		return false;
	       	}finally{
	       		config.cerrarSession();
	       	}
	    }

//-------------------------------- CUENTAS ----------------------------------
	 
	 public Cuentas LeerCuenta(int id) 
		{
			   ConfigHibernet config= new ConfigHibernet();
		        Session session = config.abrirConexion();
		        session.beginTransaction().commit();
		        session.beginTransaction();
		        Cuentas cuenta =(Cuentas)session.get(Cuentas.class, id);
		        config.cerrarSession();
		        return cuenta;
		}
		 public Cuentas AgregarCuenta(Cuentas cuenta) 
		    {
		        ConfigHibernet config= new ConfigHibernet();
		        Session session = config.abrirConexion();
		        session.beginTransaction().commit();
		        session.beginTransaction();
		        session.save(cuenta);
		        session.beginTransaction().commit();
		        config.cerrarSession(); 
		        return cuenta;
		    }
		 public void ModificarCuenta(Cuentas cuenta) 
		    {
		        ConfigHibernet config= new ConfigHibernet();
		        Session session = config.abrirConexion();
		        session.beginTransaction();
		        session.update(cuenta);
		        session.beginTransaction().commit();
		        config.cerrarSession();
		    }
		 public void EliminarCuenta(Cuentas cuenta) 
		    {
		        ConfigHibernet config= new ConfigHibernet();
		        Session session = config.abrirConexion();
		        session.beginTransaction();
		        //por baja logica , se realiza update 
		        session.update(cuenta);
		        session.beginTransaction().commit();
		        config.cerrarSession();
		       	
		    }

		
		

//--------------------- Provincias
		 
		 private static List<Provincias> prov;
			
			@SuppressWarnings("unchecked")
			public static List<Provincias> getProvincias() {
		        
		    		try {
		    			ConfigHibernet config= new ConfigHibernet();
		    			 Session session = config.abrirConexion();
		    			 session.beginTransaction();
		    			 prov = session.createCriteria(Provincias.class) .list();
		    		
		    			return prov;
		    		} catch (DataAccessException e) {
		    			return null;
		    		}
		    	
		        
		    }
			
			
			
			
			@SuppressWarnings("unchecked")
			public static Provincias getProvinciasId(Integer id) {
		        
		    		try {
		    			ConfigHibernet config= new ConfigHibernet();
		    			 Session session = config.abrirConexion();
		    			 session.beginTransaction();
		    			 Provincias prov = (Provincias) session.byId(Provincias.class).getReference(id);
		    			
		    			return prov;
		    		} catch (DataAccessException e) {
		    			return null;
		    		}
		    	
		        
		    }
			
		
			
//--------------------- Localidades
			 
			 private static List<Localidades> loc;
				
				@SuppressWarnings("unchecked")
				public static List<Localidades> getLocalidades() {
			        
			    		try {
			    			ConfigHibernet config= new ConfigHibernet();
			    			 Session session = config.abrirConexion();
			    			 session.beginTransaction();
			    			 loc = session.createCriteria(Localidades.class) .list();
			    			
			    			return loc;
			    		} catch (DataAccessException e) {
			    			return null;
			    		}
			    	
			        
			    }
				
				
				@SuppressWarnings("unchecked")
				public static Localidades getLocalidadesId(Integer id) {
			        
			    		try {
			    			ConfigHibernet config= new ConfigHibernet();
			    			 Session session = config.abrirConexion();
			    			 session.beginTransaction();
			    			 Localidades loc = (Localidades) session.byId(Localidades.class).getReference(id);
			    			
			    			return loc;
			    		} catch (DataAccessException e) {
			    			return null;
			    		}
			    	
			        
			    }
				
						
//-------------------- Sexo
			
			 private static List<Sexo> sexo;
				
				@SuppressWarnings("unchecked")
				public static List<Sexo> getSexo() {
			        
			    		try {
			    			ConfigHibernet config= new ConfigHibernet();
			    			 Session session = config.abrirConexion();
			    			 session.beginTransaction();
			    			 sexo = session.createCriteria(Sexo.class) .list();
			    			
			    			return sexo;
			    		} catch (DataAccessException e) {
			    			return null;
			    		}
			    	
			        
			    }
			
				
			
					
					@SuppressWarnings("unchecked")
					public static Sexo getSexoId(Integer id) {

				    		try {
				    			ConfigHibernet config= new ConfigHibernet();
				    			 Session session = config.abrirConexion();
				    			 session.beginTransaction();
				    			 Sexo sexo = (Sexo) session.byId(Sexo.class).getReference(id);
				    			
				    			return sexo;
				    		} catch (DataAccessException e) {
				    			return null;
				    		}
				    	
				        
				    }
				
				
			
//-------------------- Nacionalidad 
				
				
				 private static List<Nacionalidad> nac;
					
					@SuppressWarnings("unchecked")
					public static List<Nacionalidad> getNacionalidad() {
				        
				    		try {
				    			ConfigHibernet config= new ConfigHibernet();
				    			 Session session = config.abrirConexion();
				    			 session.beginTransaction();
				    			 nac = session.createCriteria(Nacionalidad.class) .list();
				    			
				    			return nac;
				    		} catch (DataAccessException e) {
				    			return null;
				    		}
				    	
				        
				    }
					
					@SuppressWarnings("unchecked")
					public static Nacionalidad getNacionalidadId(Integer id) {
				        
				    		try {
				    			ConfigHibernet config= new ConfigHibernet();
				    			 Session session = config.abrirConexion();
				    			 session.beginTransaction();
				    			 Nacionalidad nac = (Nacionalidad) session.byId(Nacionalidad.class).getReference(id);
				    			session.getTransaction().commit();
				    			return nac;
				    		} catch (DataAccessException e) {
				    			return null;
				    		}
				    	
				        
				    }
					
					
//----------------------------- NOMBRE USUARIO
					
					
					@SuppressWarnings("unchecked")
					public static Usuarios getNombreUsuarioId(Integer id) {
				        
				    		try {
				    			ConfigHibernet config= new ConfigHibernet();
				    			 Session session = config.abrirConexion();
				    			 session.beginTransaction();
				    			 Usuarios usu = (Usuarios) session.byId(Usuarios.class).getReference(id);
				    			
				    			return usu;
				    		} catch (DataAccessException e) {
				    			return null;
				    		}
				    	
				        
				    }
					
				
					
				
				
	
}
