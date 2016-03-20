package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.database.DatabaseConnection;
import de.dbae.helper.Bewertung;
import de.dbae.helper.DatabaseEdit;
import de.dbae.helper.SearchObject;

/**
 * @author Marcel
 * 
 * Servlet um die abgegebene Bewertung zu einer Serie zu bearbeiten.
 */
@WebServlet("/BewertungAbgegebenServlet")
public class BewertungAbgegebenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BewertungAbgegebenServlet() {
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
		String serienName = request.getParameter("serienNameBewertung");
		String abgegebeneBewertung = request.getParameter("abgegebeneBewertung");
		
		//SerienID wird geholt um im nächsten Schritt einfacher die Bewertung abgeben zu können.
		int serienId = new SearchObject().getIdFromSerie(serienName);
		//Bewertung wird bearbeitet
		new DatabaseEdit().addBewertung(serienId, abgegebeneBewertung);
		
		request.getRequestDispatcher("SerienUebersicht").forward(request, response);;
	}

}
