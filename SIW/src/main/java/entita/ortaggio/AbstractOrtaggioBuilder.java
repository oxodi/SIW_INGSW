package entita.ortaggio;

/*
 * Utilizziamo il pattern Builder per la creazione degli ortaggi, questa classe nello schema del pattern ricopre il ruolo di BUILDER.
 */
public abstract class AbstractOrtaggioBuilder {
	Ortaggio ortaggio;
	
	public Ortaggio getOrtaggio() {
		return ortaggio;
	}
	
	public void creaNuovoOrtaggio() {
		ortaggio = new Ortaggio();
	}
	
	public abstract void scegliNome();
	public abstract void scegliPrezzo(int prezzo);
	public abstract void scegliTempoColtivazione();
	public abstract void scegliPeriodoColtivazione(String periodoColtivazione);
}
