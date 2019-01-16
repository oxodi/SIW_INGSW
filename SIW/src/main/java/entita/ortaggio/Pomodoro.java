package entita.ortaggio;



public class Pomodoro extends Ortaggio {

	public Pomodoro() {
		this.setId(10);
		this.setNome("Pomodoro");
		this.setResa(1.0);
	}
	
	public Pomodoro(double prezzo, int tempoColtivazione, String periodoColtivazione) {
		super(prezzo, tempoColtivazione, periodoColtivazione);
		this.setId(10);
		this.setNome("Pomodoro");
		this.setResa(1.0);
	}



}
