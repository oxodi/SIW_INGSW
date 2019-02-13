package entita.ortaggio;

public class TerrenoPrenotabile extends Ortaggio {
	public TerrenoPrenotabile() {
		this.setId(99);
		this.setNome("Terreno");
		this.setResa(0.0);
		this.setPeriodoColtivazione("annuale");
	}
	
	public TerrenoPrenotabile(double prezzo, int id_terreno) {
		super(prezzo, id_terreno, 1);
		this.setId(99);
		this.setNome("Terreno");
		this.setResa(0.0);
		this.setPeriodoColtivazione("annuale");
	}
}
