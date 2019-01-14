package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestoreID {
	//id automatico
	private static final String query = "SELECT nextval('Cliente') AS Id";

	public static int getId(Connection connection) {
		int id = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			result.next(); 
			id = result.getInt("Id");
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return id;
	}
}
