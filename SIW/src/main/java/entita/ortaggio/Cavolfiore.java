package entita.ortaggio;

public class Cavolfiore extends Ortaggio{
	
	public Cavolfiore(double prezzo, String tempoColtivazione, String periodoColtivazione,  int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(2);
		this.setNome("Cavolfiore");
		this.setResa(1.0);
	}
}
