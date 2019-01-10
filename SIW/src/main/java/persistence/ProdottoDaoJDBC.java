package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entita.Prodotto;

import persistence.dao.ProdottoDao;

public class ProdottoDaoJDBC implements ProdottoDao{
	private DataSource dataSource;
	
	public ProdottoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void salva(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into Prodotto(Id, Nome, Categoria, Descrizione) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setInt(1, prodotto.getId());
			statement.setString(2, prodotto.getNome());
			statement.setString(3, prodotto.getCategoria());
			statement.setString(4, prodotto.getDescrizione());
		
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
	public Prodotto cercaPerChiavePrimaria(int id) {
		Connection connection = this.dataSource.getConnection();
		Prodotto prodotto = null;
		try {
			PreparedStatement statement;
			String query = "select * from Prodotto where Id = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("Id"));				
				prodotto.setNome(result.getString("Nome"));
				prodotto.setCategoria(result.getString("Categoria"));
				prodotto.setDescrizione(result.getString("Descrizione"));
				
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
		return prodotto;	
	}

	@Override
	public Prodotto cercaPerNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prodotto cercaPerCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> cercaTutti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Prodotto cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancella(Prodotto cliente) {
		// TODO Auto-generated method stub
		
	}

}
