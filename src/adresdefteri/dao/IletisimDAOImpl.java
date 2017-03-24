package adresdefteri.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import adresdefteri.model.Iletisim;
import adresdefteri.util.HibernateUtil;

public class IletisimDAOImpl implements IletisimDAO {

	@Override
	public Iletisim telefonEkle(Iletisim i) {
		Session session = HibernateUtil.getHibernateSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(i);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		return i;
	}

	@Override
	public List<String> TelListeleme(int id) {
		Session session = HibernateUtil.getHibernateSession();
		Transaction tx = null;
		List<String> tel = null;
		try {
			//select telefon From Iletisim i,Kisi k where k.id=i.kisi_id and k.id="+id
			System.out.println("gelen id = "+id);
			Query query= session.createQuery("From Iletisim i where i.kisi.id= "+id);
			tel=query.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		return tel;
	}

	@Override
	public void telefonSilme(int id) {
		Session session = HibernateUtil.getHibernateSession();
		Transaction tx = null;
		List<Iletisim> tel = null;
		try {
			System.out.println("Telefonu silinecek olan kullanıcının id = "+id);
			Query query= session.createQuery("From Iletisim i where i.kisi.id= "+id);
			tel=query.list();
			for(Iletisim t:tel){
				session.delete(t);
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

}
