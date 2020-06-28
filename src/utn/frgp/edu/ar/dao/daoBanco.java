package utn.frgp.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
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



public class daoBanco implements Idao {
	
	
private static List<Clientes> clientes;
	
	@SuppressWarnings("unchecked")
	public static List<Clientes> getClientes() {
        
    		try {
    			ConfigHibernet config= new ConfigHibernet();
    			 Session session = config.abrirConexion();
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
			 clientes = session.createCriteria(Clientes.class)
					 .add(Restrictions.eq("idCliente", id))
					 .list();
			 System.out.println( "Acaaaaaaaaa"+ id);
			return  clientes;
			
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	
	
	
	 public Clientes AgregarCliente (Clientes cliente) 
	    {
	        ConfigHibernet config= new ConfigHibernet();
	        Session session = config.abrirConexion();
	        session.beginTransaction();
	        session.save(cliente);
	        session.beginTransaction().commit();
	        config.cerrarSession(); 
	        return cliente;
	    }
	 public void ModificarCliente (Clientes cliente) 
	    {
	        ConfigHibernet config= new ConfigHibernet();
	        Session session = config.abrirConexion();
	        session.beginTransaction();
	        session.update(cliente);
	        session.beginTransaction().commit();
	        config.cerrarSession();
	    }
	 public void EliminarCliente (Clientes cliente) 
	    {
	        ConfigHibernet config= new ConfigHibernet();
	        Session session = config.abrirConexion();
	        session.beginTransaction();
	        //por baja logica , se realiza update 
	        session.update(cliente);
	        session.beginTransaction().commit();
	        config.cerrarSession();
	       	
	    }

//-------------------------------- CUENTAS ----------------------------------
	 
	 public Cuentas LeerCuenta(int id) 
		{
			   ConfigHibernet config= new ConfigHibernet();
		        Session session = config.abrirConexion();
		        session.beginTransaction();
		        Cuentas cuenta =(Cuentas)session.get(Cuentas.class, id);
		        config.cerrarSession();
		        return cuenta;
		}
		 public Cuentas AgregarCuenta(Cuentas cuenta) 
		    {
		        ConfigHibernet config= new ConfigHibernet();
		        Session session = config.abrirConexion();
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
		    			 prov = session.createCriteria(Provincias.class) .list();
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
			    			 loc = session.createCriteria(Localidades.class) .list();
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
			    			 sexo = session.createCriteria(Sexo.class) .list();
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
				    			 nac = session.createCriteria(Nacionalidad.class) .list();
				    			return nac;
				    		} catch (DataAccessException e) {
				    			return null;
				    		}
				    	
				        
				    }
				
				
	
}
