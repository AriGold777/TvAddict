package de.dbae.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import de.dbae.helper.SearchObject;
import de.dbae.helper.Verschluesseln;

/**
 * @author Hassib
 * 
 * Servlet zum Anmelden eines Nutzers
 */
@WebServlet("/AnmeldenServlet")
public class AnmeldenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnmeldenServlet() {
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
		// TODO Auto-generated method stub
		
		//Get Parameter benutzer und paswort
		String benutzername = request.getParameter("benutzername");
		String passwort = request.getParameter("passwort");
		
		SearchObject so = new SearchObject();
		passwort = new Verschluesseln().pwVerschluesseln(passwort);
		//Wenn abfrage = 1 dann gibt es die benutzer+passwort Kombination. Wenn 0, dann ist mindestens eins davon falsch (Gibt es nicht), wenn 7 dann admin=true
		int abfrage = so.anmeldeAbfrage(benutzername, passwort);
		if(abfrage == 1 || abfrage == 7) {
			HttpSession userSession = request.getSession();
			Benutzer benutzer = new Benutzer();
			benutzer = new SearchObject().sessionBenutzer(benutzername, passwort);
			userSession.setAttribute("loggedID", benutzer.getUserID());
			userSession.setAttribute("isUserLogged", true);
			userSession.setAttribute("loggedUser", benutzer.getBenutzername());
			
			userSession.setAttribute("benutzer", benutzer);
			if(abfrage == 7){
				userSession.setAttribute("isMitarbeiter", true);
			}
		}
		
		request.setAttribute("abfrage", abfrage);
		request.getRequestDispatcher("anmeldeCheck.jsp").forward(request, response);
		
		
		
	}

}
