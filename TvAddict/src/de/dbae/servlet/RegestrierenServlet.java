package de.dbae.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

/**
 * Servlet implementation class RegestrierenServlet
 */
@WebServlet("/RegestrierenServlet")
public class RegestrierenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegestrierenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String benutzername = request.getParameter("benutzername");
		String email = request.getParameter("email");
		
		//int alter = Integer.parseInt(request.getParameter("alter"));
		ArrayList<String> liste = new ArrayList<String>();
        PrintWriter out = response.getWriter();

		liste.add(request.getParameter(vorname));
		liste.add(request.getParameter(nachname));
		liste.add(request.getParameter(benutzername));
		liste.add(request.getParameter(email));
		

		request.getRequestDispatcher("meinProfil.jsp").forward(request, response);	
		  out.println("<html>");
	      out.println("<head>");
	      out.println("<title>JSP Tutorial - SimpleServlet</title>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h2>" + "Hello " + vorname + "</h2>");
	      out.println("</body></html>");
		
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
