package adresdefteri.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import adresdefteri.util.HibernateUtil;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	static{
		try{
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static Session getHibernateSession(){
		return sessionFactory.openSession();
	}
}