package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import entita.Azienda;
import entita.Cliente;
import persistence.PostgresDAOFactory;
import persistence.dao.AziendaDao;
import persistence.dao.ClienteDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
		System.out.println("sono all'interno di login");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		ClienteDao clientedao = factory.getClienteDAO();
		AziendaDao aziendadao = factory.getAziendaDAO();
		System.out.println(request.getSession());
		System.out.println(request.getParameter("area"));
		System.out.println(request.getAttribute("utente"));
		if (request.getParameter("area").equals("utente")) {
			if (clientedao.checkCliente(email, pass)) {
				Cliente user = clientedao.cercaPerEmail(email);
				request.getSession().setAttribute("cliente", user);
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.forward(request, response);
			} else {
				out.println("Username o Password errati");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.include(request, response);
			}
		} else if (request.getParameter("area").equals("facebook")) {

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
			JSONObject dati = new JSONObject(jsonReceived);
			JSONObject risposta = new JSONObject();
			
			Cliente user = clientedao.cercaPerEmail(dati.getString("email"));
			if(user == null)
			{
				risposta.put("resp", "nok");
			}
			else
			{
				System.out.println("L'utente è stato trovato, login: "+user.getNome());
				request.getSession().setAttribute("cliente", user);
				risposta.put("resp", "ok");
			}
			
			PrintWriter pw = response.getWriter();
			pw.print(risposta.toString());
			System.out.println(risposta);
			pw.close();
			
		} else if (request.getParameter("area").equals("azienda")) {
			System.out.println(email + pass);
			if (aziendadao.checkAzienda(email, pass)) {

				Azienda user = aziendadao.cercaPerEmail(email);
				request.getSession().setAttribute("azienda", user);
				RequestDispatcher rs = request.getRequestDispatcher("PageLoader?id=backendAzienda");
				rs.forward(request, response);
			} else {
				out.println("Username o Password errati");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.include(request, response);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("logout").equals("true"))
			req.getSession().invalidate();
		RequestDispatcher rs = req.getRequestDispatcher("Home");
		rs.forward(req, resp);
	}

}
