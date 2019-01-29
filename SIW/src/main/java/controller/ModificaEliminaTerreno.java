package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;
import entita.Terreno;
import persistence.PostgresDAOFactory;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class ModificaEliminaTerreno
 */
public class ModificaEliminaTerreno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("PageLoader?id=backendAzienda").forward(req, resp);
		

	}
}
