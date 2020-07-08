package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.TipoCuenta;

@Service
public class cuentasService {
	
	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Cuentas> cuentas;
	
	@SuppressWarnings("unchecked")
	public static List<TipoCuenta> listarTipoCuentas(){
		session = ConfigHibernet.abrirConexion();
		List<TipoCuenta> tiposcuenta = session.createCriteria(TipoCuenta.class).list();
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
			//List<Cuentas> cuentas = session.createCriteria(Cuentas.class).add(Restrictions.eq("idCliente", id)).list();
			 Query q = session.createQuery("from Cuentas where idCliente = " + id + " and fecha_baja is null");
			 cuentas = q.list();
			 //ConfigHibernet.commitSession(session);
			 return cuentas;
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
			session.update(cuenta);
			session.flush();
	        ConfigHibernet.commitSession(session);
	        return true;
	        }catch(Exception e) {
	        	ConfigHibernet.rollbackSession(session);
				return false;
	        }
		}
	
}
