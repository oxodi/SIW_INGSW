package persistence.dao;

import java.util.ArrayList;
import java.util.List;
import entita.Cliente;
import entita.Prenotazione;
import entita.Terreno;
import entita.ortaggio.Ortaggio;

public interface TerrenoDao {
	public void salva(Terreno terreno);

	public void aggiorna(Terreno terreno);

	public void cancella(Terreno terreno);

	public void aggiungiOrtaggio(int id_terreno, int id_ortaggio, double prezzo, int tempoColtivazione);

	public void cancellaOrtaggio(int id_terreno, int id_ortaggio);
	
	public void aggiornaOrtaggio(Ortaggio ortaggio);

	public Terreno cercaPerChiavePrimaria(int id);
	
	public ArrayList<Ortaggio> cercaOrtaggiPerTerreno(int id_terreno);

	public List<Terreno> cercaPerServizio(boolean servizioParziale, boolean servizioCompleto);
	
	public List<Terreno> cercaPerServizioPeriodo(boolean servizioParziale, boolean servizioCompleto, String periodo);

	public List<Terreno> cercaPerPeriodo(String periodo);

	public List<Terreno> cercaPerAzienda(int idAzienda);

	public List<Terreno> cercaTutti();

	//public List<Prenotazione> cercaPrenotazioniPerTerreno(int id_terreno);

	public List<Cliente> cercaClientiPerTerreno(int id_terreno);
	
	public void setDocumento(Terreno terreno, String documento);
}
