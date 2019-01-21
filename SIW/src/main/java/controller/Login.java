package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.jdbc2.optional.SimpleDataSource;

import persistence.PostgresDAOFactory;

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
		System.out.println(request.getParameter("area"));

		if (request.getParameter("area").equals("utente")) {
			if (factory.getClienteDAO().checkCliente(email, pass)) {
				RequestDispatcher rs = request.getRequestDispatcher("Logged");
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
