package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entita.Terreno;
import entita.ortaggio.Ortaggio;
import persistence.PostgresDAOFactory;
import persistence.dao.OrtaggioDao;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class PrelevaOrtaggi
 */
public class PrelevaOrtaggi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("edit").equals("true")) {
			TerrenoDao terrenodao = PostgresDAOFactory.getInstance().getTerrenoDAO();
			int id_terreno = Integer.parseInt(req.getParameter("editFormId"));
			List<Ortaggio> listOrtaggi = terrenodao.cercaOrtaggiPerTerreno(id_terreno);
			
		}
		else {
			
		//Ortaggio ortaggio = (Ortaggio) req.getSession().getAttribute("ortaggio");
		System.out.println("Sono in Preleva Ortaggi");
		//System.out.println((Ortaggio) req.getSession().getAttribute("ortaggio"));
		OrtaggioDao ortaggidao = PostgresDAOFactory.getInstance().getOrtaggioDAO();
		List<Ortaggio> listOrtaggi = ortaggidao.cercaTutti();
		
		req.setAttribute("ortaggi", listOrtaggi);
		
		RequestDispatcher rd = req.getRequestDispatcher("inserimentoTerreno.jsp");
		rd.forward(req, resp);

		}
	}
}
