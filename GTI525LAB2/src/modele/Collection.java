package modele;
import java.util.ArrayList;
import java.util.Date;

/**
 * Cette classe agit comme le DAO (local)
 * Une simple collection popul�e avec nos donn�es
 * @author Riad Chebli, Nicolas Brousseau
 * @version 07/15/2012
 */

public class Collection {
	Artiste aliseDion, apeterMacLeod, aelvis;
	Spectacle sliseDion, speterMacLeod, selvis;
	Salle centreBell, metropolis, jeanDrapeau;
	Representation juin11CentreBell, juin12CentreBell, juin13CentreBell, juin14Metropolis, juin15Metropolis, juin16Metropolis, juin17JDrapeau, juin18JDrapeau, juin19JDrapeau;
	User brousseau, vasco, riad;
	private ArrayList<Spectacle> listeSpectacles = new ArrayList<Spectacle>();
	private ArrayList<Representation> listeRepresentations = new ArrayList<Representation>();
	static Collection collect ;//= new Collection();
	
	private void createUsers(){
//		brousseau = new User(9001, "Brousseau", "Nicolas", "11 rue yoyo", new Panier (8001, 9001));
//		vasco = new User(9001, "Vasco", "Jo", "12 rue yaya", new Panier (8002, 9002));
//		riad = new User(9001, "Chebli", "Riad", "13 rue yiyi", new Panier (8003, 9003));
	}
	
	public static Collection getCollection(){
		return collect;
	}
	
	private void createArtistes(){
		aliseDion = new Artiste();
		aliseDion.setNom("Lise Dion");
		aliseDion.setDescription("The Famous");
		aliseDion.setPhoto("/images/lisedion2011tpro.jpg");
		aliseDion.setId(1001);
		
		apeterMacLeod = new Artiste();
		apeterMacLeod.setNom("Peter MacLeod");
		apeterMacLeod.setDescription("The Funny");
		apeterMacLeod.setPhoto("/images/peter.jpg");
		apeterMacLeod.setId(1002);
		
		aelvis = new Artiste();
		aelvis.setNom("Elvis");
		aelvis.setDescription("The King");
		aelvis.setPhoto("/images/elvis.jpg");
		aelvis.setId(1003);
	}
	
	private void createSalles(){
		centreBell = new Salle();
		centreBell.setAdresse("1234 Avenue des Canadiens");
		centreBell.setNbPlaceMax(21000);
		centreBell.setNom("Centre Bell");
		centreBell.setId(2001);
		
		metropolis = new Salle();
		metropolis.setAdresse("5678 Rue Ste-Catherine");
		metropolis.setNbPlaceMax(600);
		metropolis.setNom("M�tropolis");
		metropolis.setId(2002);
		
		jeanDrapeau = new Salle();
		jeanDrapeau.setAdresse("Ile ste Helene");
		jeanDrapeau.setNbPlaceMax(10000);
		jeanDrapeau.setNom("Parc Jean-Drapeau");
		jeanDrapeau.setId(2003);
	}
	
