package persistence;

import persistence.dao.AcquistoDao;
import persistence.dao.AziendaDao;
import persistence.dao.ClienteDao;
import persistence.dao.InserisciProdottoDao;
import persistence.dao.OrtaggioDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.ProdottoDao;
import persistence.dao.TerrenoDao;

public abstract class DAOFactory {

	// --- List of supported DAO types ---
	
	/**
	 * Numeric constant '1' corresponds to explicit MySQL choice
	 */
	public static final int MYSQL = 1;
	
	/**
	 * Numeric constant '2' corresponds to explicit Postgres choice
	 */
	public static final int POSTGRESQL = 2;
	
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case MYSQL:
			return null;//new HsqldbDAOFactory();
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
	
	// --- Factory specification: concrete factories implementing this spec must provide this methods! ---
	
	/**
	 * Method to obtain a DATA ACCESS OBJECT
	 * for the datatype 'Student'
	 */
	public abstract AcquistoDao getAcquistoDAO();
	
	public abstract AziendaDao getAziendaDAO();
	
	public abstract ClienteDao getClienteDAO();
	
	public abstract InserisciProdottoDao getInserisciProdottoDAO();
	
	public abstract OrtaggioDao getOrtaggioDAO();

	public abstract PrenotazioneDao getPrenotazioneDAO();
	
	public abstract ProdottoDao getProdottoDAO();
	
	public abstract TerrenoDao getTerrenoDAO();
	
	
	//public abstract persistence.UtilDao getUtilDAO();
}
