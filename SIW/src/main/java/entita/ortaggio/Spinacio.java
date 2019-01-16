package entita.ortaggio;

public class Spinacio extends Ortaggio {

	public Spinacio() {
		this.setId(11);
		this.setNome("Spinacio");
		this.setResa(1.0);
	}
	
	public Spinacio(double prezzo, int tempoColtivazione, String periodoColtivazione) {
		super(prezzo, tempoColtivazione, periodoColtivazione);
		this.setId(11);
		this.setNome("Spinacio");
		this.setResa(1.0);
	}
	

}
