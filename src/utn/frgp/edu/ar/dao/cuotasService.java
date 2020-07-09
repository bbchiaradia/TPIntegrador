package utn.frgp.edu.ar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Cuotas;
import utn.frgp.edu.ar.entidad.Prestamos;

@Service
public class cuotasService {
	
	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Cuotas> cuotas;
	@Autowired
	 private static Cuotas prestamo = new Cuotas();
	
	
	
	
	 @SuppressWarnings("unchecked")
		public static List<Cuotas> CuotasByIdPrestamo(Integer idPrestamo){
		 	session = ConfigHibernet.abrirConexion(); 	
		 	Query q = session.createQuery("FROM Cuotas where idPrestamo ='" + idPrestamo +"'  order by idCuota asc" );		 	  
		 	  cuotas = q.list();
			 System.out.println("CUOTASS-------------------" + cuotas);
			 ConfigHibernet.commitSession(session);
			 return cuotas;
	}
	 
	 
	 
	 @SuppressWarnings("unchecked")
		public static Double MontoCuotasByIdPrestamo(Integer idPrestamo){
		 	session = ConfigHibernet.abrirConexion(); 	
		 	Query q = session.createQuery("select importe/cuotas FROM Prestamos where idPrestamo ='" + idPrestamo +"' " );		 	  
		 	Double valor = (Double) q.uniqueResult();
			 System.out.println("CUOTASS-------------------" + cuotas);
			 ConfigHibernet.commitSession(session);
			 return valor;
	}
	 

}
