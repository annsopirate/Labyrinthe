package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import composants.Utils;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

/**
 * 
 * Cette classe permet de repr�senter un ensemble d'�lements composant une partie de jeu.
 * 
 */
public class ElementsPartie {

	private Joueur[] joueurs; 	// Les joueurs de la partie.
	private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs num�ros.
	private Plateau plateau; 	// Le plateau des pi�ces.
	private Piece pieceLibre; 	// La pi�ce libre.
	private int nombreJoueurs; 	// Le nombre de joueurs.

	/**
	 * 
	 * A Faire (02/06/2021 B,N,M,AS Finalisée)
	 *  
	 * Constructeur permettant de g�n�rer et d'initialiser l'ensemble des �l�ments d'une partie (sauf les joueurs qui sont donn�s en param�tres).
	 * 
	 * Un plateau est cr�� en placant 49 oi�ces de mani�re al�atoire (utilisation de la m�thode placerPiecesAleatoierment de la classe Plateau).
	 * La pi�ce restante (celle non pr�sente sur le plateau) est affect�e � la pi�ce libre.
	 * Les 18 objets sont cr��s avec des positions al�atoires sur le plateau (utilisation de la m�thode Objet.nouveauxObjets)
	 * et distribu�es aux diff�rents joueurs (utilisation de la m�thode attribuerObjetsAuxJoueurs).
	 * 
	 * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribu�s (c'est au constructeur de le faire).
	 */
	public ElementsPartie(Joueur[] joueurs) {
		
		// A Compl�ter
		// Affectation de l'argument aux donn�es
		this.joueurs = joueurs;

		// Initialisation du plateau
		this.plateau = new Plateau();
		this.pieceLibre=this.plateau.placerPiecesAleatoirement();
		for(int i=0; i<7; i++){
			for(int j=0; j<7; j++){
				IG.changerPiecePlateau(i, j, (this.plateau.getPiece(i, j)).getModelePiece(), (this.plateau.getPiece(i, j)).getOrientationPiece());
			}
		}
		IG.changerPieceHorsPlateau(this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());

		// Cr�ation des objets avec une position al�atoire
		this.objets = Objet.nouveauxObjets();
		for(int i=0; i< this.objets.length; i++){
			IG.placerObjetPlateau(this.objets[i].getNumeroObjet(), this.objets[i].getPosLignePlateau(),this.objets[i].getPosColonnePlateau());
		}

		// Affectation des objets aux joueurs
		attribuerObjetsAuxJoueurs();
	}

