package utn.frgp.edu.ar.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frgp.edu.ar.entidad.Movimientos_Transferencias;

@Service
public class movimientosTransferenciasService {

	@Autowired  
	 private static Session session;
	@Autowired
	private static Movimientos_Transferencias movtrans;

	
	
}
