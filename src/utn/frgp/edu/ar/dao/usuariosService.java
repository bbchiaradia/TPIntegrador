package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Usuarios;

@Service
public class usuariosService {

	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Usuarios> usuario;
	
	
	@SuppressWarnings("unchecked")
	public static List<Usuarios> UsuarioByNombrePass(String nombre){
		 try {
			 session = ConfigHibernet.abrirConexion();
			 Query q = session.createQuery("from Usuarios where nombreUsuario = '" + nombre +"'" );
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
				 Query q = session.createQuery("from Usuarios where nombreUsuario = '" + nombre +"' and contrasenia= '" +contrasenia+"'" );
				 usuario = q.list();
				 ConfigHibernet.commitSession(session);
				 return usuario;

	    		} catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return null;
	    		}
			 
	}
	
	
}
