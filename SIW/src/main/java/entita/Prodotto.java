package entita;

public class Prodotto {

	private int id;
	private String nome;
	private String categoria;
	private String descrizione;
	private int quantita;
	private double costoUnitario;
	private int idAzienda;
	private String nomeAzienda;
	
	
	
	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public Prodotto() {
	}

	public Prodotto(int id, String nome, String categoria, String descrizione, int quantita, double costoUnitario, int idAzienda) {
		this.nome = nome;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.costoUnitario = costoUnitario;
		this.idAzienda = idAzienda;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
