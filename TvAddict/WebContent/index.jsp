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

<div id="container">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
			
		<div id="nav">
				<ul>
					<li><a href="#">Startseite</a></li>
					<li><a href="SerienUebersicht.jsp">Serien</a></li>
					<li><a href="#">Mein Profil</a></li>
					<li><a href="#">Kontakt</a></li>
					</ul>
					
					<form action="Testsuche" id="textfeld" method="post">
					<input type="text" name="name" placeholder="Name der Serie"> 
					<button type="submit"> Suchen</button>
					</form>
					
					<form action="erweiterteSuche.jsp">
    					<input type="submit" value="Erweiterte Suche">
					</form>
				
		</div>			
</div>
</header>
	
	<div id="main">
	<h1>Willkommen bei TvAddict</h1>
	
		<a href="#" class="button1 big farbe">Anmelden</a>
	
		<a href="#" class="button2 big farbe">Registrieren</a>
	
		
	</div>	
	

<footer>
					<ul id="navigation">
					<li><a href="http://www.tvaddict.de">Startseite</a></li>
					<li><a href="/leistungen">Leistungen</a></li>
					<li><a href="/kontakt">Kontakt</a></li>
					</ul>	
</footer>
	
	
</body>
</html>