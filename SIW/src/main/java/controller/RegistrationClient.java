package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Cliente;
import persistence.PostgresDAOFactory;

/**
 * Servlet implementation class RegistrationClient
 */
public class RegistrationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostgresDAOFactory factory = new PostgresDAOFactory();
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String codiceFiscale = request.getParameter("codice_fiscale");
		String dataDiNascita = request.getParameter("data_di_nascita");
		String citta = request.getParameter("citta");
		String cap = request.getParameter("cap");
		String provincia = request.getParameter("provincia");
		String indirizzo = request.getParameter("indirizzo");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ITALIAN);
		
		try {
			
			Date data = format.parse(dataDiNascita);
			Cliente cliente = new Cliente(nome, cognome, codiceFiscale, data, indirizzo, citta, cap, provincia, telefono, email);
			factory.getClienteDAO().salva(cliente);
			
			/**
			 * salvati i dati della registrazione del cliente torno all index
			 */
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

}
