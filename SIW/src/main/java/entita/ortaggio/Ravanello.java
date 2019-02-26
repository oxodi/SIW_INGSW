package entita.ortaggio;

public class Ravanello extends Ortaggio {
	
	public Ravanello() {
		this.setId(20);
		this.setNome("Ravanello");
		this.setResa(3.0);
		this.setPeriodoColtivazione("inverno");
	}
	
	
	public Ravanello(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(20);
		this.setNome("Ravanello");
		this.setResa(3.0);
		this.setPeriodoColtivazione("inverno");
	}
}
