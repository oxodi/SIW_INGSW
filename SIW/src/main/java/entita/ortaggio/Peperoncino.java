package entita.ortaggio;

public class Peperoncino extends Ortaggio {

	public Peperoncino() {
		this.setId(8);
		this.setNome("Peperoncino");
		this.setResa(1.0);
		this.setPeriodoColtivazione("primavera");
	}
	
	public Peperoncino(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(8);
		this.setNome("Peperoncino");
		this.setResa(1.0);
		this.setPeriodoColtivazione("primavera");
	}
	
}

