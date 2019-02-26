package entita.ortaggio;

public class Radicchio extends Ortaggio{
	
	public Radicchio() {
		this.setId(19);
		this.setNome("Radicchio");
		this.setResa(8.0);
		this.setPeriodoColtivazione("inverno");
	}
	
	
	public Radicchio(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(19);
		this.setNome("Radicchio");
		this.setResa(8.0);
		this.setPeriodoColtivazione("inverno");
	}
}
