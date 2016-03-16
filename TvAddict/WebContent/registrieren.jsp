<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--@author: Hassib-->

<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registrieren</title>

</head>
<body>

<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		<nav id="navig">
			
			<myTags:navigation activeSite="index"></myTags:navigation>
						
			<form action="Testsuche" id="textfeld" method="post">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>
		</nav>			
	</header>
</br>
	<div id="main">
		<h1>Jetzt kostenlos registrieren</h1>
		<form id="signup" action="RegestrierenServlet" method="post" align="center">
			<h2>Registrieren</h2>
			<p>Bitte gebe deine Daten ein um dich zu registrieren</p>
				<div class="inputs" align="center">
					<label>${errorMessage}</label>
					<input type="text" placeholder="Benutzername" minlength="5" name="benutzername" pattern="{5,15}"  required="required" title="Bitte mind. 5 Zeichen eingaben" autofocus></br>
					<input type="text" placeholder="Vorname" name="vorname" required="required"></br>
					<input type="text" placeholder="Nachname" name="nachname"></br>
					<input type="email" placeholder="E-mail" name="email" required="required"pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="bsp@blabla.de"></br>
					<input type="password" placeholder="Passwort" name="passwort" required="required"></br>
					<input type="password" placeholder="Passwort wiederholen" name="passwortW" required="required"></br>
					<input type="submit" value="registrieren"></br>
					
					
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