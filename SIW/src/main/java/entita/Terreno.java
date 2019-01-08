package entita;

import java.util.ArrayList;

import entita.ortaggio.Ortaggio;

public class Terreno {
    
	private int id;
	private int idAzienda;
	private String locazione;
	/*
	 *  Le due booleane servono per indicare che tipologia di servizio è possibile avere sul terreno.
	 *  Se sono true è possibile avere quel tipo di servizio sul terreno.
	 */
	private boolean servizioParziale;
	private boolean servizioCompleto;
	private int dimensione;//in mt2
	private int dimensioneSerra;//in mt2
	private ArrayList<Ortaggio> ortaggi ;
	private double costo; //costo al mt2 del terreno
	private String periodiDisponibilita;
	
	public Terreno(int id, int idAzienda,String locazione,boolean servizioParziale, boolean servizioCompleto, int dimensione, double costo, String periodiDisponobilita) {
		this.id = id;
		this.idAzienda = idAzienda;
		this.locazione = locazione;
		this.servizioParziale = servizioParziale;
		this.servizioCompleto = servizioCompleto;
		this.dimensione = dimensione;
		this.costo = costo;
		this.periodiDisponibilita = periodiDisponobilita;
		ortaggi = new ArrayList<Ortaggio>();
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
		
	/*
	 * Setta la dimensione del terreno serra e controlla che quest ultima non sia maggiore di quella del terreno 
	 */
	public void setDimensioneSerra(int dimensioneSerra) {
		if(dimensioneSerra <= dimensione)
			this.dimensioneSerra = dimensioneSerra;
		else throw new IllegalArgumentException("La dimensione del Terreno Serra non può essere maggiore di quella del terreno");
	}

	
	public String getLocazione() {
		return locazione;
	}

	public void setLocazione(String locazione) {
		this.locazione = locazione;
	}

	public int getDimensione() {
		return dimensione;
	}

	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}

	public int getDimensioneSerra() {
		return dimensioneSerra;
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
	
	
	
}
