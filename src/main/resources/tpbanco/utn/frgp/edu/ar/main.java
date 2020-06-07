package utn.frgp.edu.ar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import utn.frgp.edu.ar.entidad.Conceptos;
import utn.frgp.edu.ar.entidad.Localidades;
import utn.frgp.edu.ar.entidad.Provincias;

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

        
        // Cargo datos en Conceptos
        Conceptos con1= new Conceptos("Alta de Cuenta");
        Conceptos con2= new Conceptos("Alta de Prestamo");
        Conceptos con3= new Conceptos("Pago de Prestamo");
        Conceptos con4= new Conceptos("Transferencia");
        session.save(con1); 
        session.save(con2); 
        session.save(con3); 
        session.save(con4); 
        
        
        
        
        
        
        session.getTransaction().commit();  
        sessionFactory.close();
        
    
    }
	
	
}
