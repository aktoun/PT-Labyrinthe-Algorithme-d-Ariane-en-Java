/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.algorithme.AlgoDeter;
import src.algorithme.AlgorithmeAlea;
import src.vue.GrilleManuelleAlea;
import src.vue.GrilleManuelleDeter;

public class ExecutionAlgo implements ActionListener {
	
	private JFrame fenetre;
	private String choixAlgo;
	private String methodeAlgo;
	private int[][] typecase;
	private int xThesee;
	private int yThesee;
	private int xSortie;
	private int ySortie;
	private int taille;
	

	/**
	 * Constructeur pour (GrilleExecutionAlgo et GrilleExistanteDefinitive)
	 * 
	 * @param fenetre
	 * 			JFrame
	 * @param taille
	 * 				taille de la grille
	 * @param choixAlgo
	 * 				choix de l'algorithme
	 * @param methodeAlgo
	 * 				methode choisie pour la simulation de l'algorithme
	 * @param typecase
	 * 				Type de chaque case de notre grille
	 * @param xThesee
	 * 			Position X de Thesee
	 * @param yThesee
	 * 			Position Y de Thesee
	 * @param xSortie
	 * 			Position X de la sortie
	 * @param ySortie
	 * 			Position Y de la sortie
	 */
	public ExecutionAlgo(JFrame fenetre, int taille, String choixAlgo, String methodeAlgo, int[][] typecase, 
			int xThesee, int yThesee, int xSortie, int ySortie) {
		this.fenetre = fenetre;
		this.taille = taille;
		this.choixAlgo = choixAlgo;
		this.methodeAlgo = methodeAlgo;
		this.typecase = typecase;
		this.xThesee = xThesee;
		this.yThesee = yThesee;
		this.xSortie = xSortie;
		this.ySortie = ySortie;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Si ALGORITHME DETERMINISTE .. */
		if(choixAlgo == "DETERMINISTE") {
			/* .. et si (algorithme deterministe) AUTOMATIQUE */
			if(methodeAlgo == "AUTOMATIQUE") {
				fenetre.dispose();
				int nbrEtape = 0;
				AlgoDeter algodeter = new AlgoDeter(typecase, xThesee, yThesee, xSortie, ySortie, taille);
				nbrEtape = algodeter.Nombre();

				if(nbrEtape == 0) {
					JOptionPane.showMessageDialog(null, "Aucune solutions ! Thesee ne peut rejoindre la sortie !",
							"ALGORITHME DETERMINISTE - AUTOMATIQUE",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, 
							"Le nombre d'etapes reliant Thesee a la sortie est de " + nbrEtape, 
							"ALGORITHME DETERMINISTE - AUTOMATIQUE", 
							JOptionPane.INFORMATION_MESSAGE);
				}
			} 
			/* .. ou si (algorithme deterministe) MANUELLE */
			else if(methodeAlgo == "MANUELLE") {
				new GrilleManuelleDeter(typecase,xThesee,yThesee,xSortie,ySortie,taille);
				fenetre.dispose();
			}
		} /* Si ALGORITHME ALEATOIRE .. */
		  else if(choixAlgo == "ALEATOIRE") {
			/* .. et si (algorithme aleatoire) AUTOMATIQUE */
			if(methodeAlgo == "AUTOMATIQUE") {
				fenetre.dispose();
				boolean b2 = false;
				int valTemp = 0;
				int moyenne = 0;
				
				for (int count = 0; count < 100; count++) {
					if(count == 99) {
						b2 = true;
					}
					AlgorithmeAlea algoAleaAuto = new AlgorithmeAlea(typecase, xThesee, yThesee,
							xSortie, ySortie, taille, b2);      
					/* Accumulation du nombre d'etapes a chaque lancement de l'algorithme */
					valTemp = valTemp+algoAleaAuto.Nombre();
				}
				/* Moyenne du nombre total d'etapes en 100 lancements */
				moyenne = Math.round(valTemp/100);
				/* Cette moyenne permet aussi de nous informer si Thesee ou la sortie est bloque */
				if(moyenne == 0) {
					/* JOptionPane permet de faire apparaitre facilement une boite de dialogue 
					 * standard qui permet a l'utilisateur d'etre informe de quelque chose. */
					JOptionPane.showMessageDialog(null, "Ce labyrinthe est impossible car Thesee ne peux pas rejoindre la sortie !",
							"ALGORITHME ALEATOIRE - AUTOMATIQUE",
							JOptionPane.PLAIN_MESSAGE,
							new ImageIcon("img/01.gif"));
				}
				if(moyenne != 0) {
					
					JOptionPane.showMessageDialog(null, 
							"Apres 100 simulations, le nombre d'etapes moyen reliant Thesee a la sortie est de " + moyenne + " !", 
							"ALGORITHME ALEATOIRE - AUTOMATIQUE",
							JOptionPane.PLAIN_MESSAGE,
							new ImageIcon("img/02.gif"));
				}
			}
			/* .. ou si (algorithme aleatoire) MANUELLE */
			else if(methodeAlgo == "MANUELLE") {
				new GrilleManuelleAlea(typecase,xThesee,yThesee,xSortie,ySortie,taille);
				fenetre.dispose();
			}
		}	
	}

}