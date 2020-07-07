package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Conceptos;
import utn.frgp.edu.ar.entidad.Sexo;

@Service
public class conceptoService {

	@Autowired
    private static Session session;

    @Autowired
    private static List<Conceptos> conceptos;
    @Autowired
    private static Conceptos concepto;
    
    
	@SuppressWarnings("unchecked")
	public static List<Conceptos> getConceptos() {
    		try { 
			 	session = ConfigHibernet.abrirConexion();
			 	conceptos = session.createCriteria(Conceptos.class) .list();
    	        ConfigHibernet.commitSession(session); 
    			return conceptos;
    		}catch (DataAccessException e) {
    			ConfigHibernet.rollbackSession(session);
    			return null;
    		}
    }
}
