/**
 * 
 */
package de.dbae.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import de.dbae.database.DatabaseConnection;

/**
 * @author Marcel
 * 
 * Diese Klasse dient dazu Informationen mittels SQL-Befehlen aus der Datenbank zu holen.
 * Keine dieser Methoden verändert Informationen in der Datenbank.
 */
public class SearchObject {
	private Connection con;
	private ResultSet result;
	
	//Konstruktor
	@SuppressWarnings("static-access")
	public SearchObject() {
		this.result = null;
		//Verbindung holen aus Klasse DatabaseConnection
		this.con = new DatabaseConnection().getConnection();
	}
	/**
	 * Methode, um eine einfache schnelle Suche der Serien in ein ResultSet zu speichern
	 *  
	 */
	public ResultSet simpleSearch(String name) {
		//Basic SQL Statement
		String sql = "SELECT serie_name, beschreibung, fsk FROM serie WHERE TRUE";
		//Leerer where-String
		String where ="";
		//Boolean der je nach dem ob der Benutzer einen Begriff eingegeben hat auf true oder false gesetzt wird.
		boolean nameIsSet = true;
		//Abfrage um zu überprüfen ob der Benutzer nach einem Begriff gesucht hat
		if (!name.equals("") && name != null) {
			where += " AND serie.serie_name ilike ?";
			
		} else {
			//Wenn nichts eingegeben wurde, wird der boolean auf false gesetzt um die "?" Platzhalter nur zu setzen, wenn der
			//"where" String mit einer Bedingung erweitert wurde-
			nameIsSet = false;
		}
		where += " ORDER BY serie_name";
		//SQL Statement & Where Statement verbinden
		String completeSQL = sql + where;
		
		//Prepared Statement in ResultSet
		try {
			PreparedStatement pstmt = con.prepareStatement(completeSQL);
			//Platzhalter nur setzen, wenn etwas eingegeben wurde, sonst gibt es einen Fehler, da kein Parameter gesetzt werden müsste.
			if(nameIsSet){
				pstmt.setString(1, "%" + name + "%");				
			}
			//Statement wird ausgeführt.
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Methode für die erweiterte Suche.
	 * Es wird jeweils geprüft ob der Benutzer die Suche nach Genre, Altersfreigabe und/oder Name ausführt.
	 */
	public ResultSet advancedSearch(String name, String genre, String fsk) {
		//Basic SQL Statement
		String sql = "SELECT serie_name, beschreibung, fsk FROM serie WHERE TRUE";
				
		//Leerer where-String
		String where ="";
		//Booleans um zu überprüfen welche Parameter werden müssen.
		boolean nameIsSet = true;
		boolean fskIsSet = true;
		boolean genreIsSet = true;
		//Anzahl der gesetzten Parameter
		int paraAnzahl = 0;
		//Variablen, um festzuhalten an welcher Stelle (index) die Parameter gesetzt werden müssen falls der Benutzer eine Suchoption auslässt.
		int nameParaCount = 0;
		int fskParaCount = 0;
		int genreParaCount = 0;
		
		//Es wird jeweils überprüft ob der Benutzer die Suchoption in Anspruch nimmt und wenn er dies tut werden die Parameter Variablen entsprechend gesetzt.
		if (!name.equals("") && name != null) {
			where += " AND serie.serie_name ilike ?";
			paraAnzahl++;
			nameParaCount = paraAnzahl;
		} else {
			nameIsSet = false;
		}
		if (!fsk.equals("") && fsk != null) {
			where += " AND serie.fsk <= ?";
			paraAnzahl++;
			fskParaCount = paraAnzahl;
		} else {
			fskIsSet = false;
		}
		if (!genre.equals("") && genre != null) {
			where += " AND (serie.genre1 = ? OR serie.genre2 = ? OR serie.genre3 = ?)";
			paraAnzahl++;
			genreParaCount = paraAnzahl;
		} else {
			genreIsSet = false;
		}
		where += " ORDER BY serie_name";		
		//SQL Statement & Where Statement verbinden
		String completeSQL = sql + where;
				
		//Prepared Statement in ResultSet
		try {
			PreparedStatement pstmt = con.prepareStatement(completeSQL);
			//Entsprechend der vorher ermittelten booleans wird hier entschieden welche Platzhalter in welcher Reihenfolge ersetzt werden müssen.
			if (nameIsSet) {
				pstmt.setString(nameParaCount, "%" + name + "%");				
			}
			if (fskIsSet) {
				pstmt.setInt(fskParaCount, Integer.parseInt(fsk));				
			}
			if (genreIsSet) {
				pstmt.setString(genreParaCount, genre);
				pstmt.setString(genreParaCount+1, genre);
				pstmt.setString(genreParaCount+2, genre);				
			}
			
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Methode um die Anzahl der verschiedenen Genres der Serien auszugeben.
	 * 
	 */
	
	public int genreCount() {
		String countSql = "SELECT COUNT (DISTINCT genre1)"
				+ " FROM (SELECT genre1 FROM serie WHERE genre1<>''"
				+ " UNION"
				+ " SELECT genre2 FROM serie WHERE genre2<>''"
				+ " UNION"
				+ " SELECT genre3 FROM serie WHERE genre3<>''"
				+ ") as GenreCount";
		int count = 0;
		try {
			ResultSet rs;
			PreparedStatement pstmt = con.prepareStatement(countSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
	            count = rs.getInt("count");
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * Alle Genres, die die verschiedenen Serien haben werden rausgesucht und in einem ResultSet gespeichert.
	 * 
	 */
	public ResultSet allGenres() {
		String sql = "SELECT genre1 FROM serie WHERE genre1<>''"
				+ " UNION"
				+ " SELECT genre2 FROM serie"
				+ " WHERE genre2<>''"
				+ " UNION"
				+ " SELECT genre3 FROM serie"
				+ " WHERE genre3<>''";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Alle Serien in der Datenbank werden zur Übersicht in ein ResultSet gespeichert.
	 * 
	 */
	public ResultSet uebersichtSearch() {
		String sql = "SELECT serie_name, beschreibung, fsk FROM serie ORDER BY serie_name";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Alle Schauspieler einer bestimmten Serie werden gesucht und in einem ResultSet gespeichert.
	 * 
	 */
	
	public ResultSet detailSchauspielerSearch(String name) {
		String sql ="SELECT schauspieler.name FROM schauspieler"
				+ " INNER JOIN serie ON schauspieler.serie_id = serie.serie_id"
				+ " WHERE serie.serie_name = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	/**
	 * Suche um den Sendetag einer bestimmten Serie als String zurückzugeben.
	 * 
	 */

	public String sendetagSearch(String name) {
		String sql ="SELECT sendetag FROM serie WHERE serie.serie_name = ?";
		String sendeTag = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			result = pstmt.executeQuery();
			//Einträge des ResultSets werden durchsucht und der Sendetag wird aus der Spalte "sendetag" bezogen.
			while(result.next()) {
				sendeTag = result.getString(result.findColumn("sendetag"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendeTag;
	}
	/**
	 * Bewertungen einer Serie werden ausgegeben und in einem Bewertungsobjekt gespeichert.
	 * 
	 */
	public Bewertung bewertungSearch(String name) {
		Bewertung serieBewertung = new Bewertung();
		String sql = "SELECT serie.serie_name, bewertungen.anzahl_1, bewertungen.anzahl_2,"
				+ " bewertungen.anzahl_3, bewertungen.anzahl_4, bewertungen.anzahl_5,"
				+ " bewertungen.anzahl_6, bewertungen.anzahl_7, bewertungen.anzahl_8,"
				+ " bewertungen.anzahl_9, bewertungen.anzahl_10"
				+ " FROM bewertungen"
				+ " INNER JOIN serie ON bewertungen.serie_id = serie.serie_id"
				+ " WHERE serie.serie_name = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet tempBewertungen = pstmt.executeQuery();
			//Alle nötigen Variablen der Bewertung werden gesetzt und anschließen wird die Bewertung berechnet.
			while(tempBewertungen.next()) {
				serieBewertung.setAnzahl1(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_1"))));
				serieBewertung.setAnzahl2(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_2"))));
				serieBewertung.setAnzahl3(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_3"))));
				serieBewertung.setAnzahl4(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_4"))));
				serieBewertung.setAnzahl5(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_5"))));
				serieBewertung.setAnzahl6(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_6"))));
				serieBewertung.setAnzahl7(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_7"))));
				serieBewertung.setAnzahl8(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_8"))));
				serieBewertung.setAnzahl9(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_9"))));
				serieBewertung.setAnzahl10(Integer.parseInt(tempBewertungen.getString(tempBewertungen.findColumn("anzahl_10"))));
				serieBewertung.berechnung();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serieBewertung;
	}
	/**
	 * Methode um zu überprüfen, ob die eingegebene Benutzername/Passwort -Kombination in der Datenbank gibt.
	 * 
	 */
	
	public int anmeldeAbfrage(String benutzername, String passwort) {
		String sql = "SELECT CASE WHEN EXISTS (SELECT * FROM benutzer"
				+ " WHERE user_name = ? AND passwort = ?)"
				+ " THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END";
		// abfrage wird mit -1 initialisiert, da die möglichen Werte der Abfrage 0 oder 1 sein können.
		int abfrage = -1;
		// Es wird überprüft, ob es sich bei der Anmeldung um einen Mitarbeiter handelt. Wenn dies der Fall ist, wird die abfrage auf 7 gesetzt
		// um so von einem normalen Benutzer (abfrage == 1) zu unterscheiden.
		String mitarbeiterAbfrage = "SELECT mitarbeiter FROM benutzer WHERE user_name = ? AND passwort = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, benutzername);
			pstmt.setString(2, passwort);
			
			result = pstmt.executeQuery();
			while(result.next()){
				abfrage = Integer.parseInt(result.getString(1));
				PreparedStatement mitarbeiterPstmt = con.prepareStatement(mitarbeiterAbfrage);
				mitarbeiterPstmt.setString(1, benutzername);
				mitarbeiterPstmt.setString(2, passwort);
				ResultSet tempRs = mitarbeiterPstmt.executeQuery();
				// Wenn der Benutzer Mitarbeiter ist, ist in der "mitarbeiter" -Spalte true oder "t" eingetragen.
				while(tempRs.next()){
					if(tempRs.getString(tempRs.findColumn("mitarbeiter")).equals("t")) {
						abfrage = 7;
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return abfrage;
		
	}
	/**
	 * Alle Benutzer werden in einer Benutzerliste gespeichert und übergeben.
	 * 
	 */
	public List<Benutzer> benutzerSearch() {
		List<Benutzer> benutzerList = new ArrayList<Benutzer>();
		String sql = "SELECT user_id, user_name, v_name, n_name, email, passwort, mitarbeiter FROM benutzer";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet tempBenutzer = pstmt.executeQuery();
			while(tempBenutzer.next()) {
				Benutzer benutzer = new Benutzer();
				benutzer.setUserID(tempBenutzer.getString(tempBenutzer.findColumn("user_id")));
				benutzer.setBenutzername(tempBenutzer.getString(tempBenutzer.findColumn("user_name")));
				benutzer.setVorname(tempBenutzer.getString(tempBenutzer.findColumn("v_name")));
				benutzer.setNachname(tempBenutzer.getString(tempBenutzer.findColumn("n_name")));
				benutzer.setEmail(tempBenutzer.getString(tempBenutzer.findColumn("email")));
				benutzer.setVerschluesseltesPW(tempBenutzer.getString(tempBenutzer.findColumn("passwort")));
				if (tempBenutzer.getString(tempBenutzer.findColumn("mitarbeiter")).equals("f")) {
					benutzerList.add(benutzer);					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return benutzerList;
	}
	/**
	 * Gibt den Benutzer der aktuellen Session in einem Benutzerobjekt wieder.
	 * 
	 */
	public Benutzer sessionBenutzer(String benutzername, String passwort) {
		Benutzer benutzer = new Benutzer();
		String sql = "SELECT user_id, user_name, v_name, n_name, email, passwort FROM benutzer"
				+ " WHERE user_name = ? AND passwort = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, benutzername);
			pstmt.setString(2, passwort);
			ResultSet tempBenutzer = pstmt.executeQuery();
			while(tempBenutzer.next()) {
				benutzer.setUserID(tempBenutzer.getString(tempBenutzer.findColumn("user_id")));
				benutzer.setBenutzername(tempBenutzer.getString(tempBenutzer.findColumn("user_name")));
				benutzer.setVorname(tempBenutzer.getString(tempBenutzer.findColumn("v_name")));
				benutzer.setNachname(tempBenutzer.getString(tempBenutzer.findColumn("n_name")));
				benutzer.setEmail(tempBenutzer.getString(tempBenutzer.findColumn("email")));
				benutzer.setVerschluesseltesPW(tempBenutzer.getString(tempBenutzer.findColumn("passwort")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return benutzer;
	}
	/**
	 * Alle Serien werden in einer Serienliste gespeichert und übergeben.
	 * 
	 */
	public List<Serie> serieSearch() {
		List<Serie> serieList = new ArrayList<Serie>();
		String sql = "SELECT * FROM serie ORDER BY serie_name";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet tempSerie = pstmt.executeQuery();
			while(tempSerie.next()) {
				Serie serie = new Serie();
				serie.setId(tempSerie.getString(tempSerie.findColumn("serie_id")));
				serie.setName(tempSerie.getString(tempSerie.findColumn("serie_name")));
				serie.setBeschreibung(tempSerie.getString(tempSerie.findColumn("beschreibung")));
				serie.setFsk(tempSerie.getString(tempSerie.findColumn("fsk")));
				serie.setSendetag(tempSerie.getString(tempSerie.findColumn("sendetag")));
				serie.setGenre1(tempSerie.getString(tempSerie.findColumn("genre1")));
				serie.setGenre2(tempSerie.getString(tempSerie.findColumn("genre2")));
				serie.setGenre3(tempSerie.getString(tempSerie.findColumn("genre3")));
				serieList.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serieList;
	}
	/**
	 * Es wird überprüft, ob die Serie bereits im Sendeplan eines Benutzers ist und ensprechend wird "serieInSendePlan" auf 0 für false und 1 für true gesetzt.
	 * 
	 */
	public int checkSerieBereitsImSendeplan(String serienName, String benutzerID) {
		int serieInSendePlan = -1;
		String sql = "SELECT CASE WHEN EXISTS (SELECT favorites.user_id, favorites.serie_id FROM favorites INNER JOIN serie"
				+ " ON favorites.serie_id = serie.serie_id INNER JOIN benutzer ON favorites.user_id = benutzer.user_id"
				+ " WHERE favorites.user_id = ? AND serie.serie_name = ?)"
				+ " THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(benutzerID));
			pstmt.setString(2, serienName);
			result = pstmt.executeQuery();
			
			while(result.next()) {
				serieInSendePlan = Integer.parseInt(result.getString(result.findColumn("case")));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serieInSendePlan;
	}
	/**
	 * Es werden alle Serien des Sendeplans eines Benutzers in einer Liste gespeichert, und mit Hilfe der Sendeplan Klasse ein Sendeplan in einem String gespeichert,
	 * der für html geschrieben ist.
	 */
	public String sendeplanSearch(int userID) {
		String sql = "SELECT favorites.serie_id, serie_name, beschreibung, fsk, genre1, genre2, genre3, sendetag"
				+ " FROM favorites INNER JOIN serie ON favorites.serie_id = serie.serie_id"
				+ " WHERE favorites.user_id = ?";
		List<Serie> serieList = new ArrayList<Serie>();
		String sendeplan = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			ResultSet tempSerie = pstmt.executeQuery();
			while(tempSerie.next()) {
				Serie serie = new Serie();
				serie.setId(tempSerie.getString(tempSerie.findColumn("serie_id")));
				serie.setName(tempSerie.getString(tempSerie.findColumn("serie_name")));
				serie.setBeschreibung(tempSerie.getString(tempSerie.findColumn("beschreibung")));
				serie.setFsk(tempSerie.getString(tempSerie.findColumn("fsk")));
				serie.setSendetag(tempSerie.getString(tempSerie.findColumn("sendetag")));
				serie.setGenre1(tempSerie.getString(tempSerie.findColumn("genre1")));
				serie.setGenre2(tempSerie.getString(tempSerie.findColumn("genre2")));
				serie.setGenre3(tempSerie.getString(tempSerie.findColumn("genre3")));
				serieList.add(serie);
			}
			//Sendeplan wird in der Sendeplan Klasse erstellt.
			Sendeplan createSendeplan = new Sendeplan(serieList);
			sendeplan = createSendeplan.getSendeplan();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sendeplan;
	}
	/**
	 * Methode um die ID einer Serie zu bekommen, wenn nur der Name gegeben ist.
	 * 
	 */
	public int getIdFromSerie(String name) {
		int serieId = 0;
		String sql = "SELECT serie_id FROM serie WHERE serie_name = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();
			while(result.next()){
				serieId = result.getInt(result.findColumn("serie_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serieId;
	}
	
	/**
	 * Methode um ResultSets zu konvertieren um sie leichter besser in JSPs ausgeben zu können.
	 * 
	 */
	public List<Map<String, Object>> convert(ResultSet rs) {
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> columns = new LinkedHashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					columns.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				rows.add(columns);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}


}