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
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.Cuotas;
import utn.frgp.edu.ar.entidad.Estados;
import utn.frgp.edu.ar.entidad.Localidades;
import utn.frgp.edu.ar.entidad.Movimientos;
import utn.frgp.edu.ar.entidad.Movimientos_Transferencias;
import utn.frgp.edu.ar.entidad.Nacionalidad;
import utn.frgp.edu.ar.entidad.Prestamos;
import utn.frgp.edu.ar.entidad.Provincias;
import utn.frgp.edu.ar.entidad.Sexo;
import utn.frgp.edu.ar.entidad.TipoCuenta;
import utn.frgp.edu.ar.entidad.Transferencias;
import utn.frgp.edu.ar.entidad.Usuarios;

public class main {

	 public static void main( String[] args )
    {
		SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
       
        
        // carga provincias
        Provincias provincia1  = new Provincias(1,"Ciudad Autónoma de Buenos Aires (CABA)");
        Provincias provincia2  = new Provincias(2,"Buenos Aires");
        Provincias provincia3  = new Provincias(3,"Catamarca");
        Provincias provincia4  = new Provincias(4,"Córdoba");
        Provincias provincia5  = new Provincias(5,"Corrientes");
        Provincias provincia6  = new Provincias(6,"Entre Ríos");
        Provincias provincia7  = new Provincias(7,"Jujuy");
        Provincias provincia8  = new Provincias(8,"Mendoza");
        Provincias provincia9  = new Provincias(9,"La Rioja");
        Provincias provincia10 = new Provincias(10,"Salta");
        Provincias provincia11 = new Provincias(11,"San Juan");
        Provincias provincia12 = new Provincias(12,"San Luis");
        Provincias provincia13 = new Provincias(13,"Santa Fe");
        Provincias provincia14 = new Provincias(14,"Santiago del Estero");
        Provincias provincia15 = new Provincias(15,"Tucumán");
        Provincias provincia16 = new Provincias(16,"Chaco");
        Provincias provincia17 = new Provincias(17,"Chubut");
        Provincias provincia18 = new Provincias(18,"Formosa");
        Provincias provincia19 = new Provincias(19,"Misiones");
        Provincias provincia20 = new Provincias(20,"Neuquén");
        Provincias provincia21 = new Provincias(21,"La Pampa");
        Provincias provincia22 = new Provincias(22,"Río Negro");
        Provincias provincia23 = new Provincias(23,"Santa Cruz");
        Provincias provincia24 = new Provincias(24,"Tierra del Fuego");
        session.save(provincia1); 
        session.save(provincia2); 
        session.save(provincia3); 
        session.save(provincia4); 
        session.save(provincia5); 
        session.save(provincia6); 
        session.save(provincia7); 
        session.save(provincia8); 
        session.save(provincia9); 
        session.save(provincia10);
        session.save(provincia11);
        session.save(provincia12);
        session.save(provincia13);
        session.save(provincia14);
        session.save(provincia15);
        session.save(provincia16);
        session.save(provincia17);
        session.save(provincia18);
        session.save(provincia19);
        session.save(provincia20);
        session.save(provincia21);
        session.save(provincia22);
        session.save(provincia23);
        session.save(provincia24);
        
        
        // cargo localidades
        
        Localidades localidad1 = new Localidades(provincia1,"PALERMO","7112");
        Localidades localidad2 = new Localidades(provincia1,"BELGRANO","7103");
        Localidades localidad3 = new Localidades(provincia2,"COSTA AZUL","7112");
        Localidades localidad4 = new Localidades(provincia2,"FARO SAN ANTONIO","7103");
        Localidades localidad5 = new Localidades(provincia3,"LA CARRERA","4711");
        Localidades localidad6 = new Localidades(provincia3,"LA FALDA DE SAN ANTONIO","4707");
        Localidades localidad7 = new Localidades(provincia4,"LOS MOLINOS","5189");
        Localidades localidad8 = new Localidades(provincia4,"RIO DE LOS SAUCES","5821");
        Localidades localidad9 = new Localidades(provincia5,"INGA","3196");
        Localidades localidad10= new Localidades(provincia5,"JESUS MARIA","3196");
        Localidades localidad11= new Localidades(provincia6,"SAN JULIAN","2841");
        Localidades localidad12= new Localidades(provincia6,"SANTA MARTA","2840");
        Localidades localidad13= new Localidades(provincia7,"REDONDA","4644");
        Localidades localidad14= new Localidades(provincia7,"RIO COLORADO","4644");
        Localidades localidad15= new Localidades(provincia8,"CERRO NEVADO","5621");
        Localidades localidad16= new Localidades(provincia8,"COCHICO","5621");
        Localidades localidad17= new Localidades(provincia9,"SAN ANTONIO","5310");
        Localidades localidad18= new Localidades(provincia9,"TERMAS DE SANTA TERESITA","5313");
        Localidades localidad19= new Localidades(provincia10,"SALADILLO","4434");
        Localidades localidad20= new Localidades(provincia10,"SAN GABRIEL","4452");
        Localidades localidad21= new Localidades(provincia11,"JUAN CELANI","5427");
        Localidades localidad22= new Localidades(provincia11,"LA CALLECITA","5421");
        Localidades localidad23= new Localidades(provincia12,"PASO LOS ALGARROBOS","5724");
        Localidades localidad24= new Localidades(provincia12,"POTRERO DE LOS FUNES","5701");
        Localidades localidad25= new Localidades(provincia13,"CABEZA DE CHANCHO","3061");
        Localidades localidad26= new Localidades(provincia13,"CAMPO GARAY","3066");
        Localidades localidad27= new Localidades(provincia14,"LAS ORELLANAS","4304");
        Localidades localidad28= new Localidades(provincia14,"POZO HONDO","4184");
        Localidades localidad29= new Localidades(provincia15,"CAMPO GRANDE","4159");
        Localidades localidad30= new Localidades(provincia15,"CAMPO LA CRUZ","4161");
        Localidades localidad31= new Localidades(provincia16,"GIRASOL","3703");
        Localidades localidad32= new Localidades(provincia16,"KILOMETRO 15","3700");
        Localidades localidad33= new Localidades(provincia17,"CASA BLANCA","9220");
        Localidades localidad34= new Localidades(provincia17,"CERRO NEGRO","9223");
        Localidades localidad35= new Localidades(provincia18,"ISLA GRAL BELGRANO","3610");
        Localidades localidad36= new Localidades(provincia18,"POSTA SANTA FE","3630");
        Localidades localidad37= new Localidades(provincia19,"VILLA ERRECABORDE","3350");
        Localidades localidad38= new Localidades(provincia19,"VILLA ORTIZ PEREIRA","3358");
        Localidades localidad39= new Localidades(provincia20,"COLLON CURA","8375");
        Localidades localidad40= new Localidades(provincia20,"QUEMQUEMTREU","8375");
        Localidades localidad41= new Localidades(provincia21,"COLONIA EL SAUZAL","8201");
        Localidades localidad42= new Localidades(provincia21,"CASA DE PIEDRA","8201");
        Localidades localidad43= new Localidades(provincia20,"LA OFELIA","8341");
        Localidades localidad44= new Localidades(provincia20,"LAGOTERA","8345");
        Localidades localidad45= new Localidades(provincia21,"COLONIA SOBADELL","6301");
        Localidades localidad46= new Localidades(provincia21,"DOBLAS","6305");
        Localidades localidad47= new Localidades(provincia22,"EL CAIN","8422");
        Localidades localidad48= new Localidades(provincia22,"EL CHEIFUL","8418");
        Localidades localidad49= new Localidades(provincia23,"LA AGUADA","9051");
        Localidades localidad50= new Localidades(provincia23,"LA ESTELA","9051");
        Localidades localidad51= new Localidades(provincia24,"SAN SEBASTIAN","9420");
        Localidades localidad52= new Localidades(provincia24,"SANTA INES","9420");
        session.save(localidad1);
        session.save(localidad2);
        session.save(localidad3);
        session.save(localidad4);
        session.save(localidad5);
        session.save(localidad6);
        session.save(localidad7);
        session.save(localidad8);
        session.save(localidad9);
        session.save(localidad10);
        session.save(localidad11);
        session.save(localidad12);
        session.save(localidad13);
        session.save(localidad14);
        session.save(localidad15);
        session.save(localidad16);
        session.save(localidad17);
        session.save(localidad18);
        session.save(localidad19);
        session.save(localidad20);
        session.save(localidad21);
        session.save(localidad22);
        session.save(localidad23);
        session.save(localidad24);
        session.save(localidad25);
        session.save(localidad26);
        session.save(localidad27);
        session.save(localidad28);
        session.save(localidad29);
        session.save(localidad30);
        session.save(localidad31);
        session.save(localidad32);
        session.save(localidad33);
        session.save(localidad34);
        session.save(localidad35);
        session.save(localidad36);
        session.save(localidad37);
        session.save(localidad38);
        session.save(localidad39);           
        session.save(localidad40);    
        session.save(localidad41);   
        session.save(localidad42);   
        session.save(localidad43);   
        session.save(localidad44);   
        session.save(localidad45);    
        session.save(localidad46);    
        session.save(localidad47);    
        session.save(localidad48);    
        session.save(localidad49);    
        session.save(localidad50);    
        session.save(localidad51);    
        session.save(localidad52); 
        
        
        //Cargo datos en sexo
        Sexo sexo = new Sexo();
        sexo.setDescripcion("Femenino");
        Sexo sexo2 = new Sexo();
        sexo2.setDescripcion("Masculino");
        session.save(sexo);
        session.save(sexo2);
        
        
        //Cargo datos en nacionalidad
        Nacionalidad nac = new Nacionalidad();
        nac.setDescripcion("Argentino");
        Nacionalidad nac2 = new Nacionalidad();
        nac2.setDescripcion("Extranjero");
        session.save(nac);
        session.save(nac2);
        
        
        //Cargo datos en administradorBanco y usuarios
        AdministradorBanco admBanco = new AdministradorBanco();
        admBanco.setDni(35718457);
        admBanco.setNombre("Nicolas");
        admBanco.setApellido("Flores");
        Usuarios usuario = new Usuarios();
        usuario.setFecha_alta(Calendar.getInstance().getTime());
        usuario.setNombreUsuario("nflores");
        usuario.setContrasenia("prueba1");
        admBanco.setIdUsuario(usuario);
        session.save(usuario);
        session.save(admBanco);
        AdministradorBanco admBanco1 = new AdministradorBanco();
        admBanco1.setDni(35718257);
        admBanco1.setNombre("Belen");
        admBanco1.setApellido("Chiaradia");
        Usuarios usuario1 = new Usuarios();
        usuario1.setFecha_alta(Calendar.getInstance().getTime());
        usuario1.setNombreUsuario("bchiaradia");
        usuario1.setContrasenia("prueba1");
        admBanco1.setIdUsuario(usuario1);
        session.save(usuario1);
        session.save(admBanco1);
        AdministradorBanco admBanco2 = new AdministradorBanco();
        admBanco2.setDni(25718457);
        admBanco2.setNombre("Ivan");
        admBanco2.setApellido("Fernandez");
        Usuarios usuario2 = new Usuarios();
        usuario2.setFecha_alta(Calendar.getInstance().getTime());
        usuario2.setNombreUsuario("ifernandez");
        usuario2.setContrasenia("prueba1");
        admBanco2.setIdUsuario(usuario2);
        session.save(usuario2);
        session.save(admBanco2);
        AdministradorBanco admBanco3 = new AdministradorBanco();
        admBanco3.setDni(32518457);
        admBanco3.setNombre("Nicolas");
        admBanco3.setApellido("Mansilla");
        Usuarios usuario3 = new Usuarios();
        usuario3.setFecha_alta(Calendar.getInstance().getTime());
        usuario3.setNombreUsuario("nmansilla");
        usuario3.setContrasenia("prueba1");
        admBanco3.setIdUsuario(usuario3);
        session.save(usuario3);
        session.save(admBanco3);
        AdministradorBanco admBanco4 = new AdministradorBanco();
        admBanco4.setDni(35561457);
        admBanco4.setNombre("Ezequiel");
        admBanco4.setApellido("Gomez");
        Usuarios usuario4 = new Usuarios();
        usuario4.setFecha_alta(Calendar.getInstance().getTime());
        usuario4.setNombreUsuario("egomez");
        usuario4.setContrasenia("prueba1");
        admBanco4.setIdUsuario(usuario4);
        session.save(usuario4);
        session.save(admBanco4);
        AdministradorBanco admBanco5 = new AdministradorBanco();
        admBanco5.setDni(35694357);
        admBanco5.setNombre("Julian");
        admBanco5.setApellido("Hermann");
        Usuarios usuario5 = new Usuarios();
        usuario5.setFecha_alta(Calendar.getInstance().getTime());
        usuario5.setNombreUsuario("jhermann");
        usuario5.setContrasenia("prueba1");
        admBanco5.setIdUsuario(usuario5);
        session.save(usuario5);
        session.save(admBanco5);
        AdministradorBanco admBanco6 = new AdministradorBanco();
        admBanco6.setDni(26948457);
        admBanco6.setNombre("Leon");
        admBanco6.setApellido("Cuello");
        Usuarios usuario6 = new Usuarios();
        usuario6.setFecha_alta(Calendar.getInstance().getTime());
        usuario6.setNombreUsuario("lcuello");
        usuario6.setContrasenia("prueba1");
        admBanco6.setIdUsuario(usuario6);
        session.save(usuario6);
        session.save(admBanco6);
        AdministradorBanco admBanco7 = new AdministradorBanco();
        admBanco7.setDni(11718457);
        admBanco7.setNombre("Matias");
        admBanco7.setApellido("Civielo");
        Usuarios usuario7 = new Usuarios();
        usuario7.setFecha_alta(Calendar.getInstance().getTime());
        usuario7.setNombreUsuario("mcivielo");
        usuario7.setContrasenia("prueba1");
        admBanco7.setIdUsuario(usuario7);
        session.save(usuario7);
        session.save(admBanco7);
        AdministradorBanco admBanco8 = new AdministradorBanco();
        admBanco8.setDni(35796757);
        admBanco8.setNombre("Julieta");
        admBanco8.setApellido("Fadini");
        Usuarios usuario8 = new Usuarios();
        usuario8.setFecha_alta(Calendar.getInstance().getTime());
        usuario8.setNombreUsuario("jfadini");
        usuario8.setContrasenia("prueba1");
        admBanco8.setIdUsuario(usuario8);
        session.save(usuario8);
        session.save(admBanco8);
        AdministradorBanco admBanco9 = new AdministradorBanco();
        admBanco9.setDni(24425457);
        admBanco9.setNombre("Tomas");
        admBanco9.setApellido("Hernandez");
        Usuarios usuario9 = new Usuarios();
        usuario9.setFecha_alta(Calendar.getInstance().getTime());
        usuario9.setNombreUsuario("thernandez");
        usuario9.setContrasenia("prueba1");
        admBanco9.setIdUsuario(usuario9);
        session.save(usuario9);
        session.save(admBanco9);
        
        
        //Cargo datos en clientes y usuarios
        Clientes cliente = new Clientes();
        cliente.setDni(45718457);
        cliente.setNombre("Jazmin");
        cliente.setApellido("Fernandez");
        cliente.setIdSexo(sexo);
        cliente.setIdNacionalidad(nac);
        cliente.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente.setIdProvincia(provincia2);
        cliente.setIdLocalidad(localidad3);
        cliente.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario10 = new Usuarios();
        usuario10.setFecha_alta(Calendar.getInstance().getTime());
        usuario10.setNombreUsuario("jfernandez");
        usuario10.setContrasenia("prueba2");
        cliente.setIdUsuario(usuario10);
        cliente.setIdAdmBanco(admBanco);
        session.save(usuario10);
        session.save(cliente);
        
        Clientes cliente1 = new Clientes();
        cliente1.setDni(10718457);
        cliente1.setNombre("Celia");
        cliente1.setApellido("Hermann");
        cliente1.setIdSexo(sexo);
        cliente1.setIdNacionalidad(nac);
        cliente1.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente1.setIdProvincia(provincia2);
        cliente1.setIdLocalidad(localidad3);
        cliente1.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario11 = new Usuarios();
        usuario11.setFecha_alta(Calendar.getInstance().getTime());
        usuario11.setNombreUsuario("chermann");
        usuario11.setContrasenia("prueba2");
        cliente1.setIdUsuario(usuario11);
        cliente1.setIdAdmBanco(admBanco1);
        session.save(usuario11);
        session.save(cliente1);
        
        Clientes cliente2 = new Clientes();
        cliente2.setDni(22718457);
        cliente2.setNombre("Claudia");
        cliente2.setApellido("Bastias");
        cliente2.setIdSexo(sexo);
        cliente2.setIdNacionalidad(nac);
        cliente2.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente2.setIdProvincia(provincia2);
        cliente2.setIdLocalidad(localidad3);
        cliente2.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario12 = new Usuarios();
        usuario12.setFecha_alta(Calendar.getInstance().getTime());
        usuario12.setNombreUsuario("cbastias");
        usuario12.setContrasenia("prueba2");
        cliente2.setIdUsuario(usuario12);
        cliente2.setIdAdmBanco(admBanco2);
        session.save(usuario12);
        session.save(cliente2);
        
        Clientes cliente3 = new Clientes();
        cliente3.setDni(26718457);
        cliente3.setNombre("Natalia");
        cliente3.setApellido("Gonzalez");
        cliente3.setIdSexo(sexo);
        cliente3.setIdNacionalidad(nac);
        cliente3.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente3.setIdProvincia(provincia2);
        cliente3.setIdLocalidad(localidad3);
        cliente3.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario13 = new Usuarios();
        usuario13.setFecha_alta(Calendar.getInstance().getTime());
        usuario13.setNombreUsuario("ngonzalez");
        usuario13.setContrasenia("prueba2");
        cliente3.setIdUsuario(usuario13);
        cliente3.setIdAdmBanco(admBanco3);
        session.save(usuario13);
        session.save(cliente3);
        
        Clientes cliente4 = new Clientes();
        cliente4.setDni(23718457);
        cliente4.setNombre("Josefina");
        cliente4.setApellido("Kinen");
        cliente4.setIdSexo(sexo);
        cliente4.setIdNacionalidad(nac);
        cliente4.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente4.setIdProvincia(provincia2);
        cliente4.setIdLocalidad(localidad3);
        cliente4.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario14 = new Usuarios();
        usuario14.setFecha_alta(Calendar.getInstance().getTime());
        usuario14.setNombreUsuario("jkinen");
        usuario14.setContrasenia("prueba2");
        cliente4.setIdUsuario(usuario14);
        cliente4.setIdAdmBanco(admBanco4);
        session.save(usuario14);
        session.save(cliente4);
        
        Clientes cliente5 = new Clientes();
        cliente5.setDni(21718457);
        cliente5.setNombre("Luca");
        cliente5.setApellido("Kinen");
        cliente5.setIdSexo(sexo2);
        cliente5.setIdNacionalidad(nac);
        cliente5.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente5.setIdProvincia(provincia2);
        cliente5.setIdLocalidad(localidad3);
        cliente5.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario15 = new Usuarios();
        usuario15.setFecha_alta(Calendar.getInstance().getTime());
        usuario15.setNombreUsuario("lkinen");
        usuario15.setContrasenia("prueba2");
        cliente5.setIdUsuario(usuario15);
        cliente5.setIdAdmBanco(admBanco5);
        session.save(usuario15);
        session.save(cliente5);
        
        Clientes cliente6 = new Clientes();
        cliente6.setDni(13718457);
        cliente6.setNombre("Braian");
        cliente6.setApellido("Fernandez");
        cliente6.setIdSexo(sexo2);
        cliente6.setIdNacionalidad(nac);
        cliente6.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente6.setIdProvincia(provincia2);
        cliente6.setIdLocalidad(localidad4);
        cliente6.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario16 = new Usuarios();
        usuario16.setFecha_alta(Calendar.getInstance().getTime());
        usuario16.setNombreUsuario("bfernandez");
        usuario16.setContrasenia("prueba2");
        cliente6.setIdUsuario(usuario16);
        cliente6.setIdAdmBanco(admBanco6);
        session.save(usuario16);
        session.save(cliente6);
        
        Clientes cliente7 = new Clientes();
        cliente7.setDni(15718457);
        cliente7.setNombre("Santiago");
        cliente7.setApellido("Gonzalez");
        cliente7.setIdSexo(sexo2);
        cliente7.setIdNacionalidad(nac);
        cliente7.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente7.setIdProvincia(provincia2);
        cliente7.setIdLocalidad(localidad4);
        cliente7.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario17 = new Usuarios();
        usuario17.setFecha_alta(Calendar.getInstance().getTime());
        usuario17.setNombreUsuario("sgonzalez");
        usuario17.setContrasenia("prueba2");
        cliente7.setIdUsuario(usuario17);
        cliente7.setIdAdmBanco(admBanco7);
        session.save(usuario17);
        session.save(cliente7);
        
        Clientes cliente8 = new Clientes();
        cliente8.setDni(14918457);
        cliente8.setNombre("Luciano");
        cliente8.setApellido("Salomon");
        cliente8.setIdSexo(sexo2);
        cliente8.setIdNacionalidad(nac);
        cliente8.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente8.setIdProvincia(provincia2);
        cliente8.setIdLocalidad(localidad4);
        cliente8.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario18 = new Usuarios();
        usuario18.setFecha_alta(Calendar.getInstance().getTime());
        usuario18.setNombreUsuario("lsalomon");
        usuario18.setContrasenia("prueba2");
        cliente8.setIdUsuario(usuario18);
        cliente8.setIdAdmBanco(admBanco8);
        session.save(usuario18);
        session.save(cliente8);
        
        Clientes cliente9 = new Clientes();
        cliente9.setDni(11618457);
        cliente9.setNombre("Marcelo");
        cliente9.setApellido("Salomon");
        cliente9.setIdSexo(sexo2);
        cliente9.setIdNacionalidad(nac);
        cliente9.setFecha_nacimiento(Calendar.getInstance().getTime());
        cliente9.setIdProvincia(provincia2);
        cliente9.setIdLocalidad(localidad4);
        cliente9.setFecha_alta(Calendar.getInstance().getTime());
        Usuarios usuario19 = new Usuarios();
        usuario19.setFecha_alta(Calendar.getInstance().getTime());
        usuario19.setNombreUsuario("msalomon");
        usuario19.setContrasenia("prueba2");
        cliente9.setIdUsuario(usuario19);
        cliente9.setIdAdmBanco(admBanco9);
        session.save(usuario19);
        session.save(cliente9);
        
        
        // Cargo datos en Conceptos
        Conceptos con1= new Conceptos("Alta de Cuenta");
        Conceptos con2= new Conceptos("Alta de Prestamo");
        Conceptos con3= new Conceptos("Pago de Prestamo");
        Conceptos con4= new Conceptos("Transferencia");
        session.save(con1); 
        session.save(con2); 
        session.save(con3); 
        session.save(con4); 
        
        
        //Cargo datos en tipo cuenta
        TipoCuenta tipo1=new TipoCuenta();
        tipo1.setDescripcion("Caja de ahorro en pesos");
        tipo1.setEstado(1);
        session.save(tipo1);
        TipoCuenta tipo2=new TipoCuenta();
        tipo2.setDescripcion("Caja de ahorro en d�lares");
        tipo2.setEstado(1);
        session.save(tipo2);
        TipoCuenta tipo3=new TipoCuenta();
        tipo3.setDescripcion("Cuenta corriente");
        tipo3.setEstado(1);
        session.save(tipo3);
        TipoCuenta tipo4=new TipoCuenta();
        tipo4.setDescripcion("Cuenta corriente especial en pesos");
        tipo4.setEstado(1);
        session.save(tipo4);
        TipoCuenta tipo5=new TipoCuenta();
        tipo5.setDescripcion("Cuenta corriente especial en d�lares");
        tipo5.setEstado(1);
        session.save(tipo5);
        
        
        //Cargo datos en estados
        Estados estado1=new Estados();
        estado1.setDescripcion("Aprobado");
        session.save(estado1);
        Estados estado2=new Estados();
        estado2.setDescripcion("Rechazado");
        session.save(estado2);
        Estados estado3=new Estados();
        estado3.setDescripcion("Pendiente");
        session.save(estado3);
        
        
        //Cargo datos en cuentas
        Cuentas cuenta=new Cuentas(cliente,591661,"111111",5000,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo1);
        session.save(cuenta);
        Cuentas cuenta1=new Cuentas(cliente1,561661,"222222",10000,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo3);
        session.save(cuenta1);
        Cuentas cuenta2=new Cuentas(cliente2,461661,"333333",50000,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo1);
        session.save(cuenta2);
        Cuentas cuenta3=new Cuentas(cliente3,361661,"444444",1000,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo2);
        session.save(cuenta3);
        Cuentas cuenta4=new Cuentas(cliente4,261661,"555555",2000,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo3);
        session.save(cuenta4);
        Cuentas cuenta5=new Cuentas(cliente5,161661,"666666",500,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo2);
        session.save(cuenta5);
        Cuentas cuenta6=new Cuentas(cliente6,661661,"777777",1500,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo2);
        session.save(cuenta6);
        Cuentas cuenta7=new Cuentas(cliente7,761661,"888888",5600,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo4);
        session.save(cuenta7);
        Cuentas cuenta8=new Cuentas(cliente8,861661,"999999",6000,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo5);
        session.save(cuenta8);
        Cuentas cuenta9=new Cuentas(cliente9,961661,"101010",800,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo4);
        session.save(cuenta9);
        Cuentas cuenta10=new Cuentas(cliente9,96166155,"1010102",10000,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),tipo5);
        session.save(cuenta10);
        
        
        

        
        //Cargo datos en prestamos y movimientos
        Prestamos prestamo=new Prestamos();
        prestamo.setIdCliente(cliente);
        prestamo.setId_estado(estado1);
        prestamo.setFecha(Calendar.getInstance().getTime());
        prestamo.setFecha_alta(Calendar.getInstance().getTime());
        prestamo.setFecha_baja(Calendar.getInstance().getTime());
        prestamo.setImporte(15000);
        prestamo.setCuotas(6);
        Movimientos movimiento=new Movimientos(Calendar.getInstance().getTime(),con2,15000);
        ArrayList<Movimientos> listaMov = new ArrayList<Movimientos>();
        listaMov.add(movimiento);
        cuenta.setListaMovimientos(listaMov);
        prestamo.setIdMovimiento(movimiento);
        session.save(movimiento);
        session.save(prestamo);
        // cargo cuotas prestamo 1
        Cuotas cuota1 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota2 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota3 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota4 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota5 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota6 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas = new ArrayList<Cuotas>();
        listaCuotas.add(cuota1);
        listaCuotas.add(cuota2);
        listaCuotas.add(cuota3);
        listaCuotas.add(cuota4);
        listaCuotas.add(cuota5);
        listaCuotas.add(cuota6);
		prestamo.setListaCuotas(listaCuotas);
		session.save(prestamo);
		
	      
		
