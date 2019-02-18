package entita;

public class CategoriaProdotti {
	String categoria;
	int quantita;
	
	public CategoriaProdotti(String categoria) {
		this.categoria = categoria;
		this.quantita = 0;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
}
