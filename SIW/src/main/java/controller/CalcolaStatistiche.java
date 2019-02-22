package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entita.Prenotazione;
import entita.Terreno;
import persistence.PostgresDAOFactory;

/**
 * Servlet implementation class CalcolaStatistiche
 */
public class CalcolaStatistiche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Prenotazione> prenotazioni = PostgresDAOFactory.getInstance().getPrenotazioneDAO().cercaTutti();
			//List<Prenotazione> prenotazioniPerAzienda = new ArrayList<Prenotazione>();
			int aziendaInSessione = Integer.parseInt(req.getParameter("azienda"));
			List<Terreno> terreniPerAzienda = PostgresDAOFactory.getInstance().getTerrenoDAO().cercaPerAzienda(aziendaInSessione);
			int primavera = 0,estate = 0,autunno = 0,inverno = 0;
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
			for(int i = 0;i<terreniPerAzienda.size();i++) {
				System.out.println("terreni: "+terreniPerAzienda.get(i).getLocazione());
				for(int j = 0;j<prenotazioni.size();j++) {
					System.out.println("prenotazione "+prenotazioni.size());
					if(prenotazioni.get(j).getIdTerreno() == terreniPerAzienda.get(i).getId())
					{
						//prenotazioniPerAzienda.add(prenotazioni.get(j));
						if(terreniPerAzienda.get(i).getPeriodiDisponibilita().equals("primavera")) {
							primavera++;
						}
						else if(terreniPerAzienda.get(i).getPeriodiDisponibilita().equals("estate")) {
							estate++;
						}
						else if(terreniPerAzienda.get(i).getPeriodiDisponibilita().equals("autunno")) {
							autunno++;
						}
						else if(terreniPerAzienda.get(i).getPeriodiDisponibilita().equals("inverno")) {
							inverno++;
						}
					}
				}
			}
			JSONObject risposta = new JSONObject();
			risposta.put("primavera", primavera);
			risposta.put("estate", estate);
			risposta.put("autunno", autunno);
			risposta.put("inverno", inverno);
			System.out.println(risposta);
			PrintWriter pw = resp.getWriter();
			pw.print(risposta.toString());
			pw.close();
			
			
	}

}