		Prestamos prestamo2=new Prestamos();
        prestamo2.setIdCliente(cliente1);
        prestamo2.setId_estado(estado1);
        prestamo2.setFecha(Calendar.getInstance().getTime());
        prestamo2.setFecha_alta(Calendar.getInstance().getTime());
        prestamo2.setFecha_baja(Calendar.getInstance().getTime());
        prestamo2.setImporte(150000);
        prestamo2.setCuotas(3);
        Movimientos movimiento2=new Movimientos(Calendar.getInstance().getTime(),con2,150000);
        ArrayList<Movimientos> listaMov2 = new ArrayList<Movimientos>();
        listaMov2.add(movimiento2);
        cuenta1.setListaMovimientos(listaMov2);
        prestamo2.setIdMovimiento(movimiento2);
        session.save(movimiento2);
        session.save(prestamo2);
        Cuotas cuota7 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota8 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota9 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas2 = new ArrayList<Cuotas>();
        listaCuotas2.add(cuota7);
        listaCuotas2.add(cuota8);
        listaCuotas2.add(cuota9);
		prestamo2.setListaCuotas(listaCuotas2);
		session.save(prestamo2);
		
		
		
		Prestamos prestamo3=new Prestamos();
        prestamo3.setIdCliente(cliente2);
        prestamo3.setId_estado(estado1);
        prestamo3.setFecha(Calendar.getInstance().getTime());
        prestamo3.setFecha_alta(Calendar.getInstance().getTime());
        prestamo3.setFecha_baja(Calendar.getInstance().getTime());
        prestamo3.setImporte(5000);
        prestamo3.setCuotas(4);
        Movimientos movimiento3=new Movimientos(Calendar.getInstance().getTime(),con2,5000);
        ArrayList<Movimientos> listaMov3 = new ArrayList<Movimientos>();
        listaMov3.add(movimiento3);
        cuenta2.setListaMovimientos(listaMov3);
        prestamo3.setIdMovimiento(movimiento3);
        session.save(movimiento3);
        session.save(prestamo3);
        Cuotas cuota10 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota11 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota12 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota13 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas3 = new ArrayList<Cuotas>();
        listaCuotas3.add(cuota10);
        listaCuotas3.add(cuota11);
        listaCuotas3.add(cuota12);
        listaCuotas3.add(cuota13);
		prestamo3.setListaCuotas(listaCuotas3);
		session.save(prestamo3);
        
        
		
