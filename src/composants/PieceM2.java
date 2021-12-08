package composants;

/**
 * 
 * Cette classe permet de repr�senter les pi�ces du jeu de mod�le 2.
 *
 */
public class PieceM2 extends Piece {

	/**
	 * A Faire (04/05/2021 AS,B Finalis�e)
	 * 
	 * Constructeur permettant de construire une pièce de modèle 2 et d'orientation 0.
	 */
	public PieceM2() {
		
		super(2,true,true,false,true); 
	}
	/**
	 * A Faire (05/05/2021 M,B,N,AS Finalis�e)
	 * 
	 * M�thode permettant de cr�er une copie de la pi�ce (un nouvelle objet Java).
	 * @return Une copie de la pi�ce.
	 */
	public Piece copy(){
		Piece piece= new PieceM2();
		piece.setOrientation(this.getOrientationPiece());
		return piece;
	}
}