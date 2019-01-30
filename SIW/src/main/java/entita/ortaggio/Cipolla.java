package entita.ortaggio;

public class Cipolla extends Ortaggio {

	public Cipolla() {
		this.setId(4);
		this.setNome("Cipolla");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");
	}

	public Cipolla(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(4);
		this.setNome("Cipolla");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");

	}

}
