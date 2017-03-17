package adresdefteri.service;

import java.util.List;

import adresdefteri.model.Kisi;
import adresdefteri.dao.KisiDAOImpl;

public class KisiServiceImpl implements KisiService{
	
	private KisiDAOImpl kisiDAOImpl;
	

	public KisiDAOImpl getKisiDAOImpl() {
		return kisiDAOImpl;
	}

	@Override
	public Kisi KisiEkle(Kisi k) {
		return getKisiDAOImpl().KisiEkle(k);
	}

	@Override
	public List<Kisi> KisiListeleme() {
		return getKisiDAOImpl().KisiListeleme();
	}

	@Override
	public void KisiGuncelleme(int id, String name, String surname) {
		getKisiDAOImpl().KisiGuncelleme(id, name, surname);
		
	}

	@Override
	public void KisiSilme(int id) {
		getKisiDAOImpl().KisiSilme(id);
		
	}

	@Override
	public Kisi KisiBulma(int id) {
		// TODO Auto-generated method stub
		return getKisiDAOImpl().KisiBulma(id);
	}

}
