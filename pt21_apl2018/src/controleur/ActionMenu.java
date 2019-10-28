/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import src.modele.LireFichier;
import src.vue.MenuGrille;

public class ActionMenu implements ActionListener {
	
	/**
	 * @param panneau
	 * 			JPanel
	 * 
	 */
	public ActionMenu(JPanel panneau) {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		
		if(btn.equals("GRILLE EXISTANTE")) {
			/* JFileChooser fournit un mecanisme simple permettant a l'utilisateur
			 * de choisir un fichier, ici dans le repertoire courant grace a "." */
			JFileChooser fichier = new JFileChooser(".");
			/* Utilisation d'un filtre pour mettre en avant tous les fichiers .bin */
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Bin Files", "bin");
			/* Application du filtre au JFileChooser */
			fichier.setFileFilter(filter);
			
			int returnVal = fichier.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File fichierSelectionne = fichier.getSelectedFile();
				
				/* Chemin d'acces vers le fichier :
				 * System.out.println(fichierSelectionne.getParent());
				 * Nom du fichier selectionne :
				 * System.out.println(fichierSelectionne.getName()); */
				
				new LireFichier(fichierSelectionne.getName());
			} 
		} else if(btn.equals("CREER UNE GRILLE")) {
			MenuGrille mGrille = new MenuGrille();
			mGrille.setVisible(true);
		}
	}
	
}
