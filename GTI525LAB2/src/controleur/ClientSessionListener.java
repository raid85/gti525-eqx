package controleur;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import modele.Panier;
import modele.User;

public class ClientSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub		
		String userID = se.getSession().getId();
		User monUser = new User(userID);
		se.getSession().setAttribute("panier", new Panier(monUser.getId()));
		se.getSession().setMaxInactiveInterval(600);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		Panier monPanier = (Panier)se.getSession().getAttribute("panier");
		if(monPanier.getPanier().length > 0 )
			monPanier.viderPanier();
		
	}

}
