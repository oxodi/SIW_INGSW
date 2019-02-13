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

import org.json.JSONArray;
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
			JSONArray ortaggiJson = new JSONArray();
			TerrenoDao terrenodao = PostgresDAOFactory.getInstance().getTerrenoDAO();
			int id_terreno = Integer.parseInt(req.getParameter("editFormId"));
			List<Ortaggio> listOrtaggi = terrenodao.cercaOrtaggiPerTerreno(id_terreno);
			for(int i = 0;i<listOrtaggi.size();i++)
			{
				JSONObject temp = new JSONObject();
				temp.put("id", listOrtaggi.get(i).getId());
				temp.put("nome",listOrtaggi.get(i).getNome());
				temp.put("resa",listOrtaggi.get(i).getResa());
				temp.put("costo",listOrtaggi.get(i).getPrezzo());
				temp.put("tempo", listOrtaggi.get(i).getTempoColtivazione());
				ortaggiJson.put(temp);
			}
			
			PrintWriter pw = resp.getWriter();
			pw.print(ortaggiJson.toString());
			System.out.println(ortaggiJson);
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
