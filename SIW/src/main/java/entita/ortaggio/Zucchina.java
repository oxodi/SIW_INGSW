package entita.ortaggio;

public class Zucchina extends Ortaggio{

	public Zucchina(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(12);
		this.setNome("Zucchina");
		this.setResa(1.0);
	}
	
}
