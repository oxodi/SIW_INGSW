package entita.ortaggio;

public class Peperoncino extends Ortaggio {

	public Peperoncino(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(8);
		this.setNome("Peperoncino");
		this.setResa(1.0);
	}
	
}

