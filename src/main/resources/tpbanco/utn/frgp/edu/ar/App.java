package utn.frgp.edu.ar;

import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import utn.frgp.edu.ar.entidad.AdministradorBanco;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Conceptos;
import utn.frgp.edu.ar.entidad.Localidades;
import utn.frgp.edu.ar.entidad.Nacionalidad;
import utn.frgp.edu.ar.entidad.Provincias;
import utn.frgp.edu.ar.entidad.Sexo;
import utn.frgp.edu.ar.entidad.Usuarios;



public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        
        
        /*
         * 
         * 
         *  NICO FLORES    	///////////1//////////////
    	
    	Cuentas cuenta = new Cuentas();
    	cuenta.setIdCliente(1);
    	cuenta.setCbu(564984612);
    	cuenta.setNroCta("22-3443-9");
    	cuenta.setSaldo(1000.10);
    	cuenta.setFecha_alta(Calendar.getInstance().getTime());
        
        TipoCuenta tipocuenta = new TipoCuenta();
        tipocuenta.setDescripcion("Caja de ahorro");
        tipocuenta.setEstado(1);
        
        Movimientos movimiento = new Movimientos(Calendar.getInstance().getTime(), 1, 200);
        Movimientos movimiento2 = new Movimientos(Calendar.getInstance().getTime(), 1, 200);
        ArrayList<Movimientos> listaMov = new ArrayList<Movimientos>();
        listaMov.add(movimiento);
        listaMov.add(movimiento2);
        cuenta.setTipocuenta(tipocuenta);
        cuenta.setListaMovimientos(listaMov);
        ///////////////2//////////
        
        Prestamos prestamo = new Prestamos();
        prestamo.setIdCliente(1);
        prestamo.setIdMovimiento(1); 
        prestamo.setFecha(Calendar.getInstance().getTime());
        prestamo.setImporte(2000);
        prestamo.setCuotas(23);
        prestamo.setPlazo_meses(23);
        prestamo.setFecha_alta(Calendar.getInstance().getTime());
                
        Estados estado = new Estados();
        estado.setDescripcion("Anulado");
        
        prestamo.setId_estado(estado);
        
        session.save(prestamo);
        
        Cuotas cuota = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota2 = new Cuotas( Calendar.getInstance().getTime());
        
        ArrayList<Cuotas> listaCuotas = new ArrayList<Cuotas>();
        listaCuotas.add(cuota);
        listaCuotas.add(cuota2);
		prestamo.setListaCuotas(listaCuotas);
        	
		session.save(prestamo);
         * 
         * 
         * 
         */
        
        
        
          
         //* BELEN CHIARADIA
       
         //****** ---- Prueba relacion  usuario - cliente 1 a 1 
        Clientes cliente = new Clientes();
        cliente.setDni(35718457);
        cliente.setNombre("Belen");
        cliente.setApellido("Chiaradia");
        cliente.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario("bchiaradia2");
        usuario.setContrasenia("prueba2");
        cliente.setIdUsuario(usuario);
        session.save(cliente);
      
        
        /*
        
        //****** ---- Prueba relacion  usuario - admBanco 1 a 1 
        AdministradorBanco admBanco = new AdministradorBanco();
        admBanco.setDni(35718457);
        admBanco.setNombre("Nicolas");
        admBanco.setApellido("Flores");
        Usuarios usuario2 = new Usuarios();
        usuario2.setNombreUsuario("bchiaradia2");
        usuario2.setContrasenia("prueba2");
        admBanco.setIdUsuario(usuario2);
        session.save(admBanco);
        
   
  
        
        //****** ---- Prueba relacion  AdmBanco - cliente 1 a 1 
        
        AdministradorBanco admBanco = new AdministradorBanco();
        admBanco.setDni(35718457);
        admBanco.setNombre("Nicolas");
        admBanco.setApellido("Flores");
        Usuarios usuario2 = new Usuarios();
        usuario2.setNombreUsuario("bchiaradia1");
        usuario2.setContrasenia("prueba1");
        
        admBanco.setIdUsuario(usuario2);
        session.save(admBanco);
        
        
        Clientes cliente = new Clientes();
        cliente.setDni(35718457);
        cliente.setNombre("Belen");
        cliente.setApellido("Chiaradia");
        
        cliente.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario("bchiaradia2");
        usuario.setContrasenia("prueba2");
        
        
        cliente.setIdUsuario(usuario);
        cliente.setIdAdmBanco(admBanco);
        
        session.save(cliente);
        
        
        
      //****** ---- Prueba relacion  sexo - cliente 1 a 1 
        
        Sexo sexo = new Sexo();
        sexo.setDescripcion("Femenino");
        Sexo sexo2 = new Sexo();
        sexo2.setDescripcion("Masculino");
        session.save(sexo);
        session.save(sexo2);
        
        
        Clientes cliente = new Clientes();
        cliente.setDni(35718457);
        cliente.setNombre("Belen");
        cliente.setApellido("Chiaradia");
        cliente.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario("bchiaradia2");
        usuario.setContrasenia("prueba2");
        cliente.setIdSexo(sexo);
        cliente.setIdUsuario(usuario);
        session.save(cliente);
       
        
       
        
        
      //****** ---- Prueba relacion  nacionalidad - cliente 1 a 1 
        
        Sexo sexo = new Sexo();
        sexo.setDescripcion("Femenino");
        Sexo sexo2 = new Sexo();
        sexo2.setDescripcion("Masculino");
        session.save(sexo);
        session.save(sexo2);
        
        Nacionalidad nac = new Nacionalidad();
        nac.setDescripcion("Argentino");
        Nacionalidad nac2 = new Nacionalidad();
        nac2.setDescripcion("Extranjero");
        session.save(nac);
        session.save(nac2);
        
        
        Clientes cliente = new Clientes();
        cliente.setDni(35718457);
        cliente.setNombre("Belen");
        cliente.setApellido("Chiaradia");
        cliente.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario("bchiaradia2");
        usuario.setContrasenia("prueba2");
        cliente.setIdSexo(sexo);
        cliente.setIdNacionalidad(nac);
        cliente.setIdUsuario(usuario);
        session.save(cliente);
        
        
    
        
        //****** ---- Prueba relacion  provincia - cliente 1 a 1 
        
        Sexo sexo = new Sexo();
        sexo.setDescripcion("Femenino");
        Sexo sexo2 = new Sexo();
        sexo2.setDescripcion("Masculino");
        session.save(sexo);
        session.save(sexo2);
        
        Nacionalidad nac = new Nacionalidad();
        nac.setDescripcion("Argentino");
        Nacionalidad nac2 = new Nacionalidad();
        nac2.setDescripcion("Extranjero");
        session.save(nac);
        session.save(nac2);
        
        Provincias prov = new Provincias();
        prov.setDescripcion("Provincia1");
        Provincias prov2 = new Provincias();
        prov2.setDescripcion("Provincia2");
        session.save(prov);
        session.save(prov2);
        
        
        Clientes cliente = new Clientes();
        cliente.setDni(35718457);
        cliente.setNombre("Belen");
        cliente.setApellido("Chiaradia");
        cliente.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario("bchiaradia2");
        usuario.setContrasenia("prueba2");
        cliente.setIdSexo(sexo);
        cliente.setIdProvincia(prov2);
        cliente.setIdNacionalidad(nac);
        cliente.setIdUsuario(usuario);
        session.save(cliente);

      
      
        //****** ---- Prueba relacion  provincia - cliente 1 a 1 
        // Cargo datos en Conceptos
        Conceptos con1= new Conceptos("Alta de Cuenta");
        Conceptos con2= new Conceptos("Alta de Prestamo");

        
        Cuentas cuenta = new Cuentas();
    	cuenta.setIdCliente(1);
    	cuenta.setCbu(564984612);
    	cuenta.setNroCta("22-3443-9");
    	cuenta.setSaldo(1000.10);
    	cuenta.setFecha_alta(Calendar.getInstance().getTime());
        
        TipoCuenta tipocuenta = new TipoCuenta();
        tipocuenta.setDescripcion("Caja de ahorro");
        tipocuenta.setEstado(1);
        
        
        Movimientos movimiento = new Movimientos(Calendar.getInstance().getTime(), con1, 200);
        Movimientos movimiento2 = new Movimientos(Calendar.getInstance().getTime(),con2, 200);
        Movimientos movimiento3 = new Movimientos(Calendar.getInstance().getTime(),con1, 200);
        ArrayList<Movimientos> listaMov = new ArrayList<Movimientos>();
        listaMov.add(movimiento);
        listaMov.add(movimiento2);
        listaMov.add(movimiento3);
        cuenta.setTipocuenta(tipocuenta);
        
       
        cuenta.setListaMovimientos(listaMov);
        
     
        session.save(cuenta);
        
        
        
        
         */
        
                

        
        session.getTransaction().commit();
        
        
        sessionFactory.close();
        
        
    }
}
