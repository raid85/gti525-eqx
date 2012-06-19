package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Collection;


public class RepresentationsServlet extends HttpServlet{
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String jsp; 
		Collection collect = new Collection();
		
		if(request.getParameter("spectacleid") != null && !request.getParameter("spectacleid").equals("")){
			int i = 0;
			while (collect.getSpectaclesids()[i] != Integer.parseInt(request.getParameter("spectacleid")) && i < collect.getSpectaclesids().length){
				i++;
			}
			jsp = "/representations.jsp";
			request.setAttribute("titre", collect.getSpectaclesTitres()[i]);
			request.setAttribute("description", collect.getSpectaclesDescriptions()[i]);
			request.setAttribute("image", collect.getSpectaclesImages()[i]);
			request.setAttribute("salles", collect.getSpectaclesRepresentationsSalles(i));
			request.setAttribute("places", collect.getSpectaclesRepresentationsPlaces(i));
			request.setAttribute("jours", collect.getSpectaclesRepresentationsJours(i));
			request.setAttribute("mois", collect.getSpectaclesRepresentationsMois(i));
			request.setAttribute("annee", collect.getSpectaclesRepresentationsAnnee(i));
			request.setAttribute("heure", collect.getSpectaclesRepresentationsHeure(i));
			request.setAttribute("minutes", collect.getSpectaclesRepresentationsMinutes(i));
			request.setAttribute("prix", collect.getSpectaclesRepresentationsPrix(i));
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		}
		

	}

}
