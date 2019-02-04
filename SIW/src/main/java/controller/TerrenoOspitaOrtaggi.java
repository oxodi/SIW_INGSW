package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entita.Azienda;
import entita.Terreno;
import persistence.PostgresDAOFactory;
import persistence.dao.TerrenoDao;

/**
 * Servlet implementation class TerrenoOspitaOrtaggi
 */
//@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
//maxFileSize=1024*1024*10,      // 10MB
//maxRequestSize=1024*1024*50)   // 50MB
public class TerrenoOspitaOrtaggi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String SAVE_DIR = "uploadFiles/";

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			if(req.getParameter("delete").equals("true"))
			{
				TerrenoDao terrenoNew = PostgresDAOFactory.getInstance().getTerrenoDAO();
				Terreno terreno = new Terreno();
				int id = Integer.parseInt(req.getParameter("tempId"));
				System.out.println("sto eliminando "+id);
				terreno.setId(id);
				terrenoNew.cancella(terreno);
				RequestDispatcher rd = req.getRequestDispatcher("PrelevaDatiTerreno");
				rd.forward(req, resp);
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("edit").equals("true")) {
			
			System.out.println("Sono nell'edit");
			System.out.println("sto cambiando l'ID " + req.getParameter("editFormId"));
			int id = Integer.parseInt(req.getParameter("editFormId"));
			int dimensione = Integer.parseInt(req.getParameter("editFormDimensione"));
			System.out.println("sto settando la dimensione " + dimensione);
			int dimensioneSerra = Integer.parseInt(req.getParameter("editFormDimensioneSerra"));
			System.out.println("sto settando la dimensione " + dimensioneSerra);
			double costo = Double.parseDouble(req.getParameter("editFormCosto"));
			System.out.println("sto settando la dimensione " + costo);
			String dispon = req.getParameter("dropdownDisponibilita");
			System.out.println("sto settando la dimensione " + dispon);
			String parziale = req.getParameter("editCheckParziale");
			//System.out.println("sto settando la dimensione " + parziale);
			String completo = req.getParameter("editCheckCompleto");
			//System.out.println("sto settando la dimensione " + completo);

			TerrenoDao terrenoNew = PostgresDAOFactory.getInstance().getTerrenoDAO();
			Terreno terreno = terrenoNew.cercaPerChiavePrimaria(id);
			terreno.setDimensione(dimensione);
			terreno.setDimensioneSerra(dimensioneSerra);
			terreno.setCosto(costo);
			terreno.setPeriodiDisponibilita(dispon);
			if (parziale != null && !parziale.isEmpty()) {
				terreno.setServizioParziale(true);
			} 
			
			else {
				terreno.setServizioParziale(false);
			} 
			if(completo != null && !completo.isEmpty()) {
				terreno.setServizioCompleto(true);
			}
				
			else 
			
			{
				terreno.setServizioCompleto(false);
			}
			System.out.println("Sto aggiornando... " + terreno.getId());
			System.out.println("Sto aggiornando... " + terreno.getDimensione());
			System.out.println("Sto aggiornando... " + terreno.getDimensioneSerra());
			System.out.println("Sto aggiornando... " + terreno.getCosto());
			System.out.println("Sto aggiornando... " + terreno.getPeriodiDisponibilita());

			terrenoNew.aggiorna(terreno);
			RequestDispatcher rd = req.getRequestDispatcher("PrelevaDatiTerreno");
			rd.forward(req, resp);
		} else {

			Terreno terreno = new Terreno();
			int dimensione = Integer.parseInt(req.getParameter("dimensione_terreno"));
			int dimensioneSerra = Integer.parseInt(req.getParameter("dimensione_serra"));
			double costo = Double.parseDouble(req.getParameter("costo_terreno"));
			String parziale = req.getParameter("parziale");
			String completo = req.getParameter("completo");
			terreno.setLocazione(req.getParameter("locazione"));
			terreno.setDimensione(dimensione);
			terreno.setDimensioneSerra(dimensioneSerra);
			terreno.setCosto(costo);
			if(parziale != null && !parziale.isEmpty()) 
			{
				terreno.setServizioParziale(true);
			}
			else
			{
				terreno.setServizioParziale(false);
			}
			
			if(completo != null && !completo.isEmpty()) 
			{
				terreno.setServizioCompleto(true);
			}
			else
			{
				terreno.setServizioCompleto(false);
			}
						
			Azienda az = (Azienda) req.getSession().getAttribute("azienda");
			System.out.println(az.getId());
			terreno.setIdAzienda(az.getId());
			terreno.setPeriodiDisponibilita(req.getParameter("disponibilita"));
			TerrenoDao terrenoNew = PostgresDAOFactory.getInstance().getTerrenoDAO();
			terrenoNew.salva(terreno);
			System.out.println("sono il terreno" + terreno.getId());
			String[] checkedIds = req.getParameterValues("ortaggiSelezionati");

			for (int i = 0; i < checkedIds.length; i++) {
				System.out.println("Ho selezionato gli ortaggi " + checkedIds[i]);
				String prezzi = req.getParameter("prezzo" + checkedIds[i]);
				double intPrezzi = Double.parseDouble(prezzi);
				String tempo = req.getParameter("tempo" + checkedIds[i]);
				int tempoInt = Integer.parseInt(tempo);

				System.out.println("con questo costo " + intPrezzi);
				System.out.println("con questo tempo " + tempoInt);
				terrenoNew.aggiungiOrtaggio(terreno.getId(), Integer.parseInt(checkedIds[i]), intPrezzi, tempoInt);
			}
			/*
			
			// gets absolute path of the web application
			String appPath = req.getServletContext().getRealPath("");
			// constructs path of the directory to save uploaded file
			String savePath = appPath + File.separator + SAVE_DIR;
			// creates the save directory if it does not exists
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
			}
			
			Part part = req.getPart(req.getParameter("file"));
				String fileName = extractFileName(part);
				// refines the fileName in case it is an absolute path
				fileName = new File(fileName).getName();
				System.out.println(fileName);
				part.write(savePath + File.separator + fileName);
				
			*/
			RequestDispatcher rd = req.getRequestDispatcher("PrelevaDatiTerreno");
			rd.forward(req, resp);

		}
	}
	
	/*
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
		if (s.trim().startsWith("filename")) {
		return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
	*/
}
