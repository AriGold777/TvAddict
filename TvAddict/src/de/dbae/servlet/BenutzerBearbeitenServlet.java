package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.helper.Benutzer;

/**
 * @author Daniel
 * 
 * Servlet um den Benutzer als Objekt für die benutzerBearbeiten.jsp vorzubereiten
 */
@WebServlet("/BenutzerBearbeitenServlet")
public class BenutzerBearbeitenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenutzerBearbeitenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Neues Benutzer-Objekt erstellen
		Benutzer benutzer = new Benutzer();
		
		// Setzen der Benutzer-Objekt-Atrribute
		benutzer.setUserID(request.getParameter("userID"));
		benutzer.setBenutzername(request.getParameter("benutzername"));
		benutzer.setVorname(request.getParameter("vorname"));
		benutzer.setNachname(request.getParameter("nachname"));
		benutzer.setEmail(request.getParameter("email"));
		benutzer.setVerschluesseltesPW(request.getParameter("verschluesseltesPW"));
		
		// Attribut Benutzer wird gesetzt
		request.setAttribute("benutzer", benutzer);
		
		request.getRequestDispatcher("benutzerBearbeiten.jsp").forward(request, response);
	}

}
