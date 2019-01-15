package entita.ortaggio;

public abstract class Ortaggio {
	private int id;
	private String nome;
	private double prezzo;
	private String tempoColtivazione;
	private String periodoColtivazione;
	private double resa;

	public Ortaggio() {
	}

	public Ortaggio(double prezzo, String tempoColtivazione, String periodoColtivazione) {
		this.prezzo = prezzo;
		this.tempoColtivazione = tempoColtivazione;
		this.periodoColtivazione = periodoColtivazione;
	}

	public double getResa() {
		return resa;
	}

	public void setResa(double d) {
		this.resa = d;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
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
		String output = "Ortaggio[" + this.id + ", " + this.nome + ", " + this.prezzo + ", " + this.periodoColtivazione
				+ ", " + this.tempoColtivazione + ", " + this.resa + "]";
		return output;

	}

}
