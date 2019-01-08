package entita.ortaggio;

public class Melanzana extends Ortaggio {

	public Melanzana(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(6);
		this.setNome("Melanzana");
		this.setResa(1.0);
	}
	

}
