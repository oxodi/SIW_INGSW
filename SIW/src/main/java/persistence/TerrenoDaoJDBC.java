package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entita.Terreno;
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
			
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
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
