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
import entita.ortaggio.Ortaggio;
import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;
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
		AziendaDao aziendadao = factory.getAziendaDAO();
		
		Terreno terreno = terrenodao.cercaPerChiavePrimaria(idTerreno);
		Azienda azienda = aziendadao.cercaPerChiavePrimaria(terreno.getIdAzienda());
		List<Ortaggio> ortaggi = terrenodao.cercaOrtaggiPerTerreno(idTerreno);
		request.getSession().setAttribute("idTerreno", idTerreno);
		request.setAttribute("ortaggi", ortaggi);
		request.setAttribute("terreno", terreno);
		request.setAttribute("azienda", azienda);
		
		RequestDispatcher rd = request.getRequestDispatcher("sceltaOrtaggi.jsp");
		rd.forward(request, response);
	
	}
	

}
