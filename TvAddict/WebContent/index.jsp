<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<!--@author: Hassib-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript">slideit();
	<!-->
	function slideit()
	
		//-->
		
</script>
</head>
<body>

<div id="seite">
	<header>
		
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		
		
		<myTags:navigation activeSite="index"></myTags:navigation> <br>
			
			<!-- Muss neu positioniert werden -->
		<form action="SchnelleSuche" id="textfeld" method="get">
			<input type="text" name="name" placeholder="Name der Serie"> 
			<button type="submit"> Suchen</button>
		</form>	
				
	</header>
</br>
	<div id="main">
		<h1>Willkommen bei TvAddict</h1>
		<a href="Anmelden.jsp" class="button1 big farbe">Anmelden</a>
		</form>
		<a href="registrieren.jsp" class="button2 big farbe">Registrieren</a>
		</br>
		<p align="center">	Die Redakteure von TvAddict.de 
			schreiben Reviews zu aktuellen Episoden und Serien. 
			Dabei werden diese Kritiken auch gern von Lesern 
			kommentiert, denn jeder hat zu seiner Lieblingsserie 
			eine andere Meinung. Bislang wurden bereits 6.797 
			(ja, wirklich schon so viel!) Reviews und 
			Kritiken unserer Redakteure veröffentlicht.
			Die Liste der aktuellen Kritiken zu Serien, 
			Staffeln, Episoden oder Pilotfolgen findest Du immer hier.</br>
			</br>
			Bitte melde dich an um deine Lieblingsserien einzusehen oder regestriere dich jetzt kostenlos.</p>
		<div id="slider" align="center">
			<img src="bb.png" name="slide" width="500" height="281">	
			<script type="text/javascript">

	
	  	</script>
		</div>
		
	 </div>
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