package entita.ortaggio;

public class Peperone extends Ortaggio{

	public Peperone(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(9);
		this.setNome("Peperone");
		this.setResa(1.0);
	}
	

}
