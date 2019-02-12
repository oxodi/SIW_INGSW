package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;
import entita.Prodotto;
import persistence.PostgresDAOFactory;
import persistence.dao.ProdottoDao;

public class InserisciProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("delete").equals("true")) {
			ProdottoDao prodottoNew = PostgresDAOFactory.getInstance().getProdottoDAO();
			Prodotto prodotto = new Prodotto();
			int id = Integer.parseInt(req.getParameter("tempId"));
			System.out.println("sto eliminando " + id);
			prodotto.setId(id);
			prodottoNew.cancella(prodotto);

			RequestDispatcher rd = req.getRequestDispatcher("PrelevaDatiTerreno");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("edit").equals("true")) {

			System.out.println("Sono nell'edit del prodotto");
			System.out.println("sto cambiando l'ID " + req.getParameter("editFormId"));
			int id = Integer.parseInt(req.getParameter("editFormId"));
			int quantita = Integer.parseInt(req.getParameter("editFormQuantita"));
			System.out.println("sto settando la Quantita " + quantita);
			double costo = Double.parseDouble(req.getParameter("editFormCosto"));
			System.out.println("sto settando il costo " + costo);
			String descrizione = req.getParameter("editFormDescrizione");
			System.out.println("sto settando la descrizione " + descrizione);

			ProdottoDao prodottoNew = PostgresDAOFactory.getInstance().getProdottoDAO();
			Prodotto prodotto = prodottoNew.cercaPerChiavePrimaria(id);
			prodotto.setQuantita(quantita);
			prodotto.setCostoUnitario(costo);
			prodotto.setDescrizione(descrizione);
			
			System.out.println("Sto aggiornando... " + prodotto.getId());
			System.out.println("Sto aggiornando... " + prodotto.getQuantita());
			System.out.println("Sto aggiornando... " + prodotto.getCostoUnitario());
			System.out.println("Sto aggiornando... " + prodotto.getDescrizione());

			prodottoNew.aggiorna(prodotto);
			RequestDispatcher rd = req.getRequestDispatcher("PrelevaDatiTerreno");
			rd.forward(req, resp);
		} else {

			String nome = req.getParameter("nome");
			String categoria = req.getParameter("categoria");
			int quantita = Integer.parseInt(req.getParameter("quantita"));
			double costo = Double.parseDouble(req.getParameter("costo"));
			String descrizione = req.getParameter("descrizione");
			Azienda aziendaInSessione = (Azienda) req.getSession().getAttribute("azienda");
			Prodotto p = new Prodotto();
			System.out.println("Setto il nome: " + nome);
			p.setNome(nome);
			System.out.println("Setto la categoria: " + categoria);
			p.setCategoria(categoria);
			System.out.println("Setto il costo: " + costo);
			p.setCostoUnitario(costo);
			System.out.println("Setto la descrizione: " + descrizione);
			p.setDescrizione(descrizione);
			System.out.println("Setto la quantita: " + quantita);
			p.setQuantita(quantita);
			System.out.println("ID Azienda: " + aziendaInSessione.getId());
			p.setIdAzienda(aziendaInSessione.getId());
			ProdottoDao prod = PostgresDAOFactory.getInstance().getProdottoDAO();
			prod.salva(p);
			RequestDispatcher rd = req.getRequestDispatcher("PageLoader?id=backendAzienda");
			rd.forward(req, resp);

		}
	}
}
