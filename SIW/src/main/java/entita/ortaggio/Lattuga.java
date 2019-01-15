package entita.ortaggio;

public class Lattuga extends Ortaggio {

	public Lattuga() {
		this.setId(5);
		this.setNome("Lattuga");
		this.setResa(1.0);
	}

	public Lattuga(double prezzo, String tempoColtivazione, String periodoColtivazione) {
		super(prezzo, tempoColtivazione, periodoColtivazione);
		this.setId(5);
		this.setNome("Lattuga");
		this.setResa(1.0);
	}

}
