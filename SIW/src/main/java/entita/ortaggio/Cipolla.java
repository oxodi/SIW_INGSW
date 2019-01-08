package entita.ortaggio;

public class Cipolla extends Ortaggio {

	public Cipolla(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(4);
		this.setNome("Cipolla");
		this.setResa(1.0);
	}


}
