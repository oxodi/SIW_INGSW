package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;
import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;

/**
 * Servlet implementation class InserisciAzienda
 */
public class InserisciAzienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		
		//	String nome = request.getParameter("name");
			String partitaIVA = request.getParameter("partita_iva");
			String referente = request.getParameter("referente");
			String sedeLegale = request.getParameter("sede_legale");
			String ragioneSociale = request.getParameter("ragione_sociale");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("email");
			String via = request.getParameter("via");
			String cap = request.getParameter("cap");
			String provincia = request.getParameter("provincia");
			String citta = request.getParameter("citta");
			String descrizione = request.getParameter("formDescrizione");
			String password = request.getParameter("password");
		
			/**
		 	* il primo parametro zero è considerato null e viene settato automaticamente nella funzione salva
		 	*/
			//Azienda azienda = new Azienda("Stringa", partitaIVA, referente, sedeLegale, ragioneSociale, telefono, "sono pippo" , email);
		
			Azienda azienda = new Azienda(ragioneSociale, referente, sedeLegale, via, citta, cap, provincia, partitaIVA, telefono, descrizione, email);
			AziendaDao aziendaJDBC = factory.getAziendaDAO();
			aziendaJDBC.salva(azienda);
			
			aziendaJDBC.setPassword(azienda, password);
		//	factory.getAziendaDAO().salva(azienda);
		
		//	System.out.println(azienda.getId());
		
			//doGet(request, response);
	
		
		
	
	}

}
