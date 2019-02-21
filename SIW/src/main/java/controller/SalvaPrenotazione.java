package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;
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
		int btnterreno = (Integer) request.getSession().getAttribute("idTerreno");
		
		String[] elementi = request.getParameterValues("str[]");
		String[] el = elementi[0].split("@");
		 
		for(int i = 1; i<el.length; i++) {
			el[i] = el[i].substring(1);
		}
		
		
		
		for(int a = 0; a < el.length; a++) {
			Prenotazione prenotazione = new Prenotazione();
			Terreno terreno = terrenoDao.cercaPerChiavePrimaria(btnterreno);
			prenotazione.setDataPrenotazione(new Date());
			prenotazione.setIdCliente(cliente.getId());
			prenotazione.setIdTerreno(btnterreno);
			int quantita = 0;
			
			String[] i = el[a].split(",");

			for(int it= 0; it<i.length; it++) {
				if(it==0) {
					System.out.println(i[it]);
					int id_ortaggio = ortaggioDao.restituisciId(i[it]);
					prenotazione.setId_ortaggio(id_ortaggio);
				}else if(it==1){
					quantita = Integer.parseInt(i[it]);
				
					prenotazione.setQuantita(quantita);
				}else if(it==4) {
					if(i[it].equals("si")) {
						prenotazione.setSerra(true);
						int dimensioneSerra = terreno.getSerraPrenotata() + quantita;
						terreno.setSerraPrenotata(dimensioneSerra);
						terrenoDao.aggiornaQuantitaPrenotata(terreno);
					} else {
						prenotazione.setSerra(false);
						int dimensioneTerreno = terreno.getTerrenoPrenotato() + quantita;
						terreno.setSerraPrenotata(dimensioneTerreno);
						terrenoDao.aggiornaQuantitaPrenotata(terreno);
					}

				}

				
			}
			prenotazioneDao.salva(prenotazione);
			
		}


		

		
		RequestDispatcher rd = request.getRequestDispatcher("ricevutaPagamento.jsp");
		rd.forward(request, response);
	}

}
