package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Conceptos;


@Service
public class conceptosService {

	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Conceptos> conceptos;
	@Autowired
	 private static Conceptos concepto;
	
	@SuppressWarnings("unchecked")
	public static List<Conceptos> getConceptos() {
		session = ConfigHibernet.abrirConexion();
		conceptos =  session.createCriteria(Conceptos.class).list();
		return conceptos;
				
	}
	
	public static Conceptos getConceptosById(Integer id) {
		session = ConfigHibernet.abrirConexion();
		concepto = (Conceptos) session.byId(Conceptos.class).getReference(id);
		return concepto;
				
	}
	
}
