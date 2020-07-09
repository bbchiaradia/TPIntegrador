package utn.frgp.edu.ar.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.Movimientos;
import utn.frgp.edu.ar.entidad.Movimientos_Transferencias;
import utn.frgp.edu.ar.entidad.TipoCuenta;
import utn.frgp.edu.ar.entidad.Transferencias;

@Service
public class transferenciasService {

	
	@Autowired  
	 private static Session session;
	@Autowired
	 private static List<Transferencias> transferencias;
	
	@Autowired
	private static Transferencias transferencia = new Transferencias();
	
	
	public static boolean saveTransferencia( String ctaorigen, String ctadestino, String monto ) {
		
		Cuentas ctao = cuentasService.cuentaById( Integer.parseInt(ctaorigen) );
		Cuentas ctad = cuentasService.cuentaById( Integer.parseInt(ctadestino) );
		Clientes clilog = clientesService.getClienteLogueado();
		
		transferencia.setCbu_destino( ctad.getCbu() );
		transferencia.setCbu_origen( ctao.getCbu() );
		transferencia.setIdCliente(clilog);
		transferencia.setFecha_alta(Calendar.getInstance().getTime());
		transferencia.setMonto( Double.parseDouble(monto) );
		
		Movimientos mov1 = new Movimientos();
		mov1.setFecha(Calendar.getInstance().getTime());
		mov1.setIdConcepto( conceptosService.getConceptosById(4) );
		mov1.setIdCuenta( ctao );
		mov1.setImporte( Double.parseDouble("-"+monto) );
		
		Movimientos mov2 = new Movimientos();
		mov2.setFecha(Calendar.getInstance().getTime());
		mov2.setIdConcepto( conceptosService.getConceptosById(4) );
		mov2.setIdCuenta( ctad );
		mov2.setImporte( Double.parseDouble(monto) );
		
		Double montoO = ctao.getSaldo();
		montoO = montoO - Double.parseDouble(monto);
		
		Double montoD = ctad.getSaldo();
		montoD = montoD + Double.parseDouble(monto);
		
		ctao.setSaldo(montoO);
		ctad.setSaldo(montoD);
		
		Movimientos_Transferencias movtrans1 = new Movimientos_Transferencias();
		Movimientos_Transferencias movtrans2 = new Movimientos_Transferencias();
		
		movtrans1.setId_movimiento(mov1);
		movtrans1.setIdTransferencia(transferencia);
		
		movtrans2.setId_movimiento(mov2);
		movtrans2.setIdTransferencia(transferencia);
		
		try {
			session = ConfigHibernet.abrirConexion();
			//session.merge(transferencia);
			System.out.println("75");
			
			//session.merge(mov1);
			System.out.println("78");
			
			session.merge(movtrans1);
			System.out.println("81");

			//session.merge(mov2);
			System.out.println("84");
			
			session.merge(movtrans2);
			System.out.println("87");

			session.merge(ctao);
			System.out.println("90");		

			session.merge(ctad);

			System.out.println("96");
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			ConfigHibernet.rollbackSession(session);
			return false;
		}
		
	}
	
}
