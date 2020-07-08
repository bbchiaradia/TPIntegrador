package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Estados;
import utn.frgp.edu.ar.entidad.Usuarios;

@Service
public class estadosService {


	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Estados> estados;
	@Autowired
	 private static Estados estado;
	
	@SuppressWarnings("unchecked")
	public static List<Estados> getEstados() {
		session = ConfigHibernet.abrirConexion();
		estados = session.createCriteria(Estados.class).list();
		ConfigHibernet.commitSession(session);
		return estados;
	}
	
	public static Estados getEstadoById(Integer id) {
		session = ConfigHibernet.abrirConexion();
		estado = (Estados) session.byId(Estados.class).getReference(id);
		ConfigHibernet.commitSession(session);
		return estado;
	}

}
