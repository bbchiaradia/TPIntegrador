package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Usuarios;

@Service
public class usuariosService {

	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Usuarios> usuario;
	@Autowired

	private static Usuarios usuarioLogin = null;
	@Autowired
	private static String rol = null;
	
	
	@SuppressWarnings("unchecked")
	public static Usuarios UsuarioLogueado() {
			return usuarioLogin;
	}
	
	
	@SuppressWarnings("unchecked")
	public static String RolUsuarioLogueado() {
			return rol;
	}
	

	 private static Usuarios user;

	
	
	@SuppressWarnings("unchecked")
	public static List<Usuarios> UsuarioByNombrePass(String nombre){
		 try {
			 session = ConfigHibernet.abrirConexion();
			 Query q = session.createQuery("from Usuarios where nombreUsuario = '" + nombre +"'  and fecha_baja is null" );
			 usuario = q.list();
			 ConfigHibernet.commitSession(session);
			 return usuario;
    		} catch (DataAccessException e) {
    			ConfigHibernet.rollbackSession(session);
    			return null;
    		}
		 
		}
	
	
	 @SuppressWarnings("unchecked")
		public static List<Usuarios> UsuarioByPass(String nombre ,String contrasenia){;
			 try {
				 session = ConfigHibernet.abrirConexion();
				 Query q = session.createQuery("from Usuarios where nombreUsuario = '" + nombre +"' and contrasenia= '" +contrasenia+"' and fecha_baja is null" );
				 usuario = q.list();
				 ConfigHibernet.commitSession(session);
				 return usuario;

	    		} catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return null;
	    		}
			 
	}
	 

	 
	 @SuppressWarnings("unchecked")
		public static boolean esAdminBanco(String nombreUsuario) {
	        
			 try {
				 session = ConfigHibernet.abrirConexion();
	    		    Query q = session.createQuery("FROM Usuarios WHERE nombreUsuario='"+ nombreUsuario +"' and idUsuario IN (SELECT idUsuario FROM AdministradorBanco ) and fecha_baja is null");
	    		   
	
   				   usuarioLogin = (Usuarios) q.uniqueResult();
   				 System.out.println( "Acaaaaaaaaa 81 "+ 	usuarioLogin	);
	    			 if (usuarioLogin==null) {
	    				 Query q2 = session.createQuery("FROM Usuarios WHERE nombreUsuario='"+ nombreUsuario +"' and idUsuario IN (SELECT idUsuario FROM Clientes ) and fecha_baja is null");
	    				 usuarioLogin =(Usuarios) q2.uniqueResult();
	    				 rol= "CLIENTE";
	    				 System.out.println( "Acaaaaaaaaa 84 "+ 	rol	);
	    				  ConfigHibernet.commitSession(session);
		    				return false;
	    			 }else {
	    				 rol= "ADMIN";
	    				 ConfigHibernet.commitSession(session);
		    				return true;	
	    			}
	    			 
			 } catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return false;
	    		}

	    }
	

	 public static Usuarios getUsuarioById(Integer id) {
		 try {
			 session = ConfigHibernet.abrirConexion();
			 user = (Usuarios) session.byId(Usuarios.class).getReference(id);
			 return user;
		 }catch(Exception e){
			 ConfigHibernet.rollbackSession(session);
			 return null;
		 }
		 
	 }
	 

	
	
}
