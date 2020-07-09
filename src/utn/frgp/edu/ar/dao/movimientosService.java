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
import utn.frgp.edu.ar.entidad.Movimientos;
import utn.frgp.edu.ar.entidad.Prestamos;
import utn.frgp.edu.ar.entidad.Usuarios;


@Service
public class movimientosService {

	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Movimientos> movimientos;
	@Autowired
	 private static Movimientos movimiento = new Movimientos();
	
	public static boolean saveMovimiento(Integer idConcepto, Integer monto, Integer idCuenta) {
		movimiento.setFecha(Calendar.getInstance().getTime());
		movimiento.setIdConcepto( conceptosService.getConceptosById(idConcepto) );
		movimiento.setImporte( monto );
		movimiento.setIdCuenta( cuentasService.cuentaById(idCuenta));
		System.out.println(movimiento);

		try {
			session = ConfigHibernet.abrirConexion();
			System.out.println("31 mov service");
			System.out.println("33 mov service");
			session.save(movimiento);
			ConfigHibernet.commitSession(session);
			return true;
		}catch(Exception e) {
			System.out.println("36 mov service");
			System.out.println(e.getMessage());
			ConfigHibernet.rollbackSession(session);
			return false;
		}
		
	}
	
	

	
	
	 @SuppressWarnings("unchecked")
		public static List<Movimientos> MovimientoByIdCuenta(Integer id){
		 	session = ConfigHibernet.abrirConexion();
			 Query q = session.createQuery("FROM Movimientos where idCuenta = '" + id +"'" );
			 movimientos = q.list();
			 System.out.println("MOVIMIENTOS-------------------" + movimientos);
			 ConfigHibernet.commitSession(session);
			 return movimientos;
	}
	
	 
	 
	 @SuppressWarnings("unchecked")
		public static List<Movimientos> MovimientosPrestamosByIdCliente(Integer id){
		 	session = ConfigHibernet.abrirConexion(); 	
		 	Query q = session.createQuery("select m FROM Prestamos as p, Movimientos as m where p.idCliente ='" + id +"' and p.idMovimiento = m.idMovimiento" );		 	  
		 	  movimientos = q.list();
			 System.out.println("movimientos-------------------" + movimientos);
			 ConfigHibernet.commitSession(session);
			 return movimientos;
	}
	
	 
	
}
