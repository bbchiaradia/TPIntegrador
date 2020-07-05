package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Nacionalidad;

@Service
public class nacionalidadService {

	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Nacionalidad> nac;
	@Autowired
	 private static Nacionalidad naci;
		
		@SuppressWarnings("unchecked")
		public static List<Nacionalidad> getNacionalidad() {
	    		try {
	    			 session = ConfigHibernet.abrirConexion();
		    	     nac = session.createCriteria(Nacionalidad.class).list();
		    	     ConfigHibernet.commitSession(session);
		    	     return nac;
	    		} catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return null;
	    		}	        
	    }
		
		public static Nacionalidad getNacionalidadId(Integer id) {
	    		try {
	    			session = ConfigHibernet.abrirConexion();
	    	        naci = (Nacionalidad) session.byId(Nacionalidad.class).getReference(id);
	    	        ConfigHibernet.commitSession(session);
	    			return naci;
	    		} catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return null;
	    		}
	    }
	
}
