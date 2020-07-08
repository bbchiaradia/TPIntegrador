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
	 private static Movimientos movimiento = new Movimientos();
	
	public static boolean saveMovimiento(Integer idConcepto, Integer monto, Integer idCuenta) {
		movimiento.setFecha(Calendar.getInstance().getTime());
		movimiento.setIdConcepto( conceptosService.getConceptosById(idConcepto) );
		movimiento.setImporte( monto );
		movimiento.set_idCuenta( cuentasService.cuentaById(idCuenta));
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
	
}
