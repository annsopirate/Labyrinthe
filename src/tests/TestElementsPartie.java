package tests;

import partie.ElementsPartie;
import composants.Plateau;
import composants.Piece;
import joueurs.Joueur;
import grafix.interfaceGraphique.IG;

public class TestElementsPartie {
    
    public static void main(String[] args) {
        Object parametresJeu[];
        parametresJeu=IG.saisirParametres();
        int  nbJoueurs=((Integer)parametresJeu[0]).intValue();
        IG.creerFenetreJeu("- TestElementsPartie",nbJoueurs);
        Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
        ElementsPartie elementsPartie=new ElementsPartie(joueurs);
        IG.creerFenetreJeu("TestElements Team Foxers Librairie IG version 1.9", nbJoueurs); // On créé la fenêtre
        IG.rendreVisibleFenetreJeu();
        
        // Affichage du message de bienvenue + mise à jour affichage + attente clic
        String message[]={
                    "",
                    "Bonjour !",
                    "Cliquez pour continuer...",
                    ""
        };
        IG.afficherMessage(message); // On change de message de la fenêtre de jeu
        IG.miseAJourAffichage();
        IG.attendreClic();
    }

}