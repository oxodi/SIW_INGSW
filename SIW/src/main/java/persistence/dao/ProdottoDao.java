package persistence.dao;

import java.util.List;

import entita.Prodotto;

public interface ProdottoDao {

	public void salva(Prodotto prodotto);

	public Prodotto cercaPerChiavePrimaria(int id);
	
	public Prodotto cercaPerNome(String nome);

	public List<Prodotto> dammiPagina(int pagina);
	
	public List<Prodotto> cercaPerCategoria(String categoria);

	public List<Prodotto> cercaTutti();
	
	public List<Prodotto> cercaPerAzienda(int idAzienda);

	public void aggiorna(Prodotto prodotto);

	public void cancella(Prodotto prodotto);
}
