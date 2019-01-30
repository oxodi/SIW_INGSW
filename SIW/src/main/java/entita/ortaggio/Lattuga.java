package entita.ortaggio;

public class Lattuga extends Ortaggio {

	public Lattuga() {
		this.setId(5);
		this.setNome("Lattuga");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");
	}

	public Lattuga(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(5);
		this.setNome("Lattuga");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");
	}

}
