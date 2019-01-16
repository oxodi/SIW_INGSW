package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import entita.Prenotazione;
import persistence.dao.PrenotazioneDao;

public class PrenotazioneDaoJDBC implements PrenotazioneDao {

	private DataSource dataSource;

	public PrenotazioneDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(Prenotazione prenotazione) {
		Connection connection = this.dataSource.getConnection();

		try {
//			int id = GestoreID.getId(connection);
//			prenotazione.setId(id);

			String insert = "INSERT INTO prenotazione(id, id_cliente, id_terreno, data) VALUES (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, prenotazione.getId());
			statement.setInt(2, prenotazione.getIdCliente());
			statement.setInt(3, prenotazione.getIdTerreno());
			long secs = prenotazione.getDataPrenotazione().getTime();
			statement.setDate(4, new java.sql.Date(secs));

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public Prenotazione cercaPerChiavePrimaria(int id) {
		Connection connection = this.dataSource.getConnection();
		Prenotazione prenotazione = null;

		try {
			PreparedStatement statement;
			String query = "SELECT * FROM prenotazione WHERE id = ?";
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {

				prenotazione = new Prenotazione();
				prenotazione.setId(result.getInt("id"));
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				long secs = result.getDate("data").getTime();
				prenotazione.setDataPrenotazione(new java.util.Date(secs));

			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prenotazione;
	}

	@Override
	public List<Prenotazione> cercaPerData(Date data) {
		Connection connection = this.dataSource.getConnection();
		List<Prenotazione> prenotazioni = new LinkedList<Prenotazione>();

		try {
			Prenotazione prenotazione;
			PreparedStatement statement;
			String query = "SELECT * FROM prenotazione WHERE data = ?";

			statement = connection.prepareStatement(query);
			statement.setDate(4, (java.sql.Date) data);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prenotazione = new Prenotazione();
				prenotazione.setId(result.getInt("id"));
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				long secs = result.getDate("data").getTime();
				prenotazione.setDataPrenotazione(new java.util.Date(secs));

				prenotazioni.add(prenotazione);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prenotazioni;
	}

	@Override
	public void aggiorna(Prenotazione prenotazione) {
		Connection connection = this.dataSource.getConnection();

		try {
			String update = "UPDATE prenotazione SET id_cliente = ?, id_terreno = ?, data = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setInt(1, prenotazione.getId());
			statement.setInt(2, prenotazione.getIdCliente());
			statement.setInt(3, prenotazione.getIdTerreno());

			long secs = prenotazione.getDataPrenotazione().getTime();
			statement.setDate(4, new java.sql.Date(secs));

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void cancella(Prenotazione prenotazione) {
		Connection connection = this.dataSource.getConnection();

		try {
			String delete = "DELETE FROM prenotazione WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, prenotazione.getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public List<Prenotazione> cercaPerCliente(int idCliente) {
		Connection connection = this.dataSource.getConnection();
		List<Prenotazione> prenotazioni = new LinkedList<Prenotazione>();

		try {
			Prenotazione prenotazione;
			PreparedStatement statement;
			String query = "SELECT * FROM prenotazione WHERE id_cliente = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(2, idCliente);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prenotazione = new Prenotazione();
				prenotazione.setId(result.getInt("id"));
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				long secs = result.getDate("data").getTime();
				prenotazione.setDataPrenotazione(new java.util.Date(secs));

				prenotazioni.add(prenotazione);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prenotazioni;
	}

	@Override
	public List<Prenotazione> cercaPerTerreno(int idTerreno) {
		Connection connection = this.dataSource.getConnection();
		List<Prenotazione> prenotazioni = new LinkedList<Prenotazione>();

		try {
			Prenotazione prenotazione;
			PreparedStatement statement;
			String query = "SELECT * FROM prenotazione WHERE id_terreno = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(3, idTerreno);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prenotazione = new Prenotazione();
				prenotazione.setId(result.getInt("id"));
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				long secs = result.getDate("data").getTime();
				prenotazione.setDataPrenotazione(new java.util.Date(secs));

				prenotazioni.add(prenotazione);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prenotazioni;
	}

	@Override
	public List<Prenotazione> cercaTutti() {
		Connection connection = this.dataSource.getConnection();
		List<Prenotazione> prenotazioni = new LinkedList<Prenotazione>();

		try {
			Prenotazione prenotazione;
			PreparedStatement statement;
			String query = "SELECT * FROM prenotazione";

			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prenotazione = new Prenotazione();
				prenotazione.setId(result.getInt("id"));
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				long secs = result.getDate("data").getTime();
				prenotazione.setDataPrenotazione(new java.util.Date(secs));

				prenotazioni.add(prenotazione);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prenotazioni;
	}

}
