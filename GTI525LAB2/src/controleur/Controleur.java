package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gti525.paiement.*;
import modele.Client;
import modele.DelegateSpectacles;
import modele.Representation;
import modele.Panier;

/**
 * Classe sous-contrôleur qui exécute les opérations en rapport à l'affichage et la lecture des messages
 *
 * @author Nicolas Brousseau
 * @author Riad Chebli
 * @version 07/15/2012
 */

public class Controleur {

	private static final long serialVersionUID = 1391688820894808468L;

	public String executerTraitement(HttpServletRequest request, HttpServletResponse response){

		//Collection collect = Collection.getCollection();

		if (request.getParameterMap().size() < 1){

			request.setAttribute("spectacles", DelegateSpectacles.getSpectacles());
			return "spectacles.jsp";
		}
		else if (request.getParameter("action").equals("afficherSpectacle")){
			int i = 0;
			while (DelegateSpectacles.getSpectacles()[i].getId() != Integer.parseInt(request.getParameter("spectacleid")) && i < DelegateSpectacles.getSpectacles().length){
				i++;
			}
			request.setAttribute("spectacle", DelegateSpectacles.getSpectacles()[i]);
			request.setAttribute("representations", DelegateSpectacles.getRepresentations(DelegateSpectacles.getSpectacles()[i].getId()));

			return "representations.jsp";
		}
		else if (request.getParameter("action").equals("reserverBillets")){


			try {

				if (Integer.parseInt(request.getParameter("qte")) > 0 && request.getParameter("repId") != null){
					Representation[] reps = DelegateSpectacles.getRepresentations(Integer.parseInt(request.getParameter("spectacle")));
					Representation maRepresentation = null;
					int i = 0;
					while (maRepresentation==null){
						if (reps[i].getId() == Integer.parseInt(request.getParameter("repId")))
							maRepresentation = reps[i];
						i++;
					}
					Panier monPanier = (Panier)request.getSession().getAttribute("panier");
					monPanier.ajouterLigne(maRepresentation, Integer.parseInt(request.getParameter("qte")));
					return "confReserv.jsp";
				} else return "erreurBillet.jsp";

			} catch (NumberFormatException e){

				return "erreurBillet.jsp";

			} 


		}
		
		else if (request.getParameter("action").equals("afficherPanier")){
			return "panier.jsp";
		}
		else if (request.getParameter("action").equals("preparePaiement")){
			//Il aurait fallu faire un servlet ici....
			Client c1 = new Client();
			c1.setAddrClient(request.getParameter("AddrClient"));			
			c1.setCCClient(request.getParameter("CCClient"));
			c1.setCourrielClient(request.getParameter("CourrielClient"));
			c1.setExpClient(request.getParameter("ExpClient"));
			c1.setNomClient(request.getParameter("NomClient"));
			c1.setPaysClient(request.getParameter("PaysClient"));
			c1.setPreClient(request.getParameter("PreClient"));
			c1.setProvinceClient(request.getParameter("ProvinceClient"));
			c1.setVilleClient(request.getParameter("VilleClient"));
			request.setAttribute("Client", c1);

			return "confPaie.jsp";
		}
		else if (request.getParameter("action").equals("processPaiement")){
			//Il aurait fallu faire un servlet ici....
			InformationsPaiementTO ipC = new InformationsPaiementTO () ;
			ReponseSystemePaiementTO rsp = new ReponseSystemePaiementTO ();
			//			ipC.setFirst_name(first_name);
			//			ipC.setLast_name(last_name);
			//			ipC.setAmount(amount);			
			//			ipC.setCard_number(card_number);
			//			ipC.setMonth(month);
			//			ipC.setYear(year);
			//			ipC.setSecurity_code(security_code);
			//			ipC.setApi_key(api_key);
			//			ipC.setOrder_id(order_id);			
			//			ipC.setStore_id(store_id);
			//			IPaiementDAO ipdao = null;
			//			rsp = ipdao.effectuerPreauthorisation(ipC);
			// ...a complèter			

			return "CACAPOIL";

		}
		else if (request.getParameter("action").equals("changerQte")){
			
			if (request.getParameter("repId") != null && request.getParameter("repId").matches("[0-9]*") && Integer.parseInt(request.getParameter("repId")) > 0) {
				Panier monPanier = (Panier)request.getSession().getAttribute("Panier");
				//if (DelegateSpectacles.getRepresentations(Integer.parseInt(request.getParameter("repId")))[1].
			}
			
			return "panier.jsp";


		}

		else
			return "";
	}
}