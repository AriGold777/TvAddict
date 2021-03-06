
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
<title>Startseite</title>
</head>
<body>
		<% 
			//Abfrage, ob ein Benutzer angemeldet ist.
			boolean isUserLogged = (session.getAttribute("loggedUser") != "");
			session.setAttribute("isUserLogged", isUserLogged);
		%>

<div id="seite">
	
	<!-- Unknown tag header wegen css-Einstellungen -->
	<header>
		
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		
		<!-- Einf�gen des Navigationstags -->
		<myTags:navigation activeSite="index"></myTags:navigation> <br>
		
		<!-- Wenn ein Benutzer angemeldet ist wird ein Ausloggen Button angezeigt -->
		<c:if test="${isUserLogged}">
			<label style="color: white; text-align: center" ><b>Angemeldet als <%= session.getAttribute("loggedUser") %>.<br></b></label>
			<form action="AbmeldenServlet" method="post">
			<input type="submit" value="Abmelden">
			</form>
		</c:if>	
		
		<!-- Formular mit Textfeld und Absende-Button f�r die schnelle Suche  -->	
		<form action="SchnelleSuche" id="textfeld" method="get">
			<input type="text" name="name" placeholder="Name der Serie"> 
			<button type="submit"> Suchen</button>
		</form>	
				
	</header>
	
	<br>
	
	<div id="main">
		<h1>Willkommen bei TvAddict</h1>
		
		
		<!-- Button mit Links zur anmelden.jsp und registrieren.jsp -->
		<a href="anmelden.jsp" class="button1 big farbe">Anmelden</a>

		<a href="registrieren.jsp" class="button2 big farbe">Registrieren</a>

		<br>
		
		<!-- Begr��ungstext -->
		<p align="center">	Der Text war eine L�ge :D<br>
			Bei Gelegenheit was anderes rein.
			<br>
			<!-- Wenn noch nicht angemeldet Hinweis auf Anmedlung -->
			<c:if test="${isUserLogged == false}">
				<h2>Bitte melde dich an um deine Lieblingsserien einzusehen oder registriere dich jetzt kostenlos.</h2>		
			</c:if>
		</p>
		
		<!-- Slider -->	
		<div id="slider" align="center">
			<img src="bb.png" name="slide" width="500" height="281">	
			<script type="text/javascript">
	  		</script>
		</div>
		
	</div>
	
	<!--  Unknown tag footer wegen css-Einstellungen --> 
	<footer>
		
		<!-- footer-navmenu -->
		<ul id="navmenu">
			<li><a href="impressum.jsp">Impressum</a></li>
			<li><a href="agb.jsp">AGB</a></li>
			<li><a href="kontakt.jsp">Kontakt</a></li>
		</ul>
	
</div>
</body>
</html>