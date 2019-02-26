package entita.ortaggio;

public class Anguria extends Ortaggio{

	public Anguria() {
		this.setId(14);
		this.setNome("Anguria");
		this.setResa(12.0);
		this.setPeriodoColtivazione("primavera");
	}
	
	
	public Anguria(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(14);
		this.setNome("Carota");
		this.setResa(12.0);
		this.setPeriodoColtivazione("primavera");
	}
}
