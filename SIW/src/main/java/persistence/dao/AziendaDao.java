package persistence.dao;

import java.util.List;

import entita.Azienda;

public interface AziendaDao {
	public void salva(Azienda azienda);

	public Azienda cercaPerChiavePrimaria(int id);
	
	public Azienda cercaPerEmail(String email);
	
	public Azienda cercaPerNome(String nome);
	
	public List<Azienda> cercaTutti();

	public void aggiorna(Azienda azienda);

	public void cancella(Azienda azienda);

	public void setPassword(Azienda azienda, String password);
	
	public boolean checkAzienda(String email, String password);
	
	public List<String> cercaAziendaConProdotto();
	
	public List<Azienda> cercaAziendaPerTipologiaPeriodo(boolean servizioParziale, boolean servizioCompleto, String periodo);
}
