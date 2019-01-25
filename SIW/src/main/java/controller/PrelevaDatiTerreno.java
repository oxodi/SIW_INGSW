package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;
import entita.Terreno;
import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class DammiAzienda
 */
public class PrelevaDatiTerreno extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Azienda aziendaInSessione = (Azienda) req.getSession().getAttribute("azienda");
		System.out.println("Sono in Dammi terreni");
		System.out.println((Azienda) req.getSession().getAttribute("azienda"));
		TerrenoDao terrenodao = PostgresDAOFactory.getInstance().getTerrenoDAO();
		List<Terreno> terreni = terrenodao.cercaPerAzienda(aziendaInSessione.getId());
		req.setAttribute("terreni", terreni);
		
		RequestDispatcher rd = req.getRequestDispatcher("backendAzienda.jsp");
		rd.forward(req, resp);
	}

}
