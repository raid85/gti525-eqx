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
		metropolis.setNom("Métropolis");
		
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
		sliseDion.setDescription("Mis en scène par Michel Courtemanche, Le temps qui court propose une réflexion sur le temps qui passe et les différentes étapes de la vie : il y est question de la vieillesse et de la mort, mais à la manière de Lise Dion bien sûr. En plus de donner des détails sur ce qu’elle a fait pendant son absence des planches qui a duré six ans, elle nous donne aussi des nouvelles de Marcel et de ses ados… qui, en principe, ne sont plus des ados. Parmi les multiples sujets abordés, l’humoriste revient avec le personnage de la femme afghane qui découvre les avantages de son costume et propose une réflexion sur les hommes qui partent avec des femmes plus jeunes… Tout un programme!/n Le temps qui court est le 3e spectacle que présente Lise Dion en carrière. Son premier spectacle a raflé 3 Félix et a été présenté 50 fois au Théâtre St-Denis 1, ce qui fait de Lise la seule femme et une des rares artistes à avoir réussi un tel exploit. Lise Dion s’est vu remettre une plaque soulignant la vente de 140,000 billets vendus de son nouveau spectacle. C’est assurément un retour en force pour l’humoriste chouchou des Québécois!");
		sliseDion.setDuree(120);
		sliseDion.setImage("images/lisedion2011tpro.jpg");
		sliseDion.setNom("Lise Dion Spectacle");
		sliseDion.ajouterRepresentation(juin11CentreBell);
		sliseDion.ajouterRepresentation(juin14Metropolis);
		sliseDion.ajouterRepresentation(juin17JDrapeau);
		maCollection.add(sliseDion);
		
		speterMacLeod = new Spectacle();
		speterMacLeod.setArtiste(apeterMacLeod);
		speterMacLeod.setDescription("Après s’être lui-même canonisé Saint, l’humoriste à la gueule sympathique et aux propos corrosifs revient sur scène avec son 4e one man show Sagesse Reportée, qui confronte l’humoriste avec la quarantaine et ses implications. En effet, MacLeod devrait prêcher par l’exemple et devenir socialement plus sage. Il devrait avoir une femme et non une blonde, un compte conjoint, un mini-van, un abonnement au Costco, une passe de saison au golf, s’intéresser soudainement au Cirque du Soleil et au train de Josélito! Mais, sa quête de liberté l’amène à laisser son auréole de côté pour nous prouver que vieillir n’est pas synonyme de s’assagir. Que ce soit la surconsommation, la société matriarcale, les jeunes, le couple, ses opinions sont tranchantes et assumées. Drôle, percutant et touchant, le justicier aux 700 000 billets vendus en carrière nous prouve avec ce quatrième rendez-vous, à la mise en scène spectaculaire, qu’il fait toujours partie de l’élite humoristique au Québec.");
		speterMacLeod.setDuree(120);
		speterMacLeod.setImage("images/peter.jpg");
		speterMacLeod.setNom("Peter Spectacle");
		speterMacLeod.ajouterRepresentation(juin12CentreBell);
		speterMacLeod.ajouterRepresentation(juin15Metropolis);
		speterMacLeod.ajouterRepresentation(juin18JDrapeau);
		maCollection.add(speterMacLeod);
		
		selvis = new Spectacle();
		selvis.setArtiste(aelvis);
		selvis.setDescription("Ce juillet, Robert Baggio est Elvis ! \nSur scène, Baggio offre ses interprétations des succès d’Elvis avec une voix étonnamment ressemblante. Il est entouré par des musiciens et choristes de talent, dont certains ont participé aux tournées d’artistes reconnus de Star Académie, Garou, Marie-Mai, Dan Bigras et de plusieurs autres. \nLe concert énergisant Viva Las Vegas inclura des classiques originaux du King et des remakes avec une touche moderne.\n Le tout pour garder la mémoire d'Elvis vivante avec une présentation inoubliable dans l'espoir de vous faire revivre un vrai concert du King.");
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
