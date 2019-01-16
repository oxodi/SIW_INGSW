package entita.ortaggio;

public class Peperoncino extends Ortaggio {

	public Peperoncino() {
		this.setId(8);
		this.setNome("Peperoncino");
		this.setResa(1.0);
	}
	
	public Peperoncino(double prezzo, int id_terreno, int tempoColtivazione, String periodoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione, periodoColtivazione);
		this.setId(8);
		this.setNome("Peperoncino");
		this.setResa(1.0);
	}
	
}

