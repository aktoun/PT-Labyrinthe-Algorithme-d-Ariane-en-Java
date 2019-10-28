/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 *
 */

package src.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.algorithme.AlgoDeter;

import java.util.LinkedList;

public class ToucheEntreeDeter implements KeyListener {
	
	private JFrame fenetre;
	private int[][] typecase;
	private int xThesee;
	private int yThesee;
	private int xSortie;
	private int ySortie;
	private int taille;

	private LinkedList<Integer> fileofX;
	private LinkedList<Integer> fileofY;
	private int nbrDeplacement;
	private int compteur=0;

	/**
	 * 
	 * @param fenetre
	 * 			JFrame pour notre fenetre
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
	public ToucheEntreeDeter(JFrame fenetre,int[][] typecase, 
			int xThesee, int yThesee, int xSortie, int ySortie, int taille) {
		this.fenetre = fenetre;
		this.typecase = typecase;
		this.xThesee = xThesee;
		this.yThesee = yThesee;
		this.xSortie = xSortie;
		this.ySortie = ySortie;
		this.taille = taille;

		AlgoDeter algo = new AlgoDeter(this.typecase, this.xThesee, this.yThesee,
				this.xSortie, this.ySortie, this.taille);

		this.fileofX=algo.recupFileX();
		this.fileofY=algo.recupFileY();
		this.nbrDeplacement=algo.Nombre();

		for(int i=0; i<taille;i++) {
			for (int j=0; j<taille;j++) {
				if(this.typecase[i][j]==4) {
					this.typecase[i][j]=0;
				}
			}
		}

		this.typecase[this.xThesee][this.yThesee]=2;
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		int etat = 0;
		int xSuivant;
		int ySuivant;

		if(this.nbrDeplacement == 0) {
			JOptionPane.showMessageDialog(null, "Thesee est bloquee, impossible de rejoindre la sortie !",
						"ALGORITHME DET - MANUELLE", 	JOptionPane.INFORMATION_MESSAGE);
			fenetre.dispose();
			etat = 1;
		}

		if(compteur < this.nbrDeplacement-1) {
			xSuivant = this.fileofX.get(1);
			ySuivant = this.fileofY.get(1);
			this.typecase[xSuivant][ySuivant] = 4;
		}

		compteur++;

		this.typecase[this.xThesee][this.yThesee] = 0;
		this.xThesee=this.fileofX.poll();
		this.yThesee=this.fileofY.poll();
		this.typecase[this.xThesee][this.yThesee] = 2;
		fenetre.repaint();
		fenetre.setVisible(true);

		if(compteur==this.nbrDeplacement+1 && etat==0) {
			JOptionPane.showMessageDialog(null, "Thesee a rejoint la sortie ! ",
						"ALGORITHME DET - MANUELLE", 	JOptionPane.INFORMATION_MESSAGE);
			fenetre.dispose();
		}


		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
}