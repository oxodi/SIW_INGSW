package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Prodotto;
import persistence.PostgresDAOFactory;
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
		List<Prodotto> prodotti = null;
		String filtro = request.getParameter("filtro");
		if(filtro.equals("cat")) {
			String categoria = request.getParameter("categoria");
			int numeroProdotti = prodottoDao.sizeProdottiCategoria(categoria);
			double numeroPagineTemp = (double) numeroProdotti / 10;
			int numeroPagine =  (int) Math.ceil(numeroPagineTemp);
			int pagina;
			if(request.getParameter("pagina") != null) {
				pagina = (Integer.parseInt(request.getParameter("pagina"))) - 1;
			} else {
				pagina = 0;
			}
			
			prodotti = prodottoDao.cercaPerCategoria(categoria);
			System.out.println(categoria);
		}
		
		
		request.setAttribute("prodotti", prodotti);
		RequestDispatcher rd = request.getRequestDispatcher("ordinaProdotto.jsp");
		rd.forward(request, response);
	}

	

}
