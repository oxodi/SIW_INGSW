package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class PageLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		if (id.equals("azienda"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("homeAziende.jsp");
			rd.include(req, resp);
		} else if (id.equals("utente")) {
			RequestDispatcher rd = req.getRequestDispatcher("registrazioneUtente.jsp");
			rd.include(req, resp);
		}
		else if(id.equals("RegAzienda"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("registrazioneAzienda.jsp");
			rd.include(req, resp);
		}
		else if(id.equals("prenotaTerreno"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("prenotazioneTerreno.jsp");
			rd.include(req, resp);
		}
		
		else if(id.equals("home"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("Home");
			rd.forward(req, resp);
		}
	}

}
