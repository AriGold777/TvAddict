<!-- @author Hassib -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="de.dbae.helper.Benutzer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Css Verbindung -->
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Anmelden</title>

</head>
<body>

<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		<nav id="navig">
			
			<myTags:navigation activeSite="Anmelden"></myTags:navigation>
			<!-- Textfeld und Button für Schnelle Suche -->		
			<form action="SchnelleSuche" id="textfeld" method="post">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>
		</nav>			
	</header>
</br>
	<div id="main">
	<!-- Prüfen ob Benutzer angemeldet ist -->
		<% 
			boolean isUserLogged = (session.getAttribute("loggedUser") != "");
			session.setAttribute("isUserLogged", isUserLogged);
		%>
 		<c:if test="${isUserLogged == false}">
 		
		<!-- Ist Nutzer nicht angemeldet dann muss er sich anmelden -->
		<h1>Melden Sie sich an um den vollen Service zu erhalten</h1>
		<form id="signup" action="AnmeldenServlet" method="post">
			<h2>Anmelden</h2>
			<p>Bitte gebe deine Anmeldedaten ein</p>
					<div class="inputs">
					<input type="text" placeholder="benutzername" name="benutzername" required="required"  autofocus>
					<input type="password" placeholder="Passwort" name="passwort" required="required"> 
					<input type="submit" value="Anmelden"></br></br>
					<a id="submit" href="PasswortZur.jsp">Passwort vergessen?</a></br>
					<a id="submit" href="registrieren.jsp">Registrieren?</a>
					</div>	
		</form>
 		</c:if>
		<c:if test="${isUserLogged}">
		<!-- Wenn Benutzer Angemeldet ist bekommt er folgendes zu sehen -->
			<label style="color: white; text-align: center" ><b>Sie sind bereits als <%= session.getAttribute("loggedUser") %> eingeloggt.<br>
			Möchten Sie sich abmelden?</b></label>
			<form action="AbmeldenServlet" method="post">
			<input type="submit" value="Abmelden">
			</form>
			
		</c:if>
		
	
	</div>
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