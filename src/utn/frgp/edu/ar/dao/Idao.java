package utn.frgp.edu.ar.dao;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;

public interface Idao {


	public Clientes AgregarCliente(Clientes cliente) ;
	public boolean EliminarCliente (Integer idcliente);
	public Cuentas LeerCuenta(int id);
	public Cuentas AgregarCuenta(Cuentas cuenta) ;
	public void ModificarCuenta(Cuentas cuenta);
	public void EliminarCuenta (Cuentas cuenta);
	
}
