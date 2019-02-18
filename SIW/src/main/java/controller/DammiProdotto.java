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
    private static final String sLatticini = "Latticini";
    private static final String sOli = "Oli e derivati";
    private static final String sVerdure = "Verdure";
    private static final String sFrutti = "Frutti";
    private static final String sVini = "Vini";
    private static final String sCarni = "Carni e derivati";
    private static final String sAltro = "Altro";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sono in Dammi Prodotto");
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		ProdottoDao prodottoDao = factory.getProdottoDAO();
		AziendaDao aziendaDao = factory.getAziendaDAO();
		List<CategoriaProdotti> categoriaProdotti = new ArrayList<CategoriaProdotti>();
		List<Azienda> aziendeDuplicate = new ArrayList<Azienda>();
	
		List<Prodotto> prodotti = prodottoDao.cercaTutti();
		
		CategoriaProdotti latticini = new CategoriaProdotti(sLatticini);
		CategoriaProdotti oli = new CategoriaProdotti(sOli);
		CategoriaProdotti verdure = new CategoriaProdotti(sVerdure);
		CategoriaProdotti frutti = new CategoriaProdotti(sFrutti);
		CategoriaProdotti vini = new CategoriaProdotti(sVini);
		CategoriaProdotti carni = new CategoriaProdotti(sCarni);
		CategoriaProdotti altro = new CategoriaProdotti(sAltro);
		
		
		
		
		
		
		for (Prodotto prodotto : prodotti) {
			
			if(prodotto.getCategoria().equals(sLatticini)) {
				latticini.setQuantita(latticini.getQuantita()+1);
			} else if (prodotto.getCategoria().equals(sOli)) {
				oli.setQuantita(oli.getQuantita()+1);
			} else if (prodotto.getCategoria().equals(sVerdure)) {
				verdure.setQuantita(verdure.getQuantita()+1);
			} else if (prodotto.getCategoria().equals(sFrutti)) {
				frutti.setQuantita(frutti.getQuantita()+1);
			} else if (prodotto.getCategoria().equals(sVini)) {
				vini.setQuantita(vini.getQuantita()+1);
			} else if (prodotto.getCategoria().equals(sCarni)) {
				carni.setQuantita(carni.getQuantita()+1);
			} else  {
				altro.setQuantita(altro.getQuantita()+1);
			}
			int idAzienda = prodotto.getIdAzienda();
			Azienda azienda = aziendaDao.cercaPerChiavePrimaria(idAzienda);
			aziendeDuplicate.add(azienda);
			prodotto.setNomeAzienda(azienda.getRagioneSociale());
		}
		
		List<Azienda> aziende = removeDuplicates(aziendeDuplicate);
		
		categoriaProdotti.add(latticini);
		categoriaProdotti.add(oli);
		categoriaProdotti.add(verdure);
		categoriaProdotti.add(frutti);
		categoriaProdotti.add(vini);
		categoriaProdotti.add(carni);
		categoriaProdotti.add(altro);
	
		request.setAttribute("prodotti", prodotti);
		request.setAttribute("aziende", aziende);
		request.setAttribute("categorie", categoriaProdotti);
		
		
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
