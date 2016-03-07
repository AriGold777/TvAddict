package de.dbae.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.dbae.helper.SearchObject;

/**
 * Servlet implementation class ErweiterteSuche
 */
@WebServlet("/ErweiterteSuche")
public class ErweiterteSuche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErweiterteSuche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		//Genre-Abfragen
		String genre = request.getParameter("genre");
		String paraGenre = "";
		if (!(genre != null)){
			genre = "";
			paraGenre = "Kein Genre ausgew�hlt.";
		} else {
			paraGenre = "Genre: " + genre;
		}
		String fsk = request.getParameter("fsk");

		SearchObject searchobject = new SearchObject();
		
		int genreAnzahl = searchobject.genreCount();
		
		
		ResultSet rs = searchobject.advancedSearch(name,genre,fsk);
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		rows = searchobject.convert(rs);
		request.setAttribute("genreCount", genreAnzahl);
		request.setAttribute("genre", paraGenre);
		request.setAttribute("result", rows);
		request.getRequestDispatcher("erweiterteSuche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}