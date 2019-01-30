 package entita.ortaggio;

public class Melanzana extends Ortaggio {

	public Melanzana() {
		this.setId(6);
		this.setNome("Melanzana");
		this.setResa(1.0);
		this.setPeriodoColtivazione("primavera");
	}

	public Melanzana(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(6);
		this.setNome("Melanzana");
		this.setResa(1.0);
		this.setPeriodoColtivazione("primavera");
	}

}
