package de.dbae.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *@author: Hassib
 * 
 */
import javax.servlet.http.HttpSession;

import de.dbae.helper.Benutzer;
import de.dbae.helper.DatabaseEdit;
import de.dbae.helper.SearchObject;
import de.dbae.helper.Verschluesseln;

/**
 * Servlet implementation class RegestrierenServlet
 */
@WebServlet("/RegestrierenServlet")
public class RegestrierenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegestrierenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Benutzer> checkUsernames = new SearchObject().benutzerSearch();
		boolean usernameAlreadyExists = false;
		boolean pwCheck = false;
		
		String errorMessage = "";
		
		String benutzername = request.getParameter("benutzername");
		for (Benutzer benutzer : checkUsernames) {
			if(benutzer.getBenutzername().equals(benutzername)) {
				usernameAlreadyExists = true;
				errorMessage = "Benutzername bereits vergeben.";
			}
		}		
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String email = request.getParameter("email");
		//String pw = new Verschlüssellung.verschluesselPasswort(request.getParameter("pw");
		String pw = request.getParameter("passwort");
		String pwWiederholung = request.getParameter("passwortW");
		if(pw.equals(pwWiederholung)) {
			pwCheck = true;
		}
		if(pwCheck && (!usernameAlreadyExists)){
			pw = new Verschluesseln().pwVerschluesseln(pw);
			new DatabaseEdit().addBenutzer(benutzername, vorname, nachname, email, pw);			
		}
		
		//Evtl hier was mit session...mal gucken :D
		if(usernameAlreadyExists) {
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("registrieren.jsp").forward(request, response);
		}
		if(pwCheck) {
			HttpSession userSession = request.getSession();
			Benutzer benutzer = new Benutzer();
			benutzer = new SearchObject().sessionBenutzer(benutzername, pw);
			userSession.setAttribute("loggedID", benutzer.getUserID());
			userSession.setAttribute("isUserLogged", true);
			userSession.setAttribute("loggedUser", benutzer.getBenutzername());
			request.getRequestDispatcher("meinProfil.jsp").forward(request, response);
		} else {
			errorMessage = "Passwort stimmt nicht überein.";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("registrieren.jsp").forward(request, response);
		}
	}

		
	

}
