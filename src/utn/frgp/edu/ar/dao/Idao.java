package utn.frgp.edu.ar.dao;

import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;

public interface Idao {

	public Clientes LeerCliente(int id);
	public Clientes AgregarCliente(Clientes cliente) ;
	public void ModificarCliente(Clientes cliente);
	public void EliminarCliente (Clientes cliente);
	public Cuentas LeerCuenta(int id);
	public Cuentas AgregarCuenta(Cuentas cuenta) ;
	public void ModificarCuenta(Cuentas cuenta);
	public void EliminarCuenta (Cuentas cuenta);
	
}
