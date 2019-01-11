package entita;

import java.util.Date;

public class Acquisto {

	private int id;
	private int idCliente;
	private int idProdotto;
	private Date dataAcquisto;
	private Date dataRitiro;
	
	public Acquisto() {}
	
	public Acquisto(int id, int idCliente, int idProdotto, Date dataAcquisto, Date dataRitiro) {
		this.id = id;
		this.idCliente = idCliente;
		this.idProdotto = idProdotto;
		this.dataAcquisto = dataAcquisto;
		this.dataRitiro = dataAcquisto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataRitiro() {
		return dataRitiro;
	}

	public void setDataRitiro(Date dataRitiro) {
		this.dataRitiro = dataRitiro;
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
