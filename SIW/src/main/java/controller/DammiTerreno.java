package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.ortaggio.Ortaggio;
import persistence.PostgresDAOFactory;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class DammiTerreno
 */
public class DammiTerreno extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		
		String btnTerreno = request.getParameter("btnTerreno");
		int idTerreno = Integer.parseInt(btnTerreno);
		
		TerrenoDao terrenodao = factory.getTerrenoDAO();
		
		List<Ortaggio> ortaggi = terrenodao.cercaOrtaggiPerTerreno(idTerreno);
		
		for(Ortaggio ortaggio : ortaggi)
			System.out.println("Ortaggio: "+ ortaggio.toString());
		
		request.setAttribute("ortaggi", ortaggi);
		RequestDispatcher rd = request.getRequestDispatcher("sceltaOrtaggi.jsp");
		rd.forward(request, response);
	
	}
	

}
