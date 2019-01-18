package entita;

import java.util.Date;
import java.util.HashMap;

public class Prenotazione {

	private int idCliente;
	private int idTerreno;
	private Date dataPrenotazione;
	private HashMap<Integer,Integer> id_ortaggi;

	public Prenotazione() {
	}

	public Prenotazione(int idCliente, int idTerreno, Date dataPrenotazione, HashMap<Integer,Integer> id_ortaggi) {
		this.idCliente = idCliente;
		this.idTerreno = idTerreno;
		this.dataPrenotazione = dataPrenotazione;
		this.id_ortaggi = id_ortaggi;
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

	public HashMap<Integer,Integer> getId_ortaggi() {
		return id_ortaggi;
	}

	public void setId_terreni(HashMap<Integer,Integer> id_ortaggi) {
		this.id_ortaggi = id_ortaggi;
	}

}
