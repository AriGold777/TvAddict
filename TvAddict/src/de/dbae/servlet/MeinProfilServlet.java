package de.dbae.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.dbae.helper.SearchObject;

/**
 * @author Hassib
 * 
 * Servlet zum Profil des angemeldeten Benutzers
 * 
 */
@WebServlet("/MeinProfilServlet")
public class MeinProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeinProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Empfangen und Speichern der nötigen Informationen 
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("loggedID");
		String sendeplan = new SearchObject().sendeplanSearch(Integer.parseInt(userID));
		
		session.setAttribute("sendeplan", sendeplan);
		request.getRequestDispatcher("meinProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
