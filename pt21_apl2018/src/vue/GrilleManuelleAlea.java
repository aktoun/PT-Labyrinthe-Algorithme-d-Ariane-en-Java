/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.controleur.ActionGrille;
import src.controleur.ToucheEntreeAlea;
import src.vue.background.BackgroundGrilleAlgo;


public class GrilleManuelleAlea extends JFrame {
    
    /**
     * Constructeur
     * 
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
    public GrilleManuelleAlea(int[][] typecase, int xThesee, int yThesee, int xSortie, int ySortie, int taille) {
        this.setUndecorated(true);
        this.setSize(1750,1000);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        /* Insertion d'une image en arriere plan */
        BackgroundGrilleAlgo background = new BackgroundGrilleAlgo();
        this.setContentPane(background);
        
        this.setLayout(new BorderLayout());
        
        JPanel grille = new JPanel();
        grille.setPreferredSize(new Dimension(1000, 1000));
        grille.setOpaque(false);
        
        /* Utilisation d'un gestionnaire de disposition pour la creation de notre grille */
        GridLayout gestionnaire = new GridLayout(taille, taille);
        grille.setLayout(gestionnaire);

        /* Remplissage de notre grille avec les types de chaques cases assignes au prealable */
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                grille.add(new DessinerTypeCase(typecase, x, y));
            }
        }
       
        /* Conteneur pour nos boutons */
        JPanel choixBtn = new JPanel();
        choixBtn.setOpaque(false);
        /* Gestionnaire de disposition pour notre conteneur */
        choixBtn.setLayout(new GridLayout(4,1));

        JButton fermerBtn = new JButton("FERMER");
        
        choixBtn.add(fermerBtn);
        
        this.getContentPane().add(grille, BorderLayout.WEST);
        this.getContentPane().add(choixBtn, BorderLayout.EAST);
        
        this.setVisible(true); 

        ActionGrille observateur = new ActionGrille(this);
        /* Ajout d'un ActionListener au bouton FERMER */
        fermerBtn.addActionListener(observateur);
        
        ToucheEntreeAlea observateur3 = new ToucheEntreeAlea(this, typecase, xThesee, yThesee, 
               xSortie, ySortie, taille);
        /* */
        this.setFocusable(true);
        /* Ajout d'un KeyListener pour les touches du clavier */
        this.addKeyListener(observateur3);
    }
    
}