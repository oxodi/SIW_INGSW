package entita.ortaggio;

public class Lattuga extends Ortaggio {

	public Lattuga(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(5);
		this.setNome("Lattuga");
		this.setResa(1.0);
	}


}
