<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
			<ul>
				<li><a href="index.jsp">Startseite</a></li>
				<li><a href="#">Serien</a></li>
				<li><a href="Anmelden.jsp">Mein Profil</a></li>
				<li><a href="kontakt.jsp">Kontakt</a></li>
			</ul>
						
			<form action="SchnelleSuche" id="textfeld" method="post">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>
		</nav>			
	</header>
</br>
	<div id="main">
		<h1>Melden Sie sich an um den vollen Service zu erhalten</h1>
		<form id="signup" action="AnmeldenServlet" method="post">
			<h2>Anmelden</h2>
			<p>Bitte gebe deine Anmeldedaten ein</p>
				<div class="inputs">
					<input type="text" placeholder="benutzername" name="benutzername" required="required"  autofocus>
					<input type="password" placeholder="Password" name="passwort" required="required"> 
					<input type="submit" value="Anmelden"></br></br>
					<a id="submit" href="PasswortZur.jsp">Passwort vergessen?</a></br>
					<a id="submit" href="registrieren.jsp">registrieren?</a>
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
	
</div>
</body>
</html>