package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import entita.Cliente;
import persistence.PostgresDAOFactory;
import persistence.dao.ClienteDao;

/**
 * Servlet implementation class aggiornaDatiCliente
 */
public class aggiornaDatiCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Sono nella servlet AggiornaDatiCliente");
		String jsonReceived = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = reader.readLine();
		
		while (line != null) {
			System.out.println("Linee: " +line);
			jsonReceived = jsonReceived + line + "\n";
			line = reader.readLine();

		}

		try {

			JSONObject json = new JSONObject(jsonReceived);

			PostgresDAOFactory factory = PostgresDAOFactory.getInstance();
			ClienteDao clientedao = factory.getClienteDAO();

			Cliente cliente= clientedao.cercaPerChiavePrimaria(json.getInt("id"));

			cliente.setCitta(json.getString("citta"));
			cliente.setProvincia(json.getString("provincia"));
			cliente.setCap(json.getString("cap"));
			cliente.setIndirizzo(json.getString("indirizzo"));
			cliente.setTelefono(json.getString("telefono"));

			clientedao.aggiorna(cliente);

			JSONObject jsonCliente = new JSONObject(cliente);
			System.out.println("JSON: "+jsonCliente.toString());
			request.getSession().setAttribute("cliente", cliente);
			response.getWriter().println(jsonCliente.toString());

		} catch (JSONException e) {
			e.printStackTrace();
		}


	}

}
