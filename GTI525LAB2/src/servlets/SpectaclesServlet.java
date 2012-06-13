package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Collection;


public class SpectaclesServlet extends HttpServlet{
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String jsp; 
		Collection collect = new Collection();
				
		request.setAttribute("collection", collect);
		jsp = "/presentation.jsp";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}
