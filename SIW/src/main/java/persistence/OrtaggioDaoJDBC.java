package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entita.ortaggio.Cavolfiore;
import entita.ortaggio.Cavolo;
import entita.ortaggio.Cetriolo;
import entita.ortaggio.Cipolla;
import entita.ortaggio.Lattuga;
import entita.ortaggio.Melanzana;
import entita.ortaggio.Ortaggio;
import entita.ortaggio.Patata;
import entita.ortaggio.Peperoncino;
import entita.ortaggio.Peperone;
import entita.ortaggio.Pomodoro;
import entita.ortaggio.Spinacio;
import entita.ortaggio.Zucchina;
import persistence.dao.OrtaggioDao;

public class OrtaggioDaoJDBC implements OrtaggioDao {
	private DataSource dataSource;

	public OrtaggioDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(Ortaggio ortaggio) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into Ortaggio(Id, Nome, Prezzo, TempoColtivazione, PeriodoColtivazione, Resa) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, ortaggio.getId());
			statement.setString(2, ortaggio.getNome());
			statement.setDouble(3, ortaggio.getPrezzo());
			statement.setString(4, ortaggio.getTempoColtivazione());
			statement.setString(5, ortaggio.getPeriodoColtivazione());
			statement.setDouble(6, ortaggio.getResa());

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
	public Ortaggio cercaPerChiavePrimaria(int id) {
		Connection connection = this.dataSource.getConnection();
		Ortaggio ortaggio = null;
		try {
			String query = "select * from Ortaggio where Id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				ortaggio = this.ortaggioSpecifico(id);
				ortaggio.setTempoColtivazione(result.getString("TempoColtivazione"));
				ortaggio.setPeriodoColtivazione(result.getString("PeriodoColtivazione"));
				ortaggio.setPrezzo(result.getDouble("Prezzo"));
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
		return ortaggio;
	}

	@Override
	public List<Ortaggio> cercaTutti() {
		Connection connection = this.dataSource.getConnection();
		List<Ortaggio> ortaggi = new LinkedList<Ortaggio>();

		try {
			Ortaggio ortaggio;
			PreparedStatement statement;
			String query = "select * from Cliente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ortaggio = this.ortaggioSpecifico(result.getInt("Id"));
				ortaggio.setTempoColtivazione(result.getString("TempoColtivazione"));
				ortaggio.setPeriodoColtivazione(result.getString("PeriodoColtivazione"));
				ortaggio.setPrezzo(result.getDouble("Prezzo"));

				ortaggi.add(ortaggio);
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
		return ortaggi;
	}

	@Override
	public void aggiorna(Ortaggio ortaggio) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update Ortaggio SET TempoColtivazione = ?, PeriodoColtivazione = ?, Prezzo = ? WHERE Id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, ortaggio.getTempoColtivazione());
			statement.setString(2, ortaggio.getPeriodoColtivazione());
			statement.setDouble(3, ortaggio.getPrezzo());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				throw new PersistenceException(e2.getMessage());
			}
		}
	}

	@Override
	public void cancella(Ortaggio ortaggio) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM Ortaggio WHERE Id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, ortaggio.getId());
			statement.executeQuery();
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

	public Ortaggio ortaggioSpecifico(int id) {
		Ortaggio ortaggio = null;
		switch (id) {

		case 1:
			ortaggio = new Cavolfiore();
			break;
		case 2:
			ortaggio = new Cavolo();
			break;
		case 3:
			ortaggio = new Cetriolo();
			break;
		case 4:
			ortaggio = new Cipolla();
			break;
		case 5:
			ortaggio = new Lattuga();
			break;
		case 6:
			ortaggio = new Melanzana();
			break;
		case 7:
			ortaggio = new Patata();
			break;
		case 8:
			ortaggio = new Peperoncino();
			break;
		case 9:
			ortaggio = new Peperone();
			break;
		case 10:
			ortaggio = new Pomodoro();
			break;
		case 11:
			ortaggio = new Spinacio();
			break;
		case 12:
			ortaggio = new Zucchina();
			break;
		default:
			System.out.println("Ortaggio non presente");
			break;
		}
		return ortaggio;
	}

}
