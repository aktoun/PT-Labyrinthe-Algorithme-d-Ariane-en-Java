/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class DessinerTypeCase extends JComponent {
	
	private int x;
	private int y;
	private int[][] typecase;
	private Image image;

	/**
	 * Constructeur
	 * 
	 * @param typecase
	 * 			typecase
	 * @param x
	 * 			x correspondant aux lignes de notre grille
	 * @param y
	 * 			y correspondant aux colonnes de notre grille
	 */
	public DessinerTypeCase(int[][] typecase, int x, int y) {
		this.typecase = typecase;
		this.x = x;
		this.y = y;
	}

	@Override
  	public void paintComponent(Graphics pinceau) {
			/* On cree un nouveau pinceau pour pouvoir le modifier plus tard */
    		Graphics monPinceau = pinceau.create();
    		/* Si le composant n'est pas cense etre transparent */
    		if (this.isOpaque()) {
    			/* On repeint alors toute la surface avec la couleur de fond */
      			monPinceau.setColor(this.getBackground());
      			monPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    		}
			monPinceau.setColor(this.getForeground());
			
			/* Si typecase[x][y] == 0, on cree un mur */
			if (typecase[x][y] == 0) {
				monPinceau.setColor(Color.WHITE);
				monPinceau.fillRect(0,0,this.getWidth(),this.getHeight());
				monPinceau.setColor(Color.BLACK);
				monPinceau.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
				
				this.setOpaque(false);
			}
			
			/* Si typecase[x][y] == 1, on cree un chemin */
			else if (typecase[x][y] == 1) {
				monPinceau.setColor(Color.BLACK);
				monPinceau.fillRect(0,0,this.getWidth(),this.getHeight());
				monPinceau.setColor(Color.BLACK);
				monPinceau.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
				
				this.setOpaque(false);
			}

			/* Si typecase[x][y] == 2, on cree Thesee */
			else if(typecase[x][y] == 2) {
				ImageIcon i = new ImageIcon("img/thesee.jpg");
				image =  i.getImage();
				pinceau.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
				/* monPinceau.setColor(Color.RED);
				monPinceau.fillRect(0,0,this.getWidth(),this.getHeight()); */
				monPinceau.setColor(Color.BLACK);
				monPinceau.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);

				this.setOpaque(false);
			}

			/* Si typecase[x][y] == 3, on cree la sortie */
	        else if(typecase[x][y] == 3) {
				ImageIcon i = new ImageIcon("img/sortie.jpg");
				image =  i.getImage();
				pinceau.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	        	/* monPinceau.setColor(Color.BLUE);
				monPinceau.fillRect(0,0,this.getWidth(),this.getHeight()); */
				monPinceau.setColor(Color.BLACK);
				monPinceau.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
				
				this.setOpaque(false);
	        }
			
			/* Si typecase[x][y] == 4, on met alors en vert le chemin de l'algorithme */
	        else if (typecase[x][y] == 4) {
	        	ImageIcon i = new ImageIcon("img/cible.jpg");
				image =  i.getImage();
				pinceau.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	        	//monPinceau.setColor(Color.GREEN);
	        	//monPinceau.fillRect(0,0,this.getWidth(),this.getHeight());
	        	monPinceau.setColor(Color.BLACK);
	        	monPinceau.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
	        	
	        	this.setOpaque(false);
	        }
			
			/* Si typecase[x][y] == 5, on met alors en jaune la prochaine etape de l'algorithme */
	        else if (typecase[x][y] == 5) {
	        	monPinceau.setColor(Color.YELLOW);
	        	monPinceau.fillRect(0,0,this.getWidth(),this.getHeight());
	        	monPinceau.setColor(Color.BLACK);
	        	monPinceau.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
	        	
	        	this.setOpaque(false);
	        }
			
	}
}
