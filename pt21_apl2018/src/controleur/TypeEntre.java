/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TypeEntre implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		
		char input = e.getKeyChar();
		/* Si le caractere rentre n'est pas un chiffre compris entre 0 et 9 .. */
		if((input < '0') || (input > '9') && input != '\b') {
			/* .. alors je ne prends en compte ce caractere */
			e.consume();
		}
	}
}