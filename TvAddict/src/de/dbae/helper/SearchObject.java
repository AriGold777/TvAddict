/**
 * 
 */
package de.dbae.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.dbae.database.DatabaseConnection;

/**
 * @author Marcel
 *
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
	
	public ResultSet simpleSearch(String name) {
		
		//Basic SQL Statement
		String sql = "SELECT * FROM serie WHERE TRUE";
		
		//Leerer where-String
		String where ="";
		
		if (!name.equals("") && name != null) {
			where += " AND serie.serie_name ilike '%"+name+"%'";
		}
		
		
		//SQL Statement & Where Statement verbinden
		String completeSQL = sql + where;
		
		//Prepared Statement in ResultSet
		try {
			result = con.prepareStatement(completeSQL).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet advancedSearch(String name, String genre, String fsk) {
		//Basic SQL Statement
		String sql = "SELECT serie_name, beschreibung, fsk FROM serie WHERE TRUE";
				
		//Leerer where-String
		String where ="";
				
		if (!name.equals("") && name != null) {
			where += " AND serie.serie_name ilike '%"+name+"%'";
		}
		if (!fsk.equals("") && fsk != null) {
			where += " AND serie.fsk <= "+fsk;
		}
		if (!genre.equals("") && genre != null) {
			where += " AND (serie.genre1 = '"+genre+"' OR serie.genre2 = '"+genre+"' OR serie.genre3 = '"+genre+"')";
		}
				
		//SQL Statement & Where Statement verbinden
		String completeSQL = sql + where;
				
		//Prepared Statement in ResultSet
		try {
			result = con.prepareStatement(completeSQL).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
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
			rs = con.prepareStatement(countSql).executeQuery();
			while (rs.next()) {
	            count = rs.getInt("count");
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public ResultSet allGenres() {
		String sql = "SELECT genre1 FROM serie WHERE genre1<>''"
				+ " UNION"
				+ " SELECT genre2 FROM serie"
				+ " WHERE genre2<>''"
				+ " UNION"
				+ " SELECT genre3 FROM serie"
				+ " WHERE genre3<>''";
		try {
			result = con.prepareStatement(sql).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet uebersichtSearch() {
		String sql = "SELECT serie_name, beschreibung, fsk FROM serie";
		try {
			result = con.prepareStatement(sql).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public ResultSet detailSchauspielerSearch(String name) {
		String sql ="SELECT schauspieler.name FROM schauspieler"
				+ " INNER JOIN serie ON schauspieler.serie_id = serie.serie_id"
				+ " WHERE serie.serie_name='"+name+"'";
		try {
			result = con.prepareStatement(sql).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public Bewertung bewertungSearch(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//ResultSet konvertieren
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