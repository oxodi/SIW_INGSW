package entita;

import java.util.ArrayList;

import entita.ortaggio.Ortaggio;

public class Terreno {
    
	//Rappresenta le tipologie di servizi offerte per ogni terreno
	public enum Tipologia{ PARZIALE, COMPLETO }


	private String locazione;
	private ArrayList<Tipologia>tipologiaServizio;
	private int dimensione;//in mt2
	private int dimensioneSerra;//in mt2
	private ArrayList<Ortaggio> ortaggi ;
	private double costo; //costo al mt2 del terreno
	private String periodiDisponibilita;
	
	public Terreno(String locazione, int dimensione, double costo, String periodiDisponobilita) {
		this.locazione = locazione;
		this.dimensione = dimensione;
		this.costo = costo;
		this.periodiDisponibilita = periodiDisponobilita;
		
		tipologiaServizio = new ArrayList<Tipologia>();
		ortaggi = new ArrayList<Ortaggio>();
	}

	public void aggiungiTipologia(Tipologia tipologia) {
		tipologiaServizio.add(tipologia);
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
