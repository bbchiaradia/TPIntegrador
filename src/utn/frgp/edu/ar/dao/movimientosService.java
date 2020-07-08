package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
