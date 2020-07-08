package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		System.out.println( idcliente);
		System.out.println( plazo);
		System.out.println( importe);
		System.out.println( cuentaDestino);
		
		prestamo.setIdCliente( clientesService.getClienteId(idcliente) );
		prestamo.setImporte(importe);
		prestamo.setFecha_alta(Calendar.getInstance().getTime());
		prestamo.setId_estado(estadosService.getEstadoById(3));
		prestamo.setPlazo_meses(plazo);
		System.out.println( prestamo);
		System.out.println( session);
		boolean flag = movimientosService.saveMovimiento(2, importe, Integer.parseInt(cuentaDestino));
		if(flag) {
			try {
				session = ConfigHibernet.abrirConexion();
				session.save(prestamo);
				session.flush();
				ConfigHibernet.commitSession(session);
				return true;
			}catch(Exception e) {
				ConfigHibernet.rollbackSession(session);
				System.out.println("44 prest service");
				System.out.println(e.getMessage());
				return false;
			}
		}else {
			return false;
		}
		
	}
	
}
