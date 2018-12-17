package entita.ortaggio;

/*
 * Utilizziamo il pattern Builder per la creazione degli ortaggi, questa classe nello schema del pattern ricopre il ruolo di PRODUCT.
 */
public class Ortaggio {
	private String nome = "";
	private int prezzo = 0;
	private String tempoColtivazione = "";
	private String  periodoColtivazione = "";
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public String getTempoColtivazione() {
		return tempoColtivazione;
	}
	public void setTempoColtivazione(String tempoColtivazione) {
		this.tempoColtivazione = tempoColtivazione;
	}
	public String getPeriodoColtivazione() {
		return periodoColtivazione;
	}
	public void setPeriodoColtivazione(String periodoColtivazione) {
		this.periodoColtivazione = periodoColtivazione;
	}
	
	@Override
	public String toString() {
		String output = "Ortaggio["+this.nome+ ", " +
						 this.prezzo+", "+
						 this.periodoColtivazione+", "+
						 this.tempoColtivazione+ "]";
		return output;
	}
}
