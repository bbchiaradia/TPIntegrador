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
	 public boolean EliminarCliente (Integer idcliente) 
	    {
		 ConfigHibernet config= new ConfigHibernet();
	        try{
	        	
	        Session session = config.abrirConexion();
	        Transaction transaction = session.beginTransaction();
	        Clientes cli = (Clientes) session.byId(Clientes.class).getReference(idcliente);
	        System.out.println( cli.toString() );
	        cli.setFecha_baja( Calendar.getInstance().getTime() );
	        session.save(cli);
	        transaction.commit();
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

		
		

	
		

		
	 
	
}
