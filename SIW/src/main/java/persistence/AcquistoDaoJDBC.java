package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import entita.Acquisto;
import persistence.dao.AcquistoDao;

public class AcquistoDaoJDBC implements AcquistoDao{
	
	private DataSource dataSource;
	
	public AcquistoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void salva(Acquisto acquisto) {
		Connection connection = this.dataSource.getConnection();
		
		try {
			int id = GestoreID.getId(connection);
			acquisto.setId(id);
			
			String insert = "insert into Acquisto(Id, Id_Cliente, Id_Prodotto, DataAcquisto,"
					+" DataRitiro) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setInt(1, acquisto.getId());
			statement.setInt(2, acquisto.getIdCliente());
			statement.setInt(3, acquisto.getIdProdotto());
			
			long secsAcquisto = acquisto.getDataAcquisto().getTime();
			long secsRitiro = acquisto.getDataRitiro().getTime();
			statement.setDate(4, new java.sql.Date(secsAcquisto));
			statement.setDate(5, new java.sql.Date(secsRitiro));
			
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
	public void aggiorna(Acquisto acquisto) {
		Connection connection = this.dataSource.getConnection();
		try {
			
			String update = "update Acquisto SET Id_Cliente = ?, Id_Prodotto = ?, DataAcquisto = ?, DataRitiro = ? WHERE Id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setInt(1, acquisto.getId());
			statement.setInt(2, acquisto.getIdCliente());
			statement.setInt(3, acquisto.getIdProdotto());
			
			long secsAcquisto = acquisto.getDataAcquisto().getTime();
			long secsRitiro = acquisto.getDataRitiro().getTime();
			statement.setDate(4, new java.sql.Date(secsAcquisto));
			statement.setDate(5, new java.sql.Date(secsRitiro));
			
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
	public void cancella(Acquisto acquisto) {
		Connection connection = this.dataSource.getConnection();
		try {
		
			String delete = "delete FROM studente WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			
			statement.setInt(1, acquisto.getId());
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
	public Acquisto cercaPerChiavePrimaria(int id) {
		Connection connection = this.dataSource.getConnection();
		Acquisto acquisto = null;
		try {
			String query = "select * FROM Acquisto WHERE Id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
			
				acquisto = new Acquisto();
				acquisto.setId(result.getInt("Id"));
				acquisto.setIdCliente(result.getInt("Id_Cliente"));
				acquisto.setIdProdotto(result.getInt("Id_Prodotto"));
				
				long secsAcquisto = result.getDate("DataAcquisto").getTime();
				long secsRitiro = result.getDate("DataRitiro").getTime();
				acquisto.setDataAcquisto(new java.util.Date(secsAcquisto));
				acquisto.setDataRitiro(new java.util.Date(secsRitiro));
			
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

		return acquisto;
	}

	@Override
	public List<Acquisto> cercaPerCliente(int idCliente) {
		Connection connection = this.dataSource.getConnection();
		List<Acquisto> acquisti = new LinkedList<Acquisto>();
		
		try {
			Acquisto acquisto;
			PreparedStatement statement;
			String query = "select * from Acquisti where Id_Cliente = ?";
		
			statement = connection.prepareStatement(query);
			statement.setInt(2, idCliente);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
			
				acquisto = new Acquisto();
				acquisto.setId(result.getInt("Id"));				
				acquisto.setIdCliente(result.getInt("Id_Cliente"));
				acquisto.setIdProdotto(result.getInt("Id_Prodotto"));
			
				long secsAcquisto = result.getDate("DataAcquisto").getTime();
				long secsRitiro = result.getDate("DataRitiro").getTime();
				acquisto.setDataAcquisto(new java.util.Date(secsAcquisto));
				acquisto.setDataRitiro(new java.util.Date(secsRitiro));
			
				acquisti.add(acquisto);
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
		return acquisti;
	}

	@Override
	public List<Acquisto> cercaPerProdotto(int idProdotto) {
		Connection connection = this.dataSource.getConnection();
		List<Acquisto> acquisti = new LinkedList<Acquisto>();
		
		try {
			Acquisto acquisto;
			PreparedStatement statement;
			String query = "select * from Acquisti where Id_Prodotto = ?";
		
			statement = connection.prepareStatement(query);
			statement.setInt(3, idProdotto);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
			
				acquisto = new Acquisto();
				acquisto.setId(result.getInt("Id"));				
				acquisto.setIdCliente(result.getInt("Id_Cliente"));
				acquisto.setIdProdotto(result.getInt("Id_Prodotto"));
			
				long secsAcquisto = result.getDate("DataAcquisto").getTime();
				long secsRitiro = result.getDate("DataRitiro").getTime();
				acquisto.setDataAcquisto(new java.util.Date(secsAcquisto));
				acquisto.setDataRitiro(new java.util.Date(secsRitiro));
			
				acquisti.add(acquisto);
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
		return acquisti;
	}

	@Override
	public List<Acquisto> cercaPerDataAcquisto(Date dataAcquisto) {
		Connection connection = this.dataSource.getConnection();
		List<Acquisto> acquisti = new LinkedList<Acquisto>();
		
		try {
			Acquisto acquisto;
			PreparedStatement statement;
			String query = "select * from Acquisto where DataAcquisto = ?";
		
			statement = connection.prepareStatement(query);
			statement.setDate(4, (java.sql.Date) dataAcquisto);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
			
				acquisto = new Acquisto();
				acquisto.setId(result.getInt("Id"));				
				acquisto.setIdCliente(result.getInt("Id_Cliente"));
				acquisto.setIdProdotto(result.getInt("Id_Prodotto"));
			
				long secsAcquisto = result.getDate("DataAcquisto").getTime();
				long secsRitiro = result.getDate("DataRitiro").getTime();
				acquisto.setDataAcquisto(new java.util.Date(secsAcquisto));
				acquisto.setDataRitiro(new java.util.Date(secsRitiro));
			
				acquisti.add(acquisto);
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
		return acquisti;
	}

	@Override
	public List<Acquisto> cercaTutti() {
		Connection connection = this.dataSource.getConnection();
		List<Acquisto> acquisti = new LinkedList<Acquisto>();
		
		try {
			Acquisto acquisto;
			PreparedStatement statement;
			String query = "select * from Acquisto";
		
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
			
				acquisto = new Acquisto();
				acquisto.setId(result.getInt("Id"));				
				acquisto.setIdCliente(result.getInt("Id_Cliente"));
				acquisto.setIdProdotto(result.getInt("Id_Prodotto"));
			
				long secsAcquisto = result.getDate("DataAcquisto").getTime();
				long secsRitiro = result.getDate("DataRitiro").getTime();
				acquisto.setDataAcquisto(new java.util.Date(secsAcquisto));
				acquisto.setDataRitiro(new java.util.Date(secsRitiro));
			
				acquisti.add(acquisto);
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
		return acquisti;
	}

}
