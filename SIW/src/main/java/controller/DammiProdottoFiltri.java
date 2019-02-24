package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Prodotto;
import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;
import persistence.dao.ProdottoDao;

/**
 * Servlet implementation class DammiProdottoFiltri
 */
public class DammiProdottoFiltri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sono in DammiProdottoFiltri");
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		ProdottoDao prodottoDao = factory.getProdottoDAO();
		AziendaDao aziendaDao = factory.getAziendaDAO();
		List<Prodotto> prodotti = null;
		String filtro = request.getParameter("filtro");
		System.out.println(filtro);
	
		if(filtro.equals("cat")) {
			
			String categoria = request.getParameter("categoria");
			prodotti = prodottoDao.cercaPerCategoria(categoria);
		
		} else if (filtro.equals("az")) {
			
			String azienda = request.getParameter("azienda");
			int id_azienda = aziendaDao.restituisciID(azienda);
			prodotti = prodottoDao.cercaPerAzienda(id_azienda);
		} else if (filtro.equals("prezzo")) {
			
			int min = Integer.parseInt(request.getParameter("minPrezzo"));
			int max = Integer.parseInt(request.getParameter("maxPrezzo"));
			prodotti = prodottoDao.filtraPerPrezzo(min, max);
		} else if (filtro.equals("cerca")) {
			String nomeProdotto = request.getParameter("nomeProdotto");
			Prodotto prodotto = prodottoDao.cercaPerNome(nomeProdotto);
			prodotti = new ArrayList<Prodotto>();
			prodotti.add(prodotto);
		}
		
		for (Prodotto prodotto : prodotti) {
			int id_azienda = prodotto.getIdAzienda();
			prodotto.setNomeAzienda(aziendaDao.restituisciNome(id_azienda));
		} 
		
		List<String> aziende = aziendaDao.cercaAziendaConProdotto();
		request.setAttribute("prodotti", prodotti);
		request.setAttribute("aziende", aziende);
		RequestDispatcher rd = request.getRequestDispatcher("ordinaProdotto.jsp");
		rd.forward(request, response);
	}

	

}
