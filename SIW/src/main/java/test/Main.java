package test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import entita.Cliente;
import entita.Terreno;
import persistence.ClienteDaoJDBC;
import persistence.DataSource;
import persistence.PostgresDAOFactory;
import persistence.TerrenoDaoJDBC;
import persistence.dao.ClienteDao;
import persistence.dao.TerrenoDao;


public class Main {

	
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			DataSource dataSource = new DataSource("jdbc:postgresql://149.202.43.174:5432/DataGrower","postgres","life2play");
		
			
			Terreno terreno = new Terreno(0, 1, "MARIA", true, true, 100,10, 10.0, "estate");
			TerrenoDao terrenodao = new TerrenoDaoJDBC(dataSource);
			terrenodao.salva(terreno);
			//System.out.println(terrenodao.cercaTutti().get(0));
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}			
	}

}
