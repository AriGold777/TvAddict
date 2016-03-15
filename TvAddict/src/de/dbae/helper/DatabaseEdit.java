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
 * @author Marcel
 *
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
					// pw = neueKlasse/Objekt.verschlüsseln(pw);
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
}
