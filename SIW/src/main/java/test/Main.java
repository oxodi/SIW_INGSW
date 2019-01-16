package test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import entita.Azienda;
import entita.Cliente;
import entita.Terreno;
import persistence.AziendaDaoJDBC;
import persistence.ClienteDaoJDBC;
import persistence.DataSource;
import persistence.PostgresDAOFactory;
import persistence.TerrenoDaoJDBC;
import persistence.dao.AziendaDao;
import persistence.dao.ClienteDao;
import persistence.dao.TerrenoDao;


public class Main {

	
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			DataSource dataSource = new DataSource("jdbc:postgresql://149.202.43.174:5432/DataGrower","postgres","life2play");
		
			
			Terreno terreno = new Terreno(1, 3, "cia", true, true, 100,10, 10.0, "cia");
			
			TerrenoDao terrenodao = new TerrenoDaoJDBC(dataSource);
			terrenodao.salva(terreno);
//			//System.out.println(terrenodao.cercaTutti().get(0));
//			Azienda azienda = new Azienda(4, "Luchino", "0123459655", "Bruno", "Uni", "sociale", "12345678", "descrizione", "email@email");
//			AziendaDao aziendadao = new AziendaDaoJDBC(dataSource);
//			aziendadao.salva(azienda);
		
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}			
	}

}
