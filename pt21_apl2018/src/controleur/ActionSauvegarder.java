/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 *
 */

package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import src.modele.EcrireFichier;

public class ActionSauvegarder implements ActionListener {
	
	private int[][] typecase;
	private int taille;

	/**
	 * Constructeur pour la sauvegarde d'un fichier (GrilleAlea, GrilleExistante, GrilleVide)
	 * 
	 * @param typecase
	 * 			Contient les informations pour les types de chaque cases
	 * @param taille
	 * 			Taille de notre grille
	 */
	public ActionSauvegarder(int[][] typecase, int taille) {	
		this.typecase = typecase;
		this.taille = taille;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		/* */
		if(btn.equals("SAUVEGARDER")) {
	         String nomGrille;
	         nomGrille = JOptionPane.showInputDialog(null, 
	        		 "Entrez le nom de la grille : ",
	        		 "CHOIX DU NOM DE LA GRILLE",
	        		 JOptionPane.INFORMATION_MESSAGE);
		     if(nomGrille == null) {
		        	JOptionPane.showMessageDialog(null, "Le fichier doit avoir un nom !",
							"SAUVEGARDER",
							JOptionPane.ERROR_MESSAGE);
		     } else if(nomGrille != null) {
	        	new EcrireFichier(typecase, taille, nomGrille);
				JOptionPane.showMessageDialog(null, "Le fichier a bien ete sauvegarde sous '" + nomGrille + ".bin'",
						"SAUVEGARDER",
						JOptionPane.INFORMATION_MESSAGE);
	        } 
		}
		
	}
}
