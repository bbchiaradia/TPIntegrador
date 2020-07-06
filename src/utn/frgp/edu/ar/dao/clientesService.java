package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Usuarios;

@Service
public class clientesService {
	
	@Autowired
    private static Session session;

    @Autowired
    private static List<Clientes> clientes;
    @Autowired
    private static Clientes cliente;
	
	@SuppressWarnings("unchecked")
	public static List<Clientes> getClientes() {
    		try {
    			session = ConfigHibernet.abrirConexion();
 		        clientes = session.createCriteria(Clientes.class)
  					 .add(Restrictions.isNull("fecha_baja"))
  					 .list();
 		        ConfigHibernet.commitSession(session);
    			return clientes;
    		} catch (DataAccessException e) {
    			ConfigHibernet.rollbackSession(session);
    			return null;
    		}
    	
        
    }
	
	
	@SuppressWarnings("unchecked")
	public static List<Clientes> LeerCliente(Integer id) {
		try {
			 session = ConfigHibernet.abrirConexion();
		        clientes = session.createCriteria(Clientes.class)
						 .add(Restrictions.eq("idCliente", id))
						 .list();
				 System.out.println( "Acaaaaaaaaa 71"+ id);
				 ConfigHibernet.commitSession(session);
				 return  clientes;
		} catch (DataAccessException e) {
			ConfigHibernet.rollbackSession(session);
			return null;
		}
	}
	
	
	 public static boolean CrearCliente (Clientes cliente) {  
		  try {
		    session = ConfigHibernet.abrirConexion();
	        session.save(cliente);
	        ConfigHibernet.commitSession(session);
	        return true;
		   }catch(Exception e) {
			   ConfigHibernet.rollbackSession(session);	
			   return false;
	       	}
	    }
	 
	 public static boolean ModificarCliente (Clientes cliente) {	 
		  try {
			session = ConfigHibernet.abrirConexion();
	        session.update(cliente);
	        session.flush();
	        session.getTransaction().commit();
	        session.flush();
	        return true;
		   }catch(Exception e) {
			   ConfigHibernet.rollbackSession(session);		
			   return false;
	       	}
	    }
	 
	 public static boolean EliminarCliente (Integer idcliente) {
		 
	        	try {
	        		session = ConfigHibernet.abrirConexion();
	         cliente = (Clientes) session.byId(Clientes.class).getReference(idcliente);
	         cliente.setFecha_baja( Calendar.getInstance().getTime() );
	        session.update(cliente);
	        session.flush();
	        ConfigHibernet.commitSession(session);
	       	return true;
	       	}catch(Exception e) {
	       		ConfigHibernet.rollbackSession(session);
	       		return false;
	       	}
	    }
	 
	 
	 @SuppressWarnings("unchecked")
		public static List<Usuarios> UsuarioByNombre(String nombre){
		 	session = ConfigHibernet.abrirConexion();
			//List<Cuentas> cuentas = session.createCriteria(Cuentas.class).add(Restrictions.eq("idCliente", id)).list();
			 Query q = session.createQuery("from Usuarios where nombreUsuario = '" + nombre +"'" );
			 List<Usuarios> usuario = q.list();
			 ConfigHibernet.commitSession(session);
			 return usuario;
	}
	 
	 @SuppressWarnings("unchecked")
		public static List<Clientes> ClienteByDni(String dni){
		 	session = ConfigHibernet.abrirConexion();
			 Query q = session.createQuery("from Clientes where dni = " + Integer.parseInt(dni));
			 clientes = q.list();
			 ConfigHibernet.commitSession(session);
			 return clientes;
	}
	
	 
		public static Clientes getClienteId(Integer id) {
	    		try {
	    			session = ConfigHibernet.abrirConexion();
	    		    Clientes cli = (Clientes) session.byId(Clientes.class).getReference(id);
	    		        System.out.println( "ACA UPDATEEEEEEE 91"+cli.toString() );
	    		        ConfigHibernet.commitSession(session);
	    			return cli;
	    		} catch (DataAccessException e) {
	    			return null;
	    		}    
	    }
	
}
