package tests;

import grafix.interfaceGraphique.IG;

public class MaDemoIG {
	public static void main(String[] args) {
		Object parametres[];
		parametres=IG.saisirParametres(); // On ouvre la fenêtre de paramètrage pour la saisie
		
		// Création de la fenêtre de jeu et affichage de la fenêtre 
		int nbJoueurs=((Integer)parametres[0]).intValue(); // Récupération du nombre de joueurs
		IG.creerFenetreJeu("Démo Team Foxers Librairie IG version 1.9", nbJoueurs); // On crée la fenêtre
		IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu
		
		// Affichage du message de bienvenue
				String message[]={
							"",
							"Bonjour !",
							"Cliquez pour continuer...",
							""
				};
				IG.afficherMessage(message); // On change de message de la fenêtre de jeu
				
				// Changement des caractéristiques du premier joueur avec les paramètres saisis
				int numImageJoueur0=((Integer)parametres[3]).intValue(); //joueur 0*3+3=3
				String nomJoueur0=(String)parametres[1]; //joueur 0*3+1=1
				String categorieJoueur0=(String)parametres[2]; //joueur 0*3+2=2
				//IG.attendreClic();
				IG.changerNomJoueur(0, nomJoueur0+" ("+categorieJoueur0+")");
				IG.changerImageJoueur(0,numImageJoueur0);
				
				// Changement des caractéristiques du second joueur avec les paramètres saisis
				int numImageJoueur1=((Integer)parametres[6]).intValue(); //joueur 1*3+3=6
				String nomJoueur1=(String)parametres[4]; //joueur 1*3+1=4
				String categorieJoueur1=(String)parametres[5]; //joueur 1*3+2=5
				//IG.attendreClic();
				IG.changerNomJoueur(1, nomJoueur1+" ("+categorieJoueur1+")");
				IG.changerImageJoueur(1,numImageJoueur1);
				
				// Changement des caractéristiques du troisième joueur avec les paramètres saisis
				int numImageJoueur2=((Integer)parametres[9]).intValue(); //joueur 2*3+3=9
				String nomJoueur2=(String)parametres[7]; //joueur 2*3+1=7
				String categorieJoueur2=(String)parametres[8]; //joueur 2*3+2=8
				//IG.attendreClic();
				IG.changerNomJoueur(2, nomJoueur2+" ("+categorieJoueur2+")");
				IG.changerImageJoueur(2,numImageJoueur2);
				IG.miseAJourAffichage();
				
				// Changement d'objets des joueurs
				for (int i=0;i<6;i++) {
					IG.changerObjetJoueur(0,i,i); //num joueur,num objet (entre 0 et 17),position
					IG.changerObjetJoueur(1,i+6,i);
					IG.changerObjetJoueur(2,i+12,i);
				}
				
				//Changer les pièces du plateau (6x6)
				for (int i=0; i<=6; i++) {
					for (int j=0; j<=6; j++) {
						IG.changerPiecePlateau(i, j, 2, 0); //ligne, colonne, modelePiece, orientationPiece (type)
					}
				}
				
				// Change la pièce hors du plateau
				IG.changerPieceHorsPlateau(1,0); //modelePiece, orientationPiece (type)
	}

}
