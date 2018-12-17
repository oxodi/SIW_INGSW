package entita;

import java.util.ArrayList;

public class Azienda {

	private String nome;
	private String partitaIVA;
	private String titolare;
	private String sedeLegale;
	private String descrizioneServizi;
	private ArrayList<Terreno> terreni;
	
	public Azienda(String nome, String partitaIVA, String titolare, String sedeLegale, String descrizioneServizi) {
		this.nome = nome;
		this.partitaIVA = partitaIVA;
		this.titolare = titolare;
		this.sedeLegale = sedeLegale;
		this.descrizioneServizi = descrizioneServizi;
		
		terreni = new ArrayList<Terreno>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public String getTitolare() {
		return titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

	public String getSedeLegale() {
		return sedeLegale;
	}

	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}

	public String getDescrizioneServizi() {
		return descrizioneServizi;
	}

	public void setDescrizioneServizi(String descrizioneServizi) {
		this.descrizioneServizi = descrizioneServizi;
	}




}
