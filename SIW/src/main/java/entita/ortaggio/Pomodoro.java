package entita.ortaggio;



public class Pomodoro extends Ortaggio {

	public Pomodoro(double prezzo, String tempoColtivazione, String periodoColtivazione, int idAzienda) {
		super(prezzo, tempoColtivazione, periodoColtivazione, idAzienda);
		this.setId(10);
		this.setNome("Pomodoro");
		this.setResa(1.0);
	}



}
