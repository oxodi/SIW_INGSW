package entita.ortaggio;

/*
 * Utilizziamo il pattern Builder per la creazione degli ortaggi, questa classe nello schema del pattern ricopre il ruolo di CONCRETEBUILDER.
*/

public class Pomodoro extends AbstractOrtaggioBuilder {

	@Override
	public void scegliNome() {
		ortaggio.setNome("");
	}

	@Override
	public void scegliPrezzo() {
		ortaggio.setPrezzo(0);
	}

	@Override
	public void scegliTempoColtivazione() {
		ortaggio.setTempoColtivazione("");
	}

	@Override
	public void scegliPeriodoColtivazione() {
		ortaggio.setPeriodoColtivazione("");
	}

}
