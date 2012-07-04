package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Collection;

/**
 * Classe sous-contrôleur qui exécute les opérations en rapport à l'affichage et la lecture des messages
 *
 * @author Eric Boivin
 * @version 01/29/2010
 */

public class Controleur {
	
	private static final long serialVersionUID = 1391688820894808468L;

	public String executerTraitement(HttpServletRequest request, HttpServletResponse response){
		
		if (request.getParameterMap().size() < 1){
			Collection collect = new Collection();
			request.setAttribute("spectacles", collect.getSpectacles());
			return "spectacles.jsp";
		}
			
		else
			return "FUCK YOU VASCO";
	}
}
