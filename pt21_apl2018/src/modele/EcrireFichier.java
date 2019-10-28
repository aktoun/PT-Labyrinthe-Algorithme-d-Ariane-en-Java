/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.modele;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class EcrireFichier {
	
	/**
	 * 
	 * @param typecase
	 * 			Correspond au type de nos case
	 * @param taille
	 * 			Taille de la grille
	 * @param nomGrille
	 * 			Nom choisi par l'utilisateur pour la grille sauvegardee
	 */
	public EcrireFichier (int[][] typecase, int taille, String nomGrille) {
		int xThesee = 0;
		int yThesee = 0;
		int xSortie = 0;
		int ySortie = 0;
		int compteur = 0;
		int res = 0;
		int valTemp;
		int compteur2=0;

		try {
			FileOutputStream flux = new FileOutputStream(nomGrille+".bin");
			try {
				for (int x = 0; x < taille; x++) {	
					for (int y = 0; y < taille; y++) {
						if (typecase[x][y] == 2) {
							xThesee = x;
							yThesee = y;
							typecase[x][y] = 0;
						}
						if (typecase[x][y] == 3) {
							xSortie = x;
							ySortie = y;
							typecase[x][y] = 0;	
						}
					}
				}
				
				flux.write(taille);
				flux.write(xThesee);
				flux.write(yThesee);
				flux.write(xSortie);
				flux.write(ySortie);

				for (int x = 0; x < taille; x++) {	
					for (int y = 0; y < taille; y++) {
						
						compteur2++;

						valTemp = typecase[y][x];
						valTemp = valTemp<<(7-compteur);
						res = res^valTemp;

						if (compteur == 7) {
							compteur = 0;
							flux.write(res);
							res = 0;
						} else {
							compteur++;
						}
						
						if (compteur2==taille*taille && ((taille*taille)%8)!=0) {
							flux.write(res);
						}
					}
				}
				typecase[xThesee][yThesee] = 2;
				typecase[xSortie][ySortie] = 3;
				try {
					flux.close();
				} catch (IOException e) {
	       			JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture du fichier !",
	    					"IOException",
	    					JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e) {
       			JOptionPane.showMessageDialog(null, "Erreur pendant l'ecriture du fichier !",
    					"IOException",
    					JOptionPane.ERROR_MESSAGE);		
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur pendant l'ouverture du fichier !",
					"IOException",
					JOptionPane.ERROR_MESSAGE);	
		}
		
		
	}
}