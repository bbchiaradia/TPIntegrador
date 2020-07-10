package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.Estados;
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

	@Autowired
	 private static Estados estado = new Estados();
	
	public static boolean setPrestamo(Integer idcliente, Integer plazo, Integer importe, String cuentaDestino) {
		
		prestamo.setIdCliente( clientesService.getClienteId(idcliente) );
		prestamo.setImporte(importe);
		prestamo.setFecha(Calendar.getInstance().getTime());
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
	
	
	 @SuppressWarnings("unchecked")
		public static List<Prestamos> PrestamosByIdCliente(Integer id){
		 	session = ConfigHibernet.abrirConexion(); 	
		 	Query q = session.createQuery("FROM Prestamos where idCliente ='" + id +"' and fecha_baja is null order by fecha desc" );		 	  
		 	  prestamos = q.list();
			 System.out.println("PRESTAMOS-------------------" + prestamos);
			 ConfigHibernet.commitSession(session);
			 return prestamos;
	}
	 
	 
	 
	 
	 
	 @SuppressWarnings("unchecked")
		public static List<Prestamos> PrestamosAll(){
		 	session = ConfigHibernet.abrirConexion(); 	
		 	Query q = session.createQuery("FROM Prestamos where fecha_baja is null and idEstado= 3 order by fecha desc" );		 	  
		 	  prestamos = q.list();
			 System.out.println("PRESTAMOS-------------------" + prestamos);
			 ConfigHibernet.commitSession(session);
			 return prestamos;
	}
	 
	 
	 
		public static boolean rechazarPrestamoPorId( Prestamos prestamo) {
			estado = estadosService.getEstadoById(2);
			prestamo.setIdEstado(estado);
			try {
				session = ConfigHibernet.abrirConexion();
		        session.update(prestamo);
		        session.flush();
		        ConfigHibernet.commitSession(session);
		       	return true;
			}catch(Exception E) {
				System.out.println( E.getMessage() );
				ConfigHibernet.rollbackSession(session);
				return false;
			}
		}
	 
		 
			public static boolean aprobarPrestamoPorId( Prestamos prestamo, Integer cuentaDestino) {
				estado = estadosService.getEstadoById(1);
				prestamo.setIdEstado(estado);
				try {
					session = ConfigHibernet.abrirConexion();
			        session.update(prestamo);
			        session.flush();
			        ConfigHibernet.commitSession(session);
			        Cuentas ctad = cuentasService.cuentaById(cuentaDestino);
			        Double saldo  = ctad.getSaldo() + prestamo.getImporte() ;
			        ctad.setSaldo( saldo );
			        System.out.println( "114 prestamos service" + ctad.getSaldo() + " - " + prestamo.getImporte() + " - " + saldo);
			        cuotasService.setCuotas(prestamo);
			        cuentasService.modificarCuenta(ctad);
			        
			       	return true;
				}catch(Exception E) {
					System.out.println( E.getMessage() );
					ConfigHibernet.rollbackSession(session);
					return false;
				}
			}
	
			
			
			public static Prestamos prestamoById(Integer id){
				session = ConfigHibernet.abrirConexion();
				//List<Cuentas> cuentas = session.createCriteria(Cuentas.class).add(Restrictions.eq("idCliente", id)).list();
				 Query q = session.createQuery("from Prestamos where fecha_baja is null and idPrestamo = " + id);
				 Prestamos prestamo = (Prestamos) q.uniqueResult();
				 ConfigHibernet.commitSession(session);
				 return prestamo;
			}
			
}
