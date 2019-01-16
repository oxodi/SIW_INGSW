package entita.ortaggio;

public class Cavolfiore extends Ortaggio {

	public Cavolfiore() {
		this.setId(1);
		this.setNome("Cavolfiore");
		this.setResa(1.0);
	}

	public Cavolfiore(double prezzo, int id_terreno, String tempoColtivazione, String periodoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione, periodoColtivazione);
		this.setId(1);
		this.setNome("Cavolfiore");
		this.setResa(1.0);
	}
}
