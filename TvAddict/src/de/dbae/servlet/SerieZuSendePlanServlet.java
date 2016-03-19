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
 * @author Marcel
 * 
 * Servlet um eine Serie dem Sendeplan des Benutzers hinzuzuf�gen, wenn dieser den 
 * "Serie zu Sendeplan hinzuf�gen" - Button in der Detailansicht einer Serie dr�ckt.
 */
@WebServlet("/SerieZuSendePlanServlet")
public class SerieZuSendePlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerieZuSendePlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("loggedID");
		int serieId = new SearchObject().getIdFromSerie(request.getParameter("serienName"));
		//BenutzerID und SerieID werden der addSerieToSendeplan �bergeben um die entsprechende Aktion in der Datenbank auszuf�hren.
		new DatabaseEdit().addSerieToSendeplan(userId, serieId); 
		
		response.sendRedirect("http://localhost:8080/TvAddict/MeinProfilServlet");
	}

}
