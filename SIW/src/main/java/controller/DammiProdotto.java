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
import entita.CategoriaProdotti;
import entita.Prodotto;
import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;
import persistence.dao.ProdottoDao;

/**
 * Servlet implementation class DammiProdotto
 */
public class DammiProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sono in Dammi Prodotto");
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		ProdottoDao prodottoDao = factory.getProdottoDAO();
		AziendaDao aziendaDao = factory.getAziendaDAO();
		int numeroProdotti = prodottoDao.sizeProdotti();
		double numeroPagineTemp = (double) numeroProdotti / 10;
		int numeroPagine =  (int) Math.ceil(numeroPagineTemp);
		int pagina;
		if(request.getParameter("pagina") != null) {
			pagina = (Integer.parseInt(request.getParameter("pagina"))) - 1;
		} else {
			pagina = 0;
		}
		
		System.out.println("Pagina: "+pagina);
		List<Prodotto> prodotti = prodottoDao.dammiProdottiPerPagina(pagina);
		
		for (Prodotto prodotto : prodotti) {
			int id_azienda = prodotto.getIdAzienda();
			prodotto.setNomeAzienda(aziendaDao.restituisciNome(id_azienda));
		}
		
		List<String> aziende = aziendaDao.cercaAziendaConProdotto();
		
		request.setAttribute("prodotti", prodotti);
		request.setAttribute("aziende", aziende);
		request.setAttribute("numeroPagine", numeroPagine);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ordinaProdotto.jsp");
		rd.forward(request, response);
	}
	



}