		Prestamos prestamo4=new Prestamos();
        prestamo4.setIdCliente(cliente3);
        prestamo4.setId_estado(estado1);
        prestamo4.setFecha(Calendar.getInstance().getTime());
        prestamo4.setFecha_alta(Calendar.getInstance().getTime());
        prestamo4.setFecha_baja(Calendar.getInstance().getTime());
        prestamo4.setImporte(25000);
        prestamo4.setCuotas(2);
        Movimientos movimiento4=new Movimientos(Calendar.getInstance().getTime(),con2,25000);
        ArrayList<Movimientos> listaMov4 = new ArrayList<Movimientos>();
        listaMov4.add(movimiento4);
        cuenta3.setListaMovimientos(listaMov4);
        prestamo4.setIdMovimiento(movimiento4);
        session.save(movimiento4);
        session.save(prestamo4);
        Cuotas cuota14 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota15 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas4 = new ArrayList<Cuotas>();
        listaCuotas4.add(cuota14);
        listaCuotas4.add(cuota15);
		prestamo4.setListaCuotas(listaCuotas4);
		session.save(prestamo4);
        
		

		
		Prestamos prestamo5=new Prestamos();
        prestamo5.setIdCliente(cliente4);
        prestamo5.setId_estado(estado1);
        prestamo5.setFecha(Calendar.getInstance().getTime());
        prestamo5.setFecha_alta(Calendar.getInstance().getTime());
        prestamo5.setFecha_baja(Calendar.getInstance().getTime());
        prestamo5.setImporte(45000);
        prestamo5.setCuotas(3);
        Movimientos movimiento5=new Movimientos(Calendar.getInstance().getTime(),con2,45000);
        ArrayList<Movimientos> listaMov5 = new ArrayList<Movimientos>();
        listaMov5.add(movimiento5);
        cuenta4.setListaMovimientos(listaMov5);
        prestamo5.setIdMovimiento(movimiento5);
        session.save(movimiento5);
        session.save(prestamo5);
        Cuotas cuota16 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota17 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota18 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas5 = new ArrayList<Cuotas>();
        listaCuotas5.add(cuota16);
        listaCuotas5.add(cuota17);
        listaCuotas5.add(cuota18);
		prestamo5.setListaCuotas(listaCuotas5);
		session.save(prestamo5);
		
		
		
