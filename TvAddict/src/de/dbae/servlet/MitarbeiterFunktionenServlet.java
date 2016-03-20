package de.dbae.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.helper.Benutzer;
import de.dbae.helper.SearchObject;
import de.dbae.helper.Serie;

/**
 * @author Daniel
 * 
 * Servlet um die Serien- und die Benutzerliste für die mitarbeiterFunktionen.jsp vorzubereiten
 */
@WebServlet("/MitarbeiterFunktionenServlet")
public class MitarbeiterFunktionenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MitarbeiterFunktionenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Neues SearchObject anlegen
		SearchObject searchobject = new SearchObject();
		
		// Benutzerliste anlegen und mittels benutzerSearch-Methode Benutzerdaten aus Datenbank ermitteln 
		List<Benutzer> benutzerList = new ArrayList<Benutzer>();
		benutzerList = searchobject.benutzerSearch();
		
		// Serienliste anlegen und mittels serieSearch-Methode Seriendaten aus Datenbank ermitteln
		List<Serie> serieList = new ArrayList<>();
		serieList = searchobject.serieSearch();

		// Setzen der Attribute BenutzerList und SerieList
		request.setAttribute("BenutzerList", benutzerList);
		request.setAttribute("SerieList", serieList);
		
		request.getRequestDispatcher("mitarbeiterFunktionen.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
