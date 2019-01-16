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
import entita.ortaggio.Melanzana;
import entita.ortaggio.Ortaggio;
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
		try {
			Class.forName("org.postgresql.Driver");
			DataSource dataSource = new DataSource("jdbc:postgresql://149.202.43.174:5432/DataGrower","postgres","life2play");
		
			
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
			
			Date date = new Date();
//			Cliente cliente = new Cliente(1, "alessandro", "pedace", "ciaa", date , "ciao", "1234", "email@email");
//			ClienteDao clientedao = new ClienteDaoJDBC(dataSource);
//			clientedao.salva(cliente);
		
			Prenotazione prenotazione = new Prenotazione(0, 1, 1, date);
			PrenotazioneDao prenotazionedao = new PrenotazioneDaoJDBC(dataSource);
			prenotazionedao.salva(prenotazione);
	
			
			
//			Prodotto prodotto = new Prodotto(0, "giuseppeeeeee", "turccccco", "duro");
//			ProdottoDao prodottodao = new ProdottoDaoJDBC(dataSource);
//			prodottodao.salva(prodotto);
		}	
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}			
	}

}
