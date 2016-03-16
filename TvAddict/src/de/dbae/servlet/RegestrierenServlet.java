package de.dbae.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *@author: Hassib
 * 
 */

import de.dbae.helper.Benutzer;

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
		// TODO Auto-generated method stub
		
		
		
		Benutzer benutzer = new Benutzer();
		benutzer.setBenutzername(request.getParameter("benutzername"));
		benutzer.setVorname(request.getParameter("vorname"));
		benutzer.setNachname(request.getParameter("nachname"));
		benutzer.setEmail(request.getParameter("email"));
		benutzer.setVerschluesseltesPW(request.getParameter("pw"));
		benutzer.setVerschluesseltesPW(request.getParameter("pww"));

		
		
		request.setAttribute("benutzer", benutzer);
		request.getRequestDispatcher("meinProfil.jsp").forward(request, response);
	}

		
	

}
