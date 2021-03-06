package entita;

import java.util.Date;

public class Acquisto {

	private int id;
	private int idCliente;
	private int idProdotto;
	private Date dataAcquisto;
	private int quantita;
	private double importo;

	public Acquisto() {
	}

	public Acquisto(int idCliente, int idProdotto, Date dataAcquisto, int quantita, double importo) {
		this.idCliente = idCliente;
		this.idProdotto = idProdotto;
		this.dataAcquisto = dataAcquisto;
		this.quantita = quantita;
		this.importo = importo;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public Date getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

}