		Prestamos prestamo7=new Prestamos();
        prestamo7.setIdCliente(cliente5);
        prestamo7.setId_estado(estado2);
        prestamo7.setFecha(Calendar.getInstance().getTime());
        prestamo7.setFecha_alta(Calendar.getInstance().getTime());
        prestamo7.setFecha_baja(Calendar.getInstance().getTime());
        prestamo7.setImporte(10000);
        prestamo7.setCuotas(2);
        Movimientos movimiento7=new Movimientos(Calendar.getInstance().getTime(),con2,10000);
        ArrayList<Movimientos> listaMov7 = new ArrayList<Movimientos>();
        listaMov7.add(movimiento7);
        cuenta5.setListaMovimientos(listaMov7);
        prestamo7.setIdMovimiento(movimiento7);
        session.save(movimiento7);
        session.save(prestamo7);
        /*Cuotas cuota21 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota22 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas7 = new ArrayList<Cuotas>();
        listaCuotas7.add(cuota21);
        listaCuotas7.add(cuota22);
		prestamo7.setListaCuotas(listaCuotas7);*/
		session.save(prestamo7);

		
		
		
		Prestamos prestamo8=new Prestamos();
        prestamo8.setIdCliente(cliente6);
        prestamo8.setId_estado(estado3);
        prestamo8.setFecha(Calendar.getInstance().getTime());
        prestamo8.setFecha_alta(Calendar.getInstance().getTime());
        prestamo8.setFecha_baja(Calendar.getInstance().getTime());
        prestamo8.setImporte(7800);
        prestamo8.setCuotas(3);
        Movimientos movimiento8=new Movimientos(Calendar.getInstance().getTime(),con2,7800);
        ArrayList<Movimientos> listaMov8 = new ArrayList<Movimientos>();
        listaMov8.add(movimiento8);
        cuenta6.setListaMovimientos(listaMov8);
        prestamo8.setIdMovimiento(movimiento8);
        session.save(movimiento8);
        session.save(prestamo8);
        /* Cuotas cuota23 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota24 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota25 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas8 = new ArrayList<Cuotas>();
        listaCuotas8.add(cuota23);
        listaCuotas8.add(cuota24);
        listaCuotas8.add(cuota25);
		prestamo8.setListaCuotas(listaCuotas8); */
		session.save(prestamo8);
		
		
		Prestamos prestamo9=new Prestamos();
        prestamo9.setIdCliente(cliente8);
        prestamo9.setId_estado(estado1);
        prestamo9.setFecha(Calendar.getInstance().getTime());
        prestamo9.setFecha_alta(Calendar.getInstance().getTime());
        prestamo9.setFecha_baja(Calendar.getInstance().getTime());
        prestamo9.setImporte(7900);
        prestamo9.setCuotas(3);
        Movimientos movimiento9=new Movimientos(Calendar.getInstance().getTime(),con2,7900);
        ArrayList<Movimientos> listaMov9 = new ArrayList<Movimientos>();
        listaMov9.add(movimiento9);
        cuenta8.setListaMovimientos(listaMov9);
        prestamo9.setIdMovimiento(movimiento9);
        session.save(movimiento9);
        session.save(prestamo9);
        Cuotas cuota26 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota27 = new Cuotas( Calendar.getInstance().getTime());
        Cuotas cuota28 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas9 = new ArrayList<Cuotas>();
        listaCuotas9.add(cuota26);
        listaCuotas9.add(cuota27);
        listaCuotas9.add(cuota28);
		prestamo9.setListaCuotas(listaCuotas9);
		session.save(prestamo9);
		
		
		Prestamos prestamo10=new Prestamos();
        prestamo10.setIdCliente(cliente7);
        prestamo10.setId_estado(estado1);
        prestamo10.setFecha(Calendar.getInstance().getTime());
        prestamo10.setFecha_alta(Calendar.getInstance().getTime());
        prestamo10.setFecha_baja(Calendar.getInstance().getTime());
        prestamo10.setImporte(1500);
        prestamo10.setCuotas(1);
        Movimientos movimiento10=new Movimientos(Calendar.getInstance().getTime(),con2,1500);
        ArrayList<Movimientos> listaMov10 = new ArrayList<Movimientos>();
        listaMov10.add(movimiento10);
        cuenta7.setListaMovimientos(listaMov10);
        prestamo10.setIdMovimiento(movimiento10);
        session.save(movimiento10);
        session.save(prestamo10);
        Cuotas cuota29 = new Cuotas( Calendar.getInstance().getTime());
        ArrayList<Cuotas> listaCuotas10 = new ArrayList<Cuotas>();
        listaCuotas10.add(cuota29);
		prestamo10.setListaCuotas(listaCuotas10);
		session.save(prestamo10);
		
		
		Prestamos prestamo11=new Prestamos();
        prestamo11.setIdCliente(cliente9);
        prestamo11.setId_estado(estado1);
        prestamo11.setFecha(Calendar.getInstance().getTime());
        prestamo11.setFecha_alta(Calendar.getInstance().getTime());
        prestamo11.setFecha_baja(Calendar.getInstance().getTime());
        prestamo11.setImporte(100);
        prestamo11.setCuotas(3);
        Movimientos movimiento11=new Movimientos(Calendar.getInstance().getTime(),con2,100);
        ArrayList<Movimientos> listaMov11 = new ArrayList<Movimientos>();
        listaMov11.add(movimiento11);
        cuenta10.setListaMovimientos(listaMov11);
        prestamo11.setIdMovimiento(movimiento11);
        session.save(movimiento11);
        session.save(prestamo11);
  
      

