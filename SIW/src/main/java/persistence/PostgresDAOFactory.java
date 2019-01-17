package persistence;

import persistence.dao.AcquistoDao;
import persistence.dao.AziendaDao;
import persistence.dao.ClienteDao;
import persistence.dao.InserisciProdottoDao;
import persistence.dao.OrtaggioDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.ProdottoDao;
import persistence.dao.TerrenoDao;

public class PostgresDAOFactory extends DAOFactory {

	private static  DataSource dataSource;


	static {
		try {
			Class.forName("org.postgresql.Driver");
			dataSource = new DataSource("jdbc:postgresql://149.202.43.174:5432/DataGrower","postgres","life2play");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}

	
	@Override
	public AcquistoDao getAcquistoDAO() {
		return new AcquistoDaoJDBC(dataSource);
	}

	@Override
	public AziendaDao getAziendaDAO() {
		return new AziendaDaoJDBC(dataSource);
	}

	@Override
	public ClienteDao getClienteDAO() {
		return new ClienteDaoJDBC(dataSource);
	}

	@Override
	public InserisciProdottoDao getInserisciProdottoDAO() {
		return new InserisciProdottoDaoJDBC(dataSource);
	}

	@Override
	public OrtaggioDao getOrtaggioDAO() {
		return new OrtaggioDaoJDBC(dataSource);
	}

	@Override
	public PrenotazioneDao getPrenotazioneDAO() {
		return new PrenotazioneDaoJDBC(dataSource);
	}

	@Override
	public ProdottoDao getProdottoDAO() {
		return new ProdottoDaoJDBC(dataSource);
	}

	@Override
	public TerrenoDao getTerrenoDAO() {
		return new TerrenoDaoJDBC(dataSource);
	}

}
