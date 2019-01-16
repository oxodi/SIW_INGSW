package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entita.Azienda;
import persistence.dao.AziendaDao;

public class AziendaDaoJDBC implements AziendaDao {

	private DataSource dataSource;

	public AziendaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(Azienda azienda) {
		Connection connection = this.dataSource.getConnection();

		try {
			//int id = GestoreID.getId(connection);
			//azienda.setId(id);

			String insert = "INSERT INTO azienda(id, ragione_sociale, partita_iva, referente, "
					+ "sede_legale, telefono, descrizione, email) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, azienda.getId());
			statement.setString(2, azienda.getRagioneSociale());
			statement.setString(3, azienda.getPartitaIVA());
			statement.setString(4, azienda.getReferente());
			statement.setString(5, azienda.getSedeLegale());
			statement.setString(6, azienda.getTelefono());
			statement.setString(7, azienda.getDescrizioneServizi());
			statement.setString(8, azienda.getEmail());

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
	public Azienda cercaPerChiavePrimaria(int id) {
		Connection connection = this.dataSource.getConnection();
		Azienda azienda = null;
		try {
			PreparedStatement statement;
			String query = "SELECT * FROM azienda WHERE id = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {

				azienda = new Azienda();
				azienda.setId(result.getInt("id"));
				azienda.setRagioneSociale(result.getString("ragione_sociale"));
				azienda.setPartitaIVA(result.getString("partita_iva"));
				azienda.setReferente(result.getString("referente"));
				azienda.setSedeLegale(result.getString("sede_legale"));
				azienda.setTelefono(result.getString("telefono"));
				azienda.setDescrizioneServizi(result.getString("descrizione"));
				azienda.setEmail(result.getString("email"));

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
		return azienda;
	}

	@Override
	public List<Azienda> cercaTutti() {
		Connection connection = this.dataSource.getConnection();
		List<Azienda> aziende = new LinkedList<Azienda>();

		try {
			Azienda azienda;
			PreparedStatement statement;
			String query = "SELECT * FROM azienda";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				azienda = new Azienda();
				azienda.setId(result.getInt("id"));
				azienda.setRagioneSociale(result.getString("ragione_sociale"));
				azienda.setPartitaIVA(result.getString("partita_iva"));
				azienda.setReferente(result.getString("referente"));
				azienda.setSedeLegale(result.getString("sede_legale"));
				azienda.setTelefono(result.getString("telefono"));
				azienda.setDescrizioneServizi(result.getString("descrizione"));
				azienda.setEmail(result.getString("email"));

				aziende.add(azienda);
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
		return aziende;

	}

	@Override
	public void aggiorna(Azienda azienda) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "UPDATE azienda SET id = ?, ragione_sociale = ?, partita_iva = ?, referente = ?, sede_legale = ?, telefono = ?,"
					+ " descrizione = ?, email = ? WHERE id=?";

			PreparedStatement statement = connection.prepareStatement(update);

			statement.setInt(1, azienda.getId());
			statement.setString(2, azienda.getRagioneSociale());
			statement.setString(3, azienda.getPartitaIVA());
			statement.setString(4, azienda.getReferente());
			statement.setString(5, azienda.getSedeLegale());
			statement.setString(6, azienda.getTelefono());
			statement.setString(7, azienda.getDescrizioneServizi());
			statement.setString(8, azienda.getEmail());

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
	public void cancella(Azienda azienda) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "DELETE FROM azienda WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, azienda.getId());
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
	public void setPassword(Azienda azienda, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "UPDATE azienda SET password = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(1, password);
			statement.setInt(2, azienda.getId());
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

}
