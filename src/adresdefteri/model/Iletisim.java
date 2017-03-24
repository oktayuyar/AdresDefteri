package adresdefteri.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Iletisim {
	@TableGenerator(name="ILT_GEN",allocationSize=1)
	@Id 
	@GeneratedValue(generator="ILT_GEN")
	private int id;
	
	private String telefon;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "kisi_id")
	private Kisi kisi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Kisi getKisi() {
		return kisi;
	}
	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}
}