package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.jdbc2.optional.SimpleDataSource;

import entita.Cliente;
import persistence.ClienteDaoJDBC;
import persistence.PostgresDAOFactory;
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
		System.out.println(request.getSession());
		System.out.println(request.getParameter("area"));
		System.out.println(request.getAttribute("cliente"));
		Cliente user = clientedao.cercaPerEmail(email);
		System.out.println("Si è loggato l'utente " + user.getNome());
		if (request.getParameter("area").equals("utente")) {
			if (clientedao.checkCliente(email, pass)) {
				request.getSession().setAttribute("utente", user);
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.forward(request, response);
			} else {
				out.println("Username o Password errati");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.include(request, response);
			}
		} else if (request.getParameter("area").equals("azienda")) {
			if (factory.getAziendaDAO().checkAzienda(email, pass)) {
				RequestDispatcher rs = request.getRequestDispatcher("Logged");
				rs.forward(request, response);
			} else {
				out.println("Username o Password errati");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.include(request, response);
			}
		}
	}
}
