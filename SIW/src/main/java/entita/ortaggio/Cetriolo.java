package entita.ortaggio;

public class Cetriolo extends Ortaggio{

	public Cetriolo(double prezzo, String tempoColtivazione, String periodoColtivazione,  int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(3);
		this.setNome("Cetriolo");
		this.setResa(1.0);
	}
}
