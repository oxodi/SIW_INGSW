package persistence.dao;

import java.util.List;

import entita.Terreno;
import entita.ortaggio.Ortaggio;

public interface TerrenoDao {
	public void salva(Terreno terreno);

	public void aggiornaDimensione(Terreno cliente);

	public void cancella(Terreno cliente);
	
	public void aggiungiOrtaggio(Terreno terreno, Ortaggio ortaggio, double prezzo, int tempoColtivazione, String periodoColtivazione);

	public Terreno cercaPerChiavePrimaria(int id);
	
	public List<Ortaggio> cercaOrtaggiPerTerreno(Terreno terreno, int id_ortaggio);

	public List<Terreno> cercaPerServizio(boolean servizioParziale, boolean servizioCompleto);

	public List<Terreno> cercaPerPeriodo(String periodo);

	public List<Terreno> cercaPerAzienda(int idAzienda);

	public List<Terreno> cercaTutti();
}
