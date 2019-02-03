package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthScrollPaneUI;

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
		
		String primavera = req.getParameter("primavera");
		String estate = req.getParameter("estate");
		String inverno = req.getParameter("inverno");
		String autunno = req.getParameter("autunno");
		 
		List<String> periodi = new ArrayList<String>();
		
		if(primavera.equals("on"))
			periodi.add(new String("primavera"));
		if(estate.equals("on"))
			periodi.add(new String("estate"));	
		if(inverno.equals("on"))
			periodi.add(new String("inverno"));
		if(autunno.equals("on"))
			periodi.add(new String("autunno"));
		
		//i terreni con periodo annuale vengono sempre inseriti nella query
		//periodi.add(new String("annuale"));
		
		if(completo.equals("true"))
			servizioCompleto = true;
		if(parziale.equals("true"))
			servizioParziale = true;

		AziendaDao aziendaDao = PostgresDAOFactory.getInstance().getAziendaDAO();
		List<Azienda> aziende = new ArrayList<Azienda>();
		List<Azienda> aziendeDuplicate = new ArrayList<Azienda>();
		
		String btnCerca = req.getParameter("btnCerca");
		
		if(btnCerca.equals("tutte"))
			aziendeDuplicate.addAll(aziendaDao.cercaTutti());
		else { 
			for(String periodo : periodi)
			aziendeDuplicate.addAll(aziendaDao.cercaAziendaPerTipologiaPeriodo(servizioParziale, servizioCompleto, periodo));
		}
		
		aziende = removeDuplicates(aziendeDuplicate);

		for(Azienda a : aziende)
			System.out.println("AziendaSenzaDuplicati: "+a.getId());
		
		
		req.setAttribute("aziende", aziende);
		
		RequestDispatcher rd = req.getRequestDispatcher("sceltaAzienda.jsp");
		rd.forward(req, resp);
	}

	public static ArrayList<Azienda> removeDuplicates(List<Azienda> aziendeDuplicate){
		ArrayList<Azienda> nuovaLista = new ArrayList<Azienda>();
		
		for (Azienda element : aziendeDuplicate) {
		    boolean isFound = false;
		    for (Azienda elEnd : nuovaLista) {
		        if ( elEnd.getId() == element.getId() ) {
		        	isFound = true;        
		            break;
		        }
		    }
		    if (!isFound) 
		    	nuovaLista.add(element);
		}
		
		return nuovaLista;
	}
	
}
