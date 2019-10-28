/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 *
 */

package src.vue.background;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundGrilleAlgo extends JPanel {
	
    final ImageIcon image = new ImageIcon("img/backgroundGrilleAlgo.jpg");
	
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
