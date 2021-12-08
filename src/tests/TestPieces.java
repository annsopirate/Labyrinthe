package tests;

import grafix.interfaceGraphique.IG;
import composants.Piece;

public class TestPieces {
    public static void main(String[] args) {
        Object parametres[];
        parametres=IG.saisirParametres(); // On ouvre la fen�tre de param�trage pour la saisie
        
        
        // Cr�ation de la fen�tre de jeu et affichage de la fen�tre 
        int nbJoueurs=((Integer)parametres[0]).intValue(); // R�cup�ration du nombre de joueurs
        IG.creerFenetreJeu("D�mo Team Foxers Librairie IG version 1.9", nbJoueurs); // On cr�e la fen�tre
        IG.rendreVisibleFenetreJeu();  // On rend visible la fen�tre de jeu
        
        String message[]={
                "",
                "",
                "Cliquez pour continuer...",
                ""
        };
        IG.afficherMessage(message); // On change de message de la fen�tre de jeu
        IG.miseAJourAffichage();
        IG.attendreClic();
        
       
        
        Piece.nouvellesPieces();
        for (int i=0;i<Piece.nouvellesPieces().length;i++) {
        	  System.out.print(Piece.nouvellesPieces()[i]+"\n");
        	//System.out.println(Piece.nouvellesPieces());
        	//IG.changerPiecePlateau(i, j, 2, 0); //ligne, colonne, modelePiece, orientationPiece (type)
        	  }
        
      //Changer les pi�ces du plateau (6x6)
       int cpt = 0;
       for (int i=0; i<=6; i++) {
            for (int j=0; j<=6; j++) {
                IG.changerPiecePlateau(i, j, Piece.nouvellesPieces()[cpt].getModelePiece(), Piece.nouvellesPieces()[cpt].getOrientationPiece()); //ligne, colonne, modelePiece, orientationPiece (type)
                cpt++;
                IG.miseAJourAffichage();
            }
        }
       
       IG.changerPieceHorsPlateau(Piece.nouvellesPieces()[49].getModelePiece(), Piece.nouvellesPieces()[49].getOrientationPiece()); //modelePiece, orientationPiece (type)
       IG.miseAJourAffichage();
       
       
      
       for(int x = 0; x<4; x++) {
           int compteur_3 = 0;
           for (int i = 0; i < 7; i++) {
               for (int j = 0; j < 7; j++) {
                   Piece.nouvellesPieces()[compteur_3].rotation();
                   IG.changerPiecePlateau(i, j, Piece.nouvellesPieces()[compteur_3].getModelePiece(), Piece.nouvellesPieces()[compteur_3].getOrientationPiece());
                   compteur_3++;
               }
           }
           Piece.nouvellesPieces()[49].rotation();
           IG.changerPieceHorsPlateau(Piece.nouvellesPieces()[Piece.nouvellesPieces().length-1].getModelePiece() ,Piece.nouvellesPieces()[Piece.nouvellesPieces().length-1].getOrientationPiece());
           System.out.println(Piece.nouvellesPieces()[Piece.nouvellesPieces().length-1].toString());
           IG.miseAJourAffichage();
           IG.attendreClic();
       }
       
        
        
        //IG.changerPiecePlateau(Piece.nouvellesPieces()[2].rotation(),);
        //IG.miseAJourAffichage();
        
    }
   
    
}