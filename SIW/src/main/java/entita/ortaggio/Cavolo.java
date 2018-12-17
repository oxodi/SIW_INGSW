package entita.ortaggio;
/*
 * Utilizziamo il pattern Builder per la creazione degli ortaggi, 
 * questa classe nello schema del pattern ricopre il ruolo di CONCRETEBUILDER.
*/
public class Cavolo extends AbstractOrtaggioBuilder {
	
	@Override
	public void scegliNome() {
		ortaggio.setNome("");
	}

	@Override
	public void scegliPrezzo(int prezzo) {
		ortaggio.setPrezzo(prezzo);
	}

	@Override
	public void scegliTempoColtivazione() {
		ortaggio.setTempoColtivazione("");
	}

	@Override
	public void scegliPeriodoColtivazione(String periodoColtivazione) {
		ortaggio.setPeriodoColtivazione(periodoColtivazione);
	}
}
