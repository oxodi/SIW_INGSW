package entita;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	private int id;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	
	public Cliente() {}
	
	public Cliente(int id, String nome, String cognome, Date dataDiNascita) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
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
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Cliente["+ this.getId() + ",";
	}

    public static void main(String[] args) {
		System.out.println("Ciao");
	}
}

