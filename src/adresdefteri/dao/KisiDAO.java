package adresdefteri.dao;

import java.awt.TextArea;
import java.util.List;

import adresdefteri.model.Kisi;
import javafx.scene.text.Text;

public interface KisiDAO {
	public Kisi KisiEkle(Kisi k);
	
	public List<Kisi> KisiListeleme();

	public void KisiGuncelleme(int id,String name,String surname,String e_posta,String adres);
	
	public void KisiSilme(int id);
	
	public Kisi KisiBulma(int id);
	
}
