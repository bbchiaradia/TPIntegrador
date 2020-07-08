package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Movimientos;


@Service
public class movimientosService {

	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Movimientos> movimientos;
	@Autowired
	 private static Movimientos movimiento = null;
	
	public static boolean saveMovimiento(Integer idConcepto, Integer monto, Integer idCuenta) {
		
		movimiento.setFecha(Calendar.getInstance().getTime());
		movimiento.setIdConcepto( conceptosService.getConceptosById(idConcepto) );
		movimiento.setImporte( monto );
		movimiento.set_idCuenta( cuentasService.cuentaById(idCuenta));
		
		try {
			session = ConfigHibernet.abrirConexion();
			session.save(movimiento);
			ConfigHibernet.commitSession(session);
			return true;
		}catch(Exception e) {
			ConfigHibernet.rollbackSession(session);
			return false;
		}
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static List<Movimientos> MovimientoByIdCuenta(Integer id) {
		try {
			 session = ConfigHibernet.abrirConexion();
			 movimientos = session.createCriteria(Movimientos.class)
						 .add(Restrictions.eq("idCuenta", id))
						 .list();
				 System.out.println( "Acaaaaaaaaa 55"+ id);
				 ConfigHibernet.commitSession(session);
				 return  movimientos;
		} catch (DataAccessException e) {
			ConfigHibernet.rollbackSession(session);
			return null;
		}
	}
	
	
}
