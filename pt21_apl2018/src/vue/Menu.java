/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controleur.ActionMenu;
import src.vue.background.BackgroundMenu;


public class Menu extends JFrame {
	
	/**
	 * Menu principal de notre programme
	 * 
	 */
	public Menu() {
		super("L'ALGORITHME D'ARIANNE - PT21_APL2018");
		this.setSize(1000,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Insertion d'une image en arriere plan */
		BackgroundMenu background = new BackgroundMenu();
		this.setContentPane(background);

		/* Utilisation d'un gestionnaire de disposition affichant les composants
		d'un conteneur dans une grille rectangulaire */
		GridLayout gestionnaire = new GridLayout(2,2);
		this.setLayout(gestionnaire);
		
		/* Zone d'affichage pour le texte */
		JLabel choixDeLaGrille = new JLabel("CHOIX DE LA GRILLE");
		choixDeLaGrille.setFont(new Font("",Font.BOLD,17));
		choixDeLaGrille.setHorizontalAlignment(JLabel.CENTER);
		choixDeLaGrille.setForeground(new Color(0,0,0));
		
		/* Conteneur pour notre observateur */
		JPanel panneau = new JPanel();
		panneau.setOpaque(false);
		
		/* Conteneur pour nos boutons */
		JPanel choixBtn = new JPanel();
		choixBtn.setOpaque(false);

		/* Creation des boutons */
		JButton grilleExistante = new JButton("GRILLE EXISTANTE");
		grilleExistante.setFont(new Font("Arial",Font.BOLD,14));
		JButton creerGrille = new JButton("CREER UNE GRILLE");
		creerGrille.setFont(new Font("Arial",Font.BOLD,14));
		
		choixBtn.add(grilleExistante);
		choixBtn.add(creerGrille);
		
		panneau.add(choixBtn);
		
		this.add(choixDeLaGrille);
		this.add(panneau);
		
		ActionMenu observateur = new ActionMenu(panneau);
		/* Ajout d'un ActionListener au bouton GRILLE EXISTANTE et au bouton CREER UNE GRILLE */
		grilleExistante.addActionListener(observateur);
		creerGrille.addActionListener(observateur);
		
	}
	
}
