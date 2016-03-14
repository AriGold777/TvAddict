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

import de.dbae.helper.SearchObject;

/**
 * Servlet implementation class AnmeldenServlet
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
		
		String benutzername = request.getParameter("benutzername");
		String passwort = request.getParameter("passwort");
		
		SearchObject so = new SearchObject();
		//Wenn abfrage = 1 dann gibt es die benutzer+passwort Kombination. Wenn 0, dann ist mindestens eins davon falsch (Gibt es nicht)
		int abfrage = so.anmeldeAbfrage(benutzername, passwort);
		
		request.setAttribute("abfrage", abfrage);
		request.setAttribute("benutzer", benutzername);
		request.getRequestDispatcher("AnmeldeCheck.jsp").forward(request, response);
		
		
		
		
		/**if(benutzername&&passwort.equals(//die Benutzer Ids der Datenbank)) {
			Weiterleitung auf mein Profil }else {
			
			Meldung Passwort nicht Korrekt oder neu regestrieren und Weiterleitung auf seite Regestrieren
			
			
		
		}
	*/
	}

}
