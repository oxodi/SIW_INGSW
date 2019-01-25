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
		
		boolean servizioCompleto = false;
		boolean servizioParziale = false;
		
		String completo = req.getParameter("bCompleto");
		String parziale = req.getParameter("bParziale");
		
		String[] stagioni = req.getParameterValues("stagioni");
		
		
		System.out.println("........." +completo);
		System.out.println("_________" +parziale);
		for(String stagionis : stagioni) {
			System.out.println("stagioni: "+stagionis);
		}
		
		if(completo.equals("true"))
			servizioCompleto = true;
		if(parziale.equals("true"))
			servizioParziale = true;
		
		System.out.println(servizioCompleto);
		System.out.println(servizioParziale);
		AziendaDao aziendaDao = PostgresDAOFactory.getInstance().getAziendaDAO();
		List<Azienda> aziende = aziendaDao.cercaAziendaPerTipologiaPeriodo(servizioParziale, servizioCompleto, "ciao");
		req.setAttribute("aziende", aziende);
		
		RequestDispatcher rd = req.getRequestDispatcher("sceltaAzienda.jsp");
		rd.forward(req, resp);
	}

}
