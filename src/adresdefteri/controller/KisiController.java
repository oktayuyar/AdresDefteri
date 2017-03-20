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
	private Kisi k1=new Kisi();
	private List<Kisi> kisiler = new ArrayList<Kisi>();


	public Kisi getK() {
		return k;
	}
	public void setK(Kisi k) {
		this.k = k;
	}
	public Kisi getK1() {
		return k1;
	}
	public void setK1(Kisi k1) {
		this.k1 = k1;
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
	
	public void KisiBul(){
		KisiDAOImpl kisiDAOImpl2 = new KisiDAOImpl();
		Kisi kisi=kisiDAOImpl2.KisiBulma(k1.getId());
		k1.setAd(kisi.getAd());
		k1.setSoyad(kisi.getSoyad());
		k1.setE_posta(kisi.getE_posta());
		k1.setAdres(kisi.getAdres());
	}
	
	public String KisiSil(){
		KisiDAOImpl kisiDAOImpl3 = new KisiDAOImpl();
		kisiDAOImpl3.KisiSilme(k1.getId());
		return "index.xhtml";
	}
	public String KisiGuncelle(){
		KisiDAOImpl kisiDAOImpl4 = new KisiDAOImpl();
		kisiDAOImpl4.KisiGuncelleme(k1.getId(), k1.getAd(), k1.getSoyad(), k1.getE_posta(), k1.getAdres());
		return "index.xhtml";
	}
	
	
}
