package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import modele.Collection;


public class RepresentationsServlet extends HttpServlet{
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		String jsp; 
//		Collection collect = new Collection();
//		
//		if(request.getParameter("spectacleid") != null && !request.getParameter("spectacleid").equals("")){
//			int i = 0;
//			while (collect.getSpectacles()[i].getId() != Integer.parseInt(request.getParameter("spectacleid")) && i < collect.getSpectacles().length){
//				i++;
//			}
//			jsp = "/representations.jsp";
//			request.setAttribute("spectacle", collect.getSpectacles()[i]);
//			request.setAttribute("representations", collect.getRepresentations(i));
//			
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
//			dispatcher.forward(request, response);
//		}
		

	}

}
