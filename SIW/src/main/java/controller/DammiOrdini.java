package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entita.Acquisto;
import entita.Azienda;
import entita.Prodotto;
import persistence.PostgresDAOFactory;

/**
 * Servlet implementation class DammiOrdini
 */
public class DammiOrdini extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameterMap());

		Azienda azienda = (Azienda) request.getSession().getAttribute("azienda");
		List<Prodotto> prodottiAzienda = PostgresDAOFactory.getInstance().getProdottoDAO()
				.cercaPerAzienda(azienda.getId());
		List<Acquisto> ordini = PostgresDAOFactory.getInstance().getAcquistoDAO().cercaTutti();
		List<Acquisto> ordiniAzienda = new ArrayList<Acquisto>();
		for (int i = 0; i < prodottiAzienda.size(); i++) {
			for (int j = 0; j < ordini.size(); j++) {
				if (prodottiAzienda.get(i).getId() == ordini.get(j).getIdProdotto()) {
					ordiniAzienda.add(ordini.get(j));
				}
			}
		}
		JSONArray risposta = new JSONArray();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN);

		for (int i = 0; i < ordiniAzienda.size(); i++) {
			JSONObject tmp = new JSONObject();
			tmp.put("NomeProdotto", PostgresDAOFactory.getInstance().getProdottoDAO()
					.cercaPerChiavePrimaria(ordiniAzienda.get(i).getIdProdotto()).getNome());
			tmp.put("NomeCliente", PostgresDAOFactory.getInstance().getClienteDAO()
					.cercaPerChiavePrimaria(ordiniAzienda.get(i).getIdCliente()).getCodiceFiscale());

			tmp.put("DataAcquisto", format.format(ordiniAzienda.get(i).getDataAcquisto()));

			risposta.put(tmp);
		}
		System.out.println(risposta);
		PrintWriter pw = response.getWriter();
		pw.print(risposta.toString());
		pw.close();

	}

}
