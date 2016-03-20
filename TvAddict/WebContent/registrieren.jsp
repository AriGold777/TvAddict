
<!-- @author Daniel -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrierung</title>

</head>
<body>

<div id="seite">

	<!-- Unknown tag header wegen css-Einstellungen -->
	<header>
	
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		
		<!-- Einfügen des Navigationstags -->
		<myTags:navigation activeSite="index"></myTags:navigation>
		
		<!-- Formular mit Textfeld und Absende-Button für die schnelle Suche  -->			
		<form action="Testsuche" id="textfeld" method="post">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
		</form>
		
	</header>
	
	<br>
	
	<div id="main">
	<% 
			//Abfrage, ob ein Benutzer angemeldet ist.
			boolean isUserLogged = (session.getAttribute("loggedUser") != "");
			session.setAttribute("isUserLogged", isUserLogged);
	%>
	
	<!-- Wenn schon angemeldet, wird ausgegeben als wer man angemeldet ist und es gibt die Möglichkeit sich abzumelden -->
	<c:if test="${isUserLogged}">

			<label style="color: white; text-align: center" ><b>Sie sind bereits als <%= session.getAttribute("loggedUser") %> eingeloggt.<br>
			Möchten Sie sich abmelden?</b></label>
			<form action="AbmeldenServlet" method="post">
			<input type="submit" value="Abmelden">
			</form>
			
	</c:if>
	
	<!-- Wenn noch nicht angemeldet wird ein Formular zur Registrierung bereitgestellt -->
	<c:if test="${isUserLogged == false}">
		<h1>Jetzt kostenlos registrieren</h1>
		<form id="signup" action="RegestrierenServlet" method="post" align="center">
			<h2>Registrieren</h2>
			<p>Bitte gebe deine Daten ein um dich zu registrieren</p>
				<div class="inputs" align="center">
					<label>${errorMessage}</label>
					<input type="text" placeholder="Benutzername" minlength="5" name="benutzername" pattern="{5,15}"  required="required" title="Bitte mind. 5 Zeichen eingaben" autofocus></br>
					<input type="text" placeholder="Vorname" name="vorname" required="required"></br>
					<input type="text" placeholder="Nachname" name="nachname" required="required"></br>
					<input type="email" placeholder="E-mail" name="email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="bsp@blabla.de"></br>
					<input type="password" placeholder="Passwort" name="passwort" required="required" pattern="[A-Za-z0-9]{5,15}" title="A-Z, a-z, 0-9, min. 5, max.15 Zeichen"></br>
					<input type="password" placeholder="Passwort wiederholen" name="passwortW" required="required" pattern="[A-Za-z0-9]{5,15}" title="A-Z, a-z, 0-9, min. 5, max.15 Zeichen"></br>
					<input type="submit" value="registrieren"></br>
					
					
				</div>
		</form>
		</c:if>
			
	</div>
	
	<!--  Unknown tag footer wegen css-Einstellungen -->
	<footer>
		<!-- footer-navmenu -->
		<ul id="navmenu">
			<li><a href="#">Impressum</a></li>
			<li><a href="#">AGB</a></li>
			<li><a href="kontakt.jsp">Kontakt</a></li>
		</ul>
	</footer>
</div>
	
</body>
</html>