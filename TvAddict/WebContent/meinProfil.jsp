
 <!-- @author Marcel -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="de.dbae.helper.Benutzer"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<!--@author: Hassib-->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mein Profil</title>

</head>
<body>
	<% 
			//Abfrage, ob ein Benutzer angemeldet ist.
			boolean isUserLogged = (session.getAttribute("loggedUser") != "");
			session.setAttribute("isUserLogged", isUserLogged);
			Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");			
	%>
	<!-- Wenn kein Benutzer angemeldet ist wird er auf die Anmeldeseite verwiesen -->
	<c:if test="${isUserLogged == false}">
		<c:redirect url="http://localhost:8080/TvAddict/anmelden.jsp"></c:redirect>
	</c:if>
	
<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		
		<myTags:navigation activeSite="meinProfil"></myTags:navigation> <br>
		<!-- Wenn ein Benutzer eingemeldet ist wird ein Ausloggen Button angezeigt -->
		<c:if test="${isUserLogged}">
			<label style="color: white; text-align: center" ><b>Angemeldet als <%= session.getAttribute("loggedUser") %>.<br></b></label>
			<form action="AbmeldenServlet" method="post">
			<input type="submit" value="Abmelden">
			</form>
		</c:if>
			
			<form action="SchnelleSuche" id="textfeld" method="get">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>	
				
	</header>
</br>
	<!-- Wenn ein Benutzer eingeloggt ist wird er begrüßt und der persönliche Sendeplan wird angezeigt -->
	<c:if test="${isUserLogged == true}">
	<div id="main">
		<h1>Mein Profil</h1><br>
		<label style="color: red; font: bold;">${errorMessage}</label>
		<form action="EmailBearbeitenServlet" method="post">
			<Label style="color: white">Aktuelle Email: <%= benutzer.getEmail() %></Label><br>
			<input type="text" name="neueEmailBenutzerEdit" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="bsp@blabla.de">
			<input type="text" name="neueEmailWdhBenutzerEdit" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="bsp@blabla.de">
			<input type="submit" value="Ändern!">
		</form>
		<form action="PasswortAendernServlet" method="post">
			<Label style="color: white">Um Ihr aktuelles Passwort zu ändern bitte beide Felder ausfüllen um ein Versehen auszuschließen </Label><br>
			<!-- Nur Buchstaben und Zahlen. Mindestens 5, Maximal 15 Zeichen -->
			<input type="password" name="neuesPasswortBenutzerEdit" required="required" pattern="[A-Za-z0-9]{5,15}" title="A-Z, a-z, 0-9, min. 5, max.15 Zeichen">
			<input type="password" name="neuesPasswortWdhBenutzerEdit" required="required" pattern="[A-Za-z0-9]{5,15}" title="A-Z, a-z, 0-9, min. 5, max.15 Zeichen"">
			<input type="submit" value="Ändern!">
		</form><br>
		<h2>Hallo ${loggedUser},<br> hier ist ihr persönlicher Sendeplan für den aktuellen Monat</h2><br><br>
		<div align="center" style="color: white">
		${sendeplan} 
		</div>
				
	</div>
	</c:if> 
	</br>
	<footer>
		<ul id="navmenu">
			<li><a href="impressum.jsp">Impressum</a></li>
			<li><a href="agb.jsp">AGB</a></li>
			<li><a href="kontakt.jsp">Kontakt</a></li>
		</ul>
</div>
</body>
</html>