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
import javax.servlet.http.HttpSession;

import de.dbae.helper.Benutzer;
import de.dbae.helper.DatabaseEdit;
import de.dbae.helper.SearchObject;
import de.dbae.helper.Verschluesseln;

/**
 * @author Hassib
 * 
 * Servlet zum Registrieren
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
	//Methode zum Registrieren eines Benutzers
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Benutzer> checkUsernames = new SearchObject().benutzerSearch();
		boolean usernameAlreadyExists = false;
		boolean emailAlreadyExists = false;
		boolean pwCheck = false;
		
		String errorMessage = "";
		
		//Überprüfung des Benutzernamen
		String benutzername = request.getParameter("benutzername");
		for (Benutzer benutzer : checkUsernames) {
			if(benutzer.getBenutzername().equals(benutzername)) {
				usernameAlreadyExists = true;
				errorMessage = "Benutzername bereits vergeben.";
			}
		}
		//Überprüfung der E-Mail
		String email = request.getParameter("email");
		for (Benutzer benutzer : checkUsernames) {
			if(benutzer.getEmail().equals(email)) {
				usernameAlreadyExists = true;
				errorMessage = "Email bereits vergeben.";
			}
		}
		
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String pw = request.getParameter("passwort");
		String pwWiederholung = request.getParameter("passwortW");
		// Prüfen ob beide Passwörter gleich sind
		if(pw.equals(pwWiederholung)) {
			pwCheck = true;
		}
		// Wenn Passwoörter übereinstimmen und E-Mail und Benutzername nicht Existieren, wird der neue benutzer angelegt
		if(pwCheck && (!usernameAlreadyExists) && (!emailAlreadyExists)){
			pw = new Verschluesseln().pwVerschluesseln(pw);
			new DatabaseEdit().addBenutzer(benutzername, vorname, nachname, email, pw);			
		}
		
		// Wenn die Email oder Benutzername bereits vergeben sind folgt nach der Fehlermeldung eine Weiterleitung auf die Registrieren Seite  
		if(usernameAlreadyExists) {
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("registrieren.jsp").forward(request, response);
		}
		if(emailAlreadyExists) {
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("registrieren.jsp").forward(request, response);
			
		
		}
		//Bei übereinstimmenden Passwörtern wird der benutzer angelegt und zur meinProfil Seite weitergeleitet
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
