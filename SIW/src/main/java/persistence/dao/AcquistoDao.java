package persistence.dao;

import java.util.Date;
import java.util.List;

import entita.Acquisto;

public interface AcquistoDao {

	public void salva(Acquisto acquisto);

	public void aggiorna(Acquisto acquisto);

	public void cancella(Acquisto acquisto);

	public Acquisto cercaPerChiavePrimaria(int id);

	public List<Acquisto> cercaPerCliente(int idCliente);

	public List<Acquisto> cercaPerProdotto(int idProdotto);

	public List<Acquisto> cercaPerDataAcquisto(Date dataAcquisto);

	public List<Acquisto> cercaTutti();
}
