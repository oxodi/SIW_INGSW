package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

import org.json.JSONObject;

import entita.Cliente;
import persistence.PostgresDAOFactory;
import persistence.dao.ClienteDao;

/**
 * Servlet implementation class RegistrationClient
 */
public class RegistrationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameterMap().containsKey("fbReg")) {
			String jsonReceived = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String line = reader.readLine();
			System.out.println("Json " + line);
			while (line != null) {
				System.out.println("Json " + line);
				jsonReceived = jsonReceived + line + "\n";
				line = reader.readLine();
			}
			System.out.println(jsonReceived);
			JSONObject datiDaSalvare = new JSONObject(jsonReceived);
			Cliente fbClient = new Cliente();
			fbClient.setNome(datiDaSalvare.getString("first_name"));
			fbClient.setCognome(datiDaSalvare.getString("last_name"));
			fbClient.setEmail(datiDaSalvare.getString("email"));
			
			request.getSession().setAttribute("tempFbCliente", fbClient);
			request.getSession().setAttribute("fbUser","true");
			JSONObject risposta = new JSONObject();
			risposta.put("success", "Utente generato da facebook");
			PrintWriter pw = response.getWriter();
			pw.print(risposta.toString());
			System.out.println(risposta);
			pw.close();
		}
		else {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		
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
		String password = request.getParameter("password");
		
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ITALIAN);
		
		try {
			
			Date data = format.parse(dataDiNascita);
			Cliente cliente = new Cliente(nome, cognome, codiceFiscale, indirizzo, data, citta, cap, provincia, telefono, email);
			
			ClienteDao clienteJDBC = factory.getClienteDAO();
			
			clienteJDBC.salva(cliente);
			clienteJDBC.setPassword(cliente,password);
			
			/**
			 * salvati i dati della registrazione del cliente torno all index
			 */
			out.println("Grazie per esserti registrato");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			
		} catch (ParseException e) {
			out.println("Inserimento dati errato");
			e.printStackTrace();
		}
	}
		//doGet(request, response);
	}

}
