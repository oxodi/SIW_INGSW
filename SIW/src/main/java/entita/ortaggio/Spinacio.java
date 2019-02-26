package entita.ortaggio;

public class Spinacio extends Ortaggio {

	public Spinacio() {
		this.setId(11);
		this.setNome("Spinacio");
		this.setResa(2.5);
		this.setPeriodoColtivazione("annuale");
	}
	
	public Spinacio(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(11);
		this.setNome("Spinacio");
		this.setResa(1.0);
		this.setPeriodoColtivazione("annuale");
	}
	

}
