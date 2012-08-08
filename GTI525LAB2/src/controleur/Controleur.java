package controleur;

import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Client;
import modele.DAOPaiementStub;
//import modele.PaiementDAO;
import modele.DelegateSpectacles;
import modele.LignePanier;
import modele.PaiementDAO;
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
	private static final long CarteCreditClient = Long.valueOf("8675309000000000") ;
	private static final String apiKey = "5952a3501dfcd5135a58";
	private static final int storeID = 69 ;
	private static final int Ok = 10200 ;

	public String executerTraitement(HttpServletRequest request, HttpServletResponse response){		
		//Panier 
		Panier monPanier = (Panier)request.getSession().getAttribute("panier");
		//Objets de paiement
		InformationsPaiementTO ipC = new InformationsPaiementTO () ;
		PaiementDAO payDAO = new PaiementDAO () ;
	
		monPanier.checkTimeOut();
		try {
		if (request.getParameterMap().size() < 1){
				request.setAttribute("spectacles", DelegateSpectacles.getSpectacles());
				return "spectacles.jsp";
			}
			
		else if (request.getParameter("action").equals("afficherSpectacle")){

			try {
				request.setAttribute("spectacle", DelegateSpectacles.getRepresentations(Integer.parseInt(request.getParameter("spectacleid"))));
			}
			catch (NumberFormatException e){
				return "erreur.jsp";
			}
			catch (ClassCastException e){
				e.printStackTrace();
				return "erreur.jsp";
			}
			return "representations.jsp";
		}
		
		else if (request.getParameter("action").equals("reserverBillets")){
			try {

				if (Integer.parseInt(request.getParameter("qte")) > 0 && request.getParameter("repId") != null && monPanier.getTotalBillets() + Integer.parseInt(request.getParameter("qte")) <= 6){
						if (DelegateSpectacles.reserverBillets(Integer.parseInt(request.getParameter("repId")), Integer.parseInt(request.getParameter("qte")), monPanier)){
							return "confReserv.jsp";
						}
						else return "erreurBillet.jsp";
				} 
				else return "erreurBillet.jsp";

			} catch (NumberFormatException e){
				return "erreurBillet.jsp";
			}


		}

		else if (request.getParameter("action").equals("afficherPanier")){
			monPanier.checkTimeOut();
			return "panier.jsp";
		}
		
		else if (request.getParameter("action").equals("payer")){
			monPanier.checkTimeOut();
			return "achat.jsp";
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
			monClient.setcS(request.getParameter("SecClient"));
			request.setAttribute("Client", monClient);

			//On remplit l'objet InformationsPaiementTO requis par le service de transactions			
			ipC.setFirst_name(monClient.getPreClient());
			ipC.setLast_name(monClient.getNomClient());
			try{
				ipC.setAmount(BigDecimal.valueOf(monPanier.getTotal()));			
				ipC.setCard_number(CarteCreditClient);
				ipC.setMonth(Integer.valueOf(monClient.getExpMClient()));
				ipC.setYear(Integer.valueOf(monClient.getExpAClient()));
				ipC.setSecurity_code(Integer.valueOf(monClient.getcS()));
				ipC.setApi_key(apiKey);
				//En attendant...
				ipC.setOrder_id((long) ((Math.random()*100)));			
				ipC.setStore_id(storeID);
			}catch (NumberFormatException e){
				System.out.println ("Internal Parsing/Casting exception");
				e.printStackTrace();
			}


			ReponseSystemePaiementTO rspPre = new ReponseSystemePaiementTO ();
			rspPre = payDAO.effectuerPreauthorisation(ipC);			
		
			request.getSession().setAttribute("trID", rspPre.getTransactionId());
			request.getSession().setAttribute("cdR",rspPre.getCode());
			
			


			return "confPaie.jsp";
		}
		
		else if (request.getParameter("action").equals("processPaiement")){	
			
			int cdR = Integer.parseInt(request.getSession().getAttribute("cdR").toString());
			int trID =Integer.parseInt(request.getSession().getAttribute("trID").toString());
			
			
			if(cdR == Ok ){

				//On effectue l approbation de la transaction				
				RequeteAuthorisationTO rqAut = new RequeteAuthorisationTO ();
				rqAut.setTransaction_id(trID);
				rqAut.setApi_key(apiKey);
				rqAut.setStore_id(storeID);
				ReponseSystemePaiementTO rspFinal = payDAO.approuverTransaction(rqAut);				
				
				

				if (rspFinal.getCode()== Ok){
					
					monPanier.finaliserVente();
					request.getSession().setAttribute("panier",new Panier(request.getSession().getId()));
					return "final.jsp" ;
				}
				else return "erreurPaiement.jsp";
			}
			else return "erreurPaiement.jsp";

		}
		
		else if (request.getParameter("action").equals("changerQte")){
			try {

				if (request.getParameter("repId") != null && request.getParameter("repId").matches("[0-9]*") && request.getParameter("qte") != null && request.getParameter("qte").matches("[0-9]*") && Integer.parseInt(request.getParameter("qte")) >= 0)  {

					int repId = Integer.parseInt(request.getParameter("repId"));
					LignePanier maLigne = monPanier.getLignePanier(repId);
					int nouveauNbBillets = Integer.parseInt(request.getParameter("qte"));

					if (nouveauNbBillets < maLigne.getNbBillets()){
						monPanier.setTotalBillets(monPanier.getTotalBillets() - maLigne.getNbBillets());
						maLigne.getRep().retournerBillet(maLigne.getNbBillets());
						maLigne.getRep().reserverBillets(nouveauNbBillets);
						monPanier.setTotalBillets(monPanier.getTotalBillets() + nouveauNbBillets);
						maLigne.setNbBillets(nouveauNbBillets);

					}
					else if ((maLigne.getRep().getBilletsDispo() + maLigne.getNbBillets() - nouveauNbBillets >= 0  && monPanier.getTotalBillets() - maLigne.getNbBillets() + nouveauNbBillets <= 6)){
						monPanier.setTotalBillets(monPanier.getTotalBillets() - maLigne.getNbBillets());
						maLigne.getRep().retournerBillet(maLigne.getNbBillets());
						maLigne.getRep().reserverBillets(nouveauNbBillets);
						monPanier.setTotalBillets(monPanier.getTotalBillets() + nouveauNbBillets);
						maLigne.setNbBillets(nouveauNbBillets);
					}
					else
						return "panier.jsp";
				}

			}
			catch (NumberFormatException e){
				return "panier.jsp";
			}

			return "panier.jsp";
		}
		else if (request.getParameter("action").equals("home")){

			request.setAttribute("spectacles", DelegateSpectacles.getSpectacles());
			return "spectacles.jsp";
		}


		else
			return "erreur.jsp";
	}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "erreur.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			return "erreur.jsp";
		}
	}

}