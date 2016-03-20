<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--@author: Hassib-->

<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset</title>

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
				<li><a href="SerienUebersicht.jsp">Serien</a></li>
				<li><a href="anmelden.jsp">Mein Profil</a></li>
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
		<h1>Haben Sie Ihre Passwort vergessen?</h1>
		<form id="signup">
			<h2>Passwort zurücksetzen</h2>
			<!-- Email Feld zum zurücksetzen des PW -->
			<p>Bitte geben Sie Ihre E-Mail Adresse ein, wir senden Ihnen einen Link zum zurücksetzen Ihres Passwortes.</p>
				<div class="inputs" align="center">
					<form action="textarea.html" method="post"> 
	   					<div>  
		   					<input type="email" placeholder="E-MAIL" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" autofocus>
		     				<input type="submit" value="zurücksetzen">
	     				</div> 
					</form> 
				</div>
			</form>
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