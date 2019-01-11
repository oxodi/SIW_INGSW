package entita.ortaggio;

public class Cipolla extends Ortaggio {

	public Cipolla() {
		this.setId(4);
		this.setNome("Cipolla");
		this.setResa(1.0);
	}
	
	public Cipolla(double prezzo, String tempoColtivazione, String periodoColtivazione) {
		super(prezzo, tempoColtivazione, periodoColtivazione);
		this.setId(4);
		this.setNome("Cipolla");
		this.setResa(1.0);
	}


}
