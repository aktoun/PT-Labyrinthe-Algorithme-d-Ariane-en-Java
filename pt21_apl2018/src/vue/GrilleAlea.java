/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.controleur.ActionGrille;
import src.controleur.ActionSauvegarder;
import src.controleur.ClicSourisGrille;
import src.controleur.Validation;
import src.vue.background.BackgroundGrille;

public class GrilleAlea extends JFrame {
	
	private boolean typebloc;

	/**
	 * Constructeur
	 * 
	 * @param taille
	 * 			Taille de notre grille
	 * @param choixAlgo
	 * 			choix de l'algorithme
	 * @param methodeAlgo
	 * 			methode pour la simulation de cet algorithme
	 */
	public GrilleAlea(int taille, String choixAlgo, String methodeAlgo) {
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
        int xThesee = 0;
        int yThesee = 0;
        int xSortie = 0;
        int ySortie = 0;
        
        
        /* Attribution aleatoire des murs et des chemins avec un certain pourcentage de chance d'avoir un
        mur donne selon la taille de la grille avec l'utilisation de typebloc(taille) */
        for (x = 0; x < taille; x++) {
            for (y = 0; y < taille; y++) {
            	
                typebloc(taille);
                
                if(typebloc == true) {
                	typecase[x][y] = 1;
                } else {
                	typecase[x][y] = 0;
                }
                /* Par choix, toutes les cases autour de la grille deviennent des murs afin de representer
                un vrai labyrinthe (choix esthetique) */
                if(x == 0 || x == taille-1) {
                   typecase[x][y] = 1;
                } else if(y == 0 || y == taille-1) {
                    typecase[x][y] = 1;
                }
            }
        }
        
        Random rand = new Random();
        
        while (xThesee == 0 || xThesee == taille - 1 || yThesee == 0 || yThesee == taille - 1) {
        	/* Tirage au hasard du x de Thesee (correspondant a la ligne) */
            xThesee = rand.nextInt(taille);
            /* Tirage au hasard du y de Thesee (correspondant a la colonne) */
            yThesee = rand.nextInt(taille);
        }
        /* Attribution des coordonnees a Thesee */
        typecase[xThesee][yThesee] = 2;
        
        while (xSortie == 0 ||  xSortie == taille - 1 ||  ySortie == 0 ||  ySortie == taille - 1) {
        	/* Tirage au hasard du x de la sortie */
            xSortie = rand.nextInt(taille);
            /* Tirage au hasard du y de la sortie */
            ySortie = rand.nextInt(taille);
         }
        
        /* On verifie que les coordonnees attribuee a la sortie ne soient pas egaux aux coordonnees
        attribuees aleatoirement a Thesee */
        if (xSortie == xThesee && ySortie == yThesee) {
        	/* Si les coordonnees sont identiques alors on donne de nouveaux coordonnees a la sortie */
        	xSortie = rand.nextInt(taille);
        	ySortie = rand.nextInt(taille);
        }
        /* Attribution de ces coordonnees a la sortie */
        typecase[xSortie][ySortie] = 3;
        
        /* Remplissage de notre grille avec les types de chaques cases assignes au prealable */
        for (x = 0; x < taille; x++) {
            for (y = 0; y < taille; y++) {
            	grille.add(new DessinerTypeCase(typecase, x, y));
            }
        }
        
        /* Conteneur pour nos boutons */
        JPanel choixBtn = new JPanel();
        /* Gestionnaire de disposition pour notre conteneur */
        choixBtn.setLayout(new GridLayout(4,1));

        JButton fermerBtn = new JButton("FERMER");
        JButton nGrilleBtn = new JButton("NOUVELLE GRILLE ALEATOIRE");
        JButton sauvegarderBtn = new JButton("SAUVEGARDER");
        JButton validerBtn = new JButton("VALIDER");
        
        choixBtn.add(fermerBtn);
        choixBtn.add(nGrilleBtn);
        choixBtn.add(sauvegarderBtn);
        choixBtn.add(validerBtn);
        
        this.getContentPane().add(grille, BorderLayout.WEST);
        this.getContentPane().add(choixBtn, BorderLayout.EAST);

        this.setVisible(true);
        
        
        ClicSourisGrille observateurGrille = new ClicSourisGrille(grille, taille, typecase,
                xThesee, yThesee, xSortie, ySortie);
        /* Ajout d'un MouseListener sur notre grille */
        grille.addMouseListener(observateurGrille);
        
        ActionGrille observateur = new ActionGrille(this, taille, choixAlgo, methodeAlgo);
        /* Ajout d'un ActionListener au bouton FERMER et au bouton NOUVELLE GRILLE ALEATOIRE */
        fermerBtn.addActionListener(observateur);
        nGrilleBtn.addActionListener(observateur);
        
        ActionSauvegarder observateur2 = new ActionSauvegarder(typecase, taille);
        /* Ajout d'un ActionListener au bouton SAUVEGARDER pour sauvegarder dans un fichier
        .bin la grille actuelle (visible sur l'cran) */
        sauvegarderBtn.addActionListener(observateur2);
        
        Validation observateur3 = new Validation(choixAlgo, methodeAlgo, this, typecase, xThesee, yThesee,
                xSortie, ySortie, taille);
        /* Ajout d'un ActionListener au bouton VALIDER pour valider la la grille actuelle
        (PLUS DE MODIFICATION) */
        validerBtn.addActionListener(observateur3);
        
    }
    
    /** 
     * Pourcentage de chance d'avoir une case mur selon la taille de la grille
     * avec un typebloc qui est mis a true selon un Math.random configure
     * 
     * @param taille (avec taille correspondant a la taille de la grille)
     * @return boolean typebloc
     */
    private boolean typebloc(int taille) {
        if(taille<=10) {
            typebloc = Math.random() < 0.25;
        } else if(taille>10) {
            typebloc = Math.random() < 0.35;
        } else if(taille>25 && taille<=40) {
            typebloc = Math.random() < 0.30; 
        } else if(taille>40 && taille<=50) {
            typebloc = Math.random() < 0.32; 
        } else if(taille>50 && taille<=60) {
            typebloc = Math.random() < 0.34; 
        } else if(taille>60 && taille<=75) {
            typebloc = Math.random() < 0.36;
        } else if(taille>75 && taille<=90) {
            typebloc = Math.random() < 0.38; 
        } else if(taille>90 && taille<=100) {
            typebloc = Math.random() < 0.40; 
        } else if(taille>100) {
            typebloc = Math.random() < 0.6;
        }
        return typebloc;
    }

}