        //Transferencias
      		Transferencias transferencia1 = new Transferencias();
              transferencia1.setIdCliente(cliente1);
              transferencia1.setCbu_origen(591661);
              transferencia1.setCbu_destino(561661);
              transferencia1.setMonto(100);
              transferencia1.setFecha_alta(Calendar.getInstance().getTime());
              transferencia1.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento12=new Movimientos(Calendar.getInstance().getTime(),con4,-100);
              ArrayList<Movimientos> listaMov12 = new ArrayList<Movimientos>();
              listaMov12.add(movimiento12);
              //credito a destino
              Movimientos movimiento13=new Movimientos(Calendar.getInstance().getTime(),con4,100);
              ArrayList<Movimientos> listaMov13 = new ArrayList<Movimientos>();
              listaMov13.add(movimiento13);
              cuenta1.setListaMovimientos(listaMov12);
              cuenta2.setListaMovimientos(listaMov13);
              Movimientos_Transferencias mov_transf_1 = new Movimientos_Transferencias(movimiento12, transferencia1 );
              Movimientos_Transferencias mov_transf_2 = new Movimientos_Transferencias(movimiento13, transferencia1 );
              session.save(transferencia1);
              session.save(movimiento12);
              session.save(movimiento13);
              session.save(mov_transf_1);
              session.save(mov_transf_2);
              session.save(cuenta1);
              session.save(cuenta2);

              
           
