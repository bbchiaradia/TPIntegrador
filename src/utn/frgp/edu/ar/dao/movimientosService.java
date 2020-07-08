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
<<<<<<< HEAD
		movimiento.set_idCuenta( cuentasService.cuentaById(idCuenta));
		System.out.println(movimiento);
=======
		movimiento.setIdCuenta( cuentasService.cuentaById(idCuenta));
		
>>>>>>> d5cde57fa821b74a71a918da893e04b682cbc2c1
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
	
	
}
