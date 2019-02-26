package entita.ortaggio;

public class Finocchio extends Ortaggio{
	
	public Finocchio() {
		this.setId(16);
		this.setNome("Finocchio");
		this.setResa(2.0);
		this.setPeriodoColtivazione("autunno");
	}
	
	
	public Finocchio(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(16);
		this.setNome("Finocchio");
		this.setResa(2.0);
		this.setPeriodoColtivazione("autunno");
	}
	

}
