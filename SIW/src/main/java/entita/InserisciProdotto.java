package entita;

public class InserisciProdotto {

	private int idAzienda;
	private int idProdotto;
	private int quantita;
	private double costoUnitario;
	
	public InserisciProdotto() {}

	public InserisciProdotto(int idAzienda, int idProdotto, int quantita, double costoUnitario) {
		this.idAzienda = idAzienda;
		this.idProdotto = idProdotto;
		this.quantita = quantita;
		this.costoUnitario = costoUnitario;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

}
