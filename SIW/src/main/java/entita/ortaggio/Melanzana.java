package entita.ortaggio;

public class Melanzana extends Ortaggio {

	public Melanzana() {
		this.setId(6);
		this.setNome("Melanzana");
		this.setResa(1.0);
	}

	public Melanzana(double prezzo, int id_terreno, String tempoColtivazione, String periodoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione, periodoColtivazione);
		this.setId(6);
		this.setNome("Melanzana");
		this.setResa(1.0);
	}

}
