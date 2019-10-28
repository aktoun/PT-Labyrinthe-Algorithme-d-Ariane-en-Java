/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import src.vue.GrilleAlea;

public class ActionGrille implements ActionListener {
	
	private JFrame fenetre;
	private int taille;
	private String choixAlgo;
	private String methodeAlgo;
	
	/**
	 * Constructeur pour ActionGrille venant de GrilleExistante
	 * 
	 * @param fenetre
	 * 			JFrame correspondant a la fenetre de la grille
	 */
	public ActionGrille(JFrame fenetre) {
		this.fenetre = fenetre;
	}
	
	/**
	 * Constructeur pour ActionGrille venant des grilles creees dans le programme
	 * (utilisee pour GrilleAlea et GrilleExistanteDefinitiv)
	 * 
	 * @param fenetre
	 * 			JFrame correspondant a la fenetre de la grille
	 * @param taille
	 * 			Taille de notre grille
	 * @param choixAlgo
	 * 			Choix de l'algorithme
	 * @param methodeAlgo
	 * 			Methode utilisee par l'algorithme pour la simulation (auto ou manuelle)
	 */
	public ActionGrille(JFrame fenetre, int taille, String choixAlgo, String methodeAlgo) {
		this.fenetre = fenetre;
		this.taille = taille;
		this.choixAlgo = choixAlgo;
		this.methodeAlgo = methodeAlgo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		
		/* Si je veux fermer la grille .. */
		if(btn.equals("FERMER")) {
			this.fenetre.dispose();
		}
		
		/* .. Ou si je souhaite obtenir une nouvelle grille aleatoire  */
		else if(btn.equals("NOUVELLE GRILLE ALEATOIRE")) {
			this.fenetre.dispose();
			new GrilleAlea(taille, choixAlgo, methodeAlgo);
 		}
 	}
}