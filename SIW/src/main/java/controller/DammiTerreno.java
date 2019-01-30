package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;
import persistence.dao.TerrenoDao;
import entita.Azienda;
import entita.Terreno;;

/**
 * Servlet implementation class DammiTerreno
 */
public class DammiTerreno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sono in Dammi Terreno");
		String btnAzienda = request.getParameter("btnAzienda");
		int idAzienda = Integer.parseInt(btnAzienda);
		AziendaDao aziendaDao = PostgresDAOFactory.getInstance().getAziendaDAO();
		TerrenoDao terrenoDao = PostgresDAOFactory.getInstance().getTerrenoDAO();
		
		List<Terreno> terreni = terrenoDao.cercaPerAzienda(idAzienda);
		Azienda azienda = aziendaDao.cercaPerChiavePrimaria(idAzienda);
		
		request.setAttribute("azienda", azienda);
		request.setAttribute("terreni", terreni);
		
		RequestDispatcher rd = request.getRequestDispatcher("sceltaTerreno.jsp");
		rd.forward(request, response);
	}



}
