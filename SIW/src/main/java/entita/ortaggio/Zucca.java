package entita.ortaggio;

public class Zucca extends Ortaggio{
	
	public Zucca() {
		this.setId(17);
		this.setNome("Zucca");
		this.setResa(5.0);
		this.setPeriodoColtivazione("estate");
	}
	
	
	public Zucca(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(17);
		this.setNome("Zucca");
		this.setResa(5.0);
		this.setPeriodoColtivazione("estate");
	}
	

}
