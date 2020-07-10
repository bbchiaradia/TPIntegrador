package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.Movimientos;
import utn.frgp.edu.ar.entidad.TipoCuenta;

@Service
public class cuentasService {
	
	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Cuentas> cuentas;
	
	@Autowired
	 private static Cuentas cuenta;
	
	@Autowired
	private static List<TipoCuenta> tiposcuenta;
	
	@SuppressWarnings("unchecked")
	public static List<TipoCuenta> listarTipoCuentas(){
		session = ConfigHibernet.abrirConexion();
		tiposcuenta = session.createCriteria(TipoCuenta.class).list();
		ConfigHibernet.commitSession(session);
		return  tiposcuenta;
	}
	
	public static TipoCuenta tipoCuentaById( Integer id  ) {
		session = ConfigHibernet.abrirConexion();
		TipoCuenta tipocuenta = (TipoCuenta) session.createCriteria(TipoCuenta.class)
				 .add(Restrictions.eq("id_TipoCuenta", id)).uniqueResult();
		ConfigHibernet.commitSession(session);
		return tipocuenta;
	}
	
	 @SuppressWarnings("unchecked")
		public static List<Cuentas> cuentasByClientId(Integer id){
		 session = ConfigHibernet.abrirConexion();
			 Query q = session.createQuery("from Cuentas where idCliente = " + id + " and fecha_baja is null");
			 cuentas = q.list();
			 //ConfigHibernet.commitSession(session);
			 return cuentas;
		}
	 
	 
	 @SuppressWarnings("unchecked")
		public static Boolean verificaMontoCuenta(Integer idCuenta, Double monto){
		 session = ConfigHibernet.abrirConexion();

		 System.out.println("ANTES CONSULTA ----------- "+ monto);
			
		    Query q = session.createQuery("from Cuentas where idCuenta = " + idCuenta + " and saldo >= "+ monto +" and fecha_baja is null");
			cuentas = q.list();
			

			 if(cuentas.size() == 0) {
				 
				 System.out.println("ENTRO IF  ");
				 return false;
			 }else {
				 System.out.println("NO ENTRO IF  ");
				 return true;
			 }
			
		}

	 
	 @SuppressWarnings("unchecked")
		public static Cuentas cuentasByPrestamoId(Integer id){
		 session = ConfigHibernet.abrirConexion();
			 Query q = session.createQuery("SELECT c FROM Prestamos as p, Movimientos as m , Cuentas as c where p.idPrestamo ='" + id +"' and p.idMovimiento = m.idMovimiento and m.idCuenta = c.idCuenta");
			 cuenta = (Cuentas) q.uniqueResult();
			 ConfigHibernet.commitSession(session);
			 return cuenta;
		}
	 
	 
		@SuppressWarnings("unchecked")
		public static List<Cuentas> getCuentas() {
	    		try {
	    			session = ConfigHibernet.abrirConexion();
	 		        cuentas = session.createCriteria(Cuentas.class)
	  					 .add(Restrictions.isNull("fecha_baja"))
	  					 .list();
	 		        ConfigHibernet.commitSession(session);
	    			return cuentas;
	    		} catch (DataAccessException e) {
	    			ConfigHibernet.rollbackSession(session);
	    			return null;
	    		}
	    	
	        
	    }
	 

		public static Cuentas cuentaById(Integer id){
			session = ConfigHibernet.abrirConexion();
			//List<Cuentas> cuentas = session.createCriteria(Cuentas.class).add(Restrictions.eq("idCliente", id)).list();
			 Query q = session.createQuery("from Cuentas where idCuenta = " + id);
			 Cuentas cuentas = (Cuentas) q.uniqueResult();
			 ConfigHibernet.commitSession(session);
			 return cuentas;
		}
		
		public static boolean darDeBajaCuentaPorId( Cuentas cuenta) {
			cuenta.setFecha_baja( Calendar.getInstance().getTime() );
			try {
				session = ConfigHibernet.abrirConexion();
		        session.update(cuenta);
		        session.flush();
		        ConfigHibernet.commitSession(session);
		       	return true;
			}catch(Exception E) {
				System.out.println( E.getMessage() );
				ConfigHibernet.rollbackSession(session);
				return false;
			}
		}
		
		public static boolean modificarCuenta(Cuentas cuenta) {
			try {
			session = ConfigHibernet.abrirConexion();
			System.out.println("cuentasService 137 " + cuenta.getSaldo()  + " id:  " + cuenta.getIdCuenta());
			String q = "update Cuentas c set c.saldo= " + cuenta.getSaldo() + " where c.idCuenta= " + cuenta.getIdCuenta();
	        Query query = session.createQuery(q);
	        query.executeUpdate();
	        session.getTransaction().commit();
	        session.close();
	        return true;
	        }catch(Exception e) {
	        	System.out.println("cuentasService 142" + e.getMessage());
	        	ConfigHibernet.rollbackSession(session);
				return false;
	        }
		}
		
		
		
		 @SuppressWarnings("unchecked")
			public static List<Cuentas> CuentasMovimientosPrestamosByIdCliente(Integer id){
			 	session = ConfigHibernet.abrirConexion(); 	
			 	Query q = session.createQuery("SELECT c FROM Prestamos as p, Movimientos as m , Cuentas as c where p.idCliente ='" + id +"' and p.idMovimiento = m.idMovimiento and m.idCuenta = c.idCuenta" );		 	  
			 	  cuentas = q.list();
				 System.out.println("cuentas-------------------" + cuentas);
				 ConfigHibernet.commitSession(session);
				 return cuentas;
		}
		 
		 public static Map<String, String> datosByCbu( String cbu ){
			 Map<String, String> datos = new HashMap<String, String>();
			 Cuentas ctad= cuentasService.cuentaByCbu(cbu);
			 
			 if(ctad != null) {
				 datos.put("status", "ok" );
				 datos.put("nombre_tit", ctad.getIdCliente().getNombre() );
				 datos.put("apellido_tit", ctad.getIdCliente().getApellido() );
				 datos.put("dni_tit", String.valueOf(ctad.getIdCliente().getDni()) );
				 datos.put("desc_cuenta", ctad.getTipocuenta().getDescripcion() );
			 }else {
				 datos.put("status", "error" );
			 }
			
			 return datos;
		 }
		 
		 public static String idCtaByCbu( String cbu ){
			
			 Cuentas ctad= cuentasService.cuentaByCbu(cbu);
			 
			 if(ctad != null) {
				 return String.valueOf(ctad.getIdCuenta());
			 }else {
				return null;
			 }
			
		 }
		 
		 public static Cuentas cuentaByCbu( String cbu ) {
			 try {
				 session = ConfigHibernet.abrirConexion();
				 Query q = session.createQuery("from Cuentas where cbu =" + cbu);
				 cuenta = (Cuentas) q.uniqueResult();
				 ConfigHibernet.commitSession(session);
				 return cuenta;
			 }catch(Exception e) {
				 ConfigHibernet.rollbackSession(session);
				 return null;
			 }
		 }
		
	
}
