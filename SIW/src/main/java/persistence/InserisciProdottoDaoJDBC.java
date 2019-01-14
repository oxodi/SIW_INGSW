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

	DataSource dataSource;

	public InserisciProdottoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(InserisciProdotto inserimento) {
		Connection connection = this.dataSource.getConnection();

		try {
			String insert = "insert into InserisciProdotto(Id_Azienda, Id_Prodotto, Quantita "
					+ "CostoUnitario) values(?,?,?,?)";
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
		// DA CONTROLLARE AGGIORNAMENTO
	}

	@Override
	public void cancella(InserisciProdotto inserimento) {
		// DA CONTROLLARE CANCELLAZIONE
	}

	@Override
	public List<InserisciProdotto> cercaPerAzienda(int idAzienda) {
		Connection connection = this.dataSource.getConnection();
		List<InserisciProdotto> inserimenti = new LinkedList<InserisciProdotto>();

		try {
			InserisciProdotto inserimento;
			PreparedStatement statement;
			String query = "select * from InserisciProdotto where Id_Azienda = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, idAzienda);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				inserimento = new InserisciProdotto();
				inserimento.setIdAzienda(result.getInt("Id_Azienda"));
				inserimento.setIdProdotto(result.getInt("Id_Prodotto"));
				inserimento.setQuantita(result.getInt("Quantita"));
				inserimento.setCostoUnitario(result.getDouble("CostoUnitario"));

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
			String query = "select * from InserisciProdotto where Id_Prodotto = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(2, idProdotto);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				inserimento = new InserisciProdotto();
				inserimento.setIdAzienda(result.getInt("Id_Azienda"));
				inserimento.setIdProdotto(result.getInt("Id_Prodotto"));
				inserimento.setQuantita(result.getInt("Quantita"));
				inserimento.setCostoUnitario(result.getDouble("CostoUnitario"));

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
