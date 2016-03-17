package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.dbae.helper.DatabaseEdit;
import de.dbae.helper.SearchObject;

/**
 * Servlet implementation class SerieAusSendePlanServlet
 */
@WebServlet("/SerieAusSendePlanServlet")
public class SerieAusSendePlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerieAusSendePlanServlet() {
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
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("loggedID");
		int serieId = new SearchObject().getIdFromSerie(request.getParameter("serienName"));
		new DatabaseEdit().removeSerieFromSendeplan(userId, serieId); 
		
		response.sendRedirect("http://localhost:8080/TvAddict/MeinProfilServlet");
	}

}
