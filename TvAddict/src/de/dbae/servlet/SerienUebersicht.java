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
 * @author Daniel
 * 
 * Servlet um die Serienübersicht für die serienUebersicht.jsp vorzubereiten
 */
@WebServlet("/SerienUebersicht")
public class SerienUebersicht extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerienUebersicht() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Neues SearchObjekt anlegen
		SearchObject searchobject = new SearchObject();
		
		// Suchen nach Serienübersicht mittels ubersichtSearch-Methode
		ResultSet rs = searchobject.uebersichtSearch();
		
		// Konvertieren des ResultSets mittels convert-Methode
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		rows = searchobject.convert(rs);
		
		request.setAttribute("result", rows);
		request.getRequestDispatcher("serienUebersicht.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
