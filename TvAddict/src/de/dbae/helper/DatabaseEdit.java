/**
 * 
 */
package de.dbae.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.dbae.database.DatabaseConnection;

/**
 * @author Hassib
 *
 *Diese KLasse dient zum Bearbeiten, Hinzuf�gen, L�schen von Benutzer und Serie 
 */
public class DatabaseEdit {
	private Connection con;
	private ResultSet result;
	
	//Konstruktor
	@SuppressWarnings("static-access")
	public DatabaseEdit() {
		this.result = null;
		//Verbindung holen aus Klasse DatabaseConnection
		this.con = new DatabaseConnection().getConnection();
	}
	
	//Methode zum bearbeiten des Benutzers
	public void editBenutzer(String aktuelleID, String ID, String benutzername, String vorname, String nachname,
			String email, String pw) {
			try {
				
				if (!(ID.equals("")) && (ID != null)) {
					String idSQL = "UPDATE benutzer SET user_id = ? WHERE user_id = ?";
					PreparedStatement pstmt = con.prepareStatement(idSQL);
					pstmt.setInt(1, Integer.parseInt(ID));
					pstmt.setInt(2, Integer.parseInt(aktuelleID));
					pstmt.executeUpdate();
					aktuelleID = ID;
				}
				if (!(benutzername.equals("")) && (benutzername != null)) {
					String benutzernameSQL = "UPDATE benutzer SET user_name = ? WHERE user_id = ?";
					PreparedStatement pstmt = con.prepareStatement(benutzernameSQL);
					pstmt.setString(1, (benutzername));
					pstmt.setInt(2, Integer.parseInt(aktuelleID));
					pstmt.executeUpdate();
				}
				if (!(vorname.equals("")) && (vorname != null)) {
					String vornameSQL = "UPDATE benutzer SET v_name = ? WHERE user_id = ?";
					PreparedStatement pstmt = con.prepareStatement(vornameSQL);
					pstmt.setString(1, (vorname));
					pstmt.setInt(2, Integer.parseInt(aktuelleID));
					pstmt.executeUpdate();
				}
				if (!(nachname.equals("")) && (nachname != null)) {
					String nachnameSQL = "UPDATE benutzer SET n_name = ? WHERE user_id = ?";
					PreparedStatement pstmt = con.prepareStatement(nachnameSQL);
					pstmt.setString(1, (nachname));
					pstmt.setInt(2, Integer.parseInt(aktuelleID));
					pstmt.executeUpdate();
				}
				if (!(email.equals("")) && (email != null)) {
					String emailSQL = "UPDATE benutzer SET email = ? WHERE user_id = ?";
					PreparedStatement pstmt = con.prepareStatement(emailSQL);
					pstmt.setString(1, (email));
					pstmt.setInt(2, Integer.parseInt(aktuelleID));
					pstmt.executeUpdate();
				}
				if (!(pw.equals("")) && (pw != null)) {
					String pwSQL = "UPDATE benutzer SET passwort = ? WHERE user_id = ?";
					PreparedStatement pstmt = con.prepareStatement(pwSQL);
					pstmt.setString(1, (pw));
					pstmt.setInt(2, Integer.parseInt(aktuelleID));
					pstmt.executeUpdate();
				}
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	// Methode zum l�schen des Benutzers
	public void deleteBenutzer(String userID) {
		String sql = "DELETE FROM benutzer WHERE user_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(userID));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Methode zum hinzuf�gen eines neuen Benutzer
	public void addBenutzer(String benutzername, String vorname, String nachname, String email, String pw) {
		String sql = "INSERT INTO benutzer (mitarbeiter,user_name,v_name,n_name,email,passwort) values(false,?,?,?,?,?)";
				PreparedStatement pstmt;
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, benutzername);
					pstmt.setString(2, vorname);
					pstmt.setString(3, nachname);
					pstmt.setString(4, email);
					pstmt.setString(5, pw);
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	//Methode zum �ndern der E-mail Adresse
	public void meinProfilEmailEdit(String email, int id) {
		if (!(email.equals("")) && (email != null)) {
			String emailSQL = "UPDATE benutzer SET email = ? WHERE user_id = ?";
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(emailSQL);
				pstmt.setString(1, email);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//Methode zum �ndern des Passwortes
	public void meinProfilPasswortEdit(String neuesPasswort, int id) {
		if (!(neuesPasswort.equals("")) && (neuesPasswort != null)) {
			String pwSQL = "UPDATE benutzer SET passwort = ? WHERE user_id = ?";
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(pwSQL);
				pstmt.setString(1, neuesPasswort);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//Methode zum Bearbeiten einer Serie
	public void editSerie(String aktuelleID, String ID, String name, String beschreibung, String fsk, String sendetag,
			String genre1, String genre2, String genre3) {
		try {
			
			if (!(ID.equals("")) && (ID != null)) {
				String idSQL = "UPDATE serie SET serie_id = ? WHERE serie_id = ?";
				PreparedStatement pstmt = con.prepareStatement(idSQL);
				pstmt.setInt(1, Integer.parseInt(ID));
				pstmt.setInt(2, Integer.parseInt(aktuelleID));
				pstmt.executeUpdate();
				aktuelleID = ID;
			}
			if (!(name.equals("")) && (name != null)) {
				String nameSQL = "UPDATE serie SET serie_name = ? WHERE serie_id = ?";
				PreparedStatement pstmt = con.prepareStatement(nameSQL);
				pstmt.setString(1, (name));
				pstmt.setInt(2, Integer.parseInt(aktuelleID));
				pstmt.executeUpdate();
			}
			if (!(beschreibung.equals("")) && (beschreibung != null)) {
				String beschreibungSQL = "UPDATE serie SET beschreibung = ? WHERE serie_id = ?";
				PreparedStatement pstmt = con.prepareStatement(beschreibungSQL);
				pstmt.setString(1, (beschreibung));
				pstmt.setInt(2, Integer.parseInt(aktuelleID));
				pstmt.executeUpdate();
			}
			if (!(fsk.equals("")) && (fsk != null)) {
				String fskSQL = "UPDATE serie SET fsk = ? WHERE serie_id = ?";
				PreparedStatement pstmt = con.prepareStatement(fskSQL);
				pstmt.setInt(1, (Integer.parseInt(fsk)));
				pstmt.setInt(2, Integer.parseInt(aktuelleID));
				pstmt.executeUpdate();
			}
			if (!(sendetag.equals("")) && (sendetag != null)) {
				String sendetagSQL = "UPDATE serie SET sendetag = ? WHERE serie_id = ?";
				PreparedStatement pstmt = con.prepareStatement(sendetagSQL);
				pstmt.setString(1, (sendetag));
				pstmt.setInt(2, Integer.parseInt(aktuelleID));
				pstmt.executeUpdate();
			}
			if (!(genre1.equals("")) && (genre1 != null)) {
				String genre1SQL = "UPDATE serie SET genre1 = ? WHERE serie_id = ?";
				PreparedStatement pstmt = con.prepareStatement(genre1SQL);
				pstmt.setString(1, (genre1));
				pstmt.setInt(2, Integer.parseInt(aktuelleID));
				pstmt.executeUpdate();
			}
			if (!(genre2.equals("")) && (genre2 != null)) {
				String genre2SQL = "UPDATE serie SET genre2 = ? WHERE serie_id = ?";
				if(genre2.equals("clear")) {
					genre2 = "";
				}
				PreparedStatement pstmt = con.prepareStatement(genre2SQL);
				pstmt.setString(1, (genre2));
				pstmt.setInt(2, Integer.parseInt(aktuelleID));
				pstmt.executeUpdate();
			}
			if (!(genre3.equals("")) && (genre3 != null)) {
				if(genre3.equals("clear")) {
					genre3 = "";
				}
				String genre3SQL = "UPDATE serie SET genre3 = ? WHERE serie_id = ?";
				PreparedStatement pstmt = con.prepareStatement(genre3SQL);
				pstmt.setString(1, (genre3));
				pstmt.setInt(2, Integer.parseInt(aktuelleID));
				pstmt.executeUpdate();
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Methode zum L�schen einer Serie
	public void deleteSerie(String id) {
		String sql = "DELETE FROM serie WHERE serie_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Methode zum Hinzuf�gen einer Serie
	public void addSerie(String name, String beschreibung, String fsk, String genre1, String genre2, String genre3,
			String sendetag) {
		String sql = "INSERT INTO serie (serie_name,beschreibung,fsk,genre1,genre2,genre3,sendetag) values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, beschreibung);
			pstmt.setInt(3, Integer.parseInt(fsk));
			pstmt.setString(4, genre1);
			pstmt.setString(5, genre2);				
			pstmt.setString(6, genre3);
			pstmt.setString(7, sendetag);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Methode um eine Serie zum Sendeplan hinzuzuf�gen
	public void addSerieToSendeplan(String userId, int serieId) {
		String sql = "INSERT INTO favorites (user_id,serie_id) values(?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(userId));
			pstmt.setInt(2, serieId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Methode zum entfernen einer Serie aus dem Sendeplan
	public void removeSerieFromSendeplan(String userId, int serieId) {
		String sql = "DELETE FROM favorites WHERE user_id = ? AND serie_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(userId));
			pstmt.setInt(2, serieId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Methode um eine Bewertung f�r eine Serie einzutragen
	
	public void addBewertung(int serienId, String abgegebeneBewertung) {
		//Es wird ein String zusammengesetzt um die richtige Spalte mit der Bewertung zu erg�nzen.
		String anzahlSpalte = "anzahl_"+abgegebeneBewertung;
		String sql = "UPDATE bewertungen SET ? = (? + 1) WHERE bewertungen.serie_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, anzahlSpalte);
			pstmt.setString(2, anzahlSpalte);
			pstmt.setInt(3, serienId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("An sich funktioniert dieses Statement, nur nicht als PreparedStatement."
					+ " Mit Variablen im sql String w�rde es funktionieren, w�rde aber die Sicherheit"
					+ " durch SQL Injektions gef�hrden.");
			System.out.println("Code in der DatabaseEdit Klasse. Methode addBewertung - wegen FEHLER: Syntaxfehler bei �$x� wird nichts ge�ndert.");
		}
	}



}
	