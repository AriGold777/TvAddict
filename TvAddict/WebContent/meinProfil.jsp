<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<!--@author: Hassib-->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mein Profil</title>

</head>
<body>

<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		<nav id="navig">
			<ul>
				<li><a href="index.jsp">Startseite</a></li>
				<li><a href="SerienUebersicht">Serien</a></li>
				<li><a href="Anmelden.jsp">Mein Profil</a></li>
				<li><a href="kontakt.jsp">Kontakt</a></li>
				</ul>
						
				<form action="SchnelleSuche" id="textfeld" method="get">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
				</form>
		</nav>			
	</header>
</br>
	<div id="main">
		<h1>Mein Profil</h1>
		<h2>Hallo </h2>
				
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