package adresdefteri.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import adresdefteri.model.Iletisim;
import adresdefteri.model.Kisi;
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


}
