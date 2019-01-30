package entita.ortaggio;

public abstract class Ortaggio {
	private int id;
	private String nome;
	private double prezzo;
	private int tempoColtivazione;
	private String periodoColtivazione;
	private double resa;
	private int id_terreno;

	public Ortaggio() {
	}

	public Ortaggio(double prezzo, int id_terreno, int tempoColtivazione) {
		this.prezzo = prezzo;
		this.id_terreno = id_terreno;
		this.tempoColtivazione = tempoColtivazione;
	}

	public int getId_terreno() {
		return id_terreno;
	}

	public void setId_terreno(int id_terreno) {
		this.id_terreno = id_terreno;
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

	public int getTempoColtivazione() {
		return tempoColtivazione;
	}

	public void setTempoColtivazione(int tempoColtivazione) {
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
