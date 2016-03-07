<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>regestrieren</title>

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
				<li><a href="#">Serien</a></li>
				<li><a href="Anmelden.jsp">Mein Profil</a></li>
				<li><a href="kontakt.jsp">Kontakt</a></li>
			</ul>
						
			<form action="Testsuche" id="textfeld" method="post">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>
		</nav>			
	</header>
</br>
	<div id="main">
		<h1>Jetzt kostenlos regestrieren</h1>
		<form id="signup" action="RegestrierenServlet" method="get" align="center">
			<h2>Regestrieren</h2>
			<p>Bitte gebe deine Daten ein um dich zu registrieren</p>
				<div class="inputs" align="center">
					<input type="text" placeholder="Vorname" name="vorname" required="required" autofocus></br>
					<input type="text" placeholder="Nachname" name="nachname"></br>
					<input type="text" placeholder="Benutzername" name="benutzername" required="required" ></br>
					<input type="email" placeholder="E-mail" name="email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"></br>
					<input type="password" placeholder="Password" name="passwort" required="required"></br>
					<input type="submit" value="regestrieren"></br>
				</div>
		</form>
	</div>
	</br>
	<footer>
		<ul id="navmenu">
			<li><a href="#">Impressum</a></li>
			<li><a href="#">AGB</a></li>
			<li><a href="kontakt.jsp">Kontakt</a></li>
		</ul>
	</footer>
</div>
	
</body>
</html>