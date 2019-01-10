package persistence.dao;

import java.util.Date;
import entita.Prenotazione;

public interface PrenotazioneDao {
	
	public void salva(Prenotazione prenotazione);
	public Prenotazione cercaPerChiavePrimaria(int id);
	public Prenotazione cercaPerData(Date data);
	public void aggiorna(Prenotazione prenotazione);
	public void cancella(Prenotazione prenotazione);
}
