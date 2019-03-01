package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entita.Acquisto;
import entita.Cliente;
import persistence.PostgresDAOFactory;
import persistence.dao.AcquistoDao;
import persistence.dao.ProdottoDao;

/**
 * Servlet implementation class DammiAcquistiCliente
 */
public class DammiAcquistiCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		AcquistoDao acquistodao = factory.getAcquistoDAO();
		ProdottoDao prodottodao = factory.getProdottoDAO();
		
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN);
		
		List<Acquisto> acquisti = acquistodao.cercaPerCliente(cliente.getId());
		JSONArray acquistiJSON = new JSONArray();
		
		long dataCorrente = new Date().getTime();
		TimeUnit timeUnit = TimeUnit.HOURS;
		
		for(Acquisto acquisto : acquisti) {
			
			JSONObject tmp = new JSONObject();
			
			Date data = acquisto.getDataAcquisto();
			
			tmp.put("idOrdine", acquisto.getId());
			tmp.put("date",format.format(data));
			
			String nomeProdotto = prodottodao.restituisciNome(acquisto.getIdProdotto());
			
			tmp.put("nome", nomeProdotto);
			tmp.put("quantita", acquisto.getQuantita());
			tmp.put("importo", acquisto.getImporto());
			
			String categoriaProdotto = prodottodao.restituisciCategoria(acquisto.getIdProdotto());
			
			tmp.put("categoria", categoriaProdotto);
			
			long progressoOrdine = dataCorrente - acquisto.getDataAcquisto().getTime();
			long progressoOre = timeUnit.convert(progressoOrdine, TimeUnit.MILLISECONDS);
			
			if(progressoOre <= 12)
				tmp.put("stato", "In lavorazione");
			else if(progressoOre <= 48)
				tmp.put("stato", "Spedito");
			else if(progressoOre <= 96)
				tmp.put("stato", "In consegna");
			else
				tmp.put("stato", "Consegnato");
			
		
			acquistiJSON.put(tmp);
		}
		
		PrintWriter pw = response.getWriter();
		pw.print(acquistiJSON.toString());
		System.out.println(acquistiJSON.toString());
		pw.close();
		
	}


}
