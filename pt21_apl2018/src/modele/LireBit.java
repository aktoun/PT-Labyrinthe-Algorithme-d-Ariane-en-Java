/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 * 
 */

package src.modele;

import java.io.FileInputStream;
import java.io.IOException;

public class LireBit {
	
	private FileInputStream input;
    private int digits;
    private int numDigits;
    private static final int BYTE_SIZE = 8;

    /**
     * Permet la lecture du fichier sauvegarde
     * 
     * @param file
     * 			String
     */
    public LireBit(String file) {
        try {
        	this.input = new FileInputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
     	this.numDigits = 0;
    }

    /**
     * Methode permettant de lire un bit grace a un masque
     * 
     * @param masque
     * 			int
     * @return result (qui est egal au bit)
     */
    public int readBit(int masque) {
    	
        if (this.digits == -1) {
            return -1;
        }
        
        int result = this.digits&masque;
        result = result>>(7-this.numDigits);
        this.numDigits++;
        
        if (this.numDigits == BYTE_SIZE) {
            nextByte();
        }
        return result;
    }

    /**
     * Methode pour passer au prochain octet
     * 
     */
    private void nextByte() {
        try {
        	this.digits = this.input.read();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        this.numDigits = 0;
    }

    /**
     * Methode pour fermer la lecture du fichier
     * 
     */
    public void close() {
        try {
        	this.input.close();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * Methode qui passe des octets
     * 
     * @param skip
     * 			long
     */
    public void skip(long skip) {
    	try {
            for(int i = 0; i < skip; i++) {
            	this.input.read();
    		}
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }
}