	/**
	 * Un simple constructeur.
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param objets Les 18 objets de la partie.
	 * @param plateau Le plateau de jeu.
	 * @param pieceLibre La pi�ce libre (la pi�ce hors plateau).
	 */
	public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
		this.joueurs=joueurs;
		nombreJoueurs=joueurs.length;
		this.objets=objets;
		this.plateau=plateau;
		this.pieceLibre=pieceLibre;
	}

	/**
	 * A Faire (02/06/2021 B,N,M,AS Finalisée)
	 * 
	 * M�thode permettant d'attribuer les objets aux diff�rents joueurs de mani�re al�atoire.
	 */
	private void attribuerObjetsAuxJoueurs(){
	
		// A Compl�ter
		this.objets = Objet.nouveauxObjets();
		int[] tab = Utils.genereTabIntAleatoirement(18);
		Objet[] liste_objet = new Objet[6];
		int inc = 0;
		for(int i =0; i<this.joueurs.length; i++){
			for(int j=0; j<liste_objet.length; j++){
				liste_objet[j] = this.objets[tab[inc]];
				inc++;
			}
			this.joueurs[i].setObjetsJoueur(liste_objet);
		}
		for(int i=0; i<this.joueurs.length; i++){
			for(int j=0; j<6; j++){
				IG.changerObjetJoueurAvecTransparence(i, this.joueurs[i].getObjetsJoueur()[j].getNumeroObjet(), j);
			}
		}
	}

	/**
	 * A Faire (28/05/2021 M Finalisée)
	 * 
	 * M�thode permettant de r�cup�rer les joueurs de la partie.
	 * @return Les joueurs de la partie.
	 */
	public Joueur[] getJoueurs() {
		return this.joueurs; // A Modifier
	}


	/**
	 * A Faire (28/05/2021 AS Finalisée)
	 * 
	 * M�thode permettant de r�cup�rer les pi�ces de la partie.
	 * @return Les objets de la partie.
	 */
	public Objet[] getObjets() {
		return this.objets; // A Modifier
	}


	/**
	 * A Faire (28/05/2021 M / AS Finalisée)
	 * 
	 * M�thode permettant de r�cup�rer le plateau de pi�ces de la partie.
	 * @return Le plateau de pi�ces.
	 */
	public Plateau getPlateau() {
		return this.plateau; // A Modifier
	}


	/**
	 * A Faire (28/05/2021 AS Finalisée)
	 * 
	 * M�thode permettant de r�cup�rer la pi�ce libre de la partie.
	 * @return La pi�ce libre.
	 */
	public Piece getPieceLibre() {
		return this.pieceLibre; // A Modifier
	}


	/**
	 * A Faire (28/05/2021 AS Finalisée)
	 * 
	 * M�thode permettant de r�cup�rer le nombre de joueurs de la partie.
	 * @return Le nombre de joueurs.
	 */
	public int getNombreJoueurs() {
		return this.nombreJoueurs; // A Modifier
	}


	/**
	 * A Faire (02/06/2021 B,N,M,AS Finalisée)
	 * 
	 * M�thode modifiant les diff�rents �l�ments de la partie suite � l'insertion de la pi�ce libre dans le plateau.
	 * 
	 * @param choixEntree L'entr�e choisie pour r�aliser l'insertion (un nombre entre 0 et 27).
	 */
	public void insertionPieceLibre(int choixEntree){
		// A Compl�ter
		if((choixEntree/7) == 0){
			Piece temp = this.plateau.getPiece(6, choixEntree);
			for(int i=0; i<6; i++){
				IG.changerPiecePlateau(6-i, choixEntree, this.plateau.getPiece(6-i-1, choixEntree).getModelePiece(), this.plateau.getPiece(6-i-1, choixEntree).getOrientationPiece());
				this.plateau.positionnePiece(this.plateau.getPiece(6-i-1, choixEntree), 6-i, choixEntree);
			}
			IG.changerPiecePlateau(0, choixEntree, this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());
			this.plateau.positionnePiece(this.pieceLibre, 0, choixEntree);
			this.pieceLibre = temp;
			IG.changerPieceHorsPlateau(temp.getModelePiece(), temp.getOrientationPiece());
			IG.miseAJourAffichage();
		}
		else if((choixEntree/7) == 1){
			Piece temp = this.plateau.getPiece(choixEntree%7, 0);
			for(int i=0; i<6; i++){
				IG.changerPiecePlateau(choixEntree%7, i, this.plateau.getPiece(choixEntree%7, i+1).getModelePiece(), this.plateau.getPiece(choixEntree%7, i+1).getOrientationPiece());
				this.plateau.positionnePiece(this.plateau.getPiece(choixEntree%7, i+1), choixEntree%7, i);
			}
			IG.changerPiecePlateau(choixEntree%7, 6, this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());
			this.plateau.positionnePiece(this.pieceLibre, choixEntree%7, 6);
			this.pieceLibre = temp;
			IG.changerPieceHorsPlateau(temp.getModelePiece(), temp.getOrientationPiece());
			IG.miseAJourAffichage();
		}
		else if((choixEntree/7) == 2){
			Piece temp = this.plateau.getPiece(0, 6-(choixEntree%7));
			for(int i=0; i<6; i++){
				IG.changerPiecePlateau(i, 6-(choixEntree%7), this.plateau.getPiece(i+1, 6-(choixEntree%7)).getModelePiece(), this.plateau.getPiece(i+1, 6-(choixEntree%7)).getOrientationPiece());
				this.plateau.positionnePiece(this.plateau.getPiece(i+1, 6-(choixEntree%7)), i, 6-(choixEntree%7));
			}
			IG.changerPiecePlateau(6, 6-(choixEntree%7), this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());
			this.plateau.positionnePiece(this.pieceLibre, 6, 6-(choixEntree%7));
			this.pieceLibre = temp;
			IG.changerPieceHorsPlateau(temp.getModelePiece(), temp.getOrientationPiece());
			IG.miseAJourAffichage();
		}
		else if((choixEntree/7) == 3){
			Piece temp = this.plateau.getPiece(6-(choixEntree%7), 6);
			for(int i=0; i<6; i++){
				IG.changerPiecePlateau(6-(choixEntree%7), 6-i, this.plateau.getPiece(6-(choixEntree%7), 6-i-1).getModelePiece(), this.plateau.getPiece(6-(choixEntree%7), 6-i-1).getOrientationPiece());
				this.plateau.positionnePiece(this.plateau.getPiece(6-(choixEntree%7), 6-i-1), 6-(choixEntree%7), 6-i);
			}
			IG.changerPiecePlateau(6-(choixEntree%7), 0, this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());
			this.plateau.positionnePiece(this.pieceLibre,6-(choixEntree%7), 0 );
			this.pieceLibre = temp;
			IG.changerPieceHorsPlateau(temp.getModelePiece(), temp.getOrientationPiece());
			IG.miseAJourAffichage();
		}
	}


	/**
	 * M�thode retournant une copie.
	 * 
	 * @return Une copie des �l�ments.
	 */
	public ElementsPartie copy(){
		Objet[] nouveauxObjets=new Objet[(this.objets).length];
		for (int i=0;i<objets.length;i++)
			nouveauxObjets[i]=(this.objets[i]).copy();
		Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
		for (int i=0;i<nombreJoueurs;i++)
			nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
		Plateau nouveauPlateau=(this.plateau).copy();
		Piece nouvellePieceLibre=(this.pieceLibre).copy();
		ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre); 
		return nouveauxElements;
	}


}
