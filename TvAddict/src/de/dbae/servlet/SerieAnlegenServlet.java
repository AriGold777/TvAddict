package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.helper.DatabaseEdit;

/**
 * Servlet implementation class SerieAnlegenServlet
 */
@WebServlet("/SerieAnlegenServlet")
public class SerieAnlegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerieAnlegenServlet() {
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
		String name = request.getParameter("name");
		String beschreibung = request.getParameter("beschreibung");
		String fsk = request.getParameter("fsk");
		String genre1 = request.getParameter("genre1");
		String genre2 = request.getParameter("genre2");
		String genre3 = request.getParameter("genre3");
		String sendetag = request.getParameter("sendetag");
		
		new DatabaseEdit().addSerie(name, beschreibung, fsk, genre1, genre2, genre3, sendetag);
		
		request.getRequestDispatcher("MitarbeiterFunktionenServlet").forward(request, response);
	}

}