              Transferencias transferencia2 = new Transferencias();
              transferencia2.setIdCliente(cliente2);
              transferencia2.setCbu_origen( 561661 );
              transferencia2.setCbu_destino( 461661 );
              transferencia2.setMonto(500);
              transferencia2.setFecha_alta(Calendar.getInstance().getTime());
              transferencia2.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento14=new Movimientos(Calendar.getInstance().getTime(),con4,-500);
              ArrayList<Movimientos> listaMov14 = new ArrayList<Movimientos>();
              listaMov14.add(movimiento14);
              //credito a destino
              Movimientos movimiento15=new Movimientos(Calendar.getInstance().getTime(),con4,500);
              ArrayList<Movimientos> listaMov15 = new ArrayList<Movimientos>();
              listaMov15.add(movimiento15);
              cuenta2.setListaMovimientos(listaMov14);
              cuenta3.setListaMovimientos(listaMov15);
              Movimientos_Transferencias mov_transf_3 = new Movimientos_Transferencias(movimiento14, transferencia2 );
              Movimientos_Transferencias mov_transf_4 = new Movimientos_Transferencias(movimiento15, transferencia2 );
              session.save(transferencia2);
              session.save(movimiento14);
              session.save(movimiento15);
              session.save(mov_transf_3);
              session.save(mov_transf_4);
              session.save(cuenta2);
              session.save(cuenta3);

              
            
