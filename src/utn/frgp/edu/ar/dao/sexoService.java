package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Sexo;

@Service
public class sexoService {

	 @Autowired  
	 private static Session session;
	 @Autowired  
	 private static List<Sexo> sexo;
	 @Autowired  
	 private static Sexo sex;
		
		@SuppressWarnings("unchecked")
		public static List<Sexo> getSexo() {
	    		try { 
				 	session = ConfigHibernet.abrirConexion();
	    	        sexo = session.createCriteria(Sexo.class) .list();
	    	        ConfigHibernet.commitSession(session); 
	    			return sexo;
	    		} catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return null;
	    		}
	    }
			
			public static Sexo getSexoId(Integer id) {
		    		try {
			   		     session = ConfigHibernet.abrirConexion();
			    	     sex = (Sexo) session.byId(Sexo.class).getReference(id);
			    	     ConfigHibernet.commitSession(session); 
		    			return sex;
		    		} catch (DataAccessException e) {
		    			ConfigHibernet.rollbackSession(session);
		    			return null;
		    		}
		    	
		        
		    }
		
	
}
