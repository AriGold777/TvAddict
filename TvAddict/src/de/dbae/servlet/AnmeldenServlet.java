package de.dbae.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *@author: Hassib
 * 
 */

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
		String passwort = request.getParameter("Passwort");
		PrintWriter out = response.getWriter();

		if(benutzername.equals("Hassib") && passwort.equals("hallo")) {
			request.getRequestDispatcher("meinProfil.jsp").forward(request, response);	

			
		}else {
			request.getRequestDispatcher("registrieren.jsp").forward(request, response);	
		}
		
		
		
		/**if(benutzername&&passwort.equals(//die Benutzer Ids der Datenbank)) {
			Weiterleitung auf mein Profil }else {
			
			Meldung Passwort nicht Korrekt oder neu regestrieren und Weiterleitung auf seite Regestrieren
			
			
		
		}
	*/
	}

}
