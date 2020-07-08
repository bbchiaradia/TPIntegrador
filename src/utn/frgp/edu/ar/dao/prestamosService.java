package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.Prestamos;

@Service
public class prestamosService {

	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Prestamos> prestamos;
	@Autowired
	 private static Prestamos prestamo = null;
	
	public static boolean setPrestamo(Integer idcliente, Integer plazo, Integer importe, String cuentaDestino) {
		System.out.println( idcliente);
		System.out.println( plazo);
		System.out.println( importe);
		System.out.println( cuentaDestino);
		
		prestamo.setIdCliente( clientesService.getClienteId(idcliente) );
		prestamo.setImporte(importe);
		prestamo.setFecha_alta(Calendar.getInstance().getTime());
		prestamo.setId_estado(estadosService.getEstadoById(3));
		prestamo.setPlazo_meses(plazo);
		
		if(movimientosService.saveMovimiento(2, importe, Integer.parseInt(cuentaDestino))) {
			try {
				session = ConfigHibernet.abrirConexion();
				session.save(prestamo);
				ConfigHibernet.commitSession(session);
				return true;
			}catch(Exception e) {
				ConfigHibernet.rollbackSession(session);
				return false;
			}
		}else {
			return false;
		}
		
	}
	
}
