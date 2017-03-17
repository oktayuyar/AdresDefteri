package adresdefteri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Kisi {
	@TableGenerator(name="KS_GEN",allocationSize=1)
	@Id 
	@GeneratedValue(generator="KS_GEN")
	private int id;
	
	private String ad;
	private String soyad;
	private String e_posta;
	private String adres;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getE_posta() {
		return e_posta;
	}
	public void setE_posta(String e_posta) {
		this.e_posta = e_posta;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	@Override
	public String toString() {
		return "Kisi [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", e_posta=" + e_posta + ", adres=" + adres + "]";
	}
	
}