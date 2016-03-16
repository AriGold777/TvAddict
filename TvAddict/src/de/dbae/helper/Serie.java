/**
 * 
 */
package de.dbae.helper;

/**
 * @author Marcel
 *
 */
public class Serie {
	private String id;
	private String name;
	private String beschreibung;
	private String fsk;
	private String sendetag;
	private String genre1;
	private String genre2;
	private String genre3;
	
	public Serie() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getFsk() {
		return fsk;
	}

	public void setFsk(String fsk) {
		this.fsk = fsk;
	}

	public String getSendetag() {
		return sendetag;
	}

	public void setSendetag(String sendetag) {
		this.sendetag = sendetag;
	}

	public String getGenre1() {
		return genre1;
	}

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}

	public String getGenre2() {
		return genre2;
	}

	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}

	public String getGenre3() {
		return genre3;
	}

	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}
}
