package adresdefteri.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import adresdefteri.dao.KisiDAO;
import adresdefteri.dao.KisiDAOImpl;
import adresdefteri.model.Kisi;

@ManagedBean
@SessionScoped
public class KisiController {
	
	private Kisi k=new Kisi();
	private List<Kisi> kisiler = new ArrayList<Kisi>();


	public Kisi getK() {
		return k;
	}
	public void setK(Kisi k) {
		this.k = k;
	}
	
	public List<Kisi> getKisiler() {
		return kisiler;
	}
	
	public void KisiEkle() {	

		KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();
		Kisi kisi=new Kisi();
		kisi.setAd(k.getAd());
		kisi.setSoyad(k.getSoyad());
		kisi.setE_posta(k.getE_posta());
		kisi.setAdres(k.getAdres());
		kisiDAOImpl.KisiEkle(kisi);
		
		k.setAd("");
		k.setSoyad("");
		k.setE_posta("");
		k.setAdres("");
		
		KisiListeleme();
	}	
	public void KisiListeleme() {	

		KisiDAOImpl kisiDAOImpl1 = new KisiDAOImpl();
		kisiler = kisiDAOImpl1.KisiListeleme();
	}		
	
}
