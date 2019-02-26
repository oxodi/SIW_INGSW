package entita.ortaggio;

public class Aglio extends Ortaggio{

	public Aglio() {
		this.setId(18);
		this.setNome("Aglio");
		this.setResa(3.0);
		this.setPeriodoColtivazione("annuale");
	}
	
	
	public Aglio(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(18);
		this.setNome("Zucca");
		this.setResa(3.0);
		this.setPeriodoColtivazione("annuale");
	}
	
}
