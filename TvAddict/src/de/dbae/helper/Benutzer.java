/**
 * 
 */
package de.dbae.helper;

/**
 * @author Marcel
 * 
 * Diese Klasse dient dazu Benutzer anzulegen, meistens um die aus der Datenbank geholten Benutzerinformation zu speichern.
 */
public class Benutzer {
	//Variablen um die Informationen der "benutzer" Tabelle zu speichern.
	private String userID;
	private String benutzername;
	private String vorname;
	private String nachname;
	private String email;
	private String verschluesseltesPW;
	
	//Konstruktor
	public Benutzer () {
		
	}
	//Standard Getter und Setter
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerschluesseltesPW() {
		return verschluesseltesPW;
	}

	public void setVerschluesseltesPW(String verschluesseltesPW) {
		this.verschluesseltesPW = verschluesseltesPW;
	}
}
