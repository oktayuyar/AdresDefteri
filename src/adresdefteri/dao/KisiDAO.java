package adresdefteri.dao;

import java.util.List;

import adresdefteri.model.Kisi;

public interface KisiDAO {
	public Kisi KisiEkle(Kisi k);
	
	public List<Kisi> KisiListeleme();

	public void KisiGuncelleme(int id,String name,String surname);
	
	public void KisiSilme(int id);
	
	public Kisi KisiBulma(int id);

}
