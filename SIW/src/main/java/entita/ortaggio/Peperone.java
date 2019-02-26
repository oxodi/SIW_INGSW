package entita.ortaggio;

public class Peperone extends Ortaggio {

	public Peperone() {
		this.setId(9);
		this.setNome("Peperone");
		this.setResa(4.5);
		this.setPeriodoColtivazione("primavera");
	}

	public Peperone(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(9);
		this.setNome("Peperone");
		this.setResa(1.0);
		this.setPeriodoColtivazione("primavera");
	}

}
