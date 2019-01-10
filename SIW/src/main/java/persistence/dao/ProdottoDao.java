package persistence.dao;

import java.util.List;

import entita.Prodotto;

public interface ProdottoDao {

	public void salva(Prodotto prodotto);
	public Prodotto cercaPerChiavePrimaria(int id);
	public Prodotto cercaPerNome(String nome);
	public Prodotto cercaPerCategoria(String categoria);
	public List<Prodotto> cercaTutti();
	public void aggiorna(Prodotto cliente);
	public void cancella(Prodotto cliente);
}
