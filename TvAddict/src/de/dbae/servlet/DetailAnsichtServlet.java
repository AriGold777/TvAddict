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

import de.dbae.helper.Bewertung;
import de.dbae.helper.SearchObject;

/**
 * Servlet implementation class DetailAnsichtServlet
 */
@WebServlet("/DetailAnsichtServlet")
public class DetailAnsichtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailAnsichtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		SearchObject searchobject = new SearchObject();
		ResultSet rs = searchobject.detailSchauspielerSearch(name);
		List<Map<String, Object>> schauspielerList = new ArrayList<Map<String, Object>>();
		schauspielerList = searchobject.convert(rs);
		
		String sendetag = searchobject.sendetagSearch(name);
		
		Bewertung bewertung = searchobject.bewertungSearch(name);
		request.setAttribute("bewertung", bewertung);
		request.setAttribute("name", name);
		request.setAttribute("schauspielerList", schauspielerList);
		request.setAttribute("sendetag", sendetag);
		
		request.getRequestDispatcher("DetailAnsicht.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
