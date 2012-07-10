package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Collection;

/**
 * Classe sous-contr�leur qui ex�cute les op�rations en rapport � l'affichage et la lecture des messages
 *
 * @author Eric Boivin
 * @version 01/29/2010
 */

public class Controleur {
	
	private static final long serialVersionUID = 1391688820894808468L;

	public String executerTraitement(HttpServletRequest request, HttpServletResponse response){
		Collection collect = new Collection();
		if (request.getParameterMap().size() < 1){
			
			request.setAttribute("spectacles", collect.getSpectacles());
			return "spectacles.jsp";
		}
		else if (request.getParameter("action").equals("afficherSpectacle")){
			int i = 0;
			while (collect.getSpectacles()[i].getId() != Integer.parseInt(request.getParameter("spectacleid")) && i < collect.getSpectacles().length){
				i++;
			}
			request.setAttribute("spectacle", collect.getSpectacles()[i]);
			request.setAttribute("representations", collect.getRepresentations(i));
			
			return "representations.jsp";
		}
			
		else
			return "FUCK YOU VASCO";
	}
}
