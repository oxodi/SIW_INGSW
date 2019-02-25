package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import entita.Azienda;
import entita.Prenotazione;
import entita.Terreno;
import persistence.PostgresDAOFactory;
import persistence.dao.PrenotazioneDao;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class DammiPrenotazioneAzienda
 */
public class DammiPrenotazioneAzienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sono nella servlet dammi prenotazioni");
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		Azienda azienda = (Azienda) request.getSession().getAttribute("azienda");
		TerrenoDao terrenoDAO = factory.getTerrenoDAO();
		PrenotazioneDao prenotazioneDAO = factory.getPrenotazioneDAO();
		
		if(request.getParameter("edit").equals("true")) {
		
			List<Terreno> terreni =  terrenoDAO.cercaPerAzienda(azienda.getId());
			List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
			
			for(int i = 0 ; i < terreni.size() ; i++) {
				
				prenotazioni.addAll(prenotazioneDAO.cercaPerTerreno(terreni.get(i).getId()));
				
			}
			
			List<Prenotazione> ordinata = new ArrayList<Prenotazione>();
			for(int i = 0  ; i < prenotazioni.size(); i++) {
				boolean trovato = false;
				for(int j = 0 ; j < ordinata.size(); j++) {
					if((prenotazioni.get(i).getIdCliente() == ordinata.get(j).getIdCliente()) &&
							(prenotazioni.get(i).getIdTerreno() == ordinata.get(j).getIdTerreno()))
						trovato = true;
				}
				
				if(trovato == false) {
					ordinata.add(prenotazioni.get(i));
				}
			}
			
			System.out.println("PRENOTAZIONI NON ORDINATE: "+prenotazioni.size());
			System.out.println("PRENOTAZIONI  ORDINATE: "+ordinata.size());
		
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN);
			JSONArray prenotazionijson = new JSONArray();
			
			for(int i = 0 ; i < ordinata.size(); i++) {
				JSONObject tmp = new JSONObject();
				tmp.put("id_terreno", ordinata.get(i).getIdTerreno());
				tmp.put("id_cliente", ordinata.get(i).getIdCliente());
				tmp.put("terreno", ordinata.get(i).getLocazioneTerreno());
				tmp.put("cliente_nome", ordinata.get(i).getNomeCliente());
				tmp.put("cliente_cognome", ordinata.get(i).getCognomeCliente());
				Date date = ordinata.get(i).getDataPrenotazione();
				tmp.put("data", format.format(date));
				
				prenotazionijson.put(tmp);
			}
			
			
			PrintWriter pw = response.getWriter();
			pw.print(prenotazionijson.toString());
			System.out.println(prenotazionijson);
			pw.close();
		}
		
		else if (request.getParameter("edit").equals("false")) {
			
			System.out.println("sono in prenotazioni per cliente");
			int idTerreno = Integer.parseInt(request.getParameter("id_terreno"));
			int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
			List<Prenotazione> prenotazioneOrtaggi = prenotazioneDAO.cercaPerTerreno(idTerreno);
			
			JSONArray ortaggiJson = new JSONArray();
			
			for(int i = 0 ; i < prenotazioneOrtaggi.size(); i++) {
				if(prenotazioneOrtaggi.get(i).getIdCliente() == idCliente) {
					JSONObject tmp = new JSONObject();
					
					System.out.println("ortaggio: "+prenotazioneOrtaggi.get(i).getNomeOrtaggio());
					
					if(prenotazioneOrtaggi.get(i).getNomeOrtaggio().equals("Terreno")) {
					tmp.put("ortaggio", "Servizio Parziale");
					}
					else
						tmp.put("ortaggio", prenotazioneOrtaggi.get(i).getNomeOrtaggio());
					
					tmp.put("quantita", prenotazioneOrtaggi.get(i).getQuantita());
					if(prenotazioneOrtaggi.get(i).isSerra()) {
						tmp.put("serra","SI");
					}
					else
						tmp.put("serra", "-");
					
					ortaggiJson.put(tmp);
				}	
				
			}
			
			PrintWriter pw = response.getWriter();
			pw.print(ortaggiJson.toString());
			System.out.println(ortaggiJson);
			pw.close();
		}
	}

	
}
