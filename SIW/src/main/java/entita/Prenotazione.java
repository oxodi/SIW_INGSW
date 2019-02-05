package entita;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Prenotazione {

	private int idCliente;
	private int idTerreno;
	private Date dataPrenotazione;
	private HashMap<Integer,Integer> id_ortaggi;
	private boolean serra;

	public Prenotazione() {
	}

	public Prenotazione(int idCliente, int idTerreno, Date dataPrenotazione, HashMap<Integer,Integer> id_ortaggi, boolean serra) {
		this.idCliente = idCliente;
		this.idTerreno = idTerreno;
		this.dataPrenotazione = dataPrenotazione;
		this.id_ortaggi = id_ortaggi;
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

	public HashMap<Integer,Integer> getId_ortaggi() {
		return id_ortaggi;
	}

	public void setId_ortaggi(HashMap<Integer,Integer> id_ortaggi) {
		this.id_ortaggi = id_ortaggi;
	}
	
	@Override
	public String toString() {
		String output = "Prenotazione[ idCliente: " + this.idCliente + ", idTerreno: " + this.idTerreno + ", " + this.toStringOrtaggi(getId_ortaggi()) + ", dataPrenotazione: " + this.dataPrenotazione + "]";
		return output;
		
		
	}
	
	public String toStringOrtaggi(HashMap<Integer, Integer> ortaggi) {
		String output = "";
		Iterator<Entry<Integer, Integer>> it = ortaggi.entrySet().iterator();
		  while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = (Entry<Integer, Integer>) it.next();
		    output += "Ortaggio: "+entry.getKey()+", Quantità: "+entry.getValue();
		    }
		return output;
	}

}
