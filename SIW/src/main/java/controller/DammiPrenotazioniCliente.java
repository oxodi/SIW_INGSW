package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.json.JSONArray;
import org.json.JSONObject;

import entita.Azienda;
import entita.Cliente;
import entita.Prenotazione;
import entita.Terreno;
import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;
import persistence.dao.OrtaggioDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class DammiPrenotazioniCliente
 */
public class DammiPrenotazioniCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		PrenotazioneDao prenotazionedao = factory.getPrenotazioneDAO();
		TerrenoDao terrenodao = factory.getTerrenoDAO();
		AziendaDao aziendadao = factory.getAziendaDAO();
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN);
		
		
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
		String dataNascita = format.format(cliente.getDataDiNascita());
		
		request.setAttribute("dataNascitaCliente", dataNascita);
		
		if (request.getParameter("edit").equals("true")) {	
			
			
			RequestDispatcher rd = request.getRequestDispatcher("profiloCliente.jsp");
			rd.forward(request, response);
						

		}
		else if(request.getParameter("edit").equals("tabPren")) {
		
			List<Prenotazione> prenotazioni = prenotazionedao.cercaPerCliente(cliente.getId());
			JSONArray prenotazioniJSON = new JSONArray();
				
			for(Prenotazione prenotazione : prenotazioni) {
				JSONObject locazionePeriodo = terrenodao.restituisciLocazionePeriodo(prenotazione.getIdTerreno());
				String nomeAzienda = aziendadao.restituisciNome(locazionePeriodo.getInt("idAzienda"));
				
				JSONObject tmp = new JSONObject();
				
				tmp.put("idTerreno", prenotazione.getIdTerreno());
				tmp.put("locazione", locazionePeriodo.get("locazione"));
				tmp.put("azienda", nomeAzienda);
				tmp.put("periodi", locazionePeriodo.get("periodo"));
				
				prenotazioniJSON.put(tmp);
			}

			
			PrintWriter pw = response.getWriter();
			pw.print(prenotazioniJSON.toString());
			System.out.println(prenotazioniJSON.toString());
			pw.close();
			
			
		}
		else if(request.getParameter("edit").equals("false")){
			System.out.println("Sono nella servlet dammiPrenotazioneCliente");
		
			int idTerreno = Integer.parseInt(request.getParameter("id_terreno"));
			System.out.println("ID TERRENO: "+idTerreno);
			
			List<Prenotazione> prenotazioniOrtaggi = prenotazionedao.cercaPerClienteTerreno(cliente.getId(), idTerreno);
			
			JSONArray prenotazioniJSON = new JSONArray();
			
			long dataCorrente = new Date().getTime();
			TimeUnit timeUnit = TimeUnit.DAYS;
			
			for(Prenotazione pren : prenotazioniOrtaggi) {
				
				
				JSONObject tmp = new JSONObject();
				
				Date data = pren.getDataPrenotazione();
				long progresso = dataCorrente - pren.getDataPrenotazione().getTime();
				long progressoGiorni = timeUnit.convert(progresso, TimeUnit.MILLISECONDS);
				//String nomeOrtaggio = ortaggiodao.cercaPerChiavePrimaria(pren.getId_ortaggio()).getNome();
				int tempoColtivazione = prenotazionedao.tempoColtivazionePerTerrenoOrtaggio(idTerreno, pren.getId_ortaggio());
				double progressoFinale;
				

				tmp.put("date",format.format(data));
				tmp.put("nome",pren.getNomeOrtaggio());
				tmp.put("quantita",pren.getQuantita());
				
				if(pren.isSerra())
					tmp.put("serra", "si");
				else
					tmp.put("serra", "no");
				
				if(tempoColtivazione == 0) 
					progressoFinale = 0.0;
				else
					progressoFinale =  (progressoGiorni * 100) / tempoColtivazione;
				
	
				if(progressoFinale > 100)
					progressoFinale = 100.0;
				
				tmp.put("progresso", progressoFinale);
				
				prenotazioniJSON.put(tmp);
				
			}
		
			PrintWriter pw = response.getWriter();
			pw.print(prenotazioniJSON.toString());
			System.out.println(prenotazioniJSON.toString());
			pw.close();
		}

	}

}
