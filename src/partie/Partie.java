package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import joueurs.JoueurOrdinateur;

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les Ã©lÃ©ments de la partie.

	/**
	 * 
	 * A Faire (02/06/2021 B,N,M,AS Finalisée)
	 * 
	 * Constructeur permettant de crÃ©er et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();
		// On affiche l'ensemble des éléments
		// A Compléter
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres(); // On ouvre la fenêtre de paramètrage pour la saisie
		Plateau plateau=new Plateau();
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		
		// Création de la fenêtre de jeu et affichage de la fenêtre 
		int nbJoueurs=joueurs.length; // Récupération du nombre de joueurs
		IG.creerFenetreJeu("Démo Team Foxers Librairie IG version 1.9", nbJoueurs); // On crée la fenêtre
		//IG.rendreVisibleFenetreJeu();
	}

	/**
	 * MÃ©thode permettant de paramÃ¨trer et initialiser les Ã©lÃ©ments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des diffÃ©rents paramÃ¨tres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// CrÃ©ation des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// CrÃ©ation des Ã©lÃ©ments de la partie
		elementsPartie=new ElementsPartie(joueurs);
	}


	/**
	 * 
	 * A Faire (02/06/2021 B,N,M,AS Finalisée)
	 * 
	 * MÃ©thode permettant de lancer une partie.
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