	private void createRepresentations(){
		juin11CentreBell = new Representation();
		juin11CentreBell.setBilletsDispo(200);
		juin11CentreBell.setDate(new Date(2012,06,11,18,0));
		juin11CentreBell.setSalle(centreBell);
		juin11CentreBell.setPrix(60);
		juin11CentreBell.setId(3001);
		juin11CentreBell.setSpectacle(5001);
		juin11CentreBell.setSpectacleNom("Lise Dion");
		listeRepresentations.add(juin11CentreBell);
		
		juin12CentreBell = new Representation();
		juin12CentreBell.setBilletsDispo(60);
		juin12CentreBell.setDate(new Date(2012,06,12,18,0));
		juin12CentreBell.setSalle(centreBell);
		juin12CentreBell.setPrix(30.30);
		juin12CentreBell.setId(3002);
		juin12CentreBell.setSpectacle(5002);
		juin12CentreBell.setSpectacleNom("Peter");
		listeRepresentations.add(juin12CentreBell);
		
		juin13CentreBell = new Representation();
		juin13CentreBell.setBilletsDispo(700);
		juin13CentreBell.setDate(new Date(2012,06,13,18,0));
		juin13CentreBell.setSalle(centreBell);
		juin13CentreBell.setPrix(100.12);
		juin13CentreBell.setId(3003);
		juin13CentreBell.setSpectacle(5003);
		juin13CentreBell.setSpectacleNom("Elvis");
		listeRepresentations.add(juin13CentreBell);
		
		juin14Metropolis = new Representation();
		juin14Metropolis.setBilletsDispo(600);
		juin14Metropolis.setDate(new Date(2012,06,14,18,0));
		juin14Metropolis.setSalle(metropolis);
		juin14Metropolis.setPrix(55.50);
		juin14Metropolis.setId(3004);
		juin14Metropolis.setSpectacle(5001);
		juin14Metropolis.setSpectacleNom("Lise Dion");
		listeRepresentations.add(juin14Metropolis);
		
		juin15Metropolis = new Representation();
		juin15Metropolis.setBilletsDispo(45);
		juin15Metropolis.setDate(new Date(2012,06,15,18,0));
		juin15Metropolis.setSalle(metropolis);
		juin15Metropolis.setPrix(60);
		juin15Metropolis.setId(3005);
		juin15Metropolis.setSpectacle(5002);
		juin15Metropolis.setSpectacleNom("Peter");
		listeRepresentations.add(juin15Metropolis);
		
		juin16Metropolis = new Representation();
		juin16Metropolis.setBilletsDispo(75);
		juin16Metropolis.setDate(new Date(2012,06,16,18,0));
		juin16Metropolis.setSalle(metropolis);
		juin16Metropolis.setPrix(123);
		juin16Metropolis.setId(3006);
		juin16Metropolis.setSpectacle(5003);
		juin16Metropolis.setSpectacleNom("Elvis");
		listeRepresentations.add(juin16Metropolis);
		
		juin17JDrapeau = new Representation();
		juin17JDrapeau.setBilletsDispo(2000);
		juin17JDrapeau.setDate(new Date(2012,06,17,18,0));
		juin17JDrapeau.setSalle(jeanDrapeau);
		juin17JDrapeau.setPrix(45);
		juin17JDrapeau.setId(3007);
		juin17JDrapeau.setSpectacle(5001);
		juin17JDrapeau.setSpectacleNom("Lise Dion");
		listeRepresentations.add(juin17JDrapeau);
		
		juin18JDrapeau = new Representation();
		juin18JDrapeau.setBilletsDispo(250);
		juin18JDrapeau.setDate(new Date(2012,06,18,18,0));
		juin18JDrapeau.setSalle(jeanDrapeau);
		juin18JDrapeau.setPrix(34);
		juin18JDrapeau.setId(3008);
		juin18JDrapeau.setSpectacle(5002);
		juin18JDrapeau.setSpectacleNom("Peter");
		listeRepresentations.add(juin18JDrapeau);
		
		juin19JDrapeau = new Representation();
		juin19JDrapeau.setBilletsDispo(3000);
		juin19JDrapeau.setDate(new Date(2012,06,19,18,0));
		juin19JDrapeau.setSalle(jeanDrapeau);
		juin19JDrapeau.setPrix(67.66);
		juin19JDrapeau.setId(3009);
		juin19JDrapeau.setSpectacle(5003);
		juin19JDrapeau.setSpectacleNom("Elvis");
		listeRepresentations.add(juin19JDrapeau);
		
	}
	
