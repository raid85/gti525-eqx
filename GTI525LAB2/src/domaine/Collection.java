package domaine;
import java.util.ArrayList;
import java.util.Date;


public class Collection {
	Artiste aliseDion, apeterMacLeod, aelvis;
	Spectacle sliseDion, speterMacLeod, selvis;
	Salle centreBell, metropolis, jeanDrapeau;
	Representation juin11CentreBell, juin12CentreBell, juin13CentreBell, juin14Metropolis, juin15Metropolis, juin16Metropolis, juin17JDrapeau, juin18JDrapeau, juin19JDrapeau;
	private ArrayList<Spectacle> maCollection = new ArrayList<Spectacle>();
	
	private void createArtistes(){
		aliseDion = new Artiste();
		aliseDion.setNom("Lise Dion");
		aliseDion.setDescription("The Famous");
		aliseDion.setPhoto("/images/lisedion2011tpro.jpg");
		
		apeterMacLeod = new Artiste();
		apeterMacLeod.setNom("Peter MacLeod");
		apeterMacLeod.setDescription("The Funny");
		apeterMacLeod.setPhoto("/images/peter.jpg");
		
		aelvis = new Artiste();
		aelvis.setNom("Elvis");
		aelvis.setDescription("The King");
		aelvis.setPhoto("/images/elvis.jpg");
	}
	
	private void createSalles(){
		centreBell = new Salle();
		centreBell.setAdresse("1234 Avenue des Canadiens");
		centreBell.setNbPlaceMax(21000);
		centreBell.setNom("Centre Bell");
		
		metropolis = new Salle();
		metropolis.setAdresse("5678 Rue Ste-Catherine");
		metropolis.setNbPlaceMax(600);
		metropolis.setNom("M�tropolis");
		
		jeanDrapeau = new Salle();
		jeanDrapeau.setAdresse("Ile ste Helene");
		jeanDrapeau.setNbPlaceMax(10000);
		jeanDrapeau.setNom("Parc Jean-Drapeau");
	}
	
	private void createRepresentations(){
		juin11CentreBell = new Representation();
		juin11CentreBell.setBilletsDispo(centreBell.getNbPlaceMax());
		juin11CentreBell.setDate(new Date(2012,06,11,18,0));
		juin11CentreBell.setSalle(centreBell);
		
		juin12CentreBell = new Representation();
		juin12CentreBell.setBilletsDispo(centreBell.getNbPlaceMax());
		juin12CentreBell.setDate(new Date(2012,06,12,18,0));
		juin12CentreBell.setSalle(centreBell);
		
		juin13CentreBell = new Representation();
		juin12CentreBell.setBilletsDispo(centreBell.getNbPlaceMax());
		juin12CentreBell.setDate(new Date(2012,06,13,18,0));
		juin12CentreBell.setSalle(centreBell);
		
		juin14Metropolis = new Representation();
		juin14Metropolis.setBilletsDispo(metropolis.getNbPlaceMax());
		juin14Metropolis.setDate(new Date(2012,06,14,18,0));
		juin14Metropolis.setSalle(metropolis);
		
		juin15Metropolis = new Representation();
		juin15Metropolis.setBilletsDispo(metropolis.getNbPlaceMax());
		juin15Metropolis.setDate(new Date(2012,06,15,18,0));
		juin15Metropolis.setSalle(metropolis);
		
		juin16Metropolis = new Representation();
		juin16Metropolis.setBilletsDispo(metropolis.getNbPlaceMax());
		juin16Metropolis.setDate(new Date(2012,06,16,18,0));
		juin16Metropolis.setSalle(metropolis);
		
		juin17JDrapeau = new Representation();
		juin17JDrapeau.setBilletsDispo(jeanDrapeau.getNbPlaceMax());
		juin17JDrapeau.setDate(new Date(2012,06,17,18,0));
		juin17JDrapeau.setSalle(jeanDrapeau);
		
		juin18JDrapeau = new Representation();
		juin18JDrapeau.setBilletsDispo(jeanDrapeau.getNbPlaceMax());
		juin18JDrapeau.setDate(new Date(2012,06,18,18,0));
		juin18JDrapeau.setSalle(jeanDrapeau);
		
		juin19JDrapeau = new Representation();
		juin19JDrapeau.setBilletsDispo(jeanDrapeau.getNbPlaceMax());
		juin19JDrapeau.setDate(new Date(2012,06,19,18,0));
		juin19JDrapeau.setSalle(jeanDrapeau);
		
	}
	
