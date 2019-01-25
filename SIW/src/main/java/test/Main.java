package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entita.Azienda;
import entita.Cliente;
import entita.Prenotazione;
import persistence.PostgresDAOFactory;

public class Main {

	public static void main(String[] args) {
		
		PostgresDAOFactory factory = new PostgresDAOFactory();
		List<Azienda> aziende = new LinkedList<Azienda>();
		aziende = factory.getAziendaDAO().cercaAziendaPerTipologiaPeriodo(true, true, "Aprile");
		for(Azienda a : aziende) {
			System.out.println(a.toString());
		}
	}
}
