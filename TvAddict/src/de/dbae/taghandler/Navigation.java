package de.dbae.taghandler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Navigation extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String activeSite;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			// Navigationsblock schreiben
            pageContext.getOut().append("<nav>");
            // Überprüfung/Entscheidung ob Seite Aktiv
            //                          Falls aktive Seite     		gebe als aktiv markierten link aus                         falls nicht aktiv gebe normalen link aus
            pageContext.getOut().append(activeSite.equals("index") ? "<a href=\"index.jsp\" class=\"active\" active>Startseite</a> " : "<a href=\"index.jsp\" >Startseite</a> ");
            pageContext.getOut().append(activeSite.equals("SerienUebersicht") ? "<a href=\"SerienUebersicht\" class=\"active\" active>Serien</a> " : "<a href=\"SerienUebersicht\" >Serien</a> ");
            pageContext.getOut().append(activeSite.equals("Anmelden") ? "<a href=\"Anmelden.jsp\" class=\"active\" active>Mein Profil</a> " : "<a href=\"Anmelden.jsp\" >Mein Profil</a> ");
            pageContext.getOut().append(activeSite.equals("kontakt") ? "<a href=\"kontakt.jsp\" class=\"active\" active>Kontakt</a> " : "<a href=\"kontakt.jsp\" >Kontakt</a> ");
            // Navigationsblock abschließen
            pageContext.getOut().append("</nav>");
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return EVAL_PAGE;
	}
	/**
	 * @return the activeSite
	 */
	public String getActiveSite() {
		return activeSite;
	}

	/**
	 * @param activeSite the activeSite to set
	 */
	public void setActiveSite(String activeSite) {
		this.activeSite = activeSite;
	}
	
	

}
