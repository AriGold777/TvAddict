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
		String sql = "SELECT * FROM serie WHERE TRUE";
				
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