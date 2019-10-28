/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import src.vue.GrilleExecutionAlgo;


public class Validation implements ActionListener {
	
	private JFrame fenetre;
	private int[][] typecase;
	private int xThesee;
	private int yThesee;
	private int xSortie;
	private int ySortie;
	private int taille;
	private String choixAlgo;
	private String methodeAlgo;

	
	/**
	 * Constructeur utile pour GrilleAlea
	 * 
	 * @param choixAlgo
	 * 			Choix de notre algorithme
	 * @param methodeAlgo
	 * 			Methode utilisee pour notre algorithme
	 * @param fenetre
	 * 			JFrame
	 * @param typecase
	 * 			typecase
	 * @param xThesee
	 * 			Position X de Thesee
	 * @param yThesee
	 * 			Position Y de Thesee
	 * @param xSortie
	 * 			Position X de la sortie
	 * @param ySortie
	 * 			Position Y de la sortie
	 * @param taille
	 * 			Taille de notre grille
	 */
	public Validation(String choixAlgo, String methodeAlgo, JFrame fenetre,int[][] typecase, 
			int xThesee, int yThesee, int xSortie, int ySortie, int taille) {
		this.fenetre = fenetre;
		this.typecase = typecase;
		this.xThesee = xThesee;
		this.yThesee = yThesee;
		this.xSortie = xSortie;
		this.ySortie = ySortie;
		this.taille = taille;
		this.choixAlgo=choixAlgo;
		this.methodeAlgo=methodeAlgo;
	}

	/**
	 * Constructeur utile pour GrilleVide
	 * 
	 * @param choixAlgo
	 * 			Choix de notre algorithme
	 * @param methodeAlgo
	 * 			Methode utilisee pour notre algorithme
	 * @param fenetre
	 * 			JFrame
	 * @param typecase
	 * 			typecase
	 * @param taille
	 * 			Taille de notre grille
	 */
	public Validation(String choixAlgo, String methodeAlgo, JFrame fenetre, int[][] typecase, int taille) {
		this.fenetre = fenetre;
		this.typecase = typecase;
		this.taille = taille;
		this.choixAlgo=choixAlgo;
		this.methodeAlgo=methodeAlgo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();

		if(btn.equals("VALIDER")) {
			this.fenetre.dispose();
			new GrilleExecutionAlgo(choixAlgo, methodeAlgo, typecase, 
					xThesee, yThesee, xSortie, ySortie, taille);
		}
	}	
}
