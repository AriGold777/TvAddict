package de.dbae.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.dbae.helper.Bewertung;
import de.dbae.helper.SearchObject;

/**
 * @author Marcel
 * 
 * Servlet um die Informationen für die detailAnsicht.jsp auszubereiten.
 */
@WebServlet("/DetailAnsichtServlet")
public class DetailAnsichtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailAnsichtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Name der Serie wird gespeichert
		String name = request.getParameter("name");
		SearchObject searchobject = new SearchObject();
		//ResultSet mit den Schauspielern der Serie wird gespeichert, in einer Liste gespeichert und konvertiert.
		ResultSet rs = searchobject.detailSchauspielerSearch(name);
		List<Map<String, Object>> schauspielerList = new ArrayList<Map<String, Object>>();
		schauspielerList = searchobject.convert(rs);
		//Der Sendetag der Serie wird ermittelt und gespeichert.
		String sendetag = searchobject.sendetagSearch(name);
		//Die BenutzerID des aktuell angemeldeten Benutzer wird gespeichert.
		HttpSession session = request.getSession();
		String benutzerID = (String)session.getAttribute("loggedID");
		//Abfrage um den Button "Serie zu Sendeplan hinzufügen" oder "Serie aus Sendeplan" Button zu setzen.
		int serieBereitsHinzugefuegt = searchobject.checkSerieBereitsImSendeplan(name, benutzerID);
		
		//Attribute werden übergeben.
		Bewertung bewertung = searchobject.bewertungSearch(name);
		request.setAttribute("addCheck", serieBereitsHinzugefuegt);
		request.setAttribute("bewertung", bewertung);
		request.setAttribute("name", name);
		request.setAttribute("schauspielerList", schauspielerList);
		request.setAttribute("sendetag", sendetag);
		
		request.getRequestDispatcher("detailAnsicht.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
