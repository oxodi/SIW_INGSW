package entita.ortaggio;


public abstract class Ortaggio {
	private int  id;
	private int idAzienda;
	private String nome;
	private double prezzo;
	private String tempoColtivazione;
	private String  periodoColtivazione;
	private double resa;
	
	public Ortaggio(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		this.prezzo = prezzo;
		this.tempoColtivazione = tempoColtivazione;
		this.periodoColtivazione = periodoColtivazione;
		this.setIdAzienda(idAzienda);
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

	@Override
	public String toString() {
		String output = "Ortaggio["+this.id+ ", "+
						 this.nome+ ", " +
						 this.prezzo+", "+
						 this.periodoColtivazione+", "+
						 this.tempoColtivazione+ ", "+
						 this.resa+"]";
		return output;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
}
