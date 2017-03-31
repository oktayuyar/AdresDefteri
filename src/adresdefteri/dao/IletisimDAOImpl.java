package adresdefteri.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import adresdefteri.model.Iletisim;
import adresdefteri.model.Kisi;
import adresdefteri.util.HibernateUtil;

public class IletisimDAOImpl implements IletisimDAO {

	/*Kişiye telefon eklediğimiz method */
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

	/* Gelen id ye göre kisilerin telefonlarını listelediğimiz method */
	@Override
	public List<String> TelListeleme(int id) {
		Session session = HibernateUtil.getHibernateSession();
		Transaction tx = null;
		List<String> tel = null;
		try {
			System.out.println("gelen id = " + id);
			Query query = session.createQuery("From Iletisim i where i.kisi.id= " + id);
			tel = query.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		return tel;
	}
	/* Id sini verdiğimiz telefonu veritabanından sildiğimiz method */
	@Override
	public void TelSilme(int id) {
		Session session = HibernateUtil.getHibernateSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			System.out.println(" silinecek tel id : " +id);
			Iletisim i = session.get(Iletisim.class, id);
			session.delete(i);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
