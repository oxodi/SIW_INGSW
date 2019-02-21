package entita;

import java.util.ArrayList;


import entita.ortaggio.Ortaggio;

public class Terreno {

	private int id;
	private int idAzienda;
	private String locazione;
	/*
	 * Le due booleane servono per indicare che tipologia di servizio è possibile
	 * avere sul terreno. Se sono true è possibile avere quel tipo di servizio sul
	 * terreno.
	 */
	private boolean servizioParziale;
	private boolean servizioCompleto;
	private int dimTerreno;// in mt2
	private int dimSerra;// in mt2
	private int terrenoPrenotato = 0;
	private int serraPrenotata = 0;
	private ArrayList<Ortaggio> ortaggi;
	private double costo; // costo al mt2 del terreno
	private String periodiDisponibilita;
	private String documento;

	public Terreno() {
	}

	public Terreno(int idAzienda, String locazione, boolean servizioParziale, boolean servizioCompleto, int dimTerreno,
			int dimSerra, ArrayList<Ortaggio> ortaggi, double costo, String periodiDisponobilita) {
		this.idAzienda = idAzienda;
		this.locazione = locazione;
		this.servizioParziale = servizioParziale;
		this.servizioCompleto = servizioCompleto;
		this.dimTerreno = dimTerreno;
		this.dimSerra = dimSerra;
		this.ortaggi = ortaggi;
		this.costo = costo;
		this.periodiDisponibilita = periodiDisponobilita;
	}

	public boolean isServizioParziale() {
		return servizioParziale;
	}

	public void setServizioParziale(boolean servizioParziale) {
		this.servizioParziale = servizioParziale;
	}

	public boolean isServizioCompleto() {
		return servizioCompleto;
	}

	public void setServizioCompleto(boolean servizioCompleto) {
		this.servizioCompleto = servizioCompleto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}

	public void aggiungiOrtaggio(Ortaggio ortaggio) {
		ortaggi.add(ortaggio);
	}

	public ArrayList<Ortaggio> getOrtaggi() {
		return ortaggi;
	}

	public void setOrtaggi(ArrayList<Ortaggio> ortaggi) {
		this.ortaggi = ortaggi;
	}

	/*
	 * Setta la dimensione del terreno serra e controlla che quest ultima non sia
	 * maggiore di quella del terreno
	 */
	public void setDimSerra(int dimensioneSerra) {
			this.dimSerra = dimensioneSerra;
	}

	public String getLocazione() {
		return locazione;
	}

	public void setLocazione(String locazione) {
		this.locazione = locazione;
	}

	public int getDimTerreno() {
		return dimTerreno;
	}

	public void setDimTerreno(int dimensione) {
		this.dimTerreno = dimensione;
	}

	public int getDimSerra() {
		return dimSerra;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getPeriodiDisponibilita() {
		return periodiDisponibilita;
	}

	public void setPeriodiDisponibilita(String periodiDisponibilita) {
		this.periodiDisponibilita = periodiDisponibilita;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public int getTerrenoPrenotato() {
		return terrenoPrenotato;
	}

	public void setTerrenoPrenotato(int terrenoPrenotato) {
		this.terrenoPrenotato = terrenoPrenotato;
	}

	public int getSerraPrenotata() {
		return serraPrenotata;
	}

	public void setSerraPrenotata(int serraPrenotata) {
		this.serraPrenotata = serraPrenotata;
	}

	@Override
	public String toString() {
		String output = "Terreno[" + this.id + ", " + this.idAzienda + ", " + this.locazione + ", "
				+ this.servizioParziale + ", " + this.servizioCompleto + ", " + this.dimTerreno + ", "
				+ this.dimSerra + ", " + this.costo + ", " + this.periodiDisponibilita + "] ";

		String output2 = toStringOrtaggi(this.ortaggi);
		return output + output2;
	}

	public String toStringOrtaggi(ArrayList<Ortaggio> ortaggi) {
		String output = "";

		for (Ortaggio ortaggio : ortaggi) {
			output += ortaggio.toString() + " ";
		}

		return output;
	}

}
