package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestoreID {

	
	public static int getId(Connection connection, String sequenceId) {
		int id = 0;
		String query = "SELECT nextval('"+ sequenceId +"') AS id";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			result.next();
			id = result.getInt("id");

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return id;
	}
}
