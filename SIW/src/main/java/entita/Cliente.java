package entita;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	private int id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private Date dataDiNascita;
	private String indirizzo;
	private String telefono;
	private String email;

	public Cliente() {
	}

	public Cliente(int id, String nome, String cognome, String codiceFiscale, Date dataDiNascita, String indirizzo,
			String telefono, String email) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataDiNascita = dataDiNascita;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;

	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return "Cliente[" + this.getId() + "," + this.getNome() + ", " + this.getCognome() + ", "
				+ this.getCodiceFiscale() + ", " + sdf.format(this.getDataDiNascita()) + ", " + this.getIndirizzo()
				+ ", " + this.getTelefono() + ", " + this.getEmail() + "]";

	}
}
