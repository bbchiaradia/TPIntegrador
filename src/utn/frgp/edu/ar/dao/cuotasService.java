package utn.frgp.edu.ar.dao;


import java.util.ArrayList;

import java.sql.Date;

import java.util.Calendar;
import java.util.List;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Conceptos;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.Cuotas;
import utn.frgp.edu.ar.entidad.Movimientos;
import utn.frgp.edu.ar.entidad.Prestamos;

@Service
public class cuotasService {
	
	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Cuotas> cuotas;
	@Autowired
	 private static Cuotas cuota = new Cuotas();

	@Autowired
	 private static Conceptos concepto = new Conceptos();
	
	@Autowired
	 private static Movimientos mov = new Movimientos();
	
	
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
		public static Cuotas CuotasByIdCuota(Integer idCuota){
		 	session = ConfigHibernet.abrirConexion(); 	
		 	Query q = session.createQuery("FROM Cuotas where idCuota ='" + idCuota +"'  order by idCuota asc" );		 	  
		 	  cuota = (Cuotas) q.uniqueResult();
			 System.out.println("CUOTASS-------------------" + cuotas);
			 ConfigHibernet.commitSession(session);
			 return cuota;
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
	 
	 
	 @SuppressWarnings("unchecked")
		public static Boolean PagarCuota(Cuentas cuenta, Double importe, Integer idCuota){

		 concepto = conceptosService.getConceptosById(3);
		 
		 
		
	        //Aquí obtienes el formato que deseas
	
		 
		 
			System.out.println("ID CUOTA "+ idCuota);
		 Cuotas cuota1 = CuotasByIdCuota(idCuota);
		 cuota1.setFecha_pago(Calendar.getInstance().getTime());
		 
			mov.setFecha(Calendar.getInstance().getTime());
			mov.setIdConcepto(concepto);
			mov.setIdCuenta( cuenta );
			mov.setImporte( Double.parseDouble("-"+importe) );
		 
		
			try {
				System.out.println("LINEA 80 ENTRO AL TRY ");
				session = ConfigHibernet.abrirConexion();

				darDeBajaCuotaPorId(idCuota);
				
			
				
				session.merge(mov);
				
				session.getTransaction().commit();
				session.close();
				return true;
			}catch(Exception e){
				System.out.println(e.getMessage());
				ConfigHibernet.rollbackSession(session);
				return false;
			}
	}
	 

	 public static boolean setCuotas( Prestamos prestamo ) {
		 Integer plazo = prestamo.getPlazo_meses();
		 try {
			 session = ConfigHibernet.abrirConexion();
			 for(Integer i = 0; i<plazo ; i++) {
				 System.out.println(i);
				 Cuotas cta = cuota;
				 cta.setPrestamo(prestamo);
				 System.out.println(cta);
				 session.merge(cta);
				 session.flush();
			 }
			 ConfigHibernet.commitSession(session);
			 return true;
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
				ConfigHibernet.rollbackSession(session);
				return false;
		 }

	 }

	 
	 
	 public static boolean darDeBajaCuotaPorId( Integer idCuota) {
		 System.out.println("idcuota al principio"+ idCuota);
		 cuota= CuotasByIdCuota(idCuota);
			 System.out.println("cuota al principio"+ cuota);
			cuota.setFecha_pago(Calendar.getInstance().getTime());
			System.out.println(" FECHA"+ Calendar.getInstance().getTime());
			System.out.println("SET FECHA"+ cuota.getFecha_pago());
		    System.out.println("cuota antes de try"+ cuota);
		    try {
				session = ConfigHibernet.abrirConexion();
		        session.update(cuota);
		        session.flush();
		        
		      //  ConfigHibernet.commitSession(session);
		       	return true;
			}catch(Exception E) {
				System.out.println( E.getMessage() );
				ConfigHibernet.rollbackSession(session);
				return false;
			}
		}


}
