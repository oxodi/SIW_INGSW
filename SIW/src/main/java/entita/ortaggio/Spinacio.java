package entita.ortaggio;

public class Spinacio extends Ortaggio {

	public Spinacio(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(11);
		this.setNome("Spinacio");
		this.setResa(1.0);
	}
	

}
