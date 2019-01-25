package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;
import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;

/**
 * Servlet implementation class DammiAzienda
 */
public class DammiAzienda extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Sono in Dammi Azienda");
		AziendaDao aziendaDao = PostgresDAOFactory.getInstance().getAziendaDAO();
		List<Azienda> aziende = aziendaDao.cercaTutti();
		req.setAttribute("aziende", aziende);
		
		RequestDispatcher rd = req.getRequestDispatcher("sceltaAzienda.jsp");
		rd.forward(req, resp);
	}

}
