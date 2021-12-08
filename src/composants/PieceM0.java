package composants;

/**
 * 
 * Cette classe permet de repr�senter les pi�ces du jeu de mod�le 0.
 *
 */
public class PieceM0 extends Piece {

	/**
	 * A Faire (04/05/2021 AS,B Finalis�e)
	 * 
	 * Constructeur permettant de construire une pi�ce de mod�le 0 et d'orientation 0.
	 */
	public PieceM0() {
		
		super(0,false,true,true,false); 
	}
	/**
	 * A Faire (05/05/2021 M,B,N,AS Finalis�e)
	 * 
	 * M�thode permettant de cr�er une copie de la pi�ce (un nouvelle objet Java).
	 * @return Une copie de la pi�ce.
	 */
	public Piece copy(){
		Piece piece= new PieceM0();
		piece.setOrientation(this.getOrientationPiece());
		return piece;
	}
}