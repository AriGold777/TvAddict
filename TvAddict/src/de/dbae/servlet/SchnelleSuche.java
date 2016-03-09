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
 * Servlet implementation class Testsuche
 */
@WebServlet("/Testsuche")
public class SchnelleSuche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchnelleSuche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		SearchObject searchobject = new SearchObject();
		ResultSet rs = searchobject.simpleSearch(name);
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		rows = searchobject.convert(rs);
		request.setAttribute("result", rows);
		request.getRequestDispatcher("testoutput.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
