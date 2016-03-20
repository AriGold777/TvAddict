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
		
		<myTags:navigation activeSite="#"></myTags:navigation> <br>
			
			<form action="SchnelleSuche" id="textfeld" method="get">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>	
				
	</header>
</br>
	<div id="main">
	<h1>Das Impressum steht in Kürze zur Verfügung</h1>
		
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