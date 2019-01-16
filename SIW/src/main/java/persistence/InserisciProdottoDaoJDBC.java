package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entita.InserisciProdotto;
import persistence.dao.InserisciProdottoDao;

public class InserisciProdottoDaoJDBC implements InserisciProdottoDao {

	private DataSource dataSource;

	public InserisciProdottoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(InserisciProdotto inserimento) {
		Connection connection = this.dataSource.getConnection();

		try {
			String insert = "INSERT INTO inserisci_prodotto(id_azienda, id_prodotto, quantita "
					+ "costo_unitario) VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, inserimento.getIdAzienda());
			statement.setInt(2, inserimento.getIdProdotto());
			statement.setInt(3, inserimento.getQuantita());
			statement.setDouble(4, inserimento.getCostoUnitario());

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
	public void aggiorna(InserisciProdotto inserimento) {

		Connection connection = this.dataSource.getConnection();
		try {

			String update = "UPDATE inserisci_prodotto SET quantita = ?, costo_unitario = ? WHERE id_azienda = ? AND id_prodotto = ?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setInt(1, inserimento.getIdAzienda());
			statement.setInt(2, inserimento.getIdProdotto());
			statement.setInt(3, inserimento.getQuantita());
			statement.setDouble(4, inserimento.getCostoUnitario());

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
	public void cancella(InserisciProdotto inserimento) {

		Connection connection = this.dataSource.getConnection();
		try {

			String delete = "DELETE FROM inserimento_prodotto WHERE id_azienda = ? AND id_prodotto = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, inserimento.getIdAzienda());
			statement.setInt(2, inserimento.getIdProdotto());
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
	public List<InserisciProdotto> cercaPerAzienda(int idAzienda) {
		Connection connection = this.dataSource.getConnection();
		List<InserisciProdotto> inserimenti = new LinkedList<InserisciProdotto>();

		try {
			InserisciProdotto inserimento;
			PreparedStatement statement;
			String query = "SELECT * FROM inserisci_prodotto WHERE id_azienda = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, idAzienda);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				inserimento = new InserisciProdotto();
				inserimento.setIdAzienda(result.getInt("id_azienda"));
				inserimento.setIdProdotto(result.getInt("id_prodotto"));
				inserimento.setQuantita(result.getInt("quantita"));
				inserimento.setCostoUnitario(result.getDouble("costo_unitario"));

				inserimenti.add(inserimento);
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
		return inserimenti;
	}

	@Override
	public List<InserisciProdotto> cercaPerProdotto(int idProdotto) {
		Connection connection = this.dataSource.getConnection();
		List<InserisciProdotto> inserimenti = new LinkedList<InserisciProdotto>();

		try {
			InserisciProdotto inserimento;
			PreparedStatement statement;
			String query = "SELECT * FROM inserisci_prodotto WHERE id_prodotto = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(2, idProdotto);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				inserimento = new InserisciProdotto();
				inserimento.setIdAzienda(result.getInt("id_azienda"));
				inserimento.setIdProdotto(result.getInt("id_prodotto"));
				inserimento.setQuantita(result.getInt("quantita"));
				inserimento.setCostoUnitario(result.getDouble("costo_unitario"));

				inserimenti.add(inserimento);
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
		return inserimenti;
	}

}
