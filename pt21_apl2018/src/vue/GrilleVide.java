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
import src.controleur.ActionSauvegarder;
import src.controleur.ClicSourisGrille;
import src.controleur.Validation;
import src.vue.background.BackgroundGrille;

public class GrilleVide extends JFrame {

    /**
     * Constructeur
     * 
     * @param taille
     * 			Taille de notre grille
     * @param choixAlgo
     * 			Choix de l'algorithme
     * @param methodeAlgo
     * 			Methode utilisee pour la simulation de cet algo
     */
    public GrilleVide(int taille, String choixAlgo, String methodeAlgo) {
        this.setUndecorated(true);
        this.setSize(1750,1000);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        /* Insertion d'une image en arriere plan */
        BackgroundGrille background = new BackgroundGrille();
        this.setContentPane(background);
        
        this.setLayout(new BorderLayout());
        
        /* Conteneur pour notre gestionnaire de disposition */
        JPanel grille = new JPanel();
        grille.setPreferredSize(new Dimension(this.getHeight(), this.getHeight()));
        grille.setOpaque(false);
        
        /* Utilisation d'un gestionnaire de disposition pour la creation de notre grille */
        GridLayout gestionnaire = new GridLayout(taille, taille);
        grille.setLayout(gestionnaire);
        
        int typecase[][] = new int[taille][taille];
        int x = 0;
        int y = 0;
        int xThesee = 1;
        int yThesee = 1;
        int xSortie = 1;
        int ySortie = 2;
        
        /* Attribution et remplissage de la grille */
        /* -> Attribution des chemins sur toute la grille, et par choix, toutes les cases autour 
        de cette grille deviennent des murs afin de representer un vrai labyrinthe */
        for(x = 0; x < taille; x++) {
            for(y = 0; y < taille; y++) {
                if(x == 0 || x == taille-1) {
                   typecase[x][y] = 1;
                } else if(y == 0 || y == taille-1) {
                    typecase[x][y] = 1;
                } else {
                    typecase[x][y] = 0;
                }
                /* -> Remplissage de notre grille avec les types de chaques cases assignes au prealable */
                grille.add(new DessinerTypeCase(typecase, x, y));
            }
        }


        /* Configuration par defaut de la position initiale de Thesee */
        typecase[xThesee][yThesee] = 2;
        /* Configuration par defaut de la position initiale de la sortie */
        typecase[xSortie][ySortie] = 3;
        
        
        /* Conteneur pour nos boutons */
        JPanel choixBtn = new JPanel();
        choixBtn.setOpaque(false);
        /* Gestionnaire de disposition pour notre conteneur */
        choixBtn.setLayout(new GridLayout(4,1));
        
        JButton fermerBtn = new JButton("FERMER");
        JButton sauvegarderBtn = new JButton("SAUVEGARDER");
        JButton validerBtn = new JButton("VALIDER");
        
        choixBtn.add(fermerBtn);
        choixBtn.add(sauvegarderBtn);
        choixBtn.add(validerBtn);
        
        this.getContentPane().add(grille, BorderLayout.WEST);
        this.getContentPane().add(choixBtn, BorderLayout.EAST);
        
        this.setVisible(true);
        
        ClicSourisGrille observateurGrille = new ClicSourisGrille(grille, taille, 
        		typecase, xThesee, yThesee, 
        		xSortie,ySortie);
        /* Ajout d'un MouseListener sur notre grille */
        grille.addMouseListener(observateurGrille);

        ActionGrille observateur = new ActionGrille(this);
        /* Ajout d'un ActionListener au bouton FERMER et au bouton NOUVELLE GRILLE ALEATOIRE */
        fermerBtn.addActionListener(observateur);
        
        ActionSauvegarder observateur2 = new ActionSauvegarder(typecase, taille);
        /* Ajout d'un ActionListener au bouton SAUVEGARDER pour sauvegarder dans un fichier
        .bin la grille actuelle (visible sur l'ecran) */
        sauvegarderBtn.addActionListener(observateur2);
        
        Validation observateur3 = new Validation(choixAlgo, methodeAlgo, this, typecase, taille);
        /* Ajout d'un ActionListener au bouton VALIDER pour valider la la grille actuelle
        (PLUS DE MODIFICATION) */
        validerBtn.addActionListener(observateur3);
        

    }

}
