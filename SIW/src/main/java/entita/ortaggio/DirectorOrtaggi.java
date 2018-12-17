package entita.ortaggio;

/*
 * Utilizziamo il pattern Builder per la creazione degli ortaggi, questa classe nello schema del pattern ricopre il ruolo di DIRECTOR.
 */
public class DirectorOrtaggi {
	private AbstractOrtaggioBuilder builder;
	
	public void setBuilder(AbstractOrtaggioBuilder builder) {
		this.builder = builder;
	}
	
	public Ortaggio getOrtaggio() {
		return builder.getOrtaggio();
	}
	
	public void creaOrtaggio(int prezzo, String periodoColtivazione) {
		builder.creaNuovoOrtaggio();
		builder.scegliNome();
		builder.scegliPrezzo(prezzo);
		builder.scegliPeriodoColtivazione(periodoColtivazione);
		builder.scegliTempoColtivazione();
	}
}
