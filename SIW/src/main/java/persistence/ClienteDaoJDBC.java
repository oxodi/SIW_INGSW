package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entita.Cliente;
import persistence.dao.ClienteDao;

public class ClienteDaoJDBC implements ClienteDao {
	private DataSource dataSource;

	public ClienteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(Cliente cliente) {
		Connection connection = this.dataSource.getConnection();

		try {
			int id = GestoreID.getId(connection, "cliente_id_seq", "cliente");
			cliente.setId(id);

			String insert = "INSERT INTO cliente(id, nome, cognome, codice_fiscale, indirizzo,"
					+ " data_di_nascita, citta, cap, provincia, telefono, email) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, cliente.getId());
			statement.setString(2, cliente.getNome());
			statement.setString(3, cliente.getCognome());
			statement.setString(4, cliente.getCodiceFiscale());
			statement.setString(5, cliente.getIndirizzo());
			long secs = cliente.getDataDiNascita().getTime();
			statement.setDate(6, new java.sql.Date(secs));
			statement.setString(7, cliente.getCitta());
			statement.setString(8, cliente.getCap());
			statement.setString(9, cliente.getProvincia());
			statement.setString(10, cliente.getTelefono());
			statement.setString(11, cliente.getEmail());

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
	public Cliente cercaPerChiavePrimaria(int id) {
		Connection connection = this.dataSource.getConnection();
		Cliente cliente = null;
		try {
			String query = "SELECT * FROM cliente WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {

				cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setCognome(result.getString("cognome"));
				cliente.setCodiceFiscale(result.getString("codice_fiscale"));
				long secs = result.getDate("data_di_nascita").getTime();
				cliente.setDataDiNascita(new java.util.Date(secs));
				cliente.setIndirizzo(result.getString("indirizzo"));
				cliente.setCitta(result.getString("citta"));
				cliente.setCap(result.getString("cap"));
				cliente.setProvincia(result.getString("provincia"));
				cliente.setTelefono(result.getString("telefono"));
				cliente.setEmail(result.getString("email"));

			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e2) {
				throw new PersistenceException(e2.getMessage());
			}
		}

		return cliente;
	}

	@Override
	public List<Cliente> cercaTutti() {
		Connection connection = this.dataSource.getConnection();
		List<Cliente> clienti = new LinkedList<Cliente>();
		try {
			Cliente cliente;
			PreparedStatement statement;
			String query = "SELECT * FROM cliente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setCognome(result.getString("cognome"));
				cliente.setCodiceFiscale(result.getString("codice_fiscale"));
				long secs = result.getDate("data_di_nascita").getTime();
				cliente.setDataDiNascita(new java.util.Date(secs));
				cliente.setIndirizzo(result.getString("indirizzo"));
				cliente.setCitta(result.getString("citta"));
				cliente.setCap(result.getString("cap"));
				cliente.setProvincia(result.getString("provincia"));
				cliente.setTelefono(result.getString("telefono"));
				cliente.setEmail(result.getString("email"));

				clienti.add(cliente);
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
		return clienti;
	}

	@Override
	public void aggiorna(Cliente cliente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String update = "UPDATE cliente SET indirizzo=?, citta=?, cap=?, provincia=?, telefono=? WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(5, cliente.getIndirizzo());
			statement.setString(7, cliente.getCitta());
			statement.setString(8, cliente.getCap());
			statement.setString(9, cliente.getProvincia());
			statement.setString(10, cliente.getTelefono());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e2) {
				throw new PersistenceException(e2.getMessage());
			}
		}
	}

	@Override
	public void cancella(Cliente cliente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String delete = "DELETE FROM studente WHERE id=? ";

			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, cliente.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e2) {
				throw new PersistenceException(e2.getMessage());
			}
		}
	}

	@Override
	public void setPassword(Cliente cliente, String password) {
		Connection connection = this.dataSource.getConnection();
		try { 

			String update = "UPDATE cliente SET password=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(12, password);
			statement.setInt(1, cliente.getId());

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
	public boolean checkCliente(String email, String password) {
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