	private void createSpectacles(){

		sliseDion = new Spectacle();
		sliseDion.setArtiste(aliseDion);
		sliseDion.setDescription("Mis en sc�ne par Michel Courtemanche, Le temps qui court propose une r�flexion sur le temps qui passe et les diff�rentes �tapes de la vie : il y est question de la vieillesse et de la mort, mais � la mani�re de Lise Dion bien s�r. En plus de donner des d�tails sur ce qu�elle a fait pendant son absence des planches qui a dur� six ans, elle nous donne aussi des nouvelles de Marcel et de ses ados� qui, en principe, ne sont plus des ados. Parmi les multiples sujets abord�s, l�humoriste revient avec le personnage de la femme afghane qui d�couvre les avantages de son costume et propose une r�flexion sur les hommes qui partent avec des femmes plus jeunes� Tout un programme!/n Le temps qui court est le 3e spectacle que pr�sente Lise Dion en carri�re. Son premier spectacle a rafl� 3 F�lix et a �t� pr�sent� 50 fois au Th��tre St-Denis 1, ce qui fait de Lise la seule femme et une des rares artistes � avoir r�ussi un tel exploit. Lise Dion s�est vu remettre une plaque soulignant la vente de 140,000 billets vendus de son nouveau spectacle. C�est assur�ment un retour en force pour l�humoriste chouchou des Qu�b�cois!");
		sliseDion.setDuree(120);
		sliseDion.setImage("images/lisedion2011tpro.jpg");
		sliseDion.setNom("Lise Dion Spectacle");
		sliseDion.ajouterRepresentation(juin11CentreBell);
		sliseDion.ajouterRepresentation(juin14Metropolis);
		sliseDion.ajouterRepresentation(juin17JDrapeau);
		maCollection.add(sliseDion);
		
		speterMacLeod = new Spectacle();
		speterMacLeod.setArtiste(apeterMacLeod);
		speterMacLeod.setDescription("Apr�s s��tre lui-m�me canonis� Saint, l�humoriste � la gueule sympathique et aux propos corrosifs revient sur sc�ne avec son 4e one man show Sagesse Report�e, qui confronte l�humoriste avec la quarantaine et ses implications. En effet, MacLeod devrait pr�cher par l�exemple et devenir socialement plus sage. Il devrait avoir une femme et non une blonde, un compte conjoint, un mini-van, un abonnement au Costco, une passe de saison au golf, s�int�resser soudainement au Cirque du Soleil et au train de Jos�lito! Mais, sa qu�te de libert� l�am�ne � laisser son aur�ole de c�t� pour nous prouver que vieillir n�est pas synonyme de s�assagir. Que ce soit la surconsommation, la soci�t� matriarcale, les jeunes, le couple, ses opinions sont tranchantes et assum�es. Dr�le, percutant et touchant, le justicier aux 700 000 billets vendus en carri�re nous prouve avec ce quatri�me rendez-vous, � la mise en sc�ne spectaculaire, qu�il fait toujours partie de l��lite humoristique au Qu�bec.");
		speterMacLeod.setDuree(120);
		speterMacLeod.setImage("images/peter.jpg");
		speterMacLeod.setNom("Peter Spectacle");
		speterMacLeod.ajouterRepresentation(juin12CentreBell);
		speterMacLeod.ajouterRepresentation(juin15Metropolis);
		speterMacLeod.ajouterRepresentation(juin18JDrapeau);
		maCollection.add(speterMacLeod);
		
		selvis = new Spectacle();
		selvis.setArtiste(aelvis);
		selvis.setDescription("Ce juillet, Robert Baggio est Elvis ! \nSur sc�ne, Baggio offre ses interpr�tations des succ�s d�Elvis avec une voix �tonnamment ressemblante. Il est entour� par des musiciens et choristes de talent, dont certains ont particip� aux tourn�es d�artistes reconnus de Star Acad�mie, Garou, Marie-Mai, Dan Bigras et de plusieurs autres. \nLe concert �nergisant Viva Las Vegas inclura des classiques originaux du King et des remakes avec une touche moderne.\n Le tout pour garder la m�moire d'Elvis vivante avec une pr�sentation inoubliable dans l'espoir de vous faire revivre un vrai concert du King.");
		selvis.setDuree(120);
		selvis.setImage("images/elvis.jpg");
		selvis.setNom("Elvis Spectacle");
		selvis.ajouterRepresentation(juin13CentreBell);
		selvis.ajouterRepresentation(juin16Metropolis);
		selvis.ajouterRepresentation(juin19JDrapeau);
		maCollection.add(selvis);
		
	}
	
	public Collection(){
		createArtistes();
		createSalles();
		createRepresentations();
		createSpectacles();
	}
	
    public ArrayList getCollection (){
        return maCollection;
    }
    
    public String[] getSpectaclesTitre(){
        String[] titres = new String[maCollection.size()];
        for (int i=0;i<maCollection.size();i++){
        	titres[i] = maCollection.get(i).getNom();
        }
        return titres;
    }
    
    public String[] getSpectaclesDescription(){
        String[] descriptions = new String[maCollection.size()];
        for (int i=0;i<maCollection.size();i++){
        	descriptions[i] = maCollection.get(i).getDescription();
        }
        return descriptions;
    }
    
    public String[] getSpectaclesImages(){
        String[] images = new String[maCollection.size()];
        for (int i=0;i<maCollection.size();i++){
        	images[i] = maCollection.get(i).getImage();
        }
        return images;
    }

}
