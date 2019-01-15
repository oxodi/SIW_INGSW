package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entita.Terreno;
import entita.ortaggio.Ortaggio;
import persistence.dao.OrtaggioDao;
import persistence.dao.TerrenoDao;

public class TerrenoDaoJDBC implements TerrenoDao{
	private DataSource dataSource;
	
	public TerrenoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("sono nel costruttore");
	}
	@Override
	public void salva(Terreno terreno) {
		Connection connection = this.dataSource.getConnection();
		
		try {
			//int id = GestoreID.getId(connection);
			//terreno.setId(id);
			System.out.println("A puttana e mammata");
			String insert = "insert into Terreno(Id, Locazione, Dimensione, DimensioneSerra, ServizioParziale, ServizioCompleto, PeriodoColtivazione, Id_Azienda, CostoTerreno) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, terreno.getId());
			statement.setString(2, terreno.getLocazione());
			statement.setInt(3, terreno.getDimensione());
			statement.setInt(4, terreno.getDimensioneSerra());
			statement.setBoolean(5, terreno.isServizioParziale());
			statement.setBoolean(6, terreno.isServizioCompleto());
			statement.setString(7, terreno.getPeriodiDisponibilita());
			statement.setInt(8, terreno.getIdAzienda());
			statement.setDouble(9, terreno.getCosto());
			System.out.println(statement);
			System.out.println(statement.executeUpdate());
			
		} catch (SQLException e) {
			if(connection != null) {
				try {
					//connection.rollback();
				} catch (Exception e2) {
					throw new PersistenceException(e2.getMessage());
				}
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e3) {
				throw new PersistenceException(e3.getMessage());
			}
		}
	}
	
	private void aggiornaOrtaggi(Terreno terreno, Connection connection) {
		OrtaggioDao ortaggioDao = new OrtaggioDaoJDBC(dataSource);
		for(Ortaggio ortaggio : terreno.getOrtaggi()) {
			if(ortaggioDao.cercaPerChiavePrimaria(ortaggio.getId()) == null) {
				ortaggioDao.salva(ortaggio);
			}
			String ospita = "SELECT Id_Terreno AND Id_Ortaggio FROM Ospita WHERE Id_Terreno = ? AND Id_Ortaggio = ? ";
			try {
				PreparedStatement statementOspita = connection.prepareStatement(ospita);
				statementOspita.setInt(1, terreno.getId());
				statementOspita.setInt(2, ortaggio.getId());
				ResultSet result = statementOspita.executeQuery();
				if(result.next()) {
					String aggiorna = "UPDATE Ospita SET Id_Terreno = ? WHERE Id_Ortaggio = ?  ";
					PreparedStatement statement = connection.prepareStatement(aggiorna);
					statement.setInt(1, terreno.getId());
					statement.setInt(2, result.getInt("Id_Ortaggio"));
					statement.executeUpdate();
				} else {
					String iscrivi = "INSERT into Ospita(Id_Terreno, Id_Ortaggio) values (?,?)";
					PreparedStatement statementIscrivi = connection.prepareStatement(iscrivi);
					statementIscrivi.setInt(1, terreno.getId());
					statementIscrivi.setInt(2, ortaggio.getId());
					statementIscrivi.executeQuery();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private void rimuoviForeignKeyDaOrtaggio(Terreno terreno, Connection connection) {
		for(Ortaggio ortaggio : terreno.getOrtaggi()) {
			String update = "update Ospita SET Id_Terreno = NULL WHERE ID_Ortaggio = ?";
			try {
				PreparedStatement statement = connection.prepareStatement(update);
				statement.setInt(1, ortaggio.getId());
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void aggiornaDimensione(Terreno terreno) {
		Connection connection = this.dataSource.getConnection();
		try {
			String aggiorna = "update Terreno Set Dimensione = ? WHERE Id = ?";
			PreparedStatement statement = connection.prepareStatement(aggiorna);
			statement.setInt(1, terreno.getDimensione());
			statement.setInt(2, terreno.getId());
			statement.executeUpdate();
			this.aggiornaOrtaggi(terreno, connection);
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					throw new PersistenceException(e2.getMessage());
				}
			}
		} finally {
			try {
				connection.close();
			} catch (Exception e3) {
				throw new PersistenceException(e3.getMessage());
			}
		}
	}

	@Override
	public void cancella(Terreno terreno) {
		Connection connection = this.dataSource.getConnection();
		try {
			String cancella = "delete FROM Terreno WHERE Id = ? ";
			PreparedStatement statement = connection.prepareStatement(cancella);
			statement.setInt(1, terreno.getId());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			this.rimuoviForeignKeyDaOrtaggio(terreno, connection);
			statement.executeUpdate();
			connection.commit();
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
	public Terreno cercaPerChiavePrimaria(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Terreno> cercaPerServizio(boolean servizioParziale, boolean servizioCompleto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Terreno> cercaPerPeriodo(String periodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Terreno> cercaPerAzienda(int idAzienda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Terreno> cercaTutti() {
		// TODO Auto-generated method stub
		return null;
	}

}
