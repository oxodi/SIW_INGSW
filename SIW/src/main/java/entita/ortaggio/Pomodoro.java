package entita.ortaggio;



public class Pomodoro extends Ortaggio {

	public Pomodoro() {
		this.setId(10);
		this.setNome("Pomodoro");
		this.setResa(1.0);
		this.setPeriodoColtivazione("primavera");
	}
	
	public Pomodoro(double prezzo, int id_terreno, int tempoColtivazione) {
		super(prezzo, id_terreno, tempoColtivazione);
		this.setId(10);
		this.setNome("Pomodoro");
		this.setResa(1.0);
		this.setPeriodoColtivazione("primavera");
	}



}
