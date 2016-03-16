<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<!--@author: Hassib-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kontakt</title>

</head>
<body>

<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		<nav id="navig">
		<myTags:navigation activeSite="kontakt"></myTags:navigation>
			<form action="Testsuche" id="textfeld" method="post">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>
		</nav>			
	</header>
</br>
	<div id="main">
	<h1>Das TvAddict-Team steht Ihnen für Fragen zu Verfügung</h1>
		<form id="signup">
			<h2>Kontaktformular</h2>
			<p>Haben Sie Fragen oder Anmerkungen? Dann schreiben Sie uns.</p>
			<div class="inputs" align="center">
				<form action="textarea.html" method="post"> 
	   				 <input type="email" placeholder="E-MAIL" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" autofocus>
	     			 <label for="text"></label>
	     			 <textarea id="text" name="text" cols="40" rows="5" placeholder="Ihr Text..."></textarea></br>	
	     			 <input type="submit" value="Senden">
				</form> 
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