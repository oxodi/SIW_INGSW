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
import entita.Cliente;
import entita.Prenotazione;
import entita.Terreno;
import entita.ortaggio.Ortaggio;
import persistence.PostgresDAOFactory;
import persistence.dao.ClienteDao;
import persistence.dao.OrtaggioDao;
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
		ClienteDao clienteDAO = factory.getClienteDAO();
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
			
			List<String> nomi = new ArrayList<String>();
			List<String> cognomi  = new ArrayList<String>();
			List<String> terrenoNome  = new ArrayList<String>();
			
			for(int i = 0 ; i < ordinata.size(); i++) {
				Cliente cliente = clienteDAO.cercaPerChiavePrimaria(ordinata.get(i).getIdCliente());
				Terreno terreno = terrenoDAO.cercaPerChiavePrimaria(ordinata.get(i).getIdTerreno());
				nomi.add(cliente.getNome());
				cognomi.add(cliente.getCognome());
				terrenoNome.add(terreno.getLocazione());
			}
			
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN);
			JSONArray prenotazionijson = new JSONArray();
			
			for(int i = 0 ; i < ordinata.size(); i++) {
				JSONObject tmp = new JSONObject();
				tmp.put("id_terreno", ordinata.get(i).getIdTerreno());
				tmp.put("id_cliente", ordinata.get(i).getIdCliente());
				tmp.put("terreno", terrenoNome.get(i));
				tmp.put("cliente_nome", nomi.get(i));
				tmp.put("cliente_cognome", cognomi.get(i));
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
			List<Prenotazione> prenotazioneOrtaggi = prenotazioneDAO.cercaPerTerreno(idTerreno);
			OrtaggioDao ortaggioDAO = factory.getOrtaggioDAO();
			
			JSONArray ortaggiJson = new JSONArray();
			
			for(int i = 0 ; i < prenotazioneOrtaggi.size(); i++) {
				JSONObject tmp = new JSONObject();
				Ortaggio ortaggio = ortaggioDAO.cercaPerChiavePrimaria(prenotazioneOrtaggi.get(i).getId_ortaggio());
				
				tmp.put("ortaggio", ortaggio.getNome());
				tmp.put("quantita", prenotazioneOrtaggi.get(i).getQuantita());
				if(prenotazioneOrtaggi.get(i).isSerra()) {
					tmp.put("serra","SI");
				}
				else
					tmp.put("serra", "-");
				
				ortaggiJson.put(tmp);
				
			}
			
			PrintWriter pw = response.getWriter();
			pw.print(ortaggiJson.toString());
			System.out.println(ortaggiJson);
			pw.close();
		}
	}

	
}
