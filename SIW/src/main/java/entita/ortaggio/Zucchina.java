package entita.ortaggio;

public class Zucchina extends Ortaggio{

	public Zucchina() {
		this.setId(12);
		this.setNome("Zucchina");
		this.setResa(3.0);
		this.setPeriodoColtivazione("estate");
	}
	
	
	public Zucchina(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(12);
		this.setNome("Zucchina");
		this.setResa(1.0);
		this.setPeriodoColtivazione("estate");
	}
	
}
