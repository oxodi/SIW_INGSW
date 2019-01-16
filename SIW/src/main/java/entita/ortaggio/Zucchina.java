package entita.ortaggio;

public class Zucchina extends Ortaggio{

	public Zucchina() {
		this.setId(12);
		this.setNome("Zucchina");
		this.setResa(1.0);
	}
	
	public Zucchina(double prezzo, int id_terreno, String tempoColtivazione, String periodoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione, periodoColtivazione);
		this.setId(12);
		this.setNome("Zucchina");
		this.setResa(1.0);
	}
	
}
