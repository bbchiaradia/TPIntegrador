package utn.frgp.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;

public class daoBanco implements Idao {
	
	
//-------------------------------- CLIENTES ----------------------------------
	
/*	public <List>Clientes LeerAllClientes() {
		ConfigHibernet config= new ConfigHibernet();
        Session session = config.abrirConexion();
        Query q = session.createQuery("select * from Clientes");
        ArrayList clientes = q.getResultList();
        config.cerrarSession();
        return clientes;
	}*/
	@Autowired
    private static List<Clientes> clientes;
	
	public static List<Clientes> getClientes() {
        
        	ConfigHibernet config= new ConfigHibernet();
        	Session session = config.abrirConexion();
            clientes = session.createCriteria(Clientes.class).list();
            session.getTransaction().commit();
        return clientes;
    }
	 public Clientes AgregarCliente (Clientes cliente) 
	    {
	        ConfigHibernet config= new ConfigHibernet();
	        Session session = config.abrirConexion();
	     // session.beginTransaction();
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
		@Override
		public Clientes LeerCliente(int id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		

	
		

		
	 
	
}
