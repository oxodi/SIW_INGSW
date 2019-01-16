package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;
import persistence.AziendaDaoJDBC;
import persistence.DataSource;
import persistence.PostgresDAOFactory;

/**
 * Servlet implementation class InserisciAzienda
 */
public class InserisciAzienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	PostgresDAOFactory factory = new PostgresDAOFactory();
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String nome = request.getParameter("name");
			String partitaIVA = request.getParameter("partitaIVA");
			String referente = request.getParameter("referente");
			String sedeLegale = request.getParameter("sedeLegale");
			String ragioneSociale = request.getParameter("ragioneSociale");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("email");
		
			/**
		 	* il primo parametro zero è considerato null e viene settato automaticamente nella funzione salva
		 	*/
			Azienda azienda = new Azienda(0, nome, partitaIVA, referente, sedeLegale, ragioneSociale, telefono, "sono pippo" , email);
		
			factory.getAziendaDAO().salva(azienda);
		
			System.out.println(azienda.getId());
			
			
			
			String message = "Hello World";
	        request.setAttribute("message", message);
			request.getRequestDispatcher("hello.jsp").forward(request, response);
		
			//doGet(request, response);
	
		
		
	
	}

}
