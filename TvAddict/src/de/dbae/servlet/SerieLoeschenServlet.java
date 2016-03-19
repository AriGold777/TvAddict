package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.helper.DatabaseEdit;

/**
 * @author Marcel
 * 
 * Servlet um einem Mitarbeiter das l�schen einer Serie zu erm�glichen.
 */
@WebServlet("/SerieLoeschenServlet")
public class SerieLoeschenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerieLoeschenServlet() {
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
		//SerieID wird der deleteSerie Methode �bergeben um sie zu l�schen.
		String id = request.getParameter("id");
		new DatabaseEdit().deleteSerie(id);
		
		request.getRequestDispatcher("MitarbeiterFunktionenServlet").forward(request, response);
	}

}
