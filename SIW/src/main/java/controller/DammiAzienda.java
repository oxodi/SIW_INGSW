package controller;

import java.io.IOException;
import java.util.ArrayList;
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
		
		String primavera = req.getParameter("primavera");
		String estate = req.getParameter("estate");
		String inverno = req.getParameter("inverno");
		String autunno = req.getParameter("autunno");
		
		
		System.out.println("periodoPrimavera: "+primavera);
		System.out.println("periodoEstate: "+estate);
		System.out.println("periodoInverno: "+inverno);
		System.out.println("periodoAutunno: "+autunno);
		 
		List<String> periodi = new ArrayList<String>();
		
		if(primavera.equals("on"))
			periodi.add(new String("primavera"));
		if(estate.equals("on"))
			periodi.add(new String("estate"));	
		if(inverno.equals("on"))
			periodi.add(new String("inverno"));
		if(autunno.equals("on"))
			periodi.add(new String("autunno"));
		
		if(completo.equals("true"))
			servizioCompleto = true;
		if(parziale.equals("true"))
			servizioParziale = true;

		AziendaDao aziendaDao = PostgresDAOFactory.getInstance().getAziendaDAO();
		List<Azienda> aziende = new ArrayList<Azienda>();
		
		String btnCerca = req.getParameter("btnCerca");
		
		if(btnCerca.equals("tutte"))
			aziende.addAll(aziendaDao.cercaTutti());
		else { 
			for(String periodo : periodi)
			aziende.addAll(aziendaDao.cercaAziendaPerTipologiaPeriodo(servizioParziale, servizioCompleto, periodo));
		}
		req.setAttribute("aziende", aziende);
		
		RequestDispatcher rd = req.getRequestDispatcher("sceltaAzienda.jsp");
		rd.forward(req, resp);
	}

}
