package persistence.dao;

import java.util.List;

import entita.Terreno;

public interface TerrenoDao {
	public void salva(Terreno terreno);
	public void aggiorna(Terreno cliente);
	public void cancella(Terreno cliente);
	public Terreno cercaPerChiavePrimaria(int id);
	public List<Terreno> cercaPerServizio(boolean servizioParziale, boolean servizioCompleto);
	public List<Terreno> cercaPerPeriodo(String periodo);
	public List<Terreno> cercaPerAzienda(int idAzienda);
	public List<Terreno> cercaTutti();
}
