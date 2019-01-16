package entita.ortaggio;

public class Patata extends Ortaggio {

	public Patata() {
		this.setId(7);
		this.setNome("Patata");
		this.setResa(1.0);
	}
	
	public Patata(double prezzo, String tempoColtivazione, String periodoColtivazione) {
		super(prezzo, tempoColtivazione, periodoColtivazione);
		this.setId(7);
		this.setNome("Patata");
		this.setResa(1.0);
	}
	

}
