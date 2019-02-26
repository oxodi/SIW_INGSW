package entita.ortaggio;

public class Fragola extends Ortaggio{

	public Fragola() {
		this.setId(15);
		this.setNome("Fragola");
		this.setResa(2.0);
		this.setPeriodoColtivazione("autunno");
	}
	
	
	public Fragola(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(15);
		this.setNome("Fragola");
		this.setResa(2.0);
		this.setPeriodoColtivazione("autunno");
	}
}
