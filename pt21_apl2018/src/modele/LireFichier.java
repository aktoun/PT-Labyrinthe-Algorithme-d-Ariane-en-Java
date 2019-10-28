/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.modele;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import src.vue.GrilleExistante;

public class LireFichier {

	/**
	 * 
	 * @param nomFichier
	 * 			Correspond au nom du fichier
	 */
	public LireFichier(String nomFichier) {
		
		String file = nomFichier;
		
		try {
			FileInputStream flux = new FileInputStream(file);
			LireBit lectureBit = new LireBit(file);       		
	       		try {
	       			int i = 0;
	       			int taille;
	    			int xThese;
	    			int yThese;
	    			int xSortie;
	    			int ySortie;
	    			int data = 0;
	    			int compteur = 1;
	    			int masque = 128;
	       			int compteur2 = 1;
	       			int reponse = flux.read();
	       			
	       			/* Taille de la grille */
	       			taille = reponse;
	       			/* Position de Thesee */
	       			reponse =  flux.read();
	       			xThese = reponse;
	       			reponse = flux.read();
	       			yThese = reponse;
	       			/* Position de la sortie */
	       			reponse =  flux.read();
	       			xSortie = reponse;
	       			reponse =  flux.read();
	       			ySortie = reponse;

	       			lectureBit.skip(5);

	       			int[] tab = new int[taille*taille+8];
	       			int[][] typecase = new int[taille][taille];

	     			while ((data = lectureBit.readBit(masque)) != -1) {
  						
  						if (compteur2 > 8) {
  							tab[i] = data;
  							i++;
	  						if (compteur == 8) {
	  							compteur = 1;
	  							masque = 128;
	  						} else {
								compteur++;
								masque = masque>>1;
	  						}

	  					}
	  					compteur2++;
  					}

  					for(int k = 0; k < taille; k++) {
	  					for(int j = 0; j < taille; j++) {
	  						typecase[k][j] = tab[taille*j+k];
	  					}
	  				}
  					typecase[xThese][yThese] = 2;
  					typecase[xSortie][ySortie] = 3;
	  				
	  				new GrilleExistante(typecase, taille);

	       		} catch (IOException e) {
	       			JOptionPane.showMessageDialog(null, "Erreur lors de la lecture du fichier selectionne !",
	    					"IOException",
	    					JOptionPane.ERROR_MESSAGE);
	       		}
	       		lectureBit.close();
	       		try {
	       			flux.close();
	       		} catch (IOException e) {
	       			JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture du fichier !",
	    					"IOException",
	    					JOptionPane.ERROR_MESSAGE);
	       		}
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur lors de l'ouverture du fichier !",
					"IOException",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
