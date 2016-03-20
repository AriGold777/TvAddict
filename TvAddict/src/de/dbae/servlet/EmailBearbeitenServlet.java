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

/**
 * @author Marcel
 * 
 * Servlet um die Benutzergesteuerte Email�nderung entgegen zu nehmen.
 */
@WebServlet("/EmailBearbeitenServlet")
public class EmailBearbeitenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailBearbeitenServlet() {
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
		//Die n�tigen Informationen werden geholt und gespeichert.
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		String neueEmail = request.getParameter("neueEmailBenutzerEdit");
		String neueEmailWdh = request.getParameter("neueEmailWdhBenutzerEdit");
		boolean emailAlreadyExists = false;
		List<Benutzer> benutzerList = new SearchObject().benutzerSearch();
		//Fehlermeldung, die sich je nach Fehler ver�ndert.
		String errorMessage = "";
		//Pr�ft ob email bereits benutzt wird.
		for (Benutzer user : benutzerList) {
			if(user.getEmail().equals(neueEmail)) {
				emailAlreadyExists = true;
				errorMessage = "Email bereits vergeben.";
			}
		}
		//Pr�ft, ob die beiden Email Inputs �bereinstimmen und passt entsprechend die Fehlermeldung an.
		if(neueEmail.equals(neueEmailWdh) && (!emailAlreadyExists)){
			new DatabaseEdit().meinProfilEmailEdit(neueEmail, Integer.parseInt(benutzer.getUserID()));
			errorMessage = "Email erfolgreich ge�ndert!";
		} else {
			if(!(errorMessage.equals("Email bereits vergeben."))) {
				errorMessage = "Email stimmt nicht �berein!";
			}
		}
		request.setAttribute("errorMessage", errorMessage);
		request.getRequestDispatcher("meinProfil.jsp").forward(request, response);
	}

}
