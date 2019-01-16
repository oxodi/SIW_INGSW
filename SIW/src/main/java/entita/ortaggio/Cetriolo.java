package entita.ortaggio;

public class Cetriolo extends Ortaggio {

	public Cetriolo() {
		this.setId(3);
		this.setNome("Cetriolo");
		this.setResa(1.0);

	}

	public Cetriolo(double prezzo, int tempoColtivazione, String periodoColtivazione) {
		super(prezzo, tempoColtivazione, periodoColtivazione);
		this.setId(3);
		this.setNome("Cetriolo");
		this.setResa(1.0);
	}
}
