/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import src.modele.CreerGrille;
import src.vue.MenuGrille;

public class DonneesMenuGrille implements ActionListener {
	
	private MenuGrille mGrille;
	private JTextField tailleGrille;
	private JRadioButton btnGrilleVide;
	private JRadioButton btnGrilleRemplie;
	private JRadioButton btnAlgoAlea;
	private JRadioButton btnAlgoDeter;
	private JRadioButton btnMetAutomatique;
	private JRadioButton btnMetManuelle;

	/**
	 * Constructeur pour la classe MenuGrille qui appelle cette ce .java
	 * 
	 * @param mGrille
	 * 			notre MenuGrille
	 * @param tailleGrille
	 * 			la taille de notre grille
	 * @param btnGrilleVide
	 * 			Bouton pour une Grille Vide
	 * @param btnGrilleRemplie
	 * 			Bouton pour une Grille Aleatoirement remplie
	 * @param btnAlgoAlea
	 * 			Bouton algo aleatoire
	 * @param btnAlgoDeter
	 * 			Bouton algo deterministe
	 * @param btnMetAutomatique
	 * 			Bouton pour le choix de la methode (simulation auto)
	 * @param btnMetManuelle
	 * 			Bouton pour le choix de la methode (simulation manuelle)
	 */
	public DonneesMenuGrille(MenuGrille mGrille, JTextField tailleGrille, JRadioButton btnGrilleVide,
			JRadioButton btnGrilleRemplie, JRadioButton btnAlgoAlea, JRadioButton btnAlgoDeter,
			JRadioButton btnMetAutomatique, JRadioButton btnMetManuelle) {
		this.mGrille = mGrille;
		this.tailleGrille = tailleGrille;
		this.btnGrilleVide = btnGrilleVide;
		this.btnGrilleRemplie = btnGrilleRemplie;
		this.btnAlgoAlea = btnAlgoAlea;
		this.btnAlgoDeter = btnAlgoDeter;
		this.btnMetAutomatique = btnMetAutomatique;
		this.btnMetManuelle = btnMetManuelle;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		/* Si j'ai clique sur le bouton OK de notre MenuGrille alors .. */
		if(btn.equals("OK")) {
			if (tailleGrille.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Veuillez rentrer une taille pour creer la grille",
						"Erreur 'TAILLE DE LA GRILLE'",
						JOptionPane.ERROR_MESSAGE);
			} else if(getTailleGrille() == 0 || getTailleGrille() > 64) {
				JOptionPane.showMessageDialog(null, "Pour une meilleure optimisation, veuillez rentrer une taille"
						+ " comprise entre 0 et/ou egale a 64 !",
						"Erreur 'TAILLE DE LA GRILLE'",
						JOptionPane.ERROR_MESSAGE);
			} else {
				/* .. j'envoie les caracteristiques de la grille choisies par l'utilisateur 
				 * vers CreerGrille */
				new CreerGrille(getTailleGrille(), getTypeGrille(), getChoixAlgo(), getMethodeAlgo());
				mGrille.dispose();
				/* .. sinon je ferme le menu pour creer une grille */
			}
		} else if(btn.equals("ANNULER")) {
			mGrille.dispose();
		}
	}
	
	/** 
	 * Conversion du texte rentre dans le JTextField
	 * 
	 * @return int taille
	 */
	private int getTailleGrille() {
		String tailleGrilleEntree = tailleGrille.getText();
		int taille = Integer.parseInt(tailleGrilleEntree);
		return taille;
	}
	
	/** 
	 * Traitement du type de la grille
	 * 
	 * @return String typeGrille
	 */
	private String getTypeGrille() {
		String typeGrille = new String();
		if(btnGrilleVide.isSelected()) {
			typeGrille = btnGrilleVide.getText();
		} else {
			typeGrille = btnGrilleRemplie.getText();
		}
		return typeGrille;
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
