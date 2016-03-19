/**
 * 
 */
package de.dbae.helper;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import sun.misc.BASE64Encoder;

/**
 * @author Marcel
 * Klasse um Passwörter zu verschlüsseln. Code von: "http://blog.axxg.de/java-aes-verschluesselung-mit-beispiel/"
 */
public class Verschluesseln {
	
	public Verschluesseln () {		
	}
	
	public String pwVerschluesseln(String pw) {
		
		String verschluesseltesPw = "";
		//Passwort bzw der Schlüsseltext
		String keyStr = "geheim";
		try {
			// byte-Array erzeugen
			byte[] key = (keyStr).getBytes("UTF-8");
			// aus dem Array einen Hash-Wert erzeugen mit MD5 oder SHA
			MessageDigest sha = MessageDigest.getInstance("MD5");
			key = sha.digest(key);
			// nur die ersten 128 bit nutzen
			key = Arrays.copyOf(key, 16);
			// der fertige Schlüssel
			SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
			
			//der zu verschlüsselnde Text
			String text = pw;
			// Verschluesseln
		    Cipher cipher = Cipher.getInstance("AES");
		    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		    byte[] encrypted = cipher.doFinal(text.getBytes());
		 
		    // bytes zu Base64-String konvertieren (dient der Lesbarkeit)
		    BASE64Encoder myEncoder = new BASE64Encoder();
		    verschluesseltesPw = myEncoder.encode(encrypted);
				       	
					
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verschluesseltesPw;
		
	}

}
