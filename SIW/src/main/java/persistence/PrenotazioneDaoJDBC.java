package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
			Iterator<Entry<Integer, Integer>> it = prenotazione.getId_ortaggi().entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry<Integer, Integer> entry = (Entry<Integer, Integer>) it.next();
				String insert = "INSERT INTO prenotazione(id_cliente, id_terreno, id_ortaggio, quantita, data) VALUES (?,?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(insert);

				statement.setInt(1, prenotazione.getIdCliente());
				statement.setInt(2, prenotazione.getIdTerreno());
				statement.setInt(3, entry.getKey());
				statement.setInt(4, entry.getValue());
				long secs = prenotazione.getDataPrenotazione().getTime();
				statement.setDate(5, new java.sql.Date(secs));
				statement.executeUpdate();
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
			statement.setDate(1, (java.sql.Date) data);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prenotazione = new Prenotazione();
				HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				hashMap.put(result.getInt("id_ortaggio"), result.getInt("quantita"));
				prenotazione.setId_ortaggi(hashMap);
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
	public void cancella(Prenotazione prenotazione) {
		Connection connection = this.dataSource.getConnection();

		try {
			String delete = "DELETE FROM prenotazione WHERE id_cliente = ? AND id_terreno = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, prenotazione.getIdCliente());
			statement.setInt(2, prenotazione.getIdTerreno());

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
			statement.setInt(1, idCliente);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prenotazione = new Prenotazione();
				HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				hashMap.put(result.getInt("id_ortaggio"), result.getInt("quantita"));
				prenotazione.setId_ortaggi(hashMap);
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
			statement.setInt(1, idTerreno);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prenotazione = new Prenotazione();
				HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				hashMap.put(result.getInt("id_ortaggio"), result.getInt("quantita"));
				prenotazione.setId_ortaggi(hashMap);
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
				HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				hashMap.put(result.getInt("id_ortaggio"), result.getInt("quantita"));
				prenotazione.setId_ortaggi(hashMap);
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
	public List<Prenotazione> cercaPerClienteTerreno(int idCliente, int idTerreno) {
		Connection connection = this.dataSource.getConnection();
		List<Prenotazione> prenotazioni = new LinkedList<Prenotazione>();

		try {
			Prenotazione prenotazione;
			PreparedStatement statement;
			String query = "SELECT * FROM prenotazione WHERE id_cliente = ? AND id_terreno = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, idCliente);
			statement.setInt(2, idTerreno);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prenotazione = new Prenotazione();
				HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
				prenotazione.setIdCliente(result.getInt("id_cliente"));
				prenotazione.setIdTerreno(result.getInt("id_terreno"));
				hashMap.put(result.getInt("id_ortaggio"), result.getInt("quantita"));
				prenotazione.setId_ortaggi(hashMap);
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
