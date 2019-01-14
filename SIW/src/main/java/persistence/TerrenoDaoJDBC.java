package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entita.Terreno;
import persistence.dao.OrtaggioDao;
import persistence.dao.TerrenoDao;

public class TerrenoDaoJDBC implements TerrenoDao{
	private DataSource dataSource;
	
	public TerrenoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void salva(Terreno terreno) {
		Connection connection = this.dataSource.getConnection();
		try {
			//int id = GestoreID.getId(connection);
			//terreno.setId(id);
			String insert = "insert into Terreno(Id, Locazione, Dimensione, DimensioneSerra, ServizioParziale, ServizioCompleto, PeriodoColtivazione, Id_Azienda) values (?, ?, ?, ?, ?, ?, ?, ?,";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, terreno.getId());
			statement.setString(2, terreno.getLocazione());
			statement.setInt(3, terreno.getDimensione());
			statement.setInt(4, terreno.getDimensioneSerra());
			statement.setBoolean(5, terreno.isServizioParziale());
			statement.setBoolean(6, terreno.isServizioCompleto());
			statement.setString(7, terreno.getPeriodiDisponibilita());
			statement.setInt(8, terreno.getIdAzienda());
			
			statement.executeUpdate();
			
			//this.aggiornaOrtaggi(terreno, connection);
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
		
	}

	@Override
	public void aggiorna(Terreno cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancella(Terreno cliente) {
		// TODO Auto-generated method stub
		
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
