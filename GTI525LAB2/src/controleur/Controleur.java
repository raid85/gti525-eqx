package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import modele.DelegateSpectacles;
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
		//Collection collect = Collection.getCollection();
		if (request.getParameterMap().size() < 1){
			
			request.setAttribute("spectacles", DelegateSpectacles.getSpectacleCol());
			return "spectacles.jsp";
		}
		else if (request.getParameter("action").equals("afficherSpectacle")){
			int i = 0;
			while (DelegateSpectacles.obtenirSpectacles()[i].getId() != Integer.parseInt(request.getParameter("spectacleid")) && i < DelegateSpectacles.obtenirSpectacles().length){
				i++;
			}
			request.setAttribute("spectacle", DelegateSpectacles.obtenirSpectacles()[i]);
			request.setAttribute("representations", DelegateSpectacles.obtenirRepresentation(DelegateSpectacles.obtenirSpectacles()[i].getId()));
			
			return "representations.jsp";
		}
		else if (request.getParameter("action").equals("reserverBillets")){
			if (Integer.parseInt(request.getParameter("qte")) > 0 && request.getParameter("repId") != null){
				Representation[] reps =DelegateSpectacles.obtenirRepresentation(Integer.parseInt(request.getParameter("spectacle")));
				Representation maRepresentation = null;
				int i = 0;
				while (maRepresentation==null){
					if (reps[i].getId() == Integer.parseInt(request.getParameter("repId")))
						maRepresentation = reps[i];
					i++;
				}
				Panier monPanier = (Panier)request.getSession().getAttribute("panier");
				monPanier.ajouterLigne(maRepresentation, Integer.parseInt(request.getParameter("qte")));
				
			}
				
			
			return "confReserv.jsp";
		}
		else if (request.getParameter("action").equals("afficherPanier")){
			return "panier.jsp";
		}
			
		else
			return "FUCK YOU VASCO";
	}
}
