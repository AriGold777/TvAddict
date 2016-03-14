package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.helper.DatabaseEdit;
import de.dbae.helper.SearchObject;

/**
 * Servlet implementation class BenutzerAktualisierenServlet
 */
@WebServlet("/BenutzerAktualisierenServlet")
public class BenutzerAktualisierenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenutzerAktualisierenServlet() {
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
		String aktuelleUserID = request.getParameter("aktuelleUserID");
		
		String userID = request.getParameter("neueUserID");
		String benutzername = request.getParameter("neuerBenutzername");
		String vorname = request.getParameter("neuerVorname");
		String nachname = request.getParameter("neuerNachname");
		String email = request.getParameter("neueEmail");
		String passwort = request.getParameter("neuesVerschluesseltesPW");
		
		new DatabaseEdit().editBenutzer(aktuelleUserID, userID, benutzername, vorname, nachname, email, passwort);
		request.getRequestDispatcher("MitarbeiterFunktionenServlet").forward(request, response);
	}

}
