package de.dbae.servlet;

import java.io.IOException;
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
 * @author Marcel
 * 
 * Servlet, dass die Passwortänderung vom Benutzer bearbeitet.
 */
@WebServlet("/PasswortAendernServlet")
public class PasswortAendernServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswortAendernServlet() {
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
		//Die nötigen Informationen werden geholt und gespeichert.
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		String neuesPasswort = request.getParameter("neuesPasswortBenutzerEdit");
		String neuesPasswortWdh = request.getParameter("neuesPasswortWdhBenutzerEdit");
		
		//Fehlermeldung, die sich je nach Fehler verändert.
		String errorMessage = "";
		
		//Prüft, ob die beiden Passwort Inputs übereinstimmen und passt entsprechend die Fehlermeldung an.
		if(neuesPasswort.equals(neuesPasswortWdh)){
			String verschlPW = new Verschluesseln().pwVerschluesseln(neuesPasswort);
			new DatabaseEdit().meinProfilPasswortEdit(verschlPW, Integer.parseInt(benutzer.getUserID()));
			errorMessage = "Passwort erfolgreich geändert!";
		} else {
			errorMessage = "Passwort stimmt nicht überein!";
		}
		request.setAttribute("errorMessage", errorMessage);
		request.getRequestDispatcher("meinProfil.jsp").forward(request, response);
	}
}

