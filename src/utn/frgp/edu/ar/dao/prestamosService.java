package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Movimientos;
import utn.frgp.edu.ar.entidad.Prestamos;

@Service
public class prestamosService {

	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Prestamos> prestamos;
	
	@Autowired
	 private static Prestamos prestamo = new Prestamos();
	
	public static boolean setPrestamo(Integer idcliente, Integer plazo, Integer importe, String cuentaDestino) {
		
		prestamo.setIdCliente( clientesService.getClienteId(idcliente) );
		prestamo.setImporte(importe);
		prestamo.setFecha_alta(Calendar.getInstance().getTime());
		prestamo.setIdEstado(estadosService.getEstadoById(3));
		prestamo.setPlazo_meses(plazo);

		Movimientos movimiento = new Movimientos();
		movimiento.setFecha(Calendar.getInstance().getTime());
		movimiento.setIdConcepto( conceptosService.getConceptosById(2) );
		movimiento.setImporte( importe );
		movimiento.setIdCuenta( cuentasService.cuentaById(Integer.parseInt(cuentaDestino)));
		
		try {
			session = ConfigHibernet.abrirConexion();
			prestamo.setIdMovimiento(movimiento);
			session.merge(prestamo);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}catch(Exception e) {
			ConfigHibernet.rollbackSession(session);
			return false;
		}
			
	}
	
}