	private void createSpectacles(){

		sliseDion = new Spectacle();
		sliseDion.setArtiste(aliseDion);
		sliseDion.setDescription("Mis en sc�ne par Michel Courtemanche, Le temps qui court propose une r�flexion sur le temps qui passe et les diff�rentes �tapes de la vie : il y est question de la vieillesse et de la mort, mais � la mani�re de Lise Dion bien s�r. En plus de donner des d�tails sur ce qu�elle a fait pendant son absence des planches qui a dur� six ans, elle nous donne aussi des nouvelles de Marcel et de ses ados� qui, en principe, ne sont plus des ados. Parmi les multiples sujets abord�s, l�humoriste revient avec le personnage de la femme afghane qui d�couvre les avantages de son costume et propose une r�flexion sur les hommes qui partent avec des femmes plus jeunes� Tout un programme!/n Le temps qui court est le 3e spectacle que pr�sente Lise Dion en carri�re. Son premier spectacle a rafl� 3 F�lix et a �t� pr�sent� 50 fois au Th��tre St-Denis 1, ce qui fait de Lise la seule femme et une des rares artistes � avoir r�ussi un tel exploit. Lise Dion s�est vu remettre une plaque soulignant la vente de 140,000 billets vendus de son nouveau spectacle. C�est assur�ment un retour en force pour l�humoriste chouchou des Qu�b�cois!");
		sliseDion.setDuree(120);
		sliseDion.setImage("images/lisedion2011tpro.jpg");
		sliseDion.setNom("Lise Dion");
		sliseDion.ajouterRepresentation(juin11CentreBell);
		sliseDion.ajouterRepresentation(juin14Metropolis);
		sliseDion.ajouterRepresentation(juin17JDrapeau);
		sliseDion.setId(5001);
		listeSpectacles.add(sliseDion);
		
		speterMacLeod = new Spectacle();
		speterMacLeod.setArtiste(apeterMacLeod);
		speterMacLeod.setDescription("Apr�s s��tre lui-m�me canonis� Saint, l�humoriste � la gueule sympathique et aux propos corrosifs revient sur sc�ne avec son 4e one man show Sagesse Report�e, qui confronte l�humoriste avec la quarantaine et ses implications. En effet, MacLeod devrait pr�cher par l�exemple et devenir socialement plus sage. Il devrait avoir une femme et non une blonde, un compte conjoint, un mini-van, un abonnement au Costco, une passe de saison au golf, s�int�resser soudainement au Cirque du Soleil et au train de Jos�lito! Mais, sa qu�te de libert� l�am�ne � laisser son aur�ole de c�t� pour nous prouver que vieillir n�est pas synonyme de s�assagir. Que ce soit la surconsommation, la soci�t� matriarcale, les jeunes, le couple, ses opinions sont tranchantes et assum�es. Dr�le, percutant et touchant, le justicier aux 700 000 billets vendus en carri�re nous prouve avec ce quatri�me rendez-vous, � la mise en sc�ne spectaculaire, qu�il fait toujours partie de l��lite humoristique au Qu�bec.");
		speterMacLeod.setDuree(120);
		speterMacLeod.setImage("images/peter.jpg");
		speterMacLeod.setNom("Peter");
		speterMacLeod.ajouterRepresentation(juin12CentreBell);
		speterMacLeod.ajouterRepresentation(juin15Metropolis);
		speterMacLeod.ajouterRepresentation(juin18JDrapeau);
		speterMacLeod.setId(5002);
		listeSpectacles.add(speterMacLeod);
		
		selvis = new Spectacle();
		selvis.setArtiste(aelvis);
		selvis.setDescription("Ce juillet, Robert Baggio est Elvis ! \nSur sc�ne, Baggio offre ses interpr�tations des succ�s d�Elvis avec une voix �tonnamment ressemblante. Il est entour� par des musiciens et choristes de talent, dont certains ont particip� aux tourn�es d�artistes reconnus de Star Acad�mie, Garou, Marie-Mai, Dan Bigras et de plusieurs autres. \nLe concert �nergisant Viva Las Vegas inclura des classiques originaux du King et des remakes avec une touche moderne.\n Le tout pour garder la m�moire d'Elvis vivante avec une pr�sentation inoubliable dans l'espoir de vous faire revivre un vrai concert du King.");
		selvis.setDuree(120);
		selvis.setImage("images/elvis.jpg");
		selvis.setNom("Elvis");
		selvis.ajouterRepresentation(juin13CentreBell);
		selvis.ajouterRepresentation(juin16Metropolis);
		selvis.ajouterRepresentation(juin19JDrapeau);
		selvis.setId(5003);
		listeSpectacles.add(selvis);
		
	}
	
	public Collection(){
		createArtistes();
		createSalles();
		createRepresentations();
		createSpectacles();
		createUsers();
	}
	
    public Spectacle[] getSpectacles (){
    	Spectacle[] spectacles = new Spectacle[listeSpectacles.size()];
        for (int i=0;i<listeSpectacles.size();i++){
        	spectacles[i] = ((Spectacle)listeSpectacles.get(i));
        }
        return spectacles;
    }
    public Representation[] getRepresentations (){
    	Representation[] representations = new Representation[listeRepresentations.size()];
        for (int i=0;i<listeSpectacles.size();i++){
        	representations[i] = ((Representation)listeRepresentations.get(i));
        }
        return representations;
    }
    
    public Representation[] getRepresentations (int idSpectacle){
    	int i = 0;
    	while (i < listeSpectacles.size()){
    		if (listeSpectacles.get(i).getId() == idSpectacle)
    			break;
    		i++;
    	}
    	
    	Representation[] representations = new Representation[listeSpectacles.get(i).getNbRepresentations()];
        for (int j=0;j<listeSpectacles.get(i).getNbRepresentations();j++){
        	representations[j] = (Representation)listeSpectacles.get(i).getRepresentation(j);
        }
        return representations;
    }
    
}
