package app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import tpbanco.Persona;

public class App {

	public static void main( String[] args ) {
		SessionFactory sessionFactory;
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Persona persona = new Persona();
		persona.setApellido("Wolfcastle");
		persona.setNombre("Rainier");
		persona.setDni("66699969");
		
		session.save(persona);
		
		session.getTransaction().commit();
		
		sessionFactory.close();
	}
	
}
