package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestoreID {

	
	public static int getId(Connection connection, String sequenceId, String entita) {
		int id = 0;
		int restartValue = maxID(connection, entita);
		
		String restartQuery = "ALTER SEQUENCE "+ sequenceId + " RESTART WITH "+ restartValue;
		String query = "SELECT nextval('"+ sequenceId +"') AS id ";

		try {
			PreparedStatement statementRestart = connection.prepareStatement(restartQuery);
			statementRestart.executeUpdate();
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			result.next();
			id = result.getInt("id");

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return id;
	}
	
	
	//massimo nella colonna id
	public static int maxID(Connection connection, String entita) {

		int maxid=0;

		try {
			PreparedStatement statement;
			String query = "SELECT max(id) FROM " + entita; 

			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if(result.next())
				maxid = result.getInt("max"); 

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());

		}

		return maxid+1;
	}
}