              Transferencias transferencia3 = new Transferencias();
              transferencia3.setIdCliente(cliente3);
              transferencia3.setCbu_origen( 461661 );
              transferencia3.setCbu_destino( 361661 );
              transferencia3.setMonto(3200);
              transferencia3.setFecha_alta(Calendar.getInstance().getTime());
              transferencia3.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento16=new Movimientos(Calendar.getInstance().getTime(),con4,-3200);
              ArrayList<Movimientos> listaMov16 = new ArrayList<Movimientos>();
              listaMov16.add(movimiento16);
              //credito a destino
              Movimientos movimiento17=new Movimientos(Calendar.getInstance().getTime(),con4,3200);
              ArrayList<Movimientos> listaMov17 = new ArrayList<Movimientos>();
              listaMov17.add(movimiento17);
              cuenta3.setListaMovimientos(listaMov16);
              cuenta4.setListaMovimientos(listaMov17);
              Movimientos_Transferencias mov_transf_5 = new Movimientos_Transferencias(movimiento16, transferencia3 );
              Movimientos_Transferencias mov_transf_6 = new Movimientos_Transferencias(movimiento17, transferencia3 );
              session.save(transferencia3);
              session.save(movimiento16);
              session.save(movimiento17);
              session.save(mov_transf_5);
              session.save(mov_transf_6);
              session.save(cuenta3);
              session.save(cuenta4);
              
             

              Transferencias transferencia4 = new Transferencias();
              transferencia4.setIdCliente(cliente4);
              transferencia4.setCbu_origen( 361661 );
              transferencia4.setCbu_destino( 261661 );
              transferencia4.setMonto(2221);
              transferencia4.setFecha_alta(Calendar.getInstance().getTime());
              transferencia4.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento18=new Movimientos(Calendar.getInstance().getTime(),con4,-2221);
              ArrayList<Movimientos> listaMov18 = new ArrayList<Movimientos>();
              listaMov18.add(movimiento18);
              //credito a destino
              Movimientos movimiento19=new Movimientos(Calendar.getInstance().getTime(),con4,2221);
              ArrayList<Movimientos> listaMov19 = new ArrayList<Movimientos>();
              listaMov19.add(movimiento19);
              cuenta4.setListaMovimientos(listaMov18);
              cuenta5.setListaMovimientos(listaMov19);
              Movimientos_Transferencias mov_transf_7 = new Movimientos_Transferencias(movimiento18, transferencia4 );
              Movimientos_Transferencias mov_transf_8 = new Movimientos_Transferencias(movimiento19, transferencia4 );
              session.save(transferencia4);
              session.save(movimiento18);
              session.save(movimiento19);
              session.save(mov_transf_7);
              session.save(mov_transf_8);
              session.save(cuenta4);
              session.save(cuenta5);
              
              

             
              
              Transferencias transferencia5 = new Transferencias();
              transferencia5.setIdCliente(cliente5);
              transferencia5.setCbu_origen( 261661 );
              transferencia5.setCbu_destino( 161661 );
              transferencia5.setMonto(4123);
              transferencia5.setFecha_alta(Calendar.getInstance().getTime());
              transferencia5.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento20=new Movimientos(Calendar.getInstance().getTime(),con4,-4123);
              ArrayList<Movimientos> listaMov20 = new ArrayList<Movimientos>();
              listaMov20.add(movimiento20);
              //credito a destino
              Movimientos movimiento21=new Movimientos(Calendar.getInstance().getTime(),con4,4123);
              ArrayList<Movimientos> listaMov21 = new ArrayList<Movimientos>();
              listaMov21.add(movimiento21);
              cuenta5.setListaMovimientos(listaMov20);
              cuenta6.setListaMovimientos(listaMov21);
              Movimientos_Transferencias mov_transf_9 = new Movimientos_Transferencias(movimiento20, transferencia5 );
              Movimientos_Transferencias mov_transf_10 = new Movimientos_Transferencias(movimiento21, transferencia5 );
              session.save(transferencia5);
              session.save(movimiento20);
              session.save(movimiento21);
              session.save(mov_transf_9);
              session.save(mov_transf_10);
              session.save(cuenta5);
              session.save(cuenta6); 
              
              
              

