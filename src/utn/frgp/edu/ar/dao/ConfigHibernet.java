package utn.frgp.edu.ar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConfigHibernet {

	private static SessionFactory sessionFactory = null;
	//private Session session;
	
	static
	{
		try {
			Configuration configuration = new Configuration().configure();
	        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	        ConfigHibernet.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
			
	}
	
	public static Session abrirConexion() {
        Session session = ConfigHibernet.sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }
	
	/*public Session abrirConexion() 
	{
		session = sessionFactory.openSession();
		return session;
	}*/
	
	public static void commitSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }
	
	/*public void cerrarSession() {
		
		session.close();
		cerrarSessionFactory();
	}*/
	
	public static void rollbackSession(Session session) {
        session.getTransaction().rollback();
        session.close();
    }
	
	public void cerrarSessionFactory() {
		ConfigHibernet.sessionFactory.close();
	}
	
}
