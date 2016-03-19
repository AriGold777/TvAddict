package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.helper.Benutzer;
import de.dbae.helper.Serie;

/**
 * @author Marcel
 * 
 * Servlet um die Serie als Objekt für die serieBearbeiten.jsp vorzubereiten.
 */
@WebServlet("/SerieBearbeitenServlet")
public class SerieBearbeitenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerieBearbeitenServlet() {
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
		Serie serie = new Serie();
		serie.setId(request.getParameter("id"));;
		serie.setName(request.getParameter("name"));
		serie.setBeschreibung(request.getParameter("beschreibung"));
		serie.setFsk(request.getParameter("fsk"));
		serie.setSendetag(request.getParameter("sendetag"));
		serie.setGenre1(request.getParameter("genre1"));
		serie.setGenre2(request.getParameter("genre2"));
		serie.setGenre3(request.getParameter("genre3"));
		
		
		request.setAttribute("serie", serie);
		request.getRequestDispatcher("serieBearbeiten.jsp").forward(request, response);
	}

}
