package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entita.Azienda;
import entita.Cliente;
import entita.Prenotazione;
import entita.Terreno;
import entita.ortaggio.Ortaggio;
import persistence.PostgresDAOFactory;
import persistence.dao.TerrenoDao;

public class Main {

	public static void main(String[] args) {

		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		TerrenoDao terrenodao = factory.getTerrenoDAO();
		List<Ortaggio> ortaggi = new ArrayList<Ortaggio>();
		Terreno terreno = new Terreno(10, "provaerrori", true, true, 100, 10, null, 20.0, "annuale");
		terreno.setDimTerreno(50);
		terrenodao.aggiorna(terreno);
		System.out.println(terreno.toString());
	}

}
