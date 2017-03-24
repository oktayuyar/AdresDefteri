package adresdefteri.dao;

import java.util.List;

import adresdefteri.model.Iletisim;
import adresdefteri.model.Kisi;

public interface IletisimDAO {
	public Iletisim telefonEkle(Iletisim i);
	
	public List<String> TelListeleme(int id);

	public void telefonSilme(int id);
}
