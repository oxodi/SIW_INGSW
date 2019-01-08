package entita.ortaggio;

public class Patata extends Ortaggio {

	public Patata(double prezzo, String tempoColtivazione, String periodoColtivazione,  int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(7);
		this.setNome("Patata");
		this.setResa(1.0);
	}
	

}
