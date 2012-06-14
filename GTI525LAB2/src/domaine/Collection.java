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
		metropolis.setNom("Métropolis");
		metropolis.setId(2002);
		
		jeanDrapeau = new Salle();
		jeanDrapeau.setAdresse("Ile ste Helene");
		jeanDrapeau.setNbPlaceMax(10000);
		jeanDrapeau.setNom("Parc Jean-Drapeau");
		jeanDrapeau.setId(2003);
	}
	
	private void createRepresentations(){
		juin11CentreBell = new Representation();
		juin11CentreBell.setBilletsDispo(centreBell.getNbPlaceMax());
		juin11CentreBell.setDate(new Date(2012,06,11,18,0));
		juin11CentreBell.setSalle(centreBell);
		juin11CentreBell.setPrix(60);
		juin11CentreBell.setId(3001);
		
		juin12CentreBell = new Representation();
		juin12CentreBell.setBilletsDispo(centreBell.getNbPlaceMax());
		juin12CentreBell.setDate(new Date(2012,06,12,18,0));
		juin12CentreBell.setSalle(centreBell);
		juin12CentreBell.setPrix(30.30);
		juin12CentreBell.setId(3002);
		
		juin13CentreBell = new Representation();
		juin13CentreBell.setBilletsDispo(centreBell.getNbPlaceMax());
		juin13CentreBell.setDate(new Date(2012,06,13,18,0));
		juin13CentreBell.setSalle(centreBell);
		juin13CentreBell.setPrix(100.12);
		juin13CentreBell.setId(3003);
		
		juin14Metropolis = new Representation();
		juin14Metropolis.setBilletsDispo(metropolis.getNbPlaceMax());
		juin14Metropolis.setDate(new Date(2012,06,14,18,0));
		juin14Metropolis.setSalle(metropolis);
		juin14Metropolis.setPrix(55.50);
		juin14Metropolis.setId(3004);
		
		juin15Metropolis = new Representation();
		juin15Metropolis.setBilletsDispo(metropolis.getNbPlaceMax());
		juin15Metropolis.setDate(new Date(2012,06,15,18,0));
		juin15Metropolis.setSalle(metropolis);
		juin15Metropolis.setPrix(60);
		juin15Metropolis.setId(3005);
		
		juin16Metropolis = new Representation();
		juin16Metropolis.setBilletsDispo(metropolis.getNbPlaceMax());
		juin16Metropolis.setDate(new Date(2012,06,16,18,0));
		juin16Metropolis.setSalle(metropolis);
		juin16Metropolis.setPrix(123);
		juin16Metropolis.setId(3006);
		
		juin17JDrapeau = new Representation();
		juin17JDrapeau.setBilletsDispo(jeanDrapeau.getNbPlaceMax());
		juin17JDrapeau.setDate(new Date(2012,06,17,18,0));
		juin17JDrapeau.setSalle(jeanDrapeau);
		juin17JDrapeau.setPrix(45);
		juin17JDrapeau.setId(3007);
		
		juin18JDrapeau = new Representation();
		juin18JDrapeau.setBilletsDispo(jeanDrapeau.getNbPlaceMax());
		juin18JDrapeau.setDate(new Date(2012,06,18,18,0));
		juin18JDrapeau.setSalle(jeanDrapeau);
		juin18JDrapeau.setPrix(34);
		juin18JDrapeau.setId(3008);
		
		juin19JDrapeau = new Representation();
		juin19JDrapeau.setBilletsDispo(jeanDrapeau.getNbPlaceMax());
		juin19JDrapeau.setDate(new Date(2012,06,19,18,0));
		juin19JDrapeau.setSalle(jeanDrapeau);
		juin19JDrapeau.setPrix(67.66);
		juin19JDrapeau.setId(3009);
		
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
		sliseDion.setId(5001);
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
		speterMacLeod.setId(5002);
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
		selvis.setId(5003);
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
    
    public String[] getSpectaclesTitres(){
        String[] titres = new String[maCollection.size()];
        for (int i=0;i<maCollection.size();i++){
        	titres[i] = maCollection.get(i).getNom();
        }
        return titres;
    }
    
    public String[] getSpectaclesDescriptions(){
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
    
    public Integer[] getSpectaclesids(){
        Integer[] ids = new Integer[maCollection.size()];
        for (int i=0;i<maCollection.size();i++){
        	ids[i] = maCollection.get(i).getId();
        }
        return ids;
    }

    public String[] getSpectaclesRepresentationsSalles(int id){
        String[] salles = new String[maCollection.get(id).getNbRepresentations()];
        for (int i=0;i<maCollection.get(id).getNbRepresentations();i++){
        	salles[i] = maCollection.get(id).getRepresentation(i).getSalle().getNom();
        }
        return salles;
    }
    public int[] getSpectaclesRepresentationsPlaces(int id){
        int[] places = new int[maCollection.get(id).getNbRepresentations()];
        for (int i=0;i<maCollection.get(id).getNbRepresentations();i++){
        	places[i] = maCollection.get(id).getRepresentation(i).getBilletsDispo();
        }
        return places;
    }
    public int[] getSpectaclesRepresentationsJours(int id){
        int[] jours = new int[maCollection.get(id).getNbRepresentations()];
        for (int i=0;i<maCollection.get(id).getNbRepresentations();i++){
        	jours[i] = maCollection.get(id).getRepresentation(i).getDate().getDate();
        }
        return jours;
    }
    public int[] getSpectaclesRepresentationsMois(int id){
        int[] mois = new int[maCollection.get(id).getNbRepresentations()];
        for (int i=0;i<maCollection.get(id).getNbRepresentations();i++){
        	mois[i] = maCollection.get(id).getRepresentation(i).getDate().getMonth();
        }
        return mois;
    }
    public int[] getSpectaclesRepresentationsAnnee(int id){
        int[] annee = new int[maCollection.get(id).getNbRepresentations()];
        for (int i=0;i<maCollection.get(id).getNbRepresentations();i++){
        	annee[i] = maCollection.get(id).getRepresentation(i).getDate().getYear();
        }
        return annee;
    }
    public int[] getSpectaclesRepresentationsHeure(int id){
        int[] annee = new int[maCollection.get(id).getNbRepresentations()];
        for (int i=0;i<maCollection.get(id).getNbRepresentations();i++){
        	annee[i] = maCollection.get(id).getRepresentation(i).getDate().getHours();
        }
        return annee;
    }
    public int[] getSpectaclesRepresentationsMinutes(int id){
        int[] annee = new int[maCollection.get(id).getNbRepresentations()];
        for (int i=0;i<maCollection.get(id).getNbRepresentations();i++){
        	annee[i] = maCollection.get(id).getRepresentation(i).getDate().getMinutes();
        }
        return annee;
    }
    
    public double[] getSpectaclesRepresentationsPrix(int id){
    	double[] prix = new double[maCollection.get(id).getNbRepresentations()];
        for (int i=0;i<maCollection.get(id).getNbRepresentations();i++){
        	prix[i] = maCollection.get(id).getRepresentation(i).getPrix();
        }
        return prix;
    }
}
