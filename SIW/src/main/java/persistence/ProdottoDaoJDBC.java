package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entita.Prodotto;
import persistence.dao.ProdottoDao;

public class ProdottoDaoJDBC implements ProdottoDao {
	private DataSource dataSource;

	public ProdottoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			int id = GestoreID.getId(connection, "prodotto_id_seq", "prodotto");
			prodotto.setId(id);

			String insert = "INSERT INTO prodotto(id, nome, categoria, descrizione, quantita, costo_unitario, id_azienda) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, prodotto.getId());
			statement.setString(2, prodotto.getNome());
			statement.setString(3, prodotto.getCategoria());
			statement.setString(4, prodotto.getDescrizione());
			statement.setInt(5, prodotto.getQuantita());
			statement.setDouble(6, prodotto.getCostoUnitario());
			statement.setInt(7, prodotto.getIdAzienda());

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
			String query = "SELECT * FROM prodotto WHERE id = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setCategoria(result.getString("categoria"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setQuantita(result.getInt("quantita"));
				prodotto.setCostoUnitario(result.getDouble("costo_unitario"));
				prodotto.setIdAzienda(result.getInt("id_azienda"));

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
			String query = "SELECT * FROM prodotto WHERE nome = ?";

			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			ResultSet result = statement.executeQuery();

			if (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setCategoria(result.getString("categoria"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setQuantita(result.getInt("quantita"));
				prodotto.setCostoUnitario(result.getDouble("costo_unitario"));
				prodotto.setIdAzienda(result.getInt("id_azienda"));

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
			String query = "SELECT * FROM prodotto WHERE categoria = ?";

			statement = connection.prepareStatement(query);
			statement.setString(1, categoria);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setCategoria(result.getString("categoria"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setQuantita(result.getInt("quantita"));
				prodotto.setCostoUnitario(result.getDouble("costo_unitario"));
				prodotto.setIdAzienda(result.getInt("id_azienda"));

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
			String query = "SELECT * FROM prodotto";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setCategoria(result.getString("categoria"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setQuantita(result.getInt("quantita"));
				prodotto.setCostoUnitario(result.getDouble("costo_unitario"));
				prodotto.setIdAzienda(result.getInt("id_azienda"));

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
	public void aggiorna(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();

		try {
			String update = "UPDATE prodotto SET quantita = ?, costo_unitario = ?, descrizione = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setInt(1, prodotto.getQuantita());
			statement.setDouble(2, prodotto.getCostoUnitario());
			statement.setString(3, prodotto.getDescrizione());
			statement.setInt(4, prodotto.getId());
			

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
			String delete = "DELETE FROM prodotto WHERE id = ? ";
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

	@Override
	public List<Prodotto> cercaPerAzienda(int idAzienda) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<Prodotto>();

		try {
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "SELECT * FROM prodotto WHERE id_azienda = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, idAzienda);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setCategoria(result.getString("categoria"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setQuantita(result.getInt("quantita"));
				prodotto.setCostoUnitario(result.getDouble("costo_unitario"));
				prodotto.setIdAzienda(result.getInt("id_azienda"));

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
	public List<Prodotto> dammiProdottiPerPagina(int pagina) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<Prodotto>();

		try {
			Prodotto prodotto;
			PreparedStatement statement;
			
			int inizio = (pagina * 10);
			int fine = (inizio + 10);
			String query = "SELECT * FROM prodotto WHERE id BETWEEN "+inizio+" AND "+fine;
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setCategoria(result.getString("categoria"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setQuantita(result.getInt("quantita"));
				prodotto.setCostoUnitario(result.getDouble("costo_unitario"));
				prodotto.setIdAzienda(result.getInt("id_azienda"));

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
	public List<Prodotto> filtraPerPrezzo(int min, int max) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<Prodotto>();

		try {
			Prodotto prodotto;
			PreparedStatement statement;
			
			String query = "SELECT * FROM prodotto WHERE costo_unitario BETWEEN "+min+" AND "+max;
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setCategoria(result.getString("categoria"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setQuantita(result.getInt("quantita"));
				prodotto.setCostoUnitario(result.getDouble("costo_unitario"));
				prodotto.setIdAzienda(result.getInt("id_azienda"));

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
	public int sizeProdotti() {
		Connection connection = this.dataSource.getConnection();
		int numProdotti;
		
		try {
			PreparedStatement statement;
			
			String query = "SELECT COUNT (id) FROM prodotto";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			numProdotti = result.getInt("count");
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
		return numProdotti;
	}

}
