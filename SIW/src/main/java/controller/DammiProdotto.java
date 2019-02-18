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
		
		List<Azienda> aziendeDuplicate = new ArrayList<Azienda>();
	
		List<Prodotto> prodotti = prodottoDao.cercaTutti();
		for (Prodotto prodotto : prodotti) {
			int idAzienda = prodotto.getIdAzienda();
			Azienda azienda = aziendaDao.cercaPerChiavePrimaria(idAzienda);
			aziendeDuplicate.add(azienda);
			prodotto.setNomeAzienda(azienda.getRagioneSociale());
		}
		
		List<Azienda> aziende = removeDuplicates(aziendeDuplicate);
	
		request.setAttribute("prodotti", prodotti);
		request.setAttribute("aziende", aziende);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ordinaProdotto.jsp");
		rd.forward(request, response);
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
