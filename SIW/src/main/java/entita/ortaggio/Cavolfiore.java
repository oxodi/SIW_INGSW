package entita.ortaggio;

public class Cavolfiore extends Ortaggio {

	public Cavolfiore() {
		this.setId(1);
		this.setNome("Cavolfiore");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");
	}

	public Cavolfiore(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(1);
		this.setNome("Cavolfiore");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");
	}
}
