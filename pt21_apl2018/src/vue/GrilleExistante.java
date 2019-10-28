/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import src.controleur.ActionGrille;
import src.controleur.ActionSauvegarder;
import src.controleur.ClicSourisGrille;
import src.controleur.DonneesGrilleExistante;
import src.vue.background.BackgroundGrilleExistante;

public class GrilleExistante extends JFrame {
    
    /**
     * Constructeur pour GrilleExistante
     * 
     * @param typecase
     * 			typecase
     * @param taille
     * 			Taille de notre grille
     */
    public GrilleExistante(int[][] typecase,int taille) {
        this.setUndecorated(true);
        this.setSize(1750,1000);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        /* Insertion d'une image en arriere plan */
        BackgroundGrilleExistante background = new BackgroundGrilleExistante();
        this.setContentPane(background);
        
        this.setLayout(new BorderLayout());

        /* Conteneur pour le choix de l'algorithme */
        JPanel panChoixAlgo = new JPanel();
        panChoixAlgo.setOpaque(false);
        panChoixAlgo.setPreferredSize(new Dimension(400,60));
        panChoixAlgo.setBorder(BorderFactory.createTitledBorder("CHOIX DE L'ALGORITHME"));
        /* Creation d'un JRadioButton selectionne par defaut sur aleatoire */
        JRadioButton btnAlgoAlea = new JRadioButton("ALEATOIRE");
        btnAlgoAlea.setSelected(true);
        btnAlgoAlea.setOpaque(false);
        /* Creation du deuxieme JRadioButton */
        JRadioButton btnAlgoDeter = new JRadioButton("DETERMINISTE");
        btnAlgoDeter.setOpaque(false);
        /* ButtonGroup est utilisee pour creer une etendue d'exclusion multiple 
		pour un ensemble de boutons */
        ButtonGroup bgAlgo = new ButtonGroup();
        bgAlgo.add(btnAlgoAlea);
        bgAlgo.add(btnAlgoDeter);
        /* Ajouts des boutons au conteneur panChoixAlgo */
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
        /* Creation du deuxieme JRadioButton */
        JRadioButton btnMetManuelle = new JRadioButton("MANUELLE");
        btnMetManuelle.setOpaque(false);
        /* ButtonGroup est utilisee pour creer une etendue d'exclusion multiple 
		pour un ensemble de boutons */
        ButtonGroup bgMethode = new ButtonGroup();
        bgMethode.add(btnMetAutomatique);
        bgMethode.add(btnMetManuelle);
        /* Ajouts des boutons au conteneur panMethode */
        panMethode.add(btnMetAutomatique);
        panMethode.add(btnMetManuelle);
        
        /* Conteneur pour notre gestionnaire de disposition */
        JPanel grille = new JPanel();
        grille.setPreferredSize(new Dimension(this.getHeight(), this.getHeight()));
        grille.setOpaque(false);
        
        /* Utilisation d'un gestionnaire de disposition pour la creation de notre grille */
        GridLayout gestionnaire = new GridLayout(taille, taille);
        grille.setLayout(gestionnaire);
        
        int xThesee = 0;
        int yThesee = 0;
        int xSortie = 0;
        int ySortie = 0;
        
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                grille.add(new DessinerTypeCase(typecase, x, y));
                
                /* Recuperation des coordonnees de Thesee et de la sortie */
                if(typecase[x][y] == 2) {
                    xThesee = x;
                    yThesee = y;
                } else if(typecase[x][y] == 3) {
                    xSortie = x;
                    ySortie = y;
                }
            }
        }
        
        /* Conteneur pour nos boutons */
        JPanel choixBtn = new JPanel();
        choixBtn.setOpaque(false);
        /* Gestionnaire de disposition pour notre conteneur */
        choixBtn.setLayout(new GridLayout(4,1));
        
        JButton fermerBtn = new JButton("FERMER");
        JButton sauvegarderBtn = new JButton("SAUVEGARDER");
        JButton creerGrille = new JButton("CREER LA GRILLE");
        
        choixBtn.add(fermerBtn);
        choixBtn.add(sauvegarderBtn);
        choixBtn.add(creerGrille);

        /* Creation du panneau principal contenant tous les conteneurs crees */
        JPanel panneau = new JPanel();
        panneau.setOpaque(false);
        /* Ajouts de tous nos conteneurs a notre panneau principal */
        panneau.add(panChoixAlgo);
        panneau.add(panMethode);
        
        this.getContentPane().add(grille, BorderLayout.WEST);
        this.getContentPane().add(choixBtn, BorderLayout.EAST);
        this.getContentPane().add(panneau);
        
        this.setVisible(true);
        
        ClicSourisGrille observateurGrille = new ClicSourisGrille(grille, taille, typecase,
        		xThesee, yThesee, xSortie, ySortie);
        /* Ajout d'un MouseListener sur notre grille */
        grille.addMouseListener(observateurGrille);
        
        ActionGrille observateur = new ActionGrille(this);
        /* Ajout d'un ActionListener au bouton FERMER */
        fermerBtn.addActionListener(observateur);
        
        ActionSauvegarder observateur2 = new ActionSauvegarder(typecase, taille);
        /* Ajout d'un ActionListener au bouton SAUVEGARDER pour sauvegarder dans un fichier
        .bin la grille actuelle (visible sur l'ecran) */
        sauvegarderBtn.addActionListener(observateur2);
        
        DonneesGrilleExistante observateur3 = new DonneesGrilleExistante(this, btnAlgoAlea, btnAlgoDeter, 
        		btnMetAutomatique, btnMetManuelle, typecase, xThesee, yThesee, 
        		xSortie, ySortie, taille);
        /* Ajout d'un ActionListener au bouton LANCER L'ALGORITHME */
        creerGrille.addActionListener(observateur3);
    }
    
}