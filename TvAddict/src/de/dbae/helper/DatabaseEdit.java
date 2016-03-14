/**
 * 
 */
package de.dbae.helper;

import java.sql.Connection;
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
					String idSQL = "UPDATE benutzer SET user_id = '"+ID+"' WHERE user_id = '"+aktuelleID+"'";
				con.prepareStatement(idSQL).executeUpdate();
				}
				if (!(benutzername.equals("")) && (benutzername != null)) {
					String benutzernameSQL = "UPDATE benutzer SET user_name = '"+benutzername+"' WHERE user_id = '"+aktuelleID+"'";
				con.prepareStatement(benutzernameSQL).executeUpdate();
				}
				if (!(vorname.equals("")) && (vorname != null)) {
					String vornameSQL = "UPDATE benutzer SET v_name = '"+vorname+"' WHERE user_id = '"+aktuelleID+"'";
				con.prepareStatement(vornameSQL).executeUpdate();
				}
				if (!(nachname.equals("")) && (nachname != null)) {
					String nachnameSQL = "UPDATE benutzer SET n_name = '"+nachname+"' WHERE user_id = '"+aktuelleID+"'";
				con.prepareStatement(nachnameSQL).executeUpdate();
				}
				if (!(email.equals("")) && (email != null)) {
					String emailSQL = "UPDATE benutzer SET email = '"+email+"' WHERE user_id = '"+aktuelleID+"'";
				con.prepareStatement(emailSQL).executeUpdate();
				}
				if (!(pw.equals("")) && (pw != null)) {
					// pw = neueKlasse/Objekt.verschlüsseln(pw);
					String pwSQL = "UPDATE benutzer SET passwort = '"+pw+"' WHERE user_id = '"+aktuelleID+"'";
				con.prepareStatement(pwSQL).executeUpdate();
				}
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void deleteBenutzer(String userID) {
		String sql = "DELETE FROM benutzer WHERE user_id = '"+userID+"'";
		try {
			con.prepareStatement(sql).executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
