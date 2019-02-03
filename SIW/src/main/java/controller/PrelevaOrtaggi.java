package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import entita.ortaggio.Ortaggio;
import persistence.PostgresDAOFactory;
import persistence.dao.OrtaggioDao;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class PrelevaOrtaggi
 */
public class PrelevaOrtaggi extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("edit").equals("true")) {

			String jsonReceived = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String line = reader.readLine();
			while (line != null) {
				jsonReceived = jsonReceived + line + "\n";
				line = reader.readLine();
			}

			System.out.println(jsonReceived);

			TerrenoDao terrenodao = PostgresDAOFactory.getInstance().getTerrenoDAO();
			int id_terreno = Integer.parseInt(req.getParameter("editFormId"));
			List<Ortaggio> listOrtaggi = terrenodao.cercaOrtaggiPerTerreno(id_terreno);

		}
		
		else if (req.getParameter("test").equals("test")) {
			JSONObject jsonprova = new JSONObject();
			jsonprova.put("nome", "cognome");
			jsonprova.put("ciccio", "pippo");
			PrintWriter pw = resp.getWriter();
			pw.print(jsonprova.toString());
			System.out.println(jsonprova);
			pw.close();
		}


		else {

			// Ortaggio ortaggio = (Ortaggio) req.getSession().getAttribute("ortaggio");
			System.out.println("Sono in Preleva Ortaggi");
			// System.out.println((Ortaggio) req.getSession().getAttribute("ortaggio"));
			OrtaggioDao ortaggidao = PostgresDAOFactory.getInstance().getOrtaggioDAO();
			List<Ortaggio> listOrtaggi = ortaggidao.cercaTutti();

			req.setAttribute("ortaggi", listOrtaggi);

			RequestDispatcher rd = req.getRequestDispatcher("inserimentoTerreno.jsp");
			rd.forward(req, resp);

		}
	}
}
