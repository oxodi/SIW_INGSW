package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;
import entita.Terreno;
import persistence.PostgresDAOFactory;
import persistence.dao.OrtaggioDao;
import persistence.dao.TerrenoDao;



/**
 * Servlet implementation class TerrenoOspitaOrtaggi
 */
public class TerrenoOspitaOrtaggi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Terreno terreno = new Terreno();
		int dimensione = Integer.parseInt(req.getParameter("dimensione_terreno"));
		int dimensioneSerra = Integer.parseInt(req.getParameter("dimensione_serra"));
		double costo = Double.parseDouble(req.getParameter("costo_terreno"));
		terreno.setLocazione(req.getParameter("locazione"));
		terreno.setDimensione(dimensione);
		terreno.setDimensioneSerra(dimensioneSerra);
		terreno.setCosto(costo);
		Azienda az = (Azienda) req.getSession().getAttribute("azienda");
		terreno.setIdAzienda(az.getId()); 
		System.out.println(terreno.getIdAzienda() + " " + terreno.getCosto() + "" + terreno.getDimensione() + "" + terreno.getLocazione());
		TerrenoDao terrenoNew = PostgresDAOFactory.getInstance().getTerrenoDAO();
		RequestDispatcher rd = req.getRequestDispatcher("backendAzienda.jsp");
		rd.forward(req, resp);
	}
}
