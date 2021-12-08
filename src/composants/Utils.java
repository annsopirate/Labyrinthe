package composants;

import java.util.Date;
import java.util.Random;

/**
 * 
 * Classe contenant quelques fonctions utilitaires.
 * 
 */
public class Utils {
	
	private static Random generateur=new Random((new Date().getTime()));

	/**
	 * A Faire (30/04/21 AS,B Finalis�e)
	 * 
	 * M�thode permettant de g�n�rer al�atoirement un nombre entier.
	 * 
	 * @param max Le nombre entier maximal pouvant �tre retourn�.
	 * @return Un nombre entier compris entre 0 et max (inclus).
	 */
	
	public static int genererEntier(int max){
		Random generateur = new Random();
		int nb;
		nb = generateur.nextInt(max);
		return nb;
	}
	
	
	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode permettant de g�n�rer un tableau d'entiers dont la longueur longTab est donn�e en param�tre.
	 * Le tableau g�n�r� doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
	 * dans le tableau doit �tre al�atoire.
	 * 
	 * @param longTab La longueur du tableau.
	 * @return Un tableau contenant les entiers 0,...,longTab-1 plac�s al�atoirement dans le tableau.
	 */
	public static int[] genereTabIntAleatoirement(int longTab){
		int tab[] = new int[longTab];
        int i = 0;
        boolean dansTableau;
        while(i != longTab) { //tant que i diff�rent de longueur tab
            tab[i] = generateur.nextInt(longTab); //je g�n�re un nb al�atoire
            dansTableau = false;
            for(int j=0; j<i; j++) {  //de j jusqu'� i (non inclus) for(int j=0; j!=i; j++)
                if(tab[j] == tab[i]) { //je v�rifie si le nombre actuel est �gal aux nombres pr�c�dents
                    dansTableau = true; //si c'est le cas, je passe � true donc je n'incr�mente pas i, un nouveau nombre est alors g�n�r�
                }
            }
            if(!dansTableau) {
                i++;
            }
        }
        return tab;
    }
	
	
	
	/**
	 * Programme testant la m�thode genereTabIntAleatoirement.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		int tab[]=genereTabIntAleatoirement(18);
		for (int i=0;i<tab.length;i++)
			System.out.print(tab[i]+" ");

	}

}