              Transferencias transferencia6 = new Transferencias();
              transferencia6.setIdCliente(cliente6);
              transferencia6.setCbu_origen( 161661 );
              transferencia6.setCbu_destino( 661661 );
              transferencia6.setMonto(2211);
              transferencia6.setFecha_alta(Calendar.getInstance().getTime());
              transferencia6.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento22=new Movimientos(Calendar.getInstance().getTime(),con4,-2211);
              ArrayList<Movimientos> listaMov22 = new ArrayList<Movimientos>();
              listaMov22.add(movimiento22);
              //credito a destino
              Movimientos movimiento23=new Movimientos(Calendar.getInstance().getTime(),con4,2211);
              ArrayList<Movimientos> listaMov23 = new ArrayList<Movimientos>();
              listaMov23.add(movimiento23);
              cuenta6.setListaMovimientos(listaMov22);
              cuenta7.setListaMovimientos(listaMov23);
              Movimientos_Transferencias mov_transf_11 = new Movimientos_Transferencias(movimiento22, transferencia6 );
              Movimientos_Transferencias mov_transf_12 = new Movimientos_Transferencias(movimiento23, transferencia6 );
              session.save(transferencia6);
              session.save(movimiento22);
              session.save(movimiento23);
              session.save(mov_transf_11);
              session.save(mov_transf_12);
              session.save(cuenta6);
              session.save(cuenta7);
              

             
              Transferencias transferencia7 = new Transferencias();
              transferencia7.setIdCliente(cliente7);
              transferencia7.setCbu_origen( 661661 );
              transferencia7.setCbu_destino( 761661 );
              transferencia7.setMonto(85);
              transferencia7.setFecha_alta(Calendar.getInstance().getTime());
              transferencia7.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento24=new Movimientos(Calendar.getInstance().getTime(),con4,-85);
              ArrayList<Movimientos> listaMov24 = new ArrayList<Movimientos>();
              listaMov24.add(movimiento24);
              //credito a destino
              Movimientos movimiento25=new Movimientos(Calendar.getInstance().getTime(),con4,85);
              ArrayList<Movimientos> listaMov25 = new ArrayList<Movimientos>();
              listaMov25.add(movimiento25);
              cuenta7.setListaMovimientos(listaMov24);
              cuenta8.setListaMovimientos(listaMov25);
              Movimientos_Transferencias mov_transf_13 = new Movimientos_Transferencias(movimiento24, transferencia7 );
              Movimientos_Transferencias mov_transf_14 = new Movimientos_Transferencias(movimiento25, transferencia7 );
              session.save(transferencia7);
              session.save(movimiento24);
              session.save(movimiento25);
              session.save(mov_transf_13);
              session.save(mov_transf_14);
              session.save(cuenta7);
              session.save(cuenta8);
              
           
              

              Transferencias transferencia8 = new Transferencias();
              transferencia8.setIdCliente(cliente8);
              transferencia8.setCbu_origen( 761661 );
              transferencia8.setCbu_destino( 861661 );
              transferencia8.setMonto(85);
              transferencia8.setFecha_alta(Calendar.getInstance().getTime());
              transferencia8.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento26=new Movimientos(Calendar.getInstance().getTime(),con4,-85);
              ArrayList<Movimientos> listaMov26 = new ArrayList<Movimientos>();
              listaMov26.add(movimiento26);
              //credito a destino
              Movimientos movimiento27=new Movimientos(Calendar.getInstance().getTime(),con4,85);
              ArrayList<Movimientos> listaMov27 = new ArrayList<Movimientos>();
              listaMov27.add(movimiento27);
              cuenta8.setListaMovimientos(listaMov26);
              cuenta9.setListaMovimientos(listaMov27);
              Movimientos_Transferencias mov_transf_15 = new Movimientos_Transferencias(movimiento26, transferencia8 );
              Movimientos_Transferencias mov_transf_16 = new Movimientos_Transferencias(movimiento27, transferencia8 );
              session.save(transferencia8);
              session.save(movimiento26);
              session.save(movimiento27);
              session.save(mov_transf_15);
              session.save(mov_transf_16);
              session.save(cuenta8);
              session.save(cuenta9);
              
               

              Transferencias transferencia9 = new Transferencias();
              transferencia9.setIdCliente(cliente8);
              transferencia9.setCbu_origen(761661);
              transferencia9.setCbu_destino(591661);
              transferencia9.setMonto(3225);
              transferencia9.setFecha_alta(Calendar.getInstance().getTime());
              transferencia9.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento28=new Movimientos(Calendar.getInstance().getTime(),con4,-3225);
              ArrayList<Movimientos> listaMov28 = new ArrayList<Movimientos>();
              listaMov28.add(movimiento28);
              //credito a destino
              Movimientos movimiento29=new Movimientos(Calendar.getInstance().getTime(),con4,3225);
              ArrayList<Movimientos> listaMov29 = new ArrayList<Movimientos>();
              listaMov29.add(movimiento29);
              cuenta8.setListaMovimientos(listaMov28);
              cuenta1.setListaMovimientos(listaMov29);
              Movimientos_Transferencias mov_transf_17 = new Movimientos_Transferencias(movimiento28, transferencia9 );
              Movimientos_Transferencias mov_transf_18 = new Movimientos_Transferencias(movimiento29, transferencia9 );
              session.save(transferencia9);
              session.save(movimiento28);
              session.save(movimiento29);
              session.save(mov_transf_17);
              session.save(mov_transf_18);
              session.save(cuenta8);
              session.save(cuenta1);
             

             Transferencias transferencia10 = new Transferencias();
              transferencia10.setIdCliente(cliente2);
              transferencia10.setCbu_origen(561661);
              transferencia10.setCbu_destino( 261661 );
              transferencia10.setMonto(3225);
              transferencia10.setFecha_alta(Calendar.getInstance().getTime());
              transferencia10.setFecha_baja(Calendar.getInstance().getTime());
              //debito de origen
              Movimientos movimiento30=new Movimientos(Calendar.getInstance().getTime(),con4,-3225);
              ArrayList<Movimientos> listaMov30 = new ArrayList<Movimientos>();
              listaMov30.add(movimiento30);
              //credito a destino
              Movimientos movimiento31=new Movimientos(Calendar.getInstance().getTime(),con4,3225);
              ArrayList<Movimientos> listaMov31 = new ArrayList<Movimientos>();
              listaMov31.add(movimiento31);
              cuenta2.setListaMovimientos(listaMov30);
              cuenta5.setListaMovimientos(listaMov31);
              Movimientos_Transferencias mov_transf_19 = new Movimientos_Transferencias(movimiento30, transferencia10 );
              Movimientos_Transferencias mov_transf_20 = new Movimientos_Transferencias(movimiento31, transferencia10 );
              session.save(transferencia10);
              session.save(movimiento30);
              session.save(movimiento31);
              session.save(mov_transf_19);
              session.save(mov_transf_20);
              session.save(cuenta2);
              session.save(cuenta5);
        
   

        session.getTransaction().commit();  
        sessionFactory.close();
        
    
    }
	
	
}
