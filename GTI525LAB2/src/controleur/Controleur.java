package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Collection;
import modele.Representation;
import modele.Panier;

/**
 * Classe sous-contrôleur qui exécute les opérations en rapport à l'affichage et la lecture des messages
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
			request.setAttribute("representations", collect.getRepresentations(collect.getSpectacles()[i].getId()));
			
			return "representations.jsp";
		}
		else if (request.getParameter("action").equals("reserverBillets")){
			if (Integer.parseInt(request.getParameter("qte")) > 0 && request.getParameter("repId") != null){
				Representation[] reps = collect.getRepresentations(Integer.parseInt(request.getParameter("spectacle")));
				Representation maRepresentation = null;
				int i = 0;
				while (maRepresentation==null){
					if (reps[i].getId() == Integer.parseInt(request.getParameter("repId")))
						maRepresentation = reps[i];
				}
				Panier monPanier = (Panier)request.getSession().getAttribute("panier");
				System.out.println(monPanier.getId());
				monPanier.ajouterLigne(maRepresentation, Integer.parseInt(request.getParameter("qte")));
				
			}
				
			
			return "confReserv.jsp";
		}
			
		else
			return "FUCK YOU VASCO";
	}
}
