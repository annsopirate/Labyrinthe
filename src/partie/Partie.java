package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import joueurs.JoueurOrdinateur;

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les éléments de la partie.

	/**
	 * 
	 * A Faire (02/06/2021 B,N,M,AS Finalis�e)
	 * 
	 * Constructeur permettant de créer et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();
		// On affiche l'ensemble des �l�ments
		// A Compl�ter
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres(); // On ouvre la fen�tre de param�trage pour la saisie
		Plateau plateau=new Plateau();
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		
		// Cr�ation de la fen�tre de jeu et affichage de la fen�tre 
		int nbJoueurs=joueurs.length; // R�cup�ration du nombre de joueurs
		IG.creerFenetreJeu("D�mo Team Foxers Librairie IG version 1.9", nbJoueurs); // On cr�e la fen�tre
		//IG.rendreVisibleFenetreJeu();
	}

	/**
	 * Méthode permettant de paramètrer et initialiser les éléments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des différents paramètres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// Création des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// Création des éléments de la partie
		elementsPartie=new ElementsPartie(joueurs);
	}


	/**
	 * 
	 * A Faire (02/06/2021 B,N,M,AS Finalis�e)
	 * 
	 * Méthode permettant de lancer une partie.
	 */
	public void lancer(){
		
        IG.rendreVisibleFenetreJeu();
	}

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		while(true){
			Partie partie=new Partie();
			partie.lancer();
		}
	}

}