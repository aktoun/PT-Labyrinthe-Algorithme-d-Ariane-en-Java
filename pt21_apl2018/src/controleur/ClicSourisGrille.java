/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ClicSourisGrille implements MouseListener {
    
    private JPanel panneau;
    private int taille;
    private int[][] typecase;
    private boolean verifThesee = false;
    private boolean verifSortie = false;
    private int x;
    private int y;
    private int xThesee;
    private int yThesee;
    private int xSortie;
    private int ySortie;

    /**
     * Constructeur pour ClicSourisGrille (GrilleAlea, GrilleExistante, Grille Vide)
     * 
     * @param panneau
     * 			JPanel
     * @param taille
     * 			Taille de notre grille
     * @param typecase
     * 			Typecase (voir DessinerTypeCase)
	 * @param xThesee
	 * 			Position X de Thesee
	 * @param yThesee
	 * 			Position Y de Thesee
	 * @param xSortie
	 * 			Position X de la sortie
	 * @param ySortie
	 * 			Position Y de la sortie
     */
    public ClicSourisGrille(JPanel panneau,int taille, int[][] typecase, int xThesee, int yThesee, int xSortie, int ySortie) {
        this.panneau = panneau;
        this.taille = taille;
        this.typecase = typecase;
        this.xThesee = xThesee;
        this.yThesee = yThesee;
        this.xSortie = xSortie;
        this.ySortie = ySortie;
        verifSortie = true;
        verifThesee = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x=e.getY();
        y=e.getX();
        int largeur = this.panneau.getWidth();
        int hauteur = this.panneau.getHeight();
        
        if(taille == 6 || taille == 12 ) {
            x -= 1;
            y -= 1;
        } else if(taille == 7 || taille == 14 || taille == 16 || taille == 18 || taille == 31  
                || taille ==  32) {
            x -= 2;
            y -= 2;
        } else if(taille == 11 || taille == 13 || taille == 15 || taille == 17 || taille == 19 || 
                taille == 21 || taille == 22 || taille == 23 || taille == 26 || taille == 29 ||
                taille == 30 || taille == 33 || taille == 38 || taille == 41 || taille == 43 ||
                taille == 45 || taille == 47 || taille == 52 || taille == 55 || taille == 62) {
            x -= 5;
            y -= 5;
        } else if(taille == 24 || taille == 34 || taille == 58) {
            x -= 7;
            y -= 7;
        } else if(taille == 28 || taille == 35 || taille == 49) {
            x -= 10;
            y -= 10;
        } else if(taille == 61) {
            x -= 12;
            y -= 12;
        } else if(taille == 36 || taille == 39 || taille == 44 || taille == 54) {
            x -= 14;
            y -= 14;
        } else if(taille == 46 || taille == 51 || taille == 57) {
            x -= 16;
            y -= 16;
        } else if(taille == 42) {
            x -= 18;
            y -= 18;
        } else if(taille == 48 || taille == 60 || taille == 64) {
            x -= 20;
            y -= 20;
        } else if(taille == 53 || taille == 56) {
            x -= 23;
            y -= 23;
        } else if(taille == 59 || taille == 63) {
            x -= 28;
            y -= 28;
        }
        
        int valTemp = 0;
                
        valTemp = largeur/taille;
        x = x/valTemp;
        Math.round(x);
        
        valTemp = (hauteur) / taille;
        y = y/valTemp;
        Math.round(y);

        if(e.getButton() == MouseEvent.BUTTON1) {
            if (typecase[x][y] == 0) {
                typecase[x][y] = 1;
                panneau.repaint();
            } else {
                typecase[x][y] = 0;
                panneau.repaint();
            }
        }
        
        if(e.getButton() == MouseEvent.BUTTON2) {
            if(verifSortie) {
                typecase[xSortie][ySortie] = 0;
                panneau.repaint();
            }
            typecase[x][y] = 3;        
            panneau.repaint();
            xSortie = x;
            ySortie = y;            
            
            verifSortie = true;
        }
        
        if(e.getButton() == MouseEvent.BUTTON3) {
            if(verifThesee) {
                typecase[xThesee][yThesee] = 0;
                panneau.repaint();
            }
            typecase[x][y] = 2;
            panneau.repaint();
            xThesee = x;
            yThesee = y;
            
            verifThesee = true;
        }

        panneau.setVisible(true);
    }
        @Override
        public void mouseEntered(MouseEvent event) {}
        
        @Override
        public void mouseExited(MouseEvent event) {}
        
        @Override
        public void mousePressed(MouseEvent event) {}
        
        @Override
        public void mouseReleased(MouseEvent event) {}

}
