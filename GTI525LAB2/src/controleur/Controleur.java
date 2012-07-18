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
		
		
		Panier monPanier = (Panier)request.getSession().getAttribute("panier");
		InformationsPaiementTO ipC = new InformationsPaiementTO () ;
		DAOPaiementStub stubDAO = new DAOPaiementStub() ;
		ReponseSystemePaiementTO rspPre = new ReponseSystemePaiementTO ();
	
		if(monPanier.checkTimeOut()==false){
			//return "pisseuse";
			System.out.println("Vidage");
		}
			
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
					//Panier monPanier = (Panier)request.getSession().getAttribute("panier");
					monPanier.ajouterLigne(maRepresentation, Integer.parseInt(request.getParameter("qte")));
					return "confReserv.jsp";
				} else return "erreurBillet.jsp";

			} catch (NumberFormatException e){

				return "erreurBillet.jsp";

			} 


		}

		else if (request.getParameter("action").equals("afficherPanier")){
			Panier monpanier = (Panier)request.getSession().getAttribute("panier");
			monpanier.checkTimeOut();
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
			
			//On remplit l'objet requis par le service de transactions
			
			ipC.setFirst_name(monClient.getPreClient());
			ipC.setLast_name(monClient.getNomClient());
			try{
			ipC.setAmount(BigDecimal.valueOf(monPanier.getTotal()));			
			ipC.setCard_number(Long.valueOf(monClient.getCCClient()));
			ipC.setMonth(Integer.valueOf(monClient.getExpMClient()));
			ipC.setYear(Integer.valueOf(monClient.getExpAClient()));
			ipC.setSecurity_code(Integer.valueOf(monClient.getcS()));
			ipC.setApi_key(null);
			ipC.setOrder_id((Long) null);			
			ipC.setStore_id((Integer) null);
			}catch (NumberFormatException e){}
			
			
			
			rspPre = stubDAO.effectuerPreauthorisation(ipC);

			return "confPaie.jsp";
		}
		else if (request.getParameter("action").equals("processPaiement")){


			//Si la preauthorisation a passee...(-1) est fictif)
			if(rspPre.getCode() != -1){
			
			//On effectue l approbation de la transaction				
			RequeteAuthorisationTO rqAut = new RequeteAuthorisationTO ();
			rqAut.setTransaction_id(rspPre.getTransactionId());
			rqAut.setApi_key(ipC.getApi_key());
			rqAut.setStore_id(ipC.getStore_id());
			ReponseSystemePaiementTO rspFinal = stubDAO.approuverTransaction(rqAut);
			
			if (rspFinal.getMessage().compareTo("Passed")==0){
				return "final.jsp" ;
			}
			else return "erreurPaiement.jsp";
			}
			else return "erreurPaiement.jsp";

		}
		else if (request.getParameter("action").equals("changerQte")){

			if (request.getParameter("repId") != null && request.getParameter("repId").matches("[0-9]*") && Integer.parseInt(request.getParameter("repId")) > 0) {
				//Panier monPanier = (Panier)request.getSession().getAttribute("panier");
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