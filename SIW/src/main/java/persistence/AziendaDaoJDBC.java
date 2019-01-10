package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entita.Azienda;
import persistence.dao.AziendaDao;

public class AziendaDaoJDBC implements AziendaDao{
	
	private DataSource dataSource;
	
	public AziendaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(Azienda azienda) {
		Connection connection = this.dataSource.getConnection();

		try {
			String insert = "insert into Azienda(Id, RagioneSociale, PartitaIVA, Referente, "
					+ "SedeLegale, Telefono, Descrizione, e-mail) values(?,?,?,?,?,?,?,?)";
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
			
		}catch (SQLException e) {
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
			String query = "select * from Azienda where Id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				
				azienda = new Azienda();
				azienda.setId(result.getInt("Id"));				
				azienda.setRagioneSociale(result.getString("RagioneSociale"));
				azienda.setPartitaIVA(result.getString("PartitaIVA"));
				azienda.setReferente(result.getString("Referente"));
				azienda.setSedeLegale(result.getString("SedeLegale"));
				azienda.setTelefono(result.getString("Telefono"));
				azienda.setDescrizioneServizi(result.getString("Descrizione"));
				azienda.setEmail(result.getString("e-mail"));
			
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
			String query = "select * from Azienda";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				
				azienda = new Azienda();
				azienda.setId(result.getInt("Id"));				
				azienda.setRagioneSociale(result.getString("RagioneSociale"));
				azienda.setPartitaIVA(result.getString("PartitaIVA"));
				azienda.setReferente(result.getString("Referente"));
				azienda.setSedeLegale(result.getString("SedeLegale"));
				azienda.setTelefono(result.getString("Telefono"));
				azienda.setDescrizioneServizi(result.getString("Descrizione"));
				azienda.setEmail(result.getString("e-mail"));
				
				aziende.add(azienda);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
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
			String update = "update Azienda SET Id = ?, RagioneSociale = ?, PartitaIVA = ?, Referente = ?, SedeLegale = ?, Telefono = ?,"
					+ " Descrizione = ?, e-mail = ? WHERE Id=?"; 
			
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
			String delete = "delete FROM Azienda WHERE Id = ? ";
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
			String update = "update Azienda SET password = ? WHERE Id=?";
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
