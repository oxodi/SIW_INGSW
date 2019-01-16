package entita.ortaggio;

public class Cavolo extends Ortaggio {

	public Cavolo() {
		this.setId(2);
		this.setNome("Cavolo");
		this.setResa(1.0);
	}

	public Cavolo(double prezzo, int tempoColtivazione, String periodoColtivazione) {
		super(prezzo, tempoColtivazione, periodoColtivazione);
		this.setId(2);
		this.setNome("Cavolo");
		this.setResa(1.0);
	}
}
