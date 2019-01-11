package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
			int id = GestoreID.getId(connection);
			prodotto.setId(id);
			
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
		Connection connection = this.dataSource.getConnection();
		Prodotto prodotto = null;
		try {
			PreparedStatement statement;
			String query = "select * from Prodotto where Nome = ?";

			statement = connection.prepareStatement(query);
			statement.setString(2, nome);
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
	public List<Prodotto> cercaPerCategoria(String categoria) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<Prodotto>();
		
		try {
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from Prodotto where Categoria = ?";

			statement = connection.prepareStatement(query);
			statement.setString(3, categoria);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("Id"));				
				prodotto.setNome(result.getString("Nome"));
				prodotto.setCategoria(result.getString("Categoria"));
				prodotto.setDescrizione(result.getString("Descrizione"));
				
				prodotti.add(prodotto);
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
		return prodotti;
	}

	@Override
	public List<Prodotto> cercaTutti() {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<Prodotto>();
		
		try {
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from Prodotto";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				
				prodotto = new Prodotto();
				prodotto.setId(result.getInt("Id"));				
				prodotto.setNome(result.getString("Nome"));
				prodotto.setCategoria(result.getString("Categoria"));
				prodotto.setDescrizione(result.getString("Descrizione"));
				
				prodotti.add(prodotto);
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
		return prodotti;
	}

	@Override
	public void aggiorna(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		
		try {	
			String update = "update Prodotto SET Nome = ?, Categoria = ?, Descrizione = ? WHERE Id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			
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
	public void cancella(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		
		try {
			String delete = "delete FROM Prodotto WHERE Id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			
			statement.setInt(1, prodotto.getId());
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
