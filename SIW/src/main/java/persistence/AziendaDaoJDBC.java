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

			int id = GestoreID.getId(connection, "azienda_id_seq", "azienda");
			azienda.setId(id);

			String insert = "INSERT INTO azienda(id, ragione_sociale, referente, sede_legale, indirizzo, " 
					+ "citta, cap, provincia, partita_iva, telefono, descrizione, email) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, azienda.getId());
			statement.setString(2, azienda.getRagioneSociale());
			statement.setString(3, azienda.getReferente());
			statement.setString(4, azienda.getSedeLegale());
			statement.setString(5, azienda.getIndirizzo());
			statement.setString(6, azienda.getCitta());
			statement.setString(7, azienda.getCap());
			statement.setString(8, azienda.getProvincia());
			statement.setString(9, azienda.getPartitaIVA());
			statement.setString(10, azienda.getTelefono());
			statement.setString(11, azienda.getDescrizioneServizi());
			statement.setString(12, azienda.getEmail());

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
				azienda.setReferente(result.getString("referente"));
				azienda.setSedeLegale(result.getString("sede_legale"));
				azienda.setIndirizzo(result.getString("indirizzo"));
				azienda.setCitta(result.getString("citta"));
				azienda.setCap(result.getString("cap"));
				azienda.setProvincia(result.getString("provincia"));
				azienda.setPartitaIVA(result.getString("partita_iva"));
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
				azienda.setReferente(result.getString("referente"));
				azienda.setSedeLegale(result.getString("sede_legale"));
				azienda.setIndirizzo(result.getString("indirizzo"));
				azienda.setCitta(result.getString("citta"));
				azienda.setCap(result.getString("cap"));
				azienda.setProvincia(result.getString("provincia"));
				azienda.setPartitaIVA(result.getString("partita_iva"));
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
			String update = "UPDATE azienda SET ragione_sociale=?, referente=?, sede_legale=?, indirizzo=?, citta=?, cap=?, provincia=?,"
					+ "partita_iva, telefono=?, descrizione=? WHERE id=?";

			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(2, azienda.getRagioneSociale());
			statement.setString(3, azienda.getReferente());
			statement.setString(4, azienda.getSedeLegale());
			statement.setString(5, azienda.getIndirizzo());
			statement.setString(6, azienda.getCitta());
			statement.setString(7, azienda.getCap());
			statement.setString(8, azienda.getProvincia());
			statement.setString(9, azienda.getPartitaIVA());
			statement.setString(10, azienda.getTelefono());
			statement.setString(11, azienda.getDescrizioneServizi());

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
			String delete = "DELETE FROM azienda WHERE id=? ";
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
			String update = "UPDATE azienda SET password=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(13, password);
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
	public boolean checkAzienda(String email, String password) {
		Connection connection = this.dataSource.getConnection();
		boolean status = false;
		
		try {
			String check = "SELECT * FROM cliente WHERE email=? AND password=?";
			PreparedStatement statement = connection.prepareStatement(check);
			
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			status = result.next();
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		
		
		return status;
	}


}
