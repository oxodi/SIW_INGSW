package entita;

import java.util.ArrayList;

public class Azienda {

	private int id;
	private String nome;
	private String partitaIVA;
	private String referente;
	private String sedeLegale;
	private String ragioneSociale;
	private String telefono;
	private String email;
	private String descrizioneServizi;
	private ArrayList<Terreno> terreni;
	
    public Azienda(){}
	
	public Azienda(int id, String nome, String partitaIVA, String referente, String sedeLegale,String ragioneSociale, String telefono, String descrizioneServizi, String email) {
		this.id = id;
		this.nome = nome;
		this.partitaIVA = partitaIVA;
		this.referente = referente;
		this.sedeLegale = sedeLegale;
		this.ragioneSociale = ragioneSociale;
		this.telefono = telefono;
		this.email = email;
		this.descrizioneServizi = descrizioneServizi;
		terreni = new ArrayList<Terreno>();  //controllare inserimento terreni
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getReferente() {
		return referente;
	}

	public void setReferente(String referente) {
		this.referente = referente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public ArrayList<Terreno> getTerreni() {
		return terreni;
	}

	public void setTerreni(ArrayList<Terreno> terreni) {
		this.terreni = terreni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return referente;
	}

	public void setTitolare(String titolare) {
		this.referente = titolare;
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
