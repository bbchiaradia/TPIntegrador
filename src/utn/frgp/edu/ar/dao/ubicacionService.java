package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Localidades;
import utn.frgp.edu.ar.entidad.Provincias;

@Service
public class ubicacionService {
	
		@Autowired
	    private static Session session;
		
		@Autowired
		private static List<Provincias> prov;
		
		@Autowired
		private static Provincias provincia;
		
		@Autowired
		private static List<Localidades> loc;
		@Autowired
		private static Localidades localidad;
		
		@SuppressWarnings("unchecked")
		public static List<Provincias> getProvincias() {
	    		try {
	    		 	session = ConfigHibernet.abrirConexion();
	    	        prov = session.createCriteria(Provincias.class).list();
	    	        ConfigHibernet.commitSession(session);
	    			return prov;
	    		} catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return null;
	    		}
	    }
		

		public static Provincias getProvinciasId(Integer id) {
	    		try {
	    			session = ConfigHibernet.abrirConexion();
	    			provincia = (Provincias) session.byId(Provincias.class).getReference(id);
		    	    ConfigHibernet.commitSession(session); 
	    			return provincia;
	    		} catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return null;
	    		}
	    }
		
			@SuppressWarnings("unchecked")
			public static List<Localidades> getLocalidades() {
		    		try {
		    				session = ConfigHibernet.abrirConexion();
			    	        loc = session.createCriteria(Localidades.class).list();
			    	        ConfigHibernet.commitSession(session);    
		    			return loc;
		    		} catch (DataAccessException e) {
		    			ConfigHibernet.rollbackSession(session);
		    			return null;
		    		}
		    }
			
			

			public static Localidades getLocalidadesId(Integer id) {
		    		try {
		    			 	session = ConfigHibernet.abrirConexion();
			    	        localidad = (Localidades) session.byId(Localidades.class).getReference(id);
			    	        ConfigHibernet.commitSession(session);    
		    			return localidad;
		    		} catch (DataAccessException e) {
		    			ConfigHibernet.rollbackSession(session);
		    			return null;
		    		}
		    	
		        
		    }

}
