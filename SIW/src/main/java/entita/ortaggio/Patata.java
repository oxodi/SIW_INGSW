package entita.ortaggio;

public class Patata extends Ortaggio {

	public Patata() {
		this.setId(7);
		this.setNome("Patata");
		this.setResa(1.0);
		this.setPeriodoColtivazione("estate");
	}
	
	public Patata(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(7);
		this.setNome("Patata");
		this.setResa(1.0);
		this.setPeriodoColtivazione("estate");
	}
	

}
