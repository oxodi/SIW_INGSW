package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import entita.Azienda;
import entita.Cliente;
import entita.Prenotazione;
import entita.Terreno;
import entita.ortaggio.Ortaggio;
import persistence.dao.TerrenoDao;

public class TerrenoDaoJDBC implements TerrenoDao {
	private DataSource dataSource;

	public TerrenoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void salva(Terreno terreno) {
		Connection connection = this.dataSource.getConnection();

		try {
			int id = GestoreID.getId(connection, "terreno_id_seq", "terreno");
			terreno.setId(id);

			String insert = "INSERT INTO terreno(id, locazione, dimensione, dimensione_serra, servizio_parziale, servizio_completo, periodo_coltivazione, id_azienda, costo_terreno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			statement.executeUpdate();

		} catch (SQLException e) {
			if (connection != null) {
				try {
					throw new PersistenceException(e.getMessage());
					// connection.rollback();
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
	public void aggiungiOrtaggio(int id_terreno, int id_ortaggio, double prezzo, int tempoColtivazione) {
		Connection connection = dataSource.getConnection();
		try {
			String inserisciOrtaggio = "INSERT INTO ospita(id_terreno, id_ortaggio, prezzo, tempo_coltivazione) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(inserisciOrtaggio);
			statement.setInt(1, id_terreno);
			statement.setInt(2, id_ortaggio);
			statement.setDouble(3, prezzo);
			statement.setInt(4, tempoColtivazione);
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
	public void cancellaOrtaggio(int id_terreno, int id_ortaggio) {
		Connection connection = dataSource.getConnection();
		try {
			String eliminaOrtaggio = "DELETE FROM ospita WHERE id_terreno = ? AND id_ortaggio = ?";
			PreparedStatement statement = connection.prepareStatement(eliminaOrtaggio);
			statement.setInt(1, id_terreno);
			statement.setInt(2, id_ortaggio);
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

	private void rimuoviForeignKeyDaOspita(Terreno terreno, Connection connection) {
		String update = "DELETE FROM ospita  WHERE id_terreno = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, terreno.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void aggiorna(Terreno terreno) {
		Connection connection = this.dataSource.getConnection();
		try {

			String aggiorna = "UPDATE terreno SET dimensione = ?, dimensione_serra = ?, servizio_parziale = ?, servizio_completo = ?, periodo_coltivazione = ?, costo_terreno = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(aggiorna);
			statement.setInt(1, terreno.getDimensione());
			statement.setInt(2, terreno.getDimensioneSerra());
			statement.setBoolean(3, terreno.isServizioParziale());
			statement.setBoolean(4, terreno.isServizioCompleto());
			statement.setString(5, terreno.getPeriodiDisponibilita());
			statement.setDouble(6, terreno.getCosto());
			statement.setInt(7, terreno.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			if (connection != null) {
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
			this.rimuoviForeignKeyDaOspita(terreno, connection);
			String cancella = "DELETE FROM terreno WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(cancella);
			statement.setInt(1, terreno.getId());
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
	public Terreno cercaPerChiavePrimaria(int id) {
		Connection connection = this.dataSource.getConnection();
		Terreno terreno = null;
		try {
			PreparedStatement statement;
			String query = "SELECT * FROM terreno WHERE id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {

				terreno = new Terreno();
				terreno.setId(result.getInt("id"));
				terreno.setCosto(result.getDouble("costo_terreno"));
				terreno.setDimensione(result.getInt("dimensione"));
				terreno.setDimensioneSerra(result.getInt("dimensione_serra"));
				terreno.setLocazione(result.getString("locazione"));
				terreno.setServizioCompleto(result.getBoolean("servizio_completo"));
				terreno.setServizioParziale(result.getBoolean("servizio_parziale"));
				terreno.setPeriodiDisponibilita(result.getString("periodo_coltivazione"));
				terreno.setIdAzienda(result.getInt("id_azienda"));
				terreno.setOrtaggi(cercaOrtaggiPerTerreno(result.getInt("id")));
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				throw new PersistenceException(e2.getMessage());
			}
		}
		return terreno;
	}

	@Override
	public List<Terreno> cercaPerServizio(boolean servizioParziale, boolean servizioCompleto) {
		Connection connection = this.dataSource.getConnection();
		List<Terreno> terreni = new ArrayList<Terreno>();
		try {
			Terreno terreno;
			PreparedStatement statement;
			String query = "SELECT * FROM terreno WHERE servizio_parziale = ? AND servizio_completo = ?";
			statement = connection.prepareStatement(query);
			statement.setBoolean(1, servizioParziale);
			statement.setBoolean(2, servizioCompleto);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				terreno = cercaPerChiavePrimaria(result.getInt("id"));
				terreni.add(terreno);
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
		return terreni;
	}

	@Override
	public List<Terreno> cercaPerPeriodo(String periodo) {
		Connection connection = this.dataSource.getConnection();
		List<Terreno> terreni = new ArrayList<Terreno>();
		try {
			Terreno terreno;
			PreparedStatement statement;
			String query = "SELECT * FROM terreno WHERE periodo_coltivazione = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, periodo);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				terreno = cercaPerChiavePrimaria(result.getInt("id"));
				terreni.add(terreno);
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
		return terreni;
	}

	@Override
	public List<Terreno> cercaPerAzienda(int idAzienda) {
		Connection connection = this.dataSource.getConnection();
		List<Terreno> terreni = new ArrayList<Terreno>();
		try {
			Terreno terreno;
			PreparedStatement statement;
			String query = "SELECT * FROM terreno WHERE id_azienda = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idAzienda);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				terreno = cercaPerChiavePrimaria(result.getInt("id"));
				terreni.add(terreno);
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
		return terreni;
	}

	@Override
	public List<Terreno> cercaTutti() {
		Connection connection = this.dataSource.getConnection();
		List<Terreno> terreni = new ArrayList<Terreno>();
		try {
			Terreno terreno;
			PreparedStatement statement;
			String query = "SELECT * FROM terreno ";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				terreno = cercaPerChiavePrimaria(result.getInt("id"));
				terreni.add(terreno);
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
		return terreni;
	}

	@Override
	public ArrayList<Ortaggio> cercaOrtaggiPerTerreno(int id_terreno) {
		Connection connection = dataSource.getConnection();
		ArrayList<Ortaggio> ortaggi = new ArrayList<Ortaggio>();
		try {
			Ortaggio ortaggio;
			PreparedStatement statement;
			String query = "SELECT * FROM ortaggio INNER JOIN  ospita ON ortaggio.id = ospita.id_ortaggio WHERE ospita.id_terreno = ? ";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id_terreno);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ortaggio = new OrtaggioDaoJDBC(dataSource).ortaggioSpecifico(result.getInt("id"));
				ortaggio.setPrezzo(result.getDouble("prezzo"));
				ortaggio.setTempoColtivazione(result.getInt("tempo_coltivazione"));
				ortaggio.setPeriodoColtivazione(result.getString("periodo_coltivazione"));
				ortaggio.setId_terreno(id_terreno);
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

//	@Override
//	public List<Prenotazione> cercaPrenotazioniPerTerreno(int id_terreno) {
//		Connection connection = this.dataSource.getConnection();
//		List<Prenotazione> prenotazioni = new LinkedList<Prenotazione>();
//
//		try {
//			Prenotazione prenotazione;
//			PreparedStatement statement;
//			String query = "SELECT * FROM prenotazione WHERE  id_terreno = ?";
//
//			statement = connection.prepareStatement(query);
//			statement.setInt(1, id_terreno);
//			ResultSet result = statement.executeQuery();
//
//			while (result.next()) {
//
//				prenotazione = new Prenotazione();
//				HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//				prenotazione.setIdCliente(result.getInt("id_cliente"));
//				prenotazione.setIdTerreno(result.getInt("id_terreno"));
//				hashMap.put(result.getInt("id_ortaggio"), result.getInt("quantita"));
//				prenotazione.setId_ortaggi(hashMap);
//				long secs = result.getDate("data").getTime();
//				prenotazione.setDataPrenotazione(new java.util.Date(secs));
//
//				prenotazioni.add(prenotazione);
//			}
//		} catch (SQLException e) {
//			throw new PersistenceException(e.getMessage());
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				throw new PersistenceException(e.getMessage());
//			}
//		}
//		return prenotazioni;
//	}

	@Override
	public List<Cliente> cercaClientiPerTerreno(int id_terreno) {
		Connection connection = this.dataSource.getConnection();
		List<Cliente> clienti = new LinkedList<Cliente>();
		try {
			Cliente cliente;
			PreparedStatement statement;
			String query = "SELECT * FROM cliente INNER JOIN prenotazione ON cliente.id = prenotazione.id_cliente WHERE prenotazione.id_terreno = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id_terreno);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setCognome(result.getString("cognome"));
				cliente.setCodiceFiscale(result.getString("codice_fiscale"));
				long secs = result.getDate("data_di_nascita").getTime();
				cliente.setDataDiNascita(new java.util.Date(secs));
				cliente.setIndirizzo(result.getString("indirizzo"));
				cliente.setCitta(result.getString("citta"));
				cliente.setCap(result.getString("cap"));
				cliente.setProvincia(result.getString("provincia"));
				cliente.setTelefono(result.getString("telefono"));
				cliente.setEmail(result.getString("email"));

				clienti.add(cliente);
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
		return clienti;
	}

	@Override
	public List<Terreno> cercaPerServizioPeriodo(boolean servizioParziale, boolean servizioCompleto, String periodo) {
		Connection connection = this.dataSource.getConnection();
		List<Terreno> terreni = new ArrayList<Terreno>();

		try {
			Terreno terreno;
			PreparedStatement statement;
			String query = "SELECT * FROM terreno WHERE servizio_parziale = ? AND servizio_completo = ? AND periodo_coltivazione = ?";
			statement = connection.prepareStatement(query);
			statement.setBoolean(1, servizioParziale);
			statement.setBoolean(2, servizioCompleto);
			statement.setString(3, periodo);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				terreno = cercaPerChiavePrimaria(result.getInt("id"));
				terreni.add(terreno);
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
		return terreni;
	}

	@Override
	public void setDocumento(Terreno terreno, String documento) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "UPDATE terreno SET documento = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(1, documento);
			statement.setInt(2, terreno.getId());
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
