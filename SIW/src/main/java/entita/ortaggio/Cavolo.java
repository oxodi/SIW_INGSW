package entita.ortaggio;

public class Cavolo extends Ortaggio {

	public Cavolo() {
		this.setId(2);
		this.setNome("Cavolo");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");
	}

	public Cavolo(double prezzo, int id_terreno, int tempoColtivazione, String periodoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(2);
		this.setNome("Cavolo");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");
	}
}
