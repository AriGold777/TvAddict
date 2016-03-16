package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.helper.DatabaseEdit;

/**
 * Servlet implementation class SerieAktualisierenServlet
 */
@WebServlet("/SerieAktualisierenServlet")
public class SerieAktualisierenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerieAktualisierenServlet() {
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
		String aktuelleID = request.getParameter("aktuelleID");
		
		String ID = request.getParameter("neueID");
		String name = request.getParameter("neuerName");
		String beschreibung = request.getParameter("neueBeschreibung");
		String fsk = request.getParameter("neueFSK");
		String sendetag = request.getParameter("neuerSendetag");
		String genre1 = request.getParameter("neuesGenre1");
		String genre2 = request.getParameter("neuesGenre2");
		String genre3 = request.getParameter("neuesGenre3");
		
		new DatabaseEdit().editSerie(aktuelleID, ID, name, beschreibung, fsk, sendetag, genre1, genre2, genre3);
		request.getRequestDispatcher("MitarbeiterFunktionenServlet").forward(request, response);
	}

}
