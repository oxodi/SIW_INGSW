package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entita.Acquisto;
import entita.Cliente;
import entita.Prodotto;
import persistence.PostgresDAOFactory;
import persistence.dao.AcquistoDao;
import persistence.dao.ProdottoDao;

/**
 * Servlet implementation class SalvaAcquisto
 */
public class SalvaAcquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("sono nella servlet SALVAACQUISTO");
			
			Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
			PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
			AcquistoDao acquistodao = factory.getAcquistoDAO();
			ProdottoDao prodottodao = factory.getProdottoDAO();
			
			String jsonReceived = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String line = reader.readLine();
			
			while (line != null) {
				System.out.println("Linee: " +line);
				jsonReceived = jsonReceived + line + "\n";
				line = reader.readLine();
			}
			
			JSONArray jsonarray = new JSONArray(jsonReceived);
			for (int i = 0; i < jsonarray.length(); i++) {
			    JSONObject jsonobject = jsonarray.getJSONObject(i);
			   
			    int idCliente = cliente.getId();
			    int idProdotto = Integer.parseInt(jsonobject.getString("id"));
			    int quantita = Integer.parseInt(jsonobject.getString("quantita"));
			    double costoUnitario = Double.parseDouble(jsonobject.getString("prezzo"));
			    double importo = (costoUnitario * quantita);
			    Date dataAcquisto = new Date();
			    
			    Acquisto acquisto = new Acquisto(idCliente, idProdotto, dataAcquisto, quantita, importo);
			    Prodotto prodotto = prodottodao.cercaPerChiavePrimaria(idProdotto);
			    
			    int quantitaProdotto = prodotto.getQuantita() - quantita;
			    
			    if(quantitaProdotto >= 0) {
			    	prodotto.setQuantita(quantitaProdotto);
			    	prodottodao.aggiorna(prodotto);
			    }
			    
			    acquistodao.salva(acquisto);
			}
			
			
	}



}
