package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
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
		
			if(request.getParameter("edit").equals("true")) {
				PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
				AziendaDao aziendaDAO = factory.getAziendaDAO();
				System.out.println(request.getParameter("id_azienda"));
				int id = Integer.parseInt(request.getParameter("id_azienda"));
				
				//int id = (Integer) request.getAttribute("azienda");
				String referente = request.getParameter("referente");
				String sedeLegale = request.getParameter("sede_legale");
				String indirizzo = request.getParameter("indirizzo");
				String citta = request.getParameter("citta");
				String cap = request.getParameter("cap");
				String provincia = request.getParameter("provincia");
				String telefono = request.getParameter("telefono");
				String descrizione = request.getParameter("formDescrizione");
				
				Azienda azienda = new Azienda() ;
				azienda.setReferente(referente);
				System.out.println("Referente "+azienda.getReferente());
				azienda.setSedeLegale(sedeLegale);
				System.out.println("sede legale "+azienda.getSedeLegale());
				azienda.setIndirizzo(indirizzo);
				System.out.println("indirizzo ");
				azienda.setCitta(citta);
				System.out.println("citta "+citta);
				azienda.setCap(cap);
				System.out.println("cap "+cap);
				azienda.setProvincia(provincia);
				System.out.println("provincia "+provincia);
				azienda.setTelefono(telefono);
				System.out.println("telefono "+telefono);
				azienda.setDescrizioneServizi(descrizione);
				System.out.println("descrizione "+descrizione);
				azienda.setId(id);
				System.out.println(id);
				
				aziendaDAO.aggiorna(azienda);
				Azienda newSessione = aziendaDAO.cercaPerChiavePrimaria(id);
				request.getSession().invalidate();
				request.getSession().setAttribute("azienda", newSessione);
				RequestDispatcher rs = request.getRequestDispatcher("PageLoader?id=backendAzienda");
				rs.forward(request, response);
				
				
				//out.println("Grazie per esserti registrato");
			}
				
		

		else {
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

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
			try {
			aziendaJDBC.salva(azienda);

			aziendaJDBC.setPassword(azienda, password);
			//	factory.getAziendaDAO().salva(azienda);

			//	System.out.println(azienda.getId());

			//doGet(request, response);
			out.println("<div class=\"alert alert-success\">\r\n" +
					" <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>"+
					"  <strong> Grazie per esserti registrato!</strong> Ora puoi effettuare il Login.\r\n" + 
					"</div>");
			
			RequestDispatcher rs = request.getRequestDispatcher("PageLoader?id=azienda");
			rs.forward(request, response);

		}
		catch (IOException e) {
			out.println("Inserimento dati errato");
			e.printStackTrace();
		}
	}
	}

}
