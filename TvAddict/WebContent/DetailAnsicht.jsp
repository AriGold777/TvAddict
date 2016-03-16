<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		<nav id="navig">
			
			<myTags:navigation activeSite="index"></myTags:navigation>
					
				<form action="SchnelleSuche" id="textfeld" method="get">
					<input type="text" name="name" placeholder="Name der Serie"> 
					<button type="submit">Suchen</button>
				</form>
		</nav>			
	</header>
	</br>
	<div id="main">
	<h1>${name}</h1>
	<br>
    <div id="bewertung">
    	<b>Bewertung: ${bewertung.bewertungString}/10 (${bewertung.gesamtBewertungen} Votes)</b>
    </div>
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
<!-- Hier könnte man später Serien zum persönlichen Sendeplan hinzufügen -->
	<form action="SendePlan">
		<input type="submit" value="Zu meinem Sendeplan hinzufügen">
	</form>
	
    </br>
	<footer>
		<ul id="navmenu">
			<li><a href="#">Impressum</a></li>
			<li><a href="#">AGB</a></li>
			<li><a href="kontakt.jsp">Kontakt</a></li>
		</ul>
</div>
</body>
</html>