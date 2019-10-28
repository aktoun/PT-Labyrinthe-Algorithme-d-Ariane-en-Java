/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 *
 */

package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import src.vue.GrilleExistanteDefinitive;
import src.vue.GrilleExistante;

public class DonneesGrilleExistante implements ActionListener {
	
	private GrilleExistante mGrille;
	private JRadioButton btnAlgoAlea;
	private JRadioButton btnAlgoDeter;
	private JRadioButton btnMetAutomatique;
	private JRadioButton btnMetManuelle;

	private int[][] typecase;
    private int xThesee;
    private int yThesee;
    private int xSortie;
    private int ySortie;
    private int taille;

	/**
	 * Constructeur pour la classe GrilleExistante qui appelle cette ce .java
	 * 
	 * @param mGrille
	 * 			notre GrilleExistante
	 * @param btnAlgoAlea
	 * 			Bouton Algorithme Aleatoire
	 * @param btnAlgoDeter
	 * 			Bouton Algorithme Deterministe
	 * @param btnMetAutomatique
	 * 			Bouton Methode Automatique
	 * @param btnMetManuelle
	 * 			Bouton Methode Manuelle
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
	public DonneesGrilleExistante(GrilleExistante mGrille, 
			JRadioButton btnAlgoAlea, JRadioButton btnAlgoDeter, 
			JRadioButton btnMetAutomatique, JRadioButton btnMetManuelle, 
			int[][] typecase, int xThesee, int yThesee, 
			int xSortie, int ySortie, int taille) {
		this.mGrille = mGrille;
		this.btnAlgoAlea = btnAlgoAlea;
		this.btnAlgoDeter = btnAlgoDeter;
		this.btnMetAutomatique = btnMetAutomatique;
		this.btnMetManuelle = btnMetManuelle;
		this.typecase = typecase;
        this.xThesee = xThesee;
        this.yThesee = yThesee;
        this.xSortie = xSortie;
        this.ySortie = ySortie;
        this.taille = taille;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		/* Si j'ai clique sur le bouton OK de notre MenuGrille alors .. */
		if(btn.equals("CREER LA GRILLE")) {
			
				/* .. j'envoie les caracteristiques de la grille choisies par l'utilisateur 
				 * vers CreerGrille */
				new GrilleExistanteDefinitive(getChoixAlgo(), getMethodeAlgo(),
						this.typecase, this.xThesee,
						this.yThesee, this.xSortie,
						this.ySortie,this.taille);
				mGrille.dispose();
		}

	}

	/** 
	 * Traitement du choix de l'algorithme
	 * 
	 * @return String choixAlgo
	 */
	private String getChoixAlgo() {
		String choixAlgo = new String();
		if(btnAlgoAlea.isSelected()) {
			choixAlgo = btnAlgoAlea.getText();
		} else {
			choixAlgo = btnAlgoDeter.getText();
		}
		return choixAlgo;
	}
	
	/** 
	 * Traitement de la methode de l'algorithme
	 * 
	 * @return String methodeAlgo
	 */
	private String getMethodeAlgo() {
		String methodeAlgo = new String();
		if(btnMetManuelle.isSelected()) {
			methodeAlgo = btnMetManuelle.getText();
		} else if(btnMetAutomatique.isSelected()) {
			methodeAlgo = btnMetAutomatique.getText();
		}
		return methodeAlgo;
	}

}