package entita.ortaggio;

public class Cavolo extends Ortaggio {

	public Cavolo(double prezzo, String tempoColtivazione, String periodoColtivazione,  int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(1);
		this.setNome("Cavolo");
		this.setResa(1.0);
	}
}
