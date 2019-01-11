package persistence.dao;

import java.util.List;

import entita.InserisciProdotto;

public interface InserisciProdottoDao {
	
	public void salva(InserisciProdotto inserimento);
	public void aggiorna(InserisciProdotto inserimento);
	public void cancella(InserisciProdotto inserimento);
	public List<InserisciProdotto> cercaPerAzienda(int idAzienda);
	public List<InserisciProdotto> cercaPerProdotto(int idProdotto);
}
