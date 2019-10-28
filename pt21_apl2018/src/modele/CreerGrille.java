/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.modele;

import src.vue.GrilleAlea;
import src.vue.GrilleVide;

public class CreerGrille {
	
	private String type;

	/**
	 * 
	 * @param tailleGrille
	 * 			Taille de la grille
	 * @param typeGrille
	 * 			GrilleVide ou GrilleAlea
	 * @param choixAlgo
	 * 			Choix de l'algorithme
	 * @param methodeAlgo
	 * 			Methode utilisee pour la simulation de notre algorithme
	 */
	public CreerGrille(int tailleGrille, String typeGrille, String choixAlgo, String methodeAlgo) {
		this.type = typeGrille;
		/* Si l'utilisateur a choisi d'utiliser une grille vide alors .. */
		if(type.equals("GRILLE VIDE")) {
			/* .. creation d'une grille vide avec la taille donnee (avec les options selectionnes 
			 * pour l'algorithme) */
			new GrilleVide(tailleGrille, choixAlgo, methodeAlgo);
			/* .. sinon */
		} else {
			/* .. creation d'une grille remplie aleatoirement avec la taille donnee (avec les 
			 * options selectionnes pour l'algorithme) */
			new GrilleAlea(tailleGrille, choixAlgo, methodeAlgo);
		}
	}
	
}
