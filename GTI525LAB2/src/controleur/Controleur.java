package controleur;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gti525.paiement.*;
import modele.Client;
import modele.DAOPaiementStub;
import modele.DelegateSpectacles;
import modele.LignePanier;
import modele.Representation;
import modele.Panier;

/**
 * Classe sous-contr�leur qui ex�cute les op�rations en rapport � l'affichage et la lecture des messages
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

			Client monClient = new Client();
			monClient.setAddrClient(request.getParameter("AddrClient"));			
			monClient.setCCClient(request.getParameter("CCClient"));
			monClient.setCourrielClient(request.getParameter("CourrielClient"));
			monClient.setExpMClient(request.getParameter("ExpMClient"));
			monClient.setExpAClient(request.getParameter("ExpAClient"));
			monClient.setNomClient(request.getParameter("NomClient"));
			monClient.setPaysClient(request.getParameter("PaysClient"));
			monClient.setPreClient(request.getParameter("PreClient"));
			monClient.setProvinceClient(request.getParameter("ProvinceClient"));
			monClient.setVilleClient(request.getParameter("VilleClient"));
			monClient.setcS(request.getParameter("CsClient"));
			request.setAttribute("Client", monClient);

			return "confPaie.jsp";
		}
		else if (request.getParameter("action").equals("processPaiement")){
			//Creation des objets requis par le DAO de paiement
			InformationsPaiementTO ipC = new InformationsPaiementTO () ;			
			//On recupere les infos des beans dans la requete
			Client monClient = (Client) request.getAttribute("Client");
			Panier monPanier = (Panier) request.getAttribute("panier");
			//On remplit l'objet requis par le service de transactions
			ipC.setFirst_name(monClient.getPreClient());
			ipC.setLast_name(monClient.getNomClient());
			ipC.setAmount(BigDecimal.valueOf(monPanier.getTotal()));			
			ipC.setCard_number(Long.valueOf(monClient.getCCClient()));
			ipC.setMonth(Integer.valueOf(monClient.getExpMClient()));
			ipC.setYear(Integer.valueOf(monClient.getExpAClient()));
			ipC.setSecurity_code(Integer.valueOf(monClient.getcS()));
			//						ipC.setApi_key(api_key);
			//						ipC.setOrder_id(order_id);			
			//						ipC.setStore_id(store_id);
			DAOPaiementStub stubDAO = new DAOPaiementStub() ;
			stubDAO.effectuerPreauthorisation(ipC);


			return "CACAPOIL";

		}
		else if (request.getParameter("action").equals("changerQte")){

			if (request.getParameter("repId") != null && request.getParameter("repId").matches("[0-9]*") && Integer.parseInt(request.getParameter("repId")) > 0) {
				Panier monPanier = (Panier)request.getSession().getAttribute("panier");
				int repId = Integer.parseInt(request.getParameter("repId"));
				LignePanier maLigne = monPanier.getLignePanier(repId);
				int nouveauNbBillets = Integer.parseInt(request.getParameter("qte"));
				if (maLigne.getRep().getBilletsDispo() + monPanier.getLignePanier(repId).getNbBillets() - nouveauNbBillets >= 0){
					maLigne.getRep().retournerBillet(maLigne.getNbBillets());
					maLigne.getRep().reserverBillets(nouveauNbBillets);
					maLigne.setNbBillets(nouveauNbBillets);
				}
			}

			return "panier.jsp";


		}

		else
			return "";
	}
}