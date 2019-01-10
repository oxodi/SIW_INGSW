package entita;

import java.util.Date;

public class Prenotazione {

	private int id;
	private int idCliente;
	private int idTerreno;
	private Date dataPrenotazione;
	
	public Prenotazione() {}
	
	public Prenotazione(int id, int idCliente, int idTerreno, Date dataPrenotazione) {
		this.id = id;
		this.idCliente = idCliente;
		this.idTerreno = idTerreno;
		this.dataPrenotazione = dataPrenotazione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTerreno() {
		return idTerreno;
	}

	public void setIdTerreno(int idTerreno) {
		this.idTerreno = idTerreno;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	
	
}
