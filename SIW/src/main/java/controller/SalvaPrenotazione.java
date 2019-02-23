package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entita.Cliente;
import entita.Prenotazione;
import entita.Terreno;
import persistence.PostgresDAOFactory;
import persistence.dao.OrtaggioDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class SalvaPrenotazione
 */
public class SalvaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sono in salva Prenotazione");
		PrenotazioneDao prenotazioneDao= PostgresDAOFactory.getInstance().getPrenotazioneDAO();
		OrtaggioDao ortaggioDao = PostgresDAOFactory.getInstance().getOrtaggioDAO();
		TerrenoDao terrenoDao =  PostgresDAOFactory.getInstance().getTerrenoDAO();
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
		Terreno terreno = (Terreno) request.getSession().getAttribute("terrenoSessione");
		
		String[] elementi = request.getParameterValues("str[]");
		String[] ortaggiPrenotati = elementi[0].split("@");
		
		for(int i = 1; i<ortaggiPrenotati.length; i++) {
			
			ortaggiPrenotati[i] = ortaggiPrenotati[i].substring(1);
			
		}
	
		
		for(int a = 0; a < ortaggiPrenotati.length; a++) {
			
			Prenotazione prenotazione = new Prenotazione();
		
			prenotazione.setDataPrenotazione(new Date());
			prenotazione.setIdCliente(cliente.getId());
			prenotazione.setIdTerreno(terreno.getId());
			prenotazione.setNomeCliente(cliente.getNome());
			prenotazione.setCognomeCliente(cliente.getCognome());
			prenotazione.setLocazioneTerreno(terreno.getLocazione());
			
			int quantita = 0;
			
			String[] colOrtaggi = ortaggiPrenotati[a].split(",");
			
			for(int it= 0; it<colOrtaggi.length; it++) {
				System.out.println("colOrtaggi["+it+"]: "+ colOrtaggi[it]);
				System.out.println();
			}
			for(int it= 0; it<colOrtaggi.length; it++) {
				if(it==0) {
				
					int id_ortaggio = ortaggioDao.restituisciId(colOrtaggi[it]);
					prenotazione.setId_ortaggio(id_ortaggio);
					prenotazione.setNomeOrtaggio(colOrtaggi[it]);
					
				}else if(it==1){
					
					quantita = Integer.parseInt(colOrtaggi[it]);
					prenotazione.setQuantita(quantita);
			
				}else if(it==4) {
					if(colOrtaggi[it].equals("si")) {
						
						prenotazione.setSerra(true);	
						int dimensioneSerra = terreno.getSerraPrenotata() + quantita;
						terreno.setSerraPrenotata(dimensioneSerra);
						
					} else {
							
						prenotazione.setSerra(false);
						int dimensioneTerreno = terreno.getTerrenoPrenotato() + quantita;
						terreno.setTerrenoPrenotato(dimensioneTerreno);
						}
					
					terrenoDao.aggiornaQuantitaPrenotata(terreno);	
				}
				//System.out.println("Quantità: "+quantita);
				
			}
			prenotazioneDao.salva(prenotazione);
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ricevutaPagamento.jsp");
		rd.forward(request, response);
	}

}
