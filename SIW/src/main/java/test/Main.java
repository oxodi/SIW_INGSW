package test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import entita.Azienda;
import entita.Cliente;
import entita.Prenotazione;
import entita.Prodotto;
import entita.Terreno;
import entita.ortaggio.Cavolo;
import entita.ortaggio.Cetriolo;
import entita.ortaggio.Cipolla;
import entita.ortaggio.Lattuga;
import entita.ortaggio.Melanzana;
import entita.ortaggio.Ortaggio;
import entita.ortaggio.Peperoncino;
import entita.ortaggio.Peperone;
import entita.ortaggio.Pomodoro;
import entita.ortaggio.Spinacio;
import entita.ortaggio.Zucchina;
import persistence.AziendaDaoJDBC;
import persistence.ClienteDaoJDBC;
import persistence.DataSource;
import persistence.OrtaggioDaoJDBC;
import persistence.PostgresDAOFactory;
import persistence.PrenotazioneDaoJDBC;
import persistence.ProdottoDaoJDBC;
import persistence.TerrenoDaoJDBC;
import persistence.dao.AziendaDao;
import persistence.dao.ClienteDao;
import persistence.dao.OrtaggioDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.ProdottoDao;
import persistence.dao.TerrenoDao;

public class Main {

	public static void main(String[] args) {
//		try {
//			Class.forName("org.postgresql.Driver");
//			DataSource dataSource = new DataSource("jdbc:postgresql://149.202.43.174:5432/DataGrower","postgres","life2play");

//			Terreno terreno = new Terreno(1, 3, "cia", true, true, 100,10, 10.0, "cia");
//			TerrenoDao terrenodao = new TerrenoDaoJDBC(dataSource);
//			terrenodao.salva(terreno);

//			Azienda azienda = new Azienda(4, "Luchino", "0123459655", "Bruno", "Uni", "sociale", "12345678", "descrizione", "email@email");
//			AziendaDao aziendadao = new AziendaDaoJDBC(dataSource);
//			aziendadao.salva(azienda);

//			Ortaggio ortaggio = new Melanzana(10.0, 10, "estate");
//			OrtaggioDao ortaggiodao = new OrtaggioDaoJDBC(dataSource);
//			ortaggiodao.salva(ortaggio);
		//

		// Date date = new Date();
//			Cliente cliente = new Cliente(1, "alessandro", "pedace", "ciaa", date , "ciao", "1234", "email@email");
//			ClienteDao clientedao = new ClienteDaoJDBC(dataSource);
//			clientedao.salva(cliente);

//			Prenotazione prenotazione = new Prenotazione(0, 1, 1, date);
//			PrenotazioneDao prenotazionedao = new PrenotazioneDaoJDBC(dataSource);
//			prenotazionedao.salva(prenotazione);

//			Prodotto prodotto = new Prodotto(0, "giuseppeeeeee", "turccccco", "duro");
//			ProdottoDao prodottodao = new ProdottoDaoJDBC(dataSource);
//			prodottodao.salva(prodotto);
//		}	
//		catch (Exception e) {
//			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
//			e.printStackTrace();
//		}	

		PostgresDAOFactory factory = new PostgresDAOFactory();
		// Azienda azienda = new Azienda(9, "Ciaaaaaaaaaaa", "0123459655", "Bruno10",
		// "Uni", "sociale", "12345678", "descrizione", "email@email");
		// factory.getAziendaDAO().salva(azienda);
		
//factory.getTerrenoDAO().salva(terreno);
		Terreno terreno = new Terreno();
		terreno.setId(21);
		factory.getTerrenoDAO().cancella(terreno);
		
//		Ortaggio ortaggio = new Cetriolo();
//		factory.getOrtaggioDAO().salva(ortaggio);
//		factory.getTerrenoDAO().aggiungiOrtaggio(terreno.getId(), ortaggio.getId(), 12.10, 10, "6 mesi");
		//factory.getTerrenoDAO().aggiungiOrtaggio(20, 2, 1.2, 9, "2 mesi");

		//System.out.println(factory.getTerrenoDAO().cercaTutti().toString());
		//System.out.println(factory.getTerrenoDAO().cercaOrtaggiPerTerreno(16));

	}
}
