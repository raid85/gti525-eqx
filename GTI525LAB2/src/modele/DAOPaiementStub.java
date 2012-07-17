package modele;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

public class DAOPaiementStub implements IPaiementDAO {

	@Override
	public ReponseSystemePaiementTO approuverTransaction(
			RequeteAuthorisationTO arg0) {
		ReponseSystemePaiementTO rsp = new ReponseSystemePaiementTO ();
		rsp.setMessage("Passed");
		return rsp;
	}

	@Override
	public ReponseSystemePaiementTO effectuerPreauthorisation(
			InformationsPaiementTO arg0) {
		ReponseSystemePaiementTO rsp = new ReponseSystemePaiementTO ();
		rsp.setMessage("Passed");
		return rsp;
	}

}
