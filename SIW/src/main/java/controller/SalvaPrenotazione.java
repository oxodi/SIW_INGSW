package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entita.Azienda;

/**
 * Servlet implementation class SalvaPrenotazione
 */
public class SalvaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Azienda azienda = new Azienda();
		azienda.setRagioneSociale("PROVIAMO");
		request.setAttribute("proviamo", azienda);
		RequestDispatcher rd = request.getRequestDispatcher("ricevutaPagamento.jsp");
		rd.forward(request, response);
	}

}
