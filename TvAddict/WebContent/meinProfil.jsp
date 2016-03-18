<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="myTags" uri="/WEB-INF/lib/myTags.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<link href="styles.css" rel="stylesheet" type="text/css"/>
<head>
<!--@author: Hassib-->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mein Profil</title>

</head>
<body>
	
	<% 
			boolean isUserLogged = (session.getAttribute("loggedUser") != "");
			session.setAttribute("isUserLogged", isUserLogged);
	%>
	<c:if test="${isUserLogged == false}">
		<c:redirect url="http://localhost:8080/TvAddict/Anmelden.jsp"></c:redirect>
	</c:if>
	
<div id="seite">
	<header>
		<div id="logo">
			<img src="tv.png" width="100" height="50">
		</div>
		
		<myTags:navigation activeSite="meinProfil"></myTags:navigation> <br>
		
		<c:if test="${isUserLogged}">
			<label style="color: white; text-align: center" ><b>Angemeldet als <%= session.getAttribute("loggedUser") %>.<br></b></label>
			<form action="AbmeldenServlet" method="post">
			<input type="submit" value="Abmelden">
			</form>
		</c:if>
			
			<!-- Muss neu positioniert werden -->
			<form action="SchnelleSuche" id="textfeld" method="get">
				<input type="text" name="name" placeholder="Name der Serie"> 
				<button type="submit"> Suchen</button>
			</form>	
				
	</header>
</br>
	<c:if test="${isUserLogged == true}">
	<div id="main">
		<h1>Mein Profil</h1>
		<h2>Hallo ${loggedUser},<br> hier ist ihr persönlicher Sendeplan für den aktuellen Monat</h2><br><br>
		<div align="center" style="color: white">
		${sendeplan} 
		</div>
				
	</div>
	</c:if> 
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