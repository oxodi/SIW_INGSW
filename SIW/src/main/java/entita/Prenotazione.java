package entita;

import java.util.Date;

public class Prenotazione {

	private int idCliente;
	private int idTerreno;
	private Date dataPrenotazione;
	private int id_ortaggio;
	private int quantita;
	private boolean serra;

	public Prenotazione() {
	}

	public Prenotazione(int idCliente, int idTerreno, Date dataPrenotazione, int  id_ortaggio,int quantita, boolean serra) {
		this.idCliente = idCliente;
		this.idTerreno = idTerreno;
		this.dataPrenotazione = dataPrenotazione;
		this.id_ortaggio = id_ortaggio;
		this.quantita = quantita;
		this.serra = serra;
	}

	public boolean isSerra() {
		return serra;
	}

	public void setSerra(boolean serra) {
		this.serra = serra;
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
	
	
	
	public int getId_ortaggio() {
		return id_ortaggio;
	}

	public void setId_ortaggio(int id_ortaggio) {
		this.id_ortaggio = id_ortaggio;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}



}
