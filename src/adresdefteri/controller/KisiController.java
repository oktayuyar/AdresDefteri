package adresdefteri.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import adresdefteri.dao.IletisimDAOImpl;
import adresdefteri.dao.KisiDAOImpl;
import adresdefteri.model.Iletisim;
import adresdefteri.model.Kisi;

@ManagedBean
@SessionScoped
public class KisiController {

	private Kisi k = new Kisi();
	private Kisi k1 = new Kisi();
	private Iletisim i = new Iletisim();
	private List<Kisi> kisiler = new ArrayList<Kisi>();
	private List<String> telefonlar = new ArrayList<String>();

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

	public Iletisim getI() {
		return i;
	}

	public void setI(Iletisim i) {
		this.i = i;
	}

	public List<Kisi> getKisiler() {
		return kisiler;
	}

	public List<String> getTelefonlar() {
		return telefonlar;
	}

	public void KisiEkle() {

		KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();
		IletisimDAOImpl iletisimDAOImpl = new IletisimDAOImpl();

		Iletisim iletisim = new Iletisim();
		Kisi kisi = new Kisi();

		iletisim.setTelefon(i.getTelefon());

		kisi.setAd(k.getAd());
		kisi.setSoyad(k.getSoyad());
		kisi.setE_posta(k.getE_posta());
		kisi.setAdres(k.getAdres());

		kisi.getIletisim().add(iletisim);
		iletisim.setKisi(kisi);

		kisiDAOImpl.KisiEkle(kisi);
		iletisimDAOImpl.telefonEkle(iletisim);

		k.setAd("");
		k.setSoyad("");
		k.setE_posta("");
		k.setAdres("");
		i.setTelefon("");
		kisi = null;
		i = null;
		KisiListeleme();
	}

	public void KisiListeleme() {

		KisiDAOImpl kisiDAOImpl1 = new KisiDAOImpl();
		kisiler = kisiDAOImpl1.KisiListeleme();
	}

	public void KisiBul() {
		KisiDAOImpl kisiDAOImpl2 = new KisiDAOImpl();
		Kisi kisi = kisiDAOImpl2.KisiBulma(k1.getId());
		k1.setAd(kisi.getAd());
		k1.setSoyad(kisi.getSoyad());
		k1.setE_posta(kisi.getE_posta());
		k1.setAdres(kisi.getAdres());

	}

	public String KisiSil() {
		KisiDAOImpl kisiDAOImpl3 = new KisiDAOImpl();
		kisiDAOImpl3.KisiSilme(k1.getId());
		return "index.xhtml";
	}

	public String KisiGuncelle() {
		KisiDAOImpl kisiDAOImpl4 = new KisiDAOImpl();
		kisiDAOImpl4.KisiGuncelleme(k1.getId(), k1.getAd(), k1.getSoyad(), k1.getE_posta(), k1.getAdres());
		return "index.xhtml";
	}

	public List<SelectItem> getKisiListesi() {

		KisiDAOImpl kisiDAOImpl4 = new KisiDAOImpl();

		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Kisi> kisiSecim = kisiDAOImpl4.KisiListeleme();
		for (Kisi kisi : kisiSecim) {
			items.add(new SelectItem(kisi.getId(), kisi.getAd(), kisi.getSoyad()));
		}
		return items;
	}

	public void TelefonListele() {
		KisiDAOImpl kisiDAOImpl5 = new KisiDAOImpl();
		telefonlar = kisiDAOImpl5.TelListeleme(k1.getId());
	}

	public void TelefonEkle() {
		KisiDAOImpl kisiDAOImpl6 = new KisiDAOImpl();
		IletisimDAOImpl iletisimDAOImpl6 = new IletisimDAOImpl();

		
		Iletisim iletisim = new Iletisim();
		Kisi kisi = kisiDAOImpl6.KisiBulma(k1.getId());
		
		iletisim.setTelefon(i.getTelefon());
		
		kisi.getIletisim().add(iletisim);
		iletisim.setKisi(kisi);

		iletisimDAOImpl6.telefonEkle(iletisim);
		i.setTelefon("");
	}

}
