package entita.ortaggio;

public class Peperone extends Ortaggio{

	public Peperone() {
		this.setId(9);
		this.setNome("Peperone");
		this.setResa(1.0);
	}
	
	public Peperone(double prezzo, int id_terreno, String tempoColtivazione, String periodoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione, periodoColtivazione);
		this.setId(9);
		this.setNome("Peperone");
		this.setResa(1.0);
	}
	

}
