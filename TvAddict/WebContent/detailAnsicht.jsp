 
 <!-- @author Marcel -->
 
 
<%@page import="de.dbae.helper.SearchObject"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detailansicht</title>
</head>
<body>
<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		<nav id="navig">
			
			<myTags:navigation activeSite="index"></myTags:navigation>
			<!-- Wenn ein Benutzer eingemeldet ist wird ein Ausloggen Button angezeigt -->
			<c:if test="${isUserLogged}">
			<label style="color: white; text-align: center" ><b>Angemeldet als <%= session.getAttribute("loggedUser") %>.<br></b></label>
			<form action="AbmeldenServlet" method="post">
			<input type="submit" value="Abmelden">
			</form>
			</c:if>
					
				<form action="SchnelleSuche" id="textfeld" method="get">
					<input type="text" name="name" placeholder="Name der Serie"> 
					<button type="submit">Suchen</button>
				</form>
		</nav>			
	</header>
	<br>
	<div id="main">
	<h1>${name}</h1>
	<br>
	<!-- Bewertung der Serie wird von einer 1-10 Skala angezeigt -->
    <div id="bewertung">
    	<b>Bewertung: ${bewertung.bewertungString}/10 (${bewertung.gesamtBewertungen} Votes)</b>
    	<form action="BewertungAbgegebenServlet" method="post">
    		<select name="abgegebeneBewertung">
    			<option>1</option>
    			<option>2</option>
    			<option>3</option>
    			<option>4</option>
    			<option>5</option>
    			<option>6</option>
    			<option>7</option>
    			<option>8</option>
    			<option>9</option>
    			<option>10</option>
    		</select>
    		<input type="submit" value="Bewerten">
    	</form>
    </div>
    <!-- Schauspielerliste wird ausgegeben -->
	<div id="schauspieler">
		<b>Schauspieler:</b><br>
		<c:forEach items="${schauspielerList}" var="columns">
        	<c:forEach items="${columns}" var="column">
          	<c:out value="${column.value}" /><br>
        	</c:forEach>
    	</c:forEach>
    </div>
    <div id="sendetag">	
		<b>Sendetag: </b> ${sendetag}
	</div>
	<!-- Wenn ein Benutzer angemeldet ist werden die Funktionen für Serie zu Sendeplan hinzufügen/entfernen freigeschaltet -->
	<c:if test="${isUserLogged}">
		<!-- Je nach dem was die Abfrage an die Datenbank ergeben hat wird für 0 (Serie war nicht im Sendeplan) oder 1 (Serie ist im Sendeplan)
			 die entsprechenden Funktion angezeigt -->
		<c:if test="${addCheck == 0}">
			<form action="SerieZuSendePlanServlet" method="post">
				<input type="submit" value="Zu meinem Sendeplan hinzufügen">
				<input type="hidden" name="serienName" value="${name}">
			</form>
		</c:if>
		<c:if test="${addCheck == 1}">
			<form action="SerieAusSendePlanServlet" method="post">
				<input type="submit" value="Aus dem Sendeplan nehmen">
				<input type="hidden" name="serienName" value="${name}">
			</form>
		</c:if>
	</c:if>
    <br>
	<footer>
		<ul id="navmenu">
			<li><a href="#">Impressum</a></li>
			<li><a href="#">AGB</a></li>
			<li><a href="kontakt.jsp">Kontakt</a></li>
		</ul>
</div>
</body>
</html>