/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import src.controleur.DonneesMenuGrille;
import src.controleur.TypeEntre;

public class MenuGrille extends JFrame {
	
	/**
	 * Menu pour la creation d'une grille avec le choix de son algorithme
	 * 
	 */
	public MenuGrille() {
		super("CREATION D'UNE GRILLE");
		this.setSize(500,350);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		/* Conteneur pour la taille de la grille */
		JPanel panTailleGrille = new JPanel();
		panTailleGrille.setOpaque(false);
		panTailleGrille.setPreferredSize(new Dimension(300,60));
		panTailleGrille.setBorder(BorderFactory.createTitledBorder("TAILLE DE LA GRILLE"));
		/* Creation du JTextField permettant de recuperer la taille de la grille, ici par defaut a 10 */
		JTextField tailleGrille = new JTextField("10");
		tailleGrille.setHorizontalAlignment(JTextField.CENTER);
		tailleGrille.setPreferredSize(new Dimension(100,25));
		/* Ajout du JTextField au conteneur panTailleGrille */
		panTailleGrille.add(tailleGrille);
		TypeEntre observateur = new TypeEntre();
		tailleGrille.addKeyListener(observateur);
		
		/* Conteneur pour le type de la grille */
		JPanel panTypeGrille = new JPanel();
		panTypeGrille.setOpaque(false);
		panTypeGrille.setPreferredSize(new Dimension(400,60));
		panTypeGrille.setBorder(BorderFactory.createTitledBorder("TYPE DE LA GRILLE"));
		/* Creation d'un JRadioButton selectionne par defaut sur grille vide */
		JRadioButton btnGrilleVide = new JRadioButton("GRILLE VIDE");
		btnGrilleVide.setOpaque(false);
		btnGrilleVide.setSelected(true);
		/* Creation du deuxieme JRadioButton */
		JRadioButton btnGrilleRemplie = new JRadioButton("GRILLE REMPLIE ALEATOIREMENT");
		btnGrilleRemplie.setOpaque(false);
		/* ButtonGroup est utilisee pour creer une etendue d'exclusion multiple 
		 * pour un ensemble de boutons */
		ButtonGroup bgType = new ButtonGroup();
		bgType.add(btnGrilleVide);
		bgType.add(btnGrilleRemplie);
		/* Ajouts des boutons au conteneur panTypeGrille */
		panTypeGrille.add(btnGrilleVide);
		panTypeGrille.add(btnGrilleRemplie);
		
		/* Conteneur pour le choix de l'algorithme */
		JPanel panChoixAlgo = new JPanel();
		panChoixAlgo.setOpaque(false);
		panChoixAlgo.setPreferredSize(new Dimension(400,60));
		panChoixAlgo.setBorder(BorderFactory.createTitledBorder("CHOIX DE L'ALGORITHME"));
		/* Creation d'un JRadioButton selectionne par defaut sur aleatoire */
		JRadioButton btnAlgoAlea = new JRadioButton("ALEATOIRE");
		btnAlgoAlea.setSelected(true);
		btnAlgoAlea.setOpaque(false);
		JRadioButton btnAlgoDeter = new JRadioButton("DETERMINISTE");
		btnAlgoDeter.setOpaque(false);
		ButtonGroup bgAlgo = new ButtonGroup();
		bgAlgo.add(btnAlgoAlea);
		bgAlgo.add(btnAlgoDeter);

		panChoixAlgo.add(btnAlgoAlea);
		panChoixAlgo.add(btnAlgoDeter);
		
		/* Conteneur pour la methode choisie */
		JPanel panMethode = new JPanel();
		panMethode.setOpaque(false);
		panMethode.setPreferredSize(new Dimension(400,60));
		panMethode.setBorder(BorderFactory.createTitledBorder("METHODE POUR L'ALGORITHME"));
		/* Creation d'un JRadioButton selectionne par defaut sur automatique */
		JRadioButton btnMetAutomatique = new JRadioButton("AUTOMATIQUE");
		btnMetAutomatique.setSelected(true);
		btnMetAutomatique.setOpaque(false);
		JRadioButton btnMetManuelle = new JRadioButton("MANUELLE");
		btnMetManuelle.setOpaque(false);
		ButtonGroup bgMethode = new ButtonGroup();
		bgMethode.add(btnMetAutomatique);
		bgMethode.add(btnMetManuelle);
		
		panMethode.add(btnMetAutomatique);
		panMethode.add(btnMetManuelle);

		/* Creation du panneau principal contenant tous les conteneurs crees */
		JPanel panneau = new JPanel();
		panneau.setBackground(new Color(250,250,250));
		/* Ajouts de tous nos conteneurs a notre panneau principal */
		panneau.add(panTailleGrille);
		panneau.add(panTypeGrille);
		panneau.add(panChoixAlgo);
		panneau.add(panMethode);
		
		/* Conteneur pour nos boutons OK et ANNULER */
		JPanel choixBtn = new JPanel();
		
		JButton okBtn = new JButton("OK");
		JButton annulerBtn = new JButton("ANNULER");
		
		choixBtn.add(okBtn);
		choixBtn.add(annulerBtn);

		this.getContentPane().add(panneau, BorderLayout.CENTER);
		this.getContentPane().add(choixBtn, BorderLayout.SOUTH);
		
		
		DonneesMenuGrille observateur2 = new DonneesMenuGrille(this, tailleGrille,
				btnGrilleVide, btnGrilleRemplie,
				btnAlgoAlea, btnAlgoDeter,
				btnMetAutomatique, btnMetManuelle);
		/* Ajout d'un ActionListener au bouton OK et au bouton ANNULER */
		okBtn.addActionListener(observateur2);
		annulerBtn.addActionListener(observateur2);
		
	}

}
