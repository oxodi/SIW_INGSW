package entita;

import java.util.ArrayList;
import java.util.List;

public class Azienda {

	private int id;
	private String partitaIVA;
	private String referente;
	private String sedeLegale;
	private String ragioneSociale;
	private String telefono;
	private String email;
	private String indirizzo;
	private String citta;	
	private String cap;
	private String provincia;
	private String descrizioneServizi;
	private List<Terreno> terreni;
	private List<Prodotto> prodotti;

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public Azienda() {
	}

	public Azienda(String ragioneSociale,  String referente, String sedeLegale, String indirizzo, String citta, String cap, String provincia,
			String partitaIVA,  String telefono, String descrizioneServizi, String email) {
		this.ragioneSociale = ragioneSociale;
		this.referente = referente;
		this.sedeLegale = sedeLegale;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.cap = cap;
		this.provincia = provincia;
		this.partitaIVA = partitaIVA;
		this.telefono = telefono;
		this.descrizioneServizi = descrizioneServizi;
		this.email = email;
		terreni = new ArrayList<Terreno>(); // controllare inserimento terreni
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

	public List<Terreno> getTerreni() {
		return terreni;
	}

	public void setTerreni(List<Terreno> list) {
		this.terreni = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	
	@Override
	public String toString() {
		String output = "Azienda[ "+this.ragioneSociale+", "+this.id+"]";
		return output;
	}

}
