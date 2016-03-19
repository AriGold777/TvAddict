/**
 * 
 */
package de.dbae.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Marcel
 * 
 * Diese Klasse dient zur Sendeplanerstellung als Monatsüberblick.
 *
 */
public class Sendeplan {
	
	private Date date;
	
	private Calendar cal;
	
	private String monthNames[] = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September","Oktober", "November", "Dezember"};
	
	private String wochenTage[] = {"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};
	
	private int maxDayMonth;
	
	private List<Serie> serieList;
	
	private String sendeplan = "";
	
	int aktuellerMonat;
	
	int aktuellesJahr;
	//Konstruktor, der das aktuelle Datum setzt.
	public Sendeplan(List<Serie> serieList) {
		this.serieList = serieList;
		date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		aktuellerMonat = cal.get(Calendar.MONTH);
		aktuellesJahr = cal.get(Calendar.YEAR);
		maxDayMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	/**
	 * Methode um den Sendeplan eines Benutzers in einem Monatsüberblick zu erstellen.
	 * Es wird als String zur direkten Ausgabe in einer JSP erstellt.
	 */
	public String getSendeplan() {
		//
		sendeplan = "<h2>" + monthNames[aktuellerMonat] + "</h2><br><table id=\"sendeplan\"><tr style=\"vertical-align: top\">";
		int weekCounter = 1;
		//Schleife um für jeden Tag im Monat. Es wird dabei die Anzahl der Tage des aktuellen Monats berücksichtig.
		for (int tagInMonat = 1; tagInMonat <= maxDayMonth; tagInMonat++) {
			Calendar temp = Calendar.getInstance();
			temp.set(aktuellesJahr, aktuellerMonat, tagInMonat);
			
			//Differenz der DAY_OF_WEEK um die Anzahl leer-<td> zu bekommen
			int leerTdCount = temp.get(Calendar.DAY_OF_WEEK)-2;
			//Vor dem ersten Tag sollen alle Tage des letzten Monats der aktuellen Woche mit leer-<td> gesetzt werden um die Tabelle einheitlich zu gestalten
			while (tagInMonat == 1 && leerTdCount > 0) {
				sendeplan += "<td></td>";
				leerTdCount--;
			}
			//Tag und Wochentag Ausgabe
			sendeplan += "<td><label style=\"color: red\"><b>"+temp.get(Calendar.DAY_OF_MONTH) +". "+ wochenTage[temp.get(Calendar.DAY_OF_WEEK)-1]+"</b></label><br>";				
			//Jede Serie, die den Sendetag am aktuellen Wochentag im Monat hat wird dem Tag hinzugefügt.
			for (Serie serie : serieList) {
				if(serie.getSendetag().equals(wochenTage[temp.get(Calendar.DAY_OF_WEEK)-1])) {
					sendeplan += serie.getName() + "<br>";
				}
			}
			sendeplan += "</td>";		
			//Nach jedem Sonntag wird eine neue Woche gestartet.
			if(wochenTage[temp.get(Calendar.DAY_OF_WEEK)-1].equals("Sonntag")) {
				weekCounter++;
				//System.out.println("Woche: "+ weekCounter);
				sendeplan += "</tr><tr style=\"vertical-align: top\">";

			}
		}
		sendeplan += "</table>";
		return sendeplan;
	}
	
}
