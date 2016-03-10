/**
 * 
 */
package de.dbae.helper;

/**
 * @author Marcel
 *
 */
public class Bewertung {
	private double bewertung;
	private int gesamtBewertungen;
	private int anzahl1;
	private int anzahl2;
	private int anzahl3;
	private int anzahl4;
	private int anzahl5;
	private int anzahl6;
	private int anzahl7;
	private int anzahl8;
	private int anzahl9;
	private int anzahl10;
	
	public Bewertung(){
		
	}
	public String berechnung() {
		gesamtBewertungen = anzahl1+anzahl2+anzahl3+anzahl4+anzahl5+anzahl6+anzahl7+anzahl8+anzahl9+anzahl10;
		bewertung = ((anzahl1*1.0)+(anzahl2*2.0)+(anzahl3*3.0)+(anzahl4*4.0)+(anzahl5*5.0)+(anzahl6*6.0)+anzahl7*(7.0)
				+(anzahl8*8.0)+(anzahl9*9.0)+(anzahl10*10.0))/gesamtBewertungen;
		String bewertungString = String.valueOf(bewertung);
		return bewertungString;
	}
	
	
	
	public double getBewertung() {
		return bewertung;
	}
	public void setBewertung(double bewertung) {
		this.bewertung = bewertung;
	}
	public int getGesamtBewertungen() {
		return gesamtBewertungen;
	}
	public void setGesamtBewertungen(int gesamtBewertungen) {
		this.gesamtBewertungen = gesamtBewertungen;
	}
	public int getAnzahl1() {
		return anzahl1;
	}
	public void setAnzahl1(int anzahl1) {
		this.anzahl1 = anzahl1;
	}
	public int getAnzahl2() {
		return anzahl2;
	}
	public void setAnzahl2(int anzahl2) {
		this.anzahl2 = anzahl2;
	}
	public int getAnzahl3() {
		return anzahl3;
	}
	public void setAnzahl3(int anzahl3) {
		this.anzahl3 = anzahl3;
	}
	public int getAnzahl4() {
		return anzahl4;
	}
	public void setAnzahl4(int anzahl4) {
		this.anzahl4 = anzahl4;
	}
	public int getAnzahl5() {
		return anzahl5;
	}
	public void setAnzahl5(int anzahl5) {
		this.anzahl5 = anzahl5;
	}
	public int getAnzahl6() {
		return anzahl6;
	}
	public void setAnzahl6(int anzahl6) {
		this.anzahl6 = anzahl6;
	}
	public int getAnzahl7() {
		return anzahl7;
	}
	public void setAnzahl7(int anzahl7) {
		this.anzahl7 = anzahl7;
	}
	public int getAnzahl8() {
		return anzahl8;
	}
	public void setAnzahl8(int anzahl8) {
		this.anzahl8 = anzahl8;
	}
	public int getAnzahl9() {
		return anzahl9;
	}
	public void setAnzahl9(int anzahl9) {
		this.anzahl9 = anzahl9;
	}
	public int getAnzahl10() {
		return anzahl10;
	}
	public void setAnzahl10(int anzahl10) {
		this.anzahl10 = anzahl10;
	}
}
