package adresdefteri.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
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
	private List<Kisi> aKisiler= new ArrayList<Kisi>();
	private String kelime;


	public String KisiEkle() {
		if(!k.getAd().equals("") & !k.getSoyad().equals("") 
				& !k.getE_posta().equals("") & !k.getAdres().equals("") 
				& !i.getTelefon().equals("")){
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

			i.setTelefon("");
			k.setAd("");
			k.setSoyad("");
			k.setE_posta("");
			k.setAdres("");
		}
		else{
			System.err.println("Verileri boş bırakmayınız!");
		}
		KisiListeleme();
		return "index.xhtml?faces-redirect=true";
	}

	public void KisiListeleme() {

		KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();
		kisiler = kisiDAOImpl.KisiListeleme();
	}

	public void KisiBul() {
		KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();
		Kisi kisi = kisiDAOImpl.KisiBulma(k1.getId());
		k1.setAd(kisi.getAd());
		k1.setSoyad(kisi.getSoyad());
		k1.setE_posta(kisi.getE_posta());
		k1.setAdres(kisi.getAdres());

	}
	
	public void Ara(){
		if(!kelime.equals("")){
			KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();
			aKisiler=kisiDAOImpl.Arama(kelime);
		}
		else{
			System.out.println("Aranacak kelime yok");
		}
	}

	public String KisiSil() {
		KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();
		IletisimDAOImpl iletisimDAOImpl = new IletisimDAOImpl();
		kisiDAOImpl.KisiSilme(k1.getId());
		return "index";
	}

	public String KisiGuncelle() {
		if(!k1.getAd().equals("") & !k1.getSoyad().equals("") 
				& !k1.getE_posta().equals("") & !k1.getAdres().equals("")){
			KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();
			kisiDAOImpl.KisiGuncelleme(k1.getId(), k1.getAd(), k1.getSoyad(), k1.getE_posta(), k1.getAdres());
		}else{
			System.err.println("Verileri boş bırakmayınız!");
			return "detay";
		}

		return "index?faces-redirect=true";
	}

	public List<SelectItem> getKisiListesi() {

		KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();

		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Kisi> kisiSecim = kisiDAOImpl.KisiListeleme();
		for (Kisi kisi : kisiSecim) {
			items.add(new SelectItem(kisi.getId(), kisi.getAd(), kisi.getSoyad()));
		}
		return items;
	}

	public void TelefonListele() {
		IletisimDAOImpl iletisimDAOImpl = new IletisimDAOImpl();
		telefonlar = iletisimDAOImpl.TelListeleme(k1.getId());
	}

	public String TelefonEkle() {
		if(!i.getTelefon().equals("")){
			KisiDAOImpl kisiDAOImpl = new KisiDAOImpl();
			IletisimDAOImpl iletisimDAOImpl = new IletisimDAOImpl();

			Iletisim iletisim = new Iletisim();
			Kisi kisi = kisiDAOImpl.KisiBulma(k1.getId());

			iletisim.setTelefon(i.getTelefon());

			kisi.getIletisim().add(iletisim);
			iletisim.setKisi(kisi);

			iletisimDAOImpl.telefonEkle(iletisim);
			i.setTelefon("");
			return "detay?faces-redirect=true";
		}else{
			System.err.println("Verileri boş bırakmayınız!");
			return "detay";
		}
	}
	
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
	public String getKelime() {
		return kelime;
	}

	public void setKelime(String kelime) {
		this.kelime = kelime;
	}

	public List<Kisi> getaKisiler() {
		return aKisiler;
	}

	public void setaKisiler(List<Kisi> aKisiler) {
		this.aKisiler = aKisiler;
	}
	
}
