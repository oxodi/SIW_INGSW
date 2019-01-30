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
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher rd = req.getRequestDispatcher("PageLoader?id=backendAzienda");
			rd.forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Terreno terreno = new Terreno();
		int dimensione = Integer.parseInt(req.getParameter("dimensione_terreno"));
		int dimensioneSerra = Integer.parseInt(req.getParameter("dimensione_serra"));
		double costo = Double.parseDouble(req.getParameter("costo_terreno"));
		boolean parziale = Boolean.parseBoolean(req.getParameter("parziale"));
		boolean completo = Boolean.parseBoolean(req.getParameter("completo"));
		terreno.setLocazione(req.getParameter("locazione"));
		terreno.setDimensione(dimensione);
		terreno.setDimensioneSerra(dimensioneSerra);
		terreno.setCosto(costo);
		terreno.setServizioCompleto(completo);
		terreno.setServizioParziale(parziale);
		Azienda az = (Azienda) req.getSession().getAttribute("azienda");
		System.out.println(az.getId());
		terreno.setIdAzienda(az.getId());
		terreno.setPeriodiDisponibilita(req.getParameter("disponibilita"));
		TerrenoDao terrenoNew = PostgresDAOFactory.getInstance().getTerrenoDAO();
		terrenoNew.salva(terreno);
		System.out.println("sono il terreno" + terreno.getId());
		String[] checkedIds = req.getParameterValues("ortaggiSelezionati");		
		
		for (int i = 0; i < checkedIds.length; i++) {
			System.out.println("Ho selezionato gli ortaggi "+ checkedIds[i]);
			String prezzi =  req.getParameter("prezzo"+checkedIds[i]);
			double intPrezzi = Double.parseDouble(prezzi);
			String tempo = req.getParameter("tempo"+checkedIds[i]);
			int tempoInt = Integer.parseInt(tempo);
			
			System.out.println("con questo costo "+intPrezzi);
			System.out.println("con questo tempo "+tempoInt);
			terrenoNew.aggiungiOrtaggio(terreno.getId(), Integer.parseInt(checkedIds[i]), intPrezzi, tempoInt);
		}
		
		doGet(req, resp);
		

	}

}
