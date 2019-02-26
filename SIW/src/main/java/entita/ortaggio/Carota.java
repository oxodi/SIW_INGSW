package entita.ortaggio;

public class Carota extends Ortaggio {
	
	public Carota() {
		this.setId(13);
		this.setNome("Carota");
		this.setResa(4.0);
		this.setPeriodoColtivazione("primavera");
	}
	
	
	public Carota(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(13);
		this.setNome("Carota");
		this.setResa(4.0);
		this.setPeriodoColtivazione("primavera");
	}

}
