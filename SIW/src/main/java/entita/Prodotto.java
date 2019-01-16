package entita;

public class Prodotto {

	private int id;
	private String nome;
	private String categoria;
	private String descrizione;

	public Prodotto() {
	}

	public Prodotto(int id, String nome, String categoria, String descrizione) {

		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.descrizione = descrizione;